package cafe.Utils.db.Dish;

import cafe.Utils.json.JSONUtils;
import cafe.view.MainForm;
import cafe.model.Dish;
import static cafe.view.MainForm.menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author suxarina
 */
public class DishUtils {

    public static  String URL = "jdbc:mysql://localhost:3306/luckyroger";
    public static  String USERNAME = "root";
    public static  String PASSWORD = "root";

    public static final String URL1 = "jdbc:mysql://db4free.net:3306/luckyroger";
    public static final String USERNAME1 = "luckyroger";
    public static final String PASSWORD1 = "luckyroger";
    
    private static final ArrayList<String> sqlSelectList = new ArrayList<>();
    private static final ArrayList<String> sqlInsertList = new ArrayList<>();
    private static final ArrayList<String> sqlRemoveList = new ArrayList<>();
    private static final ArrayList<String> sqlUpdateTitleList = new ArrayList<>();
    private static final ArrayList<String> sqlUpdatePriceList = new ArrayList<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");           
        }
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected to " +URL
                    : "Error DB connecting");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Redirection to another SERVER");
            URL = URL1;
            USERNAME = USERNAME1;
            PASSWORD = PASSWORD1;
        } catch (Exception e) {            
            
        }

        System.out.println("MySQL JDBC Driver Registered!");

        sqlSelectList.add("select * from firstdishes");
        sqlSelectList.add("select * from salats");
        sqlSelectList.add("select * from rogerdishes");
        sqlSelectList.add("select * from pandishes");
        sqlSelectList.add("select * from meat");
        sqlSelectList.add("select * from pizza");
        sqlSelectList.add("select * from pizza");
        sqlSelectList.add("select * from sushi");
        sqlSelectList.add("select * from dessert");
        sqlSelectList.add("select * from drinks");
        sqlSelectList.add("select * from alcohol");

        sqlInsertList.add("INSERT INTO firstdishes(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO salats(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO rogerdishes(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO pandishes(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO meat(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO pizza(title, priceS, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO pizza(title, pricB, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO sushi(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO dessert(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO drinks(title, price, ingredients) VALUES(?, ?, ?)");
        sqlInsertList.add("INSERT INTO alcohol(title, price, ingredients) VALUES(?, ?, ?)");

        sqlRemoveList.add("DELETE FROM firstdishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM salats WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM rogerdishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pandishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM meat WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pizza WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pizza WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM sushi WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM dessert WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM drinks WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM alcohol WHERE Id = ?");

        sqlUpdateTitleList.add("UPDATE firstdishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE salats SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE rogerdishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pandishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE meat SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pizza SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pizza SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE sushi SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE dessert SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE drinks SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE alcohol SET title = ? WHERE Id = ?");

        sqlUpdatePriceList.add("UPDATE firstdishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE salats SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE rogerdishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pandishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE meat SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pizza SET priceS = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pizza SET priceB = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE sushi SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE dessert SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE drinks SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE alcohol SET price = ? WHERE Id = ?");
    }

    public static java.sql.Timestamp getCurrentTimeStamp() {
        Date today = new Date();
        return new java.sql.Timestamp(today.getTime());
    }

    public static void readDBmenu() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            ResultSet rs;
            int activeDish = 0;
            for (int i = 0; i < sqlSelectList.size(); i++) {
                rs = statement.executeQuery(sqlSelectList.get(i));
                if (i == 5) {
                    while (rs.next()) {
                            menu.get(i).getDishes().add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("priceS")                                       
                        ));
                        JSONUtils.setJSONToRecipe(
                                rs.getString("ingredientsS"), i, activeDish++);
                    }
                } else if (i == 6) {
                    while (rs.next()) {
                            menu.get(i).getDishes().add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("priceB")
                                        
                                ));
                        JSONUtils.setJSONToRecipe(
                                rs.getString("ingredientsB"), i, activeDish++);
                    }
                } else if (i == 10) {
                    while (rs.next()) {
                            menu.get(i).getDishes().add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("price")
                                ));
//                        JSONUtils.setJSONToRecipe(
//                              rs.getString("ingredients"), i, activeDish++);
                    }
                } else {                
                    while (rs.next()) {                                               
                            menu.get(i).getDishes().add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("price")
                                ));
                        JSONUtils.setJSONToRecipe(
                                rs.getString("ingredients"), i, activeDish++);
                    }               
                }
                activeDish = 0;
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readDBmenu");
        }
    }

    public static void readDBCategoryById(int activeCat) {

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            ResultSet rs;

            rs = statement.executeQuery(sqlSelectList.get(activeCat));
            if (activeCat == 5) {
                while (rs.next()) {
                        menu.get(activeCat).getDishes().add(
                            new Dish(Integer.parseInt(
                                            rs.getString("Id")),
                                    rs.getString("title"),
                                    rs.getInt("priceS")
                                  ));
                }
            } else if (activeCat == 6) {
                while (rs.next()) {
                        menu.get(activeCat).getDishes().add(
                            new Dish(Integer.parseInt(
                                            rs.getString("Id")),
                                    rs.getString("title"),
                                    rs.getInt("priceB")
                                  ));
                }
            } else {
                while (rs.next()) {
                        menu.get(activeCat).getDishes().add(
                            new Dish(Integer.parseInt(
                                            rs.getString("Id")),
                                    rs.getString("title"),
                                    rs.getInt("price")
                                  ));
                }
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readDBCategoryById");
        }
    }

    public static void addDish(Dish dish, int activeCat) {
        for (int i = 0; i < sqlInsertList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    System.out.println(!connection.isClosed() ? "DB connected!"
                            : "Error DB connecting");
                    System.out.println("activeCat" + activeCat);
                    System.out.println("title" + dish.getTitle());
                    System.out.println("price" + dish.getPrice());

                    PreparedStatement pstatement = connection.prepareStatement(sqlInsertList.get(i));
                    pstatement.setString(1, dish.getTitle());
                    pstatement.setInt(2, dish.getPrice());   
                    pstatement.setString(3, "");
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
                    System.out.println(!connection.isClosed() ? "DB connected!"
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
