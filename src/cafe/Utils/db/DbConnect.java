/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author suxarina
 */
public class DbConnect {
//        public static String URL = "jdbc:mysql://server1cafe.ddns.net:3306/luckyroger";

    public static String URL = "jdbc:mysql://localhost:3306/luckyroger";
    public static String USERNAME = "root";
//    public static String PASSWORD = "dbiytdbq18";
    public static String PASSWORD = "root";

    public static final ArrayList<String> sqlSelectList = new ArrayList<>();
    public static final ArrayList<String> sqlSelectByIdList = new ArrayList<>();
    public static final ArrayList<String> sqlInsertList = new ArrayList<>();
    public static final ArrayList<String> sqlRemoveList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdateTitleList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdatePriceList = new ArrayList<>();

    static {
        //uncoment for stat chooseServer
//        chooseServer(0);
        ConnectDb();
        initQueries();

    }

    private static void ConnectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
        }

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting");

        } catch (SQLException e) {
            System.out.println("Connection to DB Failed! ");
            JFrame frame = new JFrame();
            int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
                    "Помилка підключення до бази данних!\nВихід з програми", "ПОМИЛКА!",
                    0, JOptionPane.YES_NO_OPTION, null, new String[]{"OK"}, null);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } catch (Exception e) {

        }

    }

    private static void initQueries() {
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

    public static void chooseServer(int cafeId) {
        if (cafeId == 0) {
            URL = "jdbc:mysql://93.183.216.29:3306/luckyroger";
        } else if (cafeId == 1) {
            URL = "jdbc:mysql://server2cafe.ddns.net:3306/luckyroger";
        } else if (cafeId == 2) {
            URL = "jdbc:mysql://server3cafe.ddns.net:3306/luckyroger";
        }

    }
}
