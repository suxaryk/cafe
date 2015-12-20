package cafe.Utils.db;

import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import static cafe.Utils.db.DbConnect.sqlInsertList;
import static cafe.Utils.db.DbConnect.sqlRemoveList;
import static cafe.Utils.db.DbConnect.sqlSelectList;
import static cafe.Utils.db.DbConnect.sqlUpdatePriceList;
import static cafe.Utils.db.DbConnect.sqlUpdateTitleList;
import cafe.Utils.json.JSONUtils;
import cafe.model.Dish;
import static cafe.view.MainForm.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DishUtils {



    public static java.sql.Timestamp getCurrentTimeStamp() {
        Date today = new Date();
        return new java.sql.Timestamp(today.getTime());
    }

    public static void readDBmenu() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected! readDBmenu"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            for (int i = 0; i < sqlSelectList.size(); i++) {
                try (ResultSet rs = statement.executeQuery(sqlSelectList.get(i))) {
                    while (rs.next()) {
                        menu.get(i).
                                getDishes().add(
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
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readDBmenu");
        }
    }

    public static void readDBCategoryById(int activeCat) {
        menu.get(activeCat).getDishes().clear();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {

            System.out.println(!connection.isClosed() ? "DB connected! readDBCategoryById"
                    : "Error DB connecting");
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
            System.out.println("Connection Failed! Check output console - readDBCategoryById");
        }
    }

    public static void addDish(Dish dish, int activeCat) {
        for (int i = 0; i < sqlInsertList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    System.out.println(!connection.isClosed() ? "DB connected! addDish"
                            : "Error DB connecting");
                    PreparedStatement pstatement = connection.prepareStatement(sqlInsertList.get(i));
                    pstatement.setString(1, dish.getTitle());
                    pstatement.setInt(2, dish.getPrice());
                    pstatement.setBoolean(3, dish.isCook());
                    pstatement.setString(4, "");
                    int rowsInserted = pstatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new dish was added successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - addDish");
                }
            }
        }

    }

    public static void removeDishById(int dbId, int activeCat) {
        for (int i = 0; i < sqlRemoveList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    System.out.println(!connection.isClosed() ? "DB connected! removeDishById"
                            : "Error DB connecting");
                    PreparedStatement pstatement = connection.prepareStatement(sqlRemoveList.get(i));
                    pstatement.setInt(1, dbId);

                    int rowsInserted = pstatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new dish was removed successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - removeDishById");
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
                        System.out.println("Name was updated successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - updateDishTitle");
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
                        System.out.println("Price was updated successfully!");
                    }
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - updateDishPrice");
                }
            }
        }
    }

}
