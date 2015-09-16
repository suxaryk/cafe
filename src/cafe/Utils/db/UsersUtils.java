/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.dbUtils.PASSWORD;
import static cafe.Utils.db.dbUtils.URL;
import static cafe.Utils.db.dbUtils.USERNAME;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
import java.sql.Connection;
import java.sql.DriverManager;
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
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                userList.add(new User(
                        rs.getString("name"),
                        rs.getInt("pass")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getUsers");
        }
    }

    public static void updateUserPass(int dbId, int pass) {
        final String SQL = "UPDATE users SET pass = " + pass
                + " WHERE Id = " + dbId;
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateUserPass");
        }

    }

    public static void updateUserName(int dbId, String name) {
        final String SQL = "UPDATE users SET name = \"" + name
                + "\" WHERE Id = " + dbId;
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateUserName");
        }

    }

}
