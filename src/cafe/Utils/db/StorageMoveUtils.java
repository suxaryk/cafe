package cafe.Utils.db;

import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.Utils.json.JSONUtils;
import cafe.model.Ingredient;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author suxarina
 */
public class StorageMoveUtils {
    private static final Logger log = Logger.getLogger(StorageMoveUtils.class);
    
    private static String getActiveUser() {
        return userList.get(User.active).getName();
    }
    
    //utils tmp
    public static List<Ingredient> convertRemovedStorageTable() {
        final String SQL = "SELECT * from storage_removed";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            List<Ingredient> addedList = new ArrayList<>(0);
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String date = rs.getString("date");
                    String user = rs.getString("user");
                    String json = rs.getString("removed_ingredients");
                    if (json.equals("[]")) {
                        continue;
                    }
                    if (json.length() < 40) {
                        Ingredient ing = JSONUtils.convertJSONToRemovedIng(json).get(0);

                        updateRemovedUtilits(id, ing.getId(), ing.getCount());
                    } else {
                        List<Ingredient> addedList1 = new ArrayList<>(JSONUtils.convertJSONToRemovedIng(json));
                        for (Ingredient ing : addedList1) {
                            insertRemovedUtilits(date, user, ing.getId(), ing.getCount());
                        }
                    }

                }
                System.out.println("read addedList size = " + addedList.size());
                return addedList;
            }

        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - convertRemovedStorageTable ");
            return null;
        }
    }    

    private static void updateRemovedUtilits(int dbId, int ingredient_id, double count) {

        final String SQL = "UPDATE storage_removed SET ingredient_id = ?, count = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, ingredient_id);
            pst.setDouble(2, count);
            pst.setInt(3, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Storage id, count count was updated successfully! " + dbId);
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateAddedUtilits" + dbId);
        }
    }


    private static void insertRemovedUtilits(String date, String user, int ing_id, double count) {
        final String SQL = "INSERT INTO storage_removed(date, user, removed_ingredients, ingredient_id, count) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, date);
            pstatement.setString(2, user);
            pstatement.setString(3, "");
            pstatement.setInt(4, ing_id);
            pstatement.setDouble(5, count);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Ingredient was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - insertAddedUtilits");
        }

    }

    public static List<Ingredient> convertAddedStorageTable() {
        final String SQL = "SELECT * from storage_added";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            List<Ingredient> addedList = new ArrayList<>(0);
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String date = rs.getString("date");
                    String user = rs.getString("user");
                    String json = rs.getString("added_ingredients");
                    if (json.equals("[]")) {
                        continue;
                    }
                    if (json.length() < 40) {
                        Ingredient ing = JSONUtils.convertJSONToRemovedIng(json).get(0);

                        updateAddedUtilits(id, ing.getId(), ing.getCount());
                    } else {
                        List<Ingredient> addedList1 = new ArrayList<>(JSONUtils.convertJSONToRemovedIng(json));
                        for (Ingredient ing : addedList1) {
                            insertAddedUtilits(date, user, ing.getId(), ing.getCount());
                        }
                    }

                }
                log.debug("read addedList size = " + addedList.size());
                return addedList;
            }

        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - convertAddedStorageTable ");
            return null;
        }
    }
    
    private static void updateAddedUtilits(int dbId, int ingredient_id, double count) {

        final String SQL = "UPDATE storage_added SET ingredient_id = ?, count = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, ingredient_id);
            pst.setDouble(2, count);
            pst.setInt(3, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Storage id, count count was updated successfully! " + dbId);
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateAddedUtilits" + dbId);
        }
    }

    private static void insertAddedUtilits(String date, String user, int ing_id, double count) {
        final String SQL = "INSERT INTO storage_added(date, user, added_ingredients, ingredient_id, count) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, date);
            pstatement.setString(2, user);
            pstatement.setString(3, "");
            pstatement.setInt(4, ing_id);
            pstatement.setDouble(5, count);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new Ingredient was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - insertAddedUtilits");
        }

    }
    
    public static void addRemovedItems(Ingredient ing) {
        final String SQL = "INSERT INTO storage_removed(date, user, ingredient_id, count) VALUES(?, ?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());
            pstatement.setString(2, getActiveUser());
            pstatement.setInt(3, ing.getId());
            pstatement.setDouble(4, ing.getCount());
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("New RemovedItem(s) was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addRemovedItems");
        }
    }

    public static void addAddedItems(Ingredient ing) {
        final String SQL = "INSERT INTO storage_added(date, user, ingredient_id, count) VALUES(?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setTimestamp(1, getCurrentTimeStamp());
            pstatement.setString(2, getActiveUser());
            pstatement.setInt(3, ing.getId());
            pstatement.setDouble(4, ing.getCount());
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("New AddedProduct was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addAddesItems");
        }
    }
    
}
