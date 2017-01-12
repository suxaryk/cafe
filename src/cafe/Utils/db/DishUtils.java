package cafe.Utils.db;

import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;
import static cafe.Utils.db.DBUtils.sqlInsertList;
import static cafe.Utils.db.DBUtils.sqlRemoveList;
import static cafe.Utils.db.DBUtils.sqlSelectList;
import static cafe.Utils.db.DBUtils.sqlUpdateIsCookList;
import static cafe.Utils.db.DBUtils.sqlUpdatePriceList;
import static cafe.Utils.db.DBUtils.sqlUpdateTitleList;
import cafe.Utils.json.JSONUtils;
import cafe.model.Dish;
import static cafe.view.MainForm.menu;
import static cafe.view.WeightForm.listOfCoeffic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.apache.log4j.Logger;

public class DishUtils {
    private static final Logger log = Logger.getLogger(DishUtils.class);
    
    public static java.sql.Timestamp getCurrentTimeStamp() {
        Date today = new Date();
        return new java.sql.Timestamp(today.getTime());
    }

    public static void readDBmenu() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {            
            Statement statement = connection.createStatement();
            for (int i = 0; i < sqlSelectList.size(); i++) {
                try (ResultSet rs = statement.executeQuery(sqlSelectList.get(i))) {
                    while (rs.next()) {
                        menu.get(i).getDishes().add(
                        new Dish(Integer.parseInt(rs.getString("Id")),
                                                rs.getString("title"),
                                                rs.getInt("price"),
                                                rs.getBoolean("isCook"),
                                                JSONUtils.getRecipeFromJSON(
                                                rs.getString("ingredients"))
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            log.debug("Connection Failed! Check output console - readDBmenu");
        }
    }

    public static void readDBCategoryById(int activeCat) {
        menu.get(activeCat).getDishes().clear();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {     
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(sqlSelectList.get(activeCat))) {
                while (rs.next()) {
                    menu.get(activeCat).getDishes().add(
                            new Dish(Integer.parseInt(
                                            rs.getString("Id")),
                                    rs.getString("title"),
                                    rs.getInt("price"),
                                    rs.getBoolean("isCook"),
                                    JSONUtils.getRecipeFromJSON(
                                            rs.getString("ingredients"))
                            ));
                }
            }
        } catch (SQLException e) {
            log.debug("Connection Failed! Check output console - readDBCategoryById");
        }
    }

    public static void addDish(Dish dish, int activeCat) {
        for (int i = 0; i < sqlInsertList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {                
                    PreparedStatement pstatement = connection.prepareStatement(sqlInsertList.get(i));
                    pstatement.setString(1, dish.getTitle());
                    pstatement.setInt(2, dish.getPrice());
                    pstatement.setBoolean(3, dish.isCook());
                    pstatement.setString(4, "");
                    int rowsInserted = pstatement.executeUpdate();
                    if (rowsInserted > 0) {
                        log.debug("A new dish was added successfully!, " + dish.getTitle() + " activeCat=" + activeCat);
                    }
                } catch (SQLException e) {
                    log.error("Connection Failed! Check output console - addDish, " + dish.getTitle() + " activeCat=" + activeCat); 
                }
            }
        }

    }

    public static void removeDishById(int dbId, int activeCat) {
        for (int i = 0; i < sqlRemoveList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {                
                    PreparedStatement pstatement = connection.prepareStatement(sqlRemoveList.get(i));
                    pstatement.setInt(1, dbId);

                    int rowsInserted = pstatement.executeUpdate();
                    if (rowsInserted > 0) {
                        log.debug("Dish was removed successfully!, cateforyDBID=" + dbId + " activeCat=" + activeCat);
                    }
                } catch (SQLException e) {
                    log.error("Connection Failed! Check output console - removeDishById, cateforyDBID=" + dbId + " activeCat=" + activeCat);;
                }
            }
        }
    }

    public static void updateDishTitle(int dbId, String name, int activeCat) {
        for (int i = 0; i < sqlUpdateTitleList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    PreparedStatement pst = connection.prepareStatement(sqlUpdateTitleList.get(i));
                    pst.setString(1, name);
                    pst.setInt(2, dbId);
                    int rowsInserted = pst.executeUpdate();
                    if (rowsInserted > 0) {
                        log.debug("updateDishTitle was updated successfully!, cateforyDBID=" + dbId + " activeCat=" + activeCat);
                    }
                } catch (SQLException e) {
                    log.error("Connection Failed! Check output console - updateDishTitle, cateforyDBID=" + dbId + " activeCat=" + activeCat);
                }
            }
        }
    }

    public static void updateDishPrice(int dbId, int pass, int activeCat) {
        for (int i = 0; i < sqlUpdatePriceList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    PreparedStatement pst = connection.prepareStatement(sqlUpdatePriceList.get(i));
                    pst.setInt(1, pass);
                    pst.setInt(2, dbId);
                    int rowsInserted = pst.executeUpdate();
                    if (rowsInserted > 0) {
                        log.debug("updateDishPrice was updated successfully!, cateforyDBID=" + dbId + " activeCat=" + activeCat);
                    }
                } catch (SQLException e) {
                    log.error("Connection Failed! Check output console - updateDishPrice!, cateforyDBID=" + dbId + " activeCat=" + activeCat);
                }
            }
        }
    }
    
    public static void updateCookDishParametr(int dbId, boolean isCook, int activeCat) {
        for (int i = 0; i < sqlUpdatePriceList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    PreparedStatement pst = connection.prepareStatement(sqlUpdateIsCookList.get(i));
                    pst.setBoolean(1, isCook);
                    pst.setInt(2, dbId);
                    int rowsInserted = pst.executeUpdate();
                    if (rowsInserted > 0) {
                        log.debug("IsCook parametr was updated successfully!");
                    }
                } catch (SQLException e) {
                    log.error("Connection Failed! Check output console - updateCookDishParametr");
                }
            }
        }
    }
    
    public static void initDishMeatWeight(){
        final String SQL = "SELECT * from meat_weight";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {            
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    listOfCoeffic.put(rs.getInt("storage_id"), (double) rs.getInt("weight")/100);                    
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - initDishMeatWeight");
        }
    }
    
    public static void updateDishMeatWeight(int storageId, int weight) {
        final String SQL = "UPDATE meat_weight SET weight = ? WHERE  storage_id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, weight);
            pst.setInt(2, storageId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("The DishMeatWeight was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateDishMeatWeight");
        }
    }
    
    public static void createDishMeatWeight(int storageId, int weight) {
        final String SQL = "INSERT INTO meat_weight(storage_id, weight) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setInt(1, storageId);
            pstatement.setInt(2, weight);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("The new DishMeatWeight was added successfully! storageId " + storageId + " weight" + weight);
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - createDishMeatWeight");
        }
    }
}
