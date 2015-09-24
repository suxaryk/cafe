/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.Dish.DishUtils.PASSWORD;
import static cafe.Utils.db.Dish.DishUtils.URL;
import static cafe.Utils.db.Dish.DishUtils.USERNAME;
import static cafe.Utils.db.Dish.DishUtils.getCurrentTimeStamp;
import cafe.model.Check;
import cafe.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author suxarina
 */
public class CheckUtils {

    private static int checkId;

    public static int getCheckId() {
        return checkId;
    }

    public static void setCheckId(int checkId) {
        CheckUtils.checkId = checkId;
    }
    
    

    public static void addCheck(Check check, User user) {
        final String sql = "INSERT INTO checks( checkId, sum, cookCount, datatime, operator)"
                + " VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(sql);
         
            pstatement.setInt(1, ++checkId);
            pstatement.setInt(2, check.getTotalsum());
            pstatement.setInt(3, check.getCookCount());
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, user.getName());

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addCheck");
        }

    }

    public static int getDaySum() {
        final String SQL = "select SUM(sum) from ("
                + "SELECT * FROM checks"
                + "order by id "
                + "desc limit ?"
                + ") as daysum";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, getDayCount());
            int sum;
            try (ResultSet rs = pst.executeQuery()) {  
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getDaySum");
            return 0;
        }

    }

    public static int getLastCheckId() {
        final String SQL = "SELECT checkId FROM checks"
                + "order by id desc limit 1";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            int last;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                last = 0;
                while (rs.next()) {
                    last = rs.getInt(1);
                }
            }
            return last;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getLastCheckId");
            return 0;
        }
    }

    public static int getDayCount() {
        final String SQL = "SELECT checkId FROM checks"
                + "order by id desc"
                + "limit 1";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            int count;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                count = 0;
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            }
            return count;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getDayCount");
            return 0;
        }
    }

}
