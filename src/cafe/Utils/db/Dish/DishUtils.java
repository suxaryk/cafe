package cafe.Utils.db.Dish;

import cafe.Utils.json.JSONUtils;
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


public class DishUtils {

    public static String URL = "jdbc:mysql://localhost:3306/luckyroger";
    public static String USERNAME = "root";
//    public static String PASSWORD = "dbiytdbq18";
    public static String PASSWORD = "root";
    
    //client

//    public static final String URL1 = "jdbc:mysql://db4free.net:3306/luckyroger";
//    public static final String USERNAME1 = "luckyroger";
//    public static final String PASSWORD1 = "luckyroger";
    public static final String URL2 = "jdbc:mysql://suharina.ddns.net:3306/luckyroger";
    public static final String USERNAME2 = "root";
    public static final String PASSWORD2 = "dbiytdbq18";
    
    private static final ArrayList<String> sqlSelectList = new ArrayList<>();
    public static final ArrayList<String> sqlSelectByIdList = new ArrayList<>();
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
//        URL = URL2;
//        USERNAME = USERNAME2;
//        PASSWORD = PASSWORD2;
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Redirection to another SERVER" + URL2);
            URL = URL2;
            USERNAME = USERNAME2;
            PASSWORD = PASSWORD2;
        } catch (Exception e) {

        }

        System.out.println("MySQL JDBC Driver Registered!");

        sqlSelectList.add("select * from firstdishes");
        sqlSelectList.add("select * from salats");
        sqlSelectList.add("select * from rogerdishes");
        sqlSelectList.add("select * from pandishes");
        sqlSelectList.add("select * from meat");
        sqlSelectList.add("select * from pizzaS");
        sqlSelectList.add("select * from pizzaB");
        sqlSelectList.add("select * from sushi");
        sqlSelectList.add("select * from dessert");
        sqlSelectList.add("select * from drinks");
        sqlSelectList.add("select * from bear");
        sqlSelectList.add("select * from alcohol");
        sqlSelectList.add("select * from not_alcohol");
        
        sqlSelectByIdList.add("select * from firstdishes WHERE Id = ?");
        sqlSelectByIdList.add("select * from salats WHERE Id = ?");
        sqlSelectByIdList.add("select * from rogerdishes WHERE Id = ?");
        sqlSelectByIdList.add("select * from pandishes WHERE Id = ?");
        sqlSelectByIdList.add("select * from meat WHERE Id = ?");
        sqlSelectByIdList.add("select * from pizzaS WHERE Id = ?");
        sqlSelectByIdList.add("select * from pizzaB WHERE Id = ?");
        sqlSelectByIdList.add("select * from sushi WHERE Id = ?");
        sqlSelectByIdList.add("select * from dessert WHERE Id = ?");
        sqlSelectByIdList.add("select * from drinks WHERE Id = ?");
        sqlSelectByIdList.add("select * from bear WHERE Id = ?");
        sqlSelectByIdList.add("select * from alcohol WHERE Id = ?");
        sqlSelectByIdList.add("select * from not_alcohol WHERE Id = ?");

        sqlInsertList.add("INSERT INTO firstdishes(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO salats(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO rogerdishes(title, price, isCook,  ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO pandishes(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO meat(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO pizzaS(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO pizzaB(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO sushi(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO dessert(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO drinks(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO bear(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO alcohol(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO not_alcohol(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");

        sqlRemoveList.add("DELETE FROM firstdishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM salats WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM rogerdishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pandishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM meat WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pizzaS WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pizzaB WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM sushi WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM dessert WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM drinks WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM bear WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM alcohol WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM not_alcohol WHERE Id = ?");

        sqlUpdateTitleList.add("UPDATE firstdishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE salats SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE rogerdishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pandishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE meat SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pizzaS SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pizzaB SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE sushi SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE dessert SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE drinks SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE bear SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE alcohol SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE not_alcohol SET title = ? WHERE Id = ?");

        sqlUpdatePriceList.add("UPDATE firstdishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE salats SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE rogerdishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pandishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE meat SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pizzaS SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pizzaB SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE sushi SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE dessert SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE drinks SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE bear SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE alcohol SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE not_alcohol SET price = ? WHERE Id = ?");
    }
    
    public static void chooseServer(int cafeId){
        if (cafeId == 0) {
            URL = "jdbc:mysql://server1cafe.ddns.net:3306/luckyroger";                 
        }else if (cafeId == 1) {
            URL = "jdbc:mysql://server2cafe.ddns.net:3306/luckyroger";
        }else if (cafeId == 2) {
            URL = "jdbc:mysql://server3cafe.ddns.net:3306/luckyroger";
        }
        
    }
    //unused
    public static Dish getDishById(int catId, int dishId){
        for (int i = 0; i < sqlSelectByIdList.size(); i++) {
            if (i == catId) {
                System.out.println("catId " + catId);
                System.out.println("getDishById");
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    PreparedStatement pst = connection.prepareStatement(sqlSelectByIdList.get(catId));
                    pst.setInt(1, dishId);               
                    Dish dish = new Dish();
                    try (ResultSet rs = pst.executeQuery()) {
                        while (rs.next()) {                            
                            dish.setDbID(rs.getInt("Id"));
                            dish.setTitle(rs.getString("title"));
                            dish.setPrice(rs.getInt("price"));
                            dish.setCook(rs.getBoolean("isCook"));
                                dish.setRecipe(JSONUtils.getRecipeFromJSON(rs.getString("ingredients")));
                       
                        }
                    }
                    return dish;
                    
                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - getDishById");
                }                  
            }         
        }
        return null;
    }

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
//            System.out.println("error in " + menu.get(i));
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
//                }
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
