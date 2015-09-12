package cafe.Utils;

import cafe.model.Check;
import cafe.view.MainForm;
import cafe.model.Dish;
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

    private static final String URL = "jdbc:mysql://localhost:3306/luckyroger";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    
//    private static final String URL = "jdbc:mysql://db4free.net:3306/luckyroger";
//    private static final String USERNAME = "luckyroger";
//    private static final String PASSWORD = "luckyroger";


    private static final ArrayList<String> sqlList = new ArrayList<>();
    private static int checkId;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();            
        }
        System.out.println("MySQL JDBC Driver Registered!");
        
        sqlList.add("select * from firstdishes");
        sqlList.add("select * from salats");
        sqlList.add("select * from rogerdishes");
        sqlList.add("select * from pandishes");
        sqlList.add("select * from meat");
        sqlList.add("select * from pizza");
        sqlList.add("select * from pizza");
        sqlList.add("select * from sushi");
        sqlList.add("select * from dessert");
        sqlList.add("select * from drinks");
        sqlList.add("select * from alcohol");
        
    }
    private static java.sql.Timestamp getCurrentTimeStamp() {

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
            for (int i = 0; i < sqlList.size(); i++) {
                rs = statement.executeQuery(sqlList.get(i));
                if (i == 5) {
                    while (rs.next()) {
                        MainForm.listofCat.get(i).add(
                                new Dish(Integer.parseInt(
                                        rs.getString("Id")),
                                        rs.getString("title"),
                                        rs.getInt("priceS")));
                    }
                } else 
                    if (i == 6) {
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
            System.out.println("Connection Failed! Check output console");
        }
    }

    public static void addCheck(Check check) {      
        final String sql = "INSERT INTO checks( checkId, sum, datatime)"
                                                    +" VALUES(?, ?, ?)";
        final String sql1 = "SELECT COUNT(checkId) FROM checks";

        
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");            

            PreparedStatement pstatement = connection.prepareStatement(sql);
            //pstatement.setInt(1, (count+1));
            pstatement.setInt(1, ++checkId);
            pstatement.setInt(2, check.getTotalsum());
            pstatement.setTimestamp(3, getCurrentTimeStamp());
           

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
          
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        }

    }

}
