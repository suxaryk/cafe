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
            String SQL = "SELECT * FROM product";        
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
            log.error("Connection Failed! Check output console - readStorage");
        }
    }
    public static String getIngTitleById(int Id) {
        for (Ingredient ing : MainForm.storageList) {
            if (ing.getId() == Id) {
                return ing.getTitle();
            }
        }
        log.error("getIngTitleById - no product with id = " + Id);
        return "";
    }
    public static void addIngredientToDB(Ingredient ingredient) {
        final String SQL = "INSERT INTO product(title, count) VALUES(?, ?)";
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
        final String SQL = "DELETE FROM product WHERE Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Ingredient was removed successfully!" + dbId + " " + getIngTitleById(dbId));
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - removeIngredientFromDB");
        }

    }
    public static void updateCount(int dbId, double count) {
        System.out.println("count =============" + count);
        final String SQL = "UPDATE product SET count = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setDouble(1, count);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Storage count was updated successfully! " + dbId);
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateCount" + dbId);
        }
    }
    public static Ingredient getIngredientById(int id) {
        Ingredient ingredient = new Ingredient();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM product WHERE Id =" + id;           
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
        final String SQL = "SELECT * FROM luckyroger.storage_removed where"
                + " date >= '" + start
                + "' AND date <= '" + end
                + "' group by ingredient_id";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            List<Ingredient> removedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    removedList.add(new Ingredient(                         
                    rs.getInt("ingredient_id"),
                    rs.getDouble("count")
                    ));             
                }
                log.debug("read removedList size = " + removedList.size());
                return removedList;
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getRemovedIngredients ");
            return null;
        }
    }

    public static List<Ingredient> getAddedIngredients(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from storage_added where"
                + " date >= '" + start
                + "' AND date <= '" + end
                + "' group by ingredient_id";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {            
            List<Ingredient> addedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    addedList.add(new Ingredient(
                            rs.getInt("ingredient_id"),
                            rs.getDouble("count")
                    ));
                }
                log.debug("read addedList size = " + addedList.size());
                return addedList;
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getAddedIngredients ");
            return null;
        }
    }
    
 
    

  
 
    //SELECT dish_id, dish.title, sum(quantity) as sm 
    //FROM luckyroger.order_item inner join dish on order_item.dish_id = dish.id group by dish_id order by sm desc;
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
