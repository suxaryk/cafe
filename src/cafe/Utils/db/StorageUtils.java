package cafe.Utils.db;


import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.Utils.json.JSONUtils;
import static cafe.Utils.json.JSONUtils.convertJSONToOrder;
import cafe.model.Ingredient;
import cafe.model.OrderItem;
import cafe.model.User;
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

/**
 *
 * @author suxarina
 */
public class StorageUtils {

    public static void readStorage() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage";
            System.out.println(!connection.isClosed() ? "DB connected! readStorage"
                    : "Error DB connecting");
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
        
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readStorage");
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
                System.out.println("A new Ingredient was added successfully!");

            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addIngredientToDB");
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
                System.out.println("Ingredient was removed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - removeIngredientFromDB");
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
                System.out.println("Storage count was updated successfully! " + dbId);
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateCount" + dbId);
        }
    }

    public static Ingredient getIngredientById(int id) {
        Ingredient ingredient = new Ingredient();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage WHERE Id =" + id;
            System.out.println(!connection.isClosed() ? "DB connected! getIngredientById " + id
                    : "Error DB connecting");
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
            System.out.println("Connection Failed! Check output console - getIngredientById " + id);
        }
        return ingredient;

    }

    public static void addRemovedItems(String JsonItems, User user) {
        final String SQL = "INSERT INTO storage_removed(date, operator, removed_ingredients) VALUES(?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());
            pstatement.setString(2, user.getName());
            pstatement.setString(3, JsonItems);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New RemovedItem(s) was added successfully!");

            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addRemovedItems");
        }
    }
    public static void addAddedItems(String JsonItems) {
        final String SQL = "INSERT INTO storage_added(date, added_ingredients) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());          
            pstatement.setString(2, JsonItems);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New AddedItem(s) was added successfully!");

            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addAddesItems");
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

            System.out.println(!connection.isClosed() ? "DB connected! getRemovedIngredients"
                    : "Error DB connecting");
            List<Ingredient> removedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinIngLists(removedList,
                            JSONUtils.convertJSONToRemovedIng(
                                    rs.getString("removed_ingredients"))
                    );
                }
                System.out.println("read removedList size = " + removedList.size());
                return removedList;
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getRemovedIngredients ");
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

            System.out.println(!connection.isClosed() ? "DB connected! getAddedIngredients"
                    : "Error DB connecting");
            List<Ingredient> addedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinIngLists(addedList,
                            JSONUtils.convertJSONToRemovedIng(
                                    rs.getString("added_ingredients"))
                    );
                }
                System.out.println("read addedList size = " + addedList.size());
                return addedList;
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAddedIngredients ");
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

            System.out.println(!connection.isClosed() ? "DB connected! getOrderedDishes"
                    : "Error DB connecting");
            List<OrderItem> orderedDishes = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinOrderItemLists(orderedDishes,
                            convertJSONToOrder(rs.getString("order_items"))
                    );
                }
                System.out.println("read orderedDishes size = " + orderedDishes.size());
                return orderedDishes;
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getOrderedDishes ");
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
            System.out.println("Connection Failed! Check output console - addStorageHistory");
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
