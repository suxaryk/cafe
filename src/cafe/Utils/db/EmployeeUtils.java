/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.dbUtils.PASSWORD;
import static cafe.Utils.db.dbUtils.URL;
import static cafe.Utils.db.dbUtils.USERNAME;
import cafe.model.Employee;
import static cafe.view.MainForm.employeeList;
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
public class EmployeeUtils {

    public static void addEmployeeToDB(String name, int pass) {
        final String SQL = "INSERT INTO employee(name, pass) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, name);
            pstatement.setInt(2, pass);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Employee was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addEmployeeToDB");
        }
    }

    public static void readAllEmployees() {
        final String SQL = "SELECT Id, name, pass from employee ORDER BY Id";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("pass")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - setAllEmployees");
        }

    }
//    public static void setEmployee(int dbId) {
//        final String SQL = "SELECT Id, name, pass from employee "               
//                                                 +"where Id = " + (dbId);
//
//        try (Connection connection = DriverManager
//                .getConnection(URL, USERNAME, PASSWORD)) {
//
//            System.out.println(!connection.isClosed() ? "DB connected!"
//                    : "Error DB connecting");
//
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(SQL);
//            while (rs.next()) {
//                employeeList.set(dbId-1, new User(
//                        rs.getInt("Id"),
//                        rs.getString("name"),
//                        rs.getInt("pass")
//                ));
//            }
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console - setEmployee");
//        }
//
//    }

    public static void removeById(int dbId) {
        final String SQL = "DELETE FROM employee WHERE Id = " + dbId;

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - removeEmployee");
        }

    }

    public static void updateEmployeePass(int dbId, int pass) {
        final String SQL = "UPDATE employee SET pass = " + pass
                + " WHERE Id = " + dbId;
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - setEmployeePass");
        }

    }

    public static void updateEmployeeName(int dbId, String name) {
        final String SQL = "UPDATE employee SET name = \"" + name
                + "\" WHERE Id = " + dbId;

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - setEmployeeName");
        }

    }

}
