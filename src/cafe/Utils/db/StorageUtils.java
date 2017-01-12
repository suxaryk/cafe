package cafe.Utils.db;


import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;
import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.Utils.json.JSONUtils;
import static cafe.Utils.json.JSONUtils.convertJSONToOrder;
import cafe.model.Ingredient;
import cafe.model.OrderItem;
import cafe.model.User;
import cafe.view.ClientForm;
import static cafe.view.LoginForm.userList;
import cafe.view.MainForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author suxarina
 */
public class StorageUtils {
    private static final Logger log = Logger.getLogger(StorageUtils.class);

    public static void readStorage() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage";
            MainForm.storageList.clear();
            Statement statement = connection.createStatement();        
            ResultSet rs = statement.executeQuery(SQL);                
            while (rs.next()) {
                MainForm.storageList.add(
                        new Ingredient(
                                rs.getInt("Id"),
                                rs.getString("title"),
                                rs.getDouble("count")
                        ));
            }
        log.debug("readStorage");
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - readStorage");
        }

    }

    public static String getIngTitleById(int Id) {
        for (Ingredient ing : MainForm.storageList) {
            if (ing.getId() == Id) {
                return ing.getTitle();
            }
        }
        return "";
    }

    public static void addIngredientToDB(Ingredient ingredient) {
        final String SQL = "INSERT INTO storage(title, count) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, ingredient.getTitle());
            pstatement.setInt(2, 0);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new Ingredient was added successfully!");

            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addIngredientToDB");
        }

    }

    public static void removeIngredientFromDB(int dbId) {
        final String SQL = "DELETE FROM storage WHERE Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Ingredient was removed successfully!");
            }
        } catch (SQLException e) {
            log.debug("Connection Failed! Check output console - removeIngredientFromDB");
        }

    }

    public static void updateCount(int dbId, double count) {

        final String SQL = "UPDATE storage SET count = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setDouble(1, count);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Storage ing count was updated successfully! Product id = " + dbId);
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateCount(Storage ing count)" + dbId);
        }
    }

    public static Ingredient getIngredientById(int id) {
        Ingredient ingredient = new Ingredient();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage WHERE Id =" + id;
            MainForm.storageList.clear();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    ingredient.setId(rs.getInt("Id"));
                    ingredient.setTitle(rs.getString("title"));
                    ingredient.setCount(rs.getDouble("count"));
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getIngredientById " + id);
        }
        return ingredient;

    }
//TODO fix hardcode
    public static void addRemovedItems(String JsonItems, User user) {
        final String SQL1 = "INSERT INTO storage_removed(date, user, removed_ingredients) VALUES(?, ?, ?)";
        String SQL = "INSERT INTO storage_removed(date, operator, removed_ingredients) VALUES(?, ?, ?)";
        if (ClientForm.cafeId == 0) {
            SQL = SQL1;            
        }
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());
            pstatement.setString(2, user.getName());
            pstatement.setString(3, JsonItems);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Списання продуктів RemovedItem(s) was added successfully!");

            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addRemovedItems(Списання продуктів)");
        }
    }
//TODO fix hardcode
    public static void addAddedItems(String JsonItems) {     
        String SQL = "INSERT INTO storage_added(date, added_ingredients) VALUES(?, ?)";          
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());        
            pstatement.setString(2, JsonItems);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("New AddedItem(приход) was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addAddesItems(приход)");
        }
    }
    
    public static void addAddedItemsWithUser(String JsonItems, User user) {
        final String SQL = "INSERT INTO storage_added(date, user, added_ingredients) VALUES(?, ?, ?)";    
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());          
            pstatement.setString(2, user.getName());          
            pstatement.setString(3, JsonItems);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("New addAddedItemsWithUser(приход) was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addAddedItemsWithUser(приход)");
        }
    }

 

    public static void fullJoinIngLists(List<Ingredient> list1, List<Ingredient> list2) {
        for (Ingredient ing : list2) {
            if (list1.contains(ing)) {
                int index = list1.indexOf(ing);
                list1.get(index).addCount(ing.getCount());
            } else {
                list1.add(ing);
            }
        }
    }

    public static void fullJoinOrderItemLists(List<OrderItem> list1, List<OrderItem> list2) {
        for (OrderItem item : list2) {
            if (list1.contains(item)) {
                int index = list1.indexOf(item);
                list1.get(index).addCount(item.getCount());
            } else {
                list1.add(item);
            }
        }
    }

    public static List<Ingredient> getRemovedIngredients(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from storage_removed where"
                + " date >= '" + start
                + "' AND date <= '" + end
                + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            List<Ingredient> removedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinIngLists(removedList,
                            JSONUtils.convertJSONToRemovedIng(
                                    rs.getString("removed_ingredients"))
                    );
                }
                log.debug("read removedList(списання) size = " + removedList.size());
                return removedList;
            }

        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getRemovedIngredients(списання) ");
            return null;
        }
    }
    public static List<Ingredient> getAddedIngredients(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from storage_added where"
                + " date >= '" + start
                + "' AND date <= '" + end
                + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            List<Ingredient> addedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinIngLists(addedList,
                            JSONUtils.convertJSONToRemovedIng(
                                    rs.getString("added_ingredients"))
                    );
                }
                log.debug("read addedList(приход) size = " + addedList.size());
                return addedList;
            }

        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getAddedIngredients (приход)");
            return null;
        }
    }

    public static List<OrderItem> getOrderedDishes(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' AND sum >= 0 ";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            List<OrderItem> orderedDishes = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinOrderItemLists(orderedDishes,
                            convertJSONToOrder(rs.getString("order_items"))
                    );
                }
                log.debug("read orderedDishes size = " + orderedDishes.size());
                return orderedDishes;
            }

        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getOrderedDishes ");
            return null;
        }
    }
    
    public static void addStorageHistory(List<Ingredient> storageDump) throws SQLException{
        final String SQL = "INSERT INTO storage_history(date, ingredient_id, count) VALUES(?, ?, ?)";
        Connection connection = null;
        PreparedStatement pstatement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstatement = connection.prepareStatement(SQL);
            connection.setAutoCommit(false);

            for (Ingredient ing : storageDump) {
                pstatement.setTimestamp(1, getCurrentTimeStamp());
                pstatement.setInt(2, ing.getId());
                pstatement.setDouble(3, ing.getCount());
                pstatement.addBatch();
            }
            pstatement.executeBatch();
            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            log.error("Connection Failed! Check output console - addStorageHistory");
        } finally {
            if (pstatement != null) {
                pstatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

    }

}
