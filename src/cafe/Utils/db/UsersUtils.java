package cafe.Utils.db;

import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UsersUtils {

    public static void readAllUsers() {
        userList.clear();
        final String SQL = "SELECT * from users";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    userList.add(new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("pass")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readAllUsers");
        }
    }

    public static void updateUserPass(int dbId, int pass) {
        final String SQL = "UPDATE users SET pass = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, pass);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new User was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateUserPass");
        }
    }

    public static void updateUserName(int dbId, String name) {
        final String SQL = "UPDATE users SET name = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, name);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new User was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateUserName");
        }
    }

    public static void readUserDayTime(Date date) {
        final String SQL = "select * from employee_time where name = '" + userList.get(User.active) + "' ORDER BY id DESC LIMIT 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    userList.get(User.active).setStartTime(rs.getTimestamp("date_in"));
                    userList.get(User.active).setEndTime(rs.getTimestamp("date_out"));
                    System.out.println("date in " + rs.getTimestamp("date_in"));
                    System.out.println("date out " + rs.getTimestamp("date_out"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeDayTime");
        }
    }

}
