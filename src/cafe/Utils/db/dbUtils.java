package cafe.Utils.db;

import cafe.model.Check;
import cafe.view.MainForm;
import cafe.model.Dish;
import cafe.model.Ingredient;
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
public class dbUtils {

    public static final String URL = "jdbc:mysql://localhost:3306/luckyroger";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

//    private static final String URL = "jdbc:mysql://db4free.net:3306/luckyroger";
//    private static final String USERNAME = "luckyroger";
//    private static final String PASSWORD = "luckyroger";
    private static final ArrayList<String> sqlSelectList = new ArrayList<>();
    private static final ArrayList<String> sqlInsertList = new ArrayList<>();
    private static final ArrayList<String> sqlRemoteList = new ArrayList<>();
    

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
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

        sqlInsertList.add("INSERT INTO firstdishes(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO salats(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO rogerdishes(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO pandishes(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO meat(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO pizza(title, priceS) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO pizza(title, pricB) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO sushi(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO dessert(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO drinks(title, price) VALUES(?, ?)");
        sqlInsertList.add("INSERT INTO alcohol(title, price) VALUES(?, ?)");

        sqlRemoteList.add("DELETE FROM firstdishes WHERE Id = ");
        sqlRemoteList.add("DELETE FROM salats WHERE Id = ");
        sqlRemoteList.add("DELETE FROM rogerdishes WHERE Id = ");
        sqlRemoteList.add("DELETE FROM pandishes WHERE Id = ");
        sqlRemoteList.add("DELETE FROM meat WHERE Id = ");
        sqlRemoteList.add("DELETE FROM pizza WHERE Id = ");
        sqlRemoteList.add("DELETE FROM pizza WHERE Id = ");
        sqlRemoteList.add("DELETE FROM sushi WHERE Id = ");
        sqlRemoteList.add("DELETE FROM dessert WHERE Id = ");
        sqlRemoteList.add("DELETE FROM drinks WHERE Id = ");
        sqlRemoteList.add("DELETE FROM alcohol WHERE Id = ");

    }

    public static java.sql.Timestamp getCurrentTimeStamp() {

        Date today = new Date();
        return new java.sql.Timestamp(today.getTime());

    }

    public static void getDBmenu() {

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            ResultSet rs;
            for (int i = 0; i < sqlSelectList.size(); i++) {
                rs = statement.executeQuery(sqlSelectList.get(i));
                if (i == 5) {
                    while (rs.next()) {
                        MainForm.listofCat.get(i).add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("priceS")));
                    }
                } else if (i == 6) {
                    while (rs.next()) {
                        MainForm.listofCat.get(i).add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("priceB")));
                    }
                } else {
                    while (rs.next()) {
                        MainForm.listofCat.get(i).add(
                                new Dish(Integer.parseInt(
                                                rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("price")));
                    }
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getDBmenu");
        }
    }

   

    public static void addDish(Dish dish, int activeCat) {
        for (int i = 0; i < sqlInsertList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {

                    System.out.println(!connection.isClosed() ? "DB connected!"
                            : "Error DB connecting");

                    PreparedStatement pstatement = connection.prepareStatement(sqlInsertList.get(i));
                    pstatement.setString(1, dish.getTitle());
                    pstatement.setInt(2, dish.getPrice());

                    int rowsInserted = pstatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new dish was added successfully!");
                    }

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - addDish");
                }
            }
        }
        for (ArrayList<Dish> category : MainForm.listofCat) {
            category.clear();
        }

        getDBmenu();
    }

    public static void removeDish(int Id, int activeCat) {
        for (int i = 0; i < sqlInsertList.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {

                    System.out.println(!connection.isClosed() ? "DB connected!"
                            : "Error DB connecting");

                    Statement statement = connection.createStatement();
                    statement.executeUpdate("" + sqlRemoteList.get(i) + Id);

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console - removeDish");
                }
            }
        }
        for (ArrayList<Dish> category : MainForm.listofCat) {
            category.clear();
        }

        getDBmenu();
    }

    public static void getStorage() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage ORDER BY title;";
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                MainForm.storageList.add(
                        new Ingredient(
                                rs.getInt("Id"),
                                rs.getString("title")
                        ));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getStorage");
        }

    }
}
