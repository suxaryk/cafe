package cafe.Utils.db;


import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeUtils {

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

    public static boolean isEmployeeLogged() {      
        final String SQL = "SELECT name FROM luckyroger.employee_time where DATE(date_in) = DATE(curdate())";
        List<String> tmpEmplNames = new ArrayList<>(0);
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! isDayCountStarted"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
           
            try (ResultSet rs = statement.executeQuery(SQL)) {             
                while (rs.next()) {
                    tmpEmplNames.add(rs.getString("name"));
                }
            }
            for(String empl: tmpEmplNames){
                if (empl.equals(userList.get(User.active).getName())) {
                    return true;
                }
            }
            return false;
            

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - isEmployeeLogged");
            return false;
        }
    }

    //for find who start first today

    public static Date getStartDayTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String SQL = "SELECT date_in from employee_time where DATE(date_in)=DATE('" + sdf.format(date) + "') LIMIT 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getStartDayTime"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();

            Date newdate = new Date();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    newdate = rs.getTimestamp(1);
                }
            }
            return newdate;

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getStartDayTime");
            return null;
        }
    }

    public static void readEmployeeDayTime(Date date) {
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
        employees.clear();
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

    public static void addTimeOut(User employee) {
        final String SQL = "UPDATE employee_time "
                + "SET date_out = current_timestamp()"
                + "WHERE name = ?"
                + "ORDER BY Id DESC limit 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);          
            pstatement.setString(1, employee.getName());
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Time was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addTimeOut");
        }
    }
    
    
    
    public static void getEmployeeFullWorksDay(Timestamp start, Timestamp end) {
        final String SQL = ""
                + "   SELECT name, Count(hour(TIMEDIFF(date_out, date_in))) as 'full_work_day'"
                + "   FROM employee_time"
                + "   where date_in >= '" + start
                + "'  AND date_out <= '" + end
                + "'  AND hour(TIMEDIFF(date_out, date_in)) >= 12"
                + "   GROUP BY name";        
        
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
           
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {                                      
                    for(Employee empl: employees){
                        if (empl.getName().equals(rs.getString("name"))) {
                            empl.setWorkDaysCount(rs.getInt("full_work_day"));
                            System.out.println("rez " + empl.getWorkDaysCount());
                        }
                    }                                                 
                }
            }        
            System.out.println("getEmployeeFullWorksDay");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeFullWorksDay");
        }
    }   
    public static void getEmployeeHalfWorksDay(Timestamp start, Timestamp end) {
        final String SQL = ""
                + "   SELECT name, Count(hour(TIMEDIFF(date_out, date_in))) as 'half_work_day'"
                + "   FROM employee_time"
                + "   where date_in >= '" + start
                + "'  AND date_out <= '" + end
                + "'  AND hour(TIMEDIFF(date_out, date_in)) < 12"
                + "   GROUP BY name";
        
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
           
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {    
                    for(Employee empl: employees){
                        if (empl.getName().equals(rs.getString("name"))) {
                            empl.setHalfWorkDaysCount(rs.getInt("half_work_day"));
                            System.out.println("rez " + rs.getInt("half_work_day"));
                        }
                    }                                                 
                }
            }        
            System.out.println("getEmployeeHalfWorksDay");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeHalfWorksDay");
        }
            
    }   
   
    

}
