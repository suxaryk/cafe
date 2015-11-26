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
import cafe.model.Employee;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
import static cafe.view.MainForm.employees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author suxarina
 */
public class EmployeeUtils {
    
    
    
//    public static Employee getEmployeeById(int dbId) {
//        final String SQL = "SELECT * from employee WHERE Id = " + dbId;
//        try (Connection connection = DriverManager
//                .getConnection(URL, USERNAME, PASSWORD)) {
//
//            Statement statement = connection.createStatement();
//            try (ResultSet rs = statement.executeQuery(SQL)) {
//                while (rs.next()) {
//                    return new Employee(
//                            rs.getInt("Id"),
//                            rs.getString("name"),
//                            rs.getInt("pass")                          
//                    );
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console - getEmployeeById");
//        }
//        return null;
//    }
    public static void getEmployeeTime(Date date) {
        final String SQL = "SELECT * from employee_time WHERE DATE(date_in) = DATE('" + date + "')";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            employees.clear();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getInt("Id"),
                            rs.getString("name"),
                            rs.getTimestamp("date_in"),
                            rs.getTimestamp("date_out")                            
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeTime");
        }
    }
   
    public static void readEmployeeDayTime(Date date) {
//        final String SQL = "select * from employee_time where date_in > '"+ userList.get(User.active).getStartTime()+"'";
        final String SQL = "SELECT * from employee_time WHERE DATE(date_in) = DATE('" + date + "')";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    for (Employee employee : employees) {
                        if (employee.getName().equals(rs.getString("name"))) {
                            employee.setStartTime(rs.getTimestamp("date_in"));
                            employee.setEndTime(rs.getTimestamp("date_out"));
                        }                              
                    }
                    for (User user : userList) {
                        if (user.getName().equals(rs.getString("name"))) {
                            user.setStartTime(rs.getTimestamp("date_in"));
                            user.setEndTime(rs.getTimestamp("date_out"));                            
                        }
                        
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeDayTime");
        }
    }

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
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getInt("Id"),
                            rs.getString("name"),
                            rs.getInt("pass")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - setAllEmployees");
        }

    }

    public static void removeById(int dbId) {
        final String SQL = "DELETE FROM employee WHERE Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee was removed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - removeEmployee");
        }

    }

    public static void updateEmployeePass(int dbId, int pass) {
        final String SQL = "UPDATE employee SET pass = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, pass);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateEmployeePass");
        }

    }

    public static void updateEmployeeName(int dbId, String name) {
        final String SQL = "UPDATE employee SET name = ? WHERE Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, name);
            pst.setInt(2, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateEmployeeName");
        }

    }
    
    public static void addTimeIn(User employee) {
        final String SQL = "INSERT INTO employee_time(name, date_in) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            System.out.println("name" + employee.getName());
            pstatement.setString(1, employee.getName());
            pstatement.setTimestamp(2, getCurrentTimeStamp());
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Time was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addTimeIn");
        }
    }
    public static void addTimeOut(Employee employee) {
        final String SQL = "UPDATE employee_time SET date_out = ? WHERE name = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);                     
            pstatement.setTimestamp(1, getCurrentTimeStamp());
            pstatement.setString(2, employee.getName());
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Time was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addTimeOut");
        }
    }
    
    

}
