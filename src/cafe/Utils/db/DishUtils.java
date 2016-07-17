package cafe.Utils.db;

import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import cafe.model.Dish;
import static cafe.view.MainForm.menu;

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
        
        for (int i = 0; i < 13; i++) {
            readMenuCategoryById(i);
        }      
    }

    public static void readMenuCategoryById(int categoryId) {
        final String SQL = "SELECT * FROM dish where category_id = " + (categoryId +1) ;
//        menu.get(activeCat).getDishes().clear();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            log.debug(!connection.isClosed() ? "DB connected! readDBCategoryById"
                    : "Error DB connecting readDBCategoryById");
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    menu.get(categoryId).getDishes().add(
                            new Dish(Integer.parseInt(
                                    rs.getString("Id")),
                                    rs.getString("title"),
                                    rs.getInt("price"),
                                    rs.getBoolean("isCook"),
                                    RecepiesUtils.getRecipeByDishId(rs.getInt("Id"))
                            ));
                    int lastDish = menu.get(categoryId).getDishes().size()-1;
                    log.info("read dish " + 
                    menu.get(categoryId).getDishes().get(lastDish).getDbID()+ " " +
                    menu.get(categoryId).getDishes().get(lastDish).getTitle());
                    
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - readDBCategoryById " + e.toString());
        }
    }

    public static void addDish(Dish dish, int activeCat) {
        final String SQL = "INSERT INTO dish(category_id, title, price, isCook) VALUES(?, ?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            log.debug(!connection.isClosed() ? "DB connected! addDish"
                    : "Error DB connecting addDish");
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setInt(1, activeCat);
            pstatement.setString(2, dish.getTitle());
            pstatement.setInt(3, dish.getPrice());
            pstatement.setBoolean(4, dish.isCook());
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new dish was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addDish " + e.toString());
        }

    }

    public static void removeDishById(int dbId) {
        final String SQL = "DELETE FROM dish WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            log.debug(!connection.isClosed() ? "DB connected! removeDishById"
                    : "Error DB connecting removeDishById");
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setInt(1, dbId);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new dish was removed successfully!");
            }
        } catch (SQLException e) {          
            log.error("Connection Failed! Check output console - removeDishById " + e.toString());
        }

    }

    public static void updateTitle(int dbId, String title) {   
        final String SQL = "UPDATE dish SET title = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            log.debug(!connection.isClosed() ? "DB connected! updateDishTitle"
                    : "Error DB connecting updateDishTitle");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, title);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Dish title was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateDishTitle " + e.toString());
        }
     

    }

    public static void updatePrice(int dbId, int pass) { 
        final String SQL = "UPDATE dish SET price = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            log.debug(!connection.isClosed() ? "DB connected! updatePrice"
                    : "Error DB connecting updatePrice");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, pass);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Dish price was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updatePrice " + e.toString());
        }
    }   

}
