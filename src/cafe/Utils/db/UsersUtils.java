/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.Dish.DishUtils.PASSWORD;
import static cafe.Utils.db.Dish.DishUtils.URL;
import static cafe.Utils.db.Dish.DishUtils.USERNAME;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
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
public class UsersUtils {

    public static void readAllUsers() {
        final String SQL = "SELECT name, pass from users";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    userList.add(new User(
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

}
