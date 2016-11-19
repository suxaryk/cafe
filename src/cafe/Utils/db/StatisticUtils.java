package cafe.Utils.db;

import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.StorageUtils.fullJoinIngLists;
import static cafe.Utils.db.StorageUtils.fullJoinOrderItemLists;
import cafe.Utils.json.JSONUtils;
import static cafe.Utils.json.JSONUtils.convertJSONToOrder;
import cafe.model.Employee;
import cafe.model.Ingredient;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
import cafe.view.MainForm;
import static cafe.view.MainForm.employees;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticUtils {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dbiytdbq18";
    private static final String HOST = "";
    private static final String R_HOST = "localhost";
    private static final int PORT = 22;
    private static final int L_PORT = 3306;
    private static final int R_PORT = 3306;
    
    private static Connection connect = null;
    private static Session session = null;
    
    
    public static void main(String args[]) {
        try {
            Connection connection = getSSHConnection();
            readAllUsers(connection);
            for (User user : userList) {
                System.out.println(user.getName());
            }         
        } catch (SQLException e) {
            System.err.println("SQL Exception in ssh");
        }finally{
            closeAllConnections();
        }                 
    }
    
   
    
    
    public static Connection getSSHConnection() throws SQLException{       
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(USERNAME, HOST, PORT);      
            session.setPassword(PASSWORD);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "3");
            session.setConfig(config);
            System.out.println("Establishing Connection...");
            session.connect();
            if (session.isConnected()) {
                System.out.println("Ssh session is open...");
            }
//            session.setPortForwardingL(L_PORT, R_HOST, R_PORT);            
//            String url = "jdbc:mysql://" + R_HOST + ":" + L_PORT + "/";
            String url = "jdbc:mysql://localhost:3306/luckyroger";
            String db = "luckyroger";
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connect = DriverManager.getConnection(url, USERNAME, PASSWORD);
                if (!connect.isClosed()) {
                    System.out.println("Mysql connection is open...");                    
                }             
            } catch (SQLException ex) {
                Logger.getLogger(StatisticUtils.class.getName()).log(Level.SEVERE, null, ex);
                throw new SQLException();
            }
        } catch (Exception e) {            
            System.err.println(e);
        }finally{                
            return connect;            
        }
    }
    
    private static void closeAllConnections() {
        CloseDataBaseConnection();
        CloseSSHConnection();
    }

    private static void CloseDataBaseConnection() {
        try {
            if (connect != null && !connect.isClosed()) {
                System.out.println("Closing Database Connection");
                connect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void CloseSSHConnection() {
        if (session != null && session.isConnected()) {
            System.out.println("Closing SSH Connection");
            session.disconnect();
        }
    }
    
  
    
    private static void readAllUsers(Connection connection) {
        userList.clear();
        final String SQL = "SELECT * from users";
        try (Statement statement = connection.createStatement()) {            
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    userList.add(new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("pass")
                    ));
                }
                System.out.println("DB readAllUsers");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readAllUsers");
        }
    }
    
    private static List<Date> getReviziaDates() {
        List<Date> reviziaDates = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            final String SQL = "SELECT distinct date(date) "
                    + "FROM revizia ORDER BY date DESC";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                reviziaDates.add(rs.getDate(1));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed!"
                    + " Check output console - getReviziaDates" + e);

        } finally {
            System.out.println("DB getReviziaDates");
            return reviziaDates;
        }
    }
    
    private static void readAllEmployees() {
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
                System.out.println("DB readAllEmployees");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - setAllEmployees");
        }

    }
    
    private static List<Order> getOrdersBetween(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' ORDER BY Id DESC";
        List<Order> loadOrders = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getOrders"
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    Order tmpOrder = new Order();
                    tmpOrder.setId(rs.getInt("Id"));
                    tmpOrder.setDayId(rs.getInt("dayId"));
                    tmpOrder.setOrderSum(rs.getInt("sum"));
                    tmpOrder.setCookCount(rs.getInt("cookCount"));
                    tmpOrder.setDate(rs.getTimestamp("datatime"));
                    tmpOrder.setUser(rs.getString("operator"));
                    tmpOrder.setItems(JSONUtils.convertJSONToOrder(rs.getString("order_items")));
                    tmpOrder.setRemovedItems(JSONUtils.convertJSONToOrder(rs.getString("removed_items")));
                    loadOrders.add(tmpOrder);
                }
            }
            return loadOrders;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getOrdersBetween");
            return null;
        }
    }
        
    private static void getEmployeeFullWorksDay(Timestamp start, Timestamp end) {
        final String SQL = ""
                + "   SELECT name, COUNT(diff) as full_work_day"
                + "   FROM employee_time"
                + "   where date_in >= '" + start
                + "'  AND date_in <= '" + end
                + "'  AND diff >= 12"
                + "   AND name = ?";
        for (Employee empl : employees) {
            empl.setWorkDaysCount(0);
            empl.setHalfWorkDaysCount(0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("getEmployeeFullWorksDay->");
        System.out.println("start " + sdf.format(new Date(start.getTime())));
        System.out.println("end " + sdf.format(new Date(end.getTime())));
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            for (Employee empl : employees) {
                try (PreparedStatement pstatement = connection.prepareStatement(SQL)) {
                    pstatement.setString(1, empl.getName());
                    ResultSet rs = pstatement.executeQuery();
                    while (rs.next()) {
                        if (empl.getName().equals(rs.getString("name"))) {
                            empl.setWorkDaysCount(rs.getInt("full_work_day"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error execute query prepare statment getEmployeeFullWorksDay");
                }
            }
            System.out.println("DB connection getEmployeeFullWorksDay");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeFullWorksDay");
        }
    }

    private static void getEmployeeHalfWorksDay(Timestamp start, Timestamp end) {
        final String SQL = ""
                + "   SELECT name, COUNT(diff) as half_work_day"
                + "   FROM employee_time"
                + "   where date_in >= '" + start
                + "'  AND date_in <= '" + end
                + "'  AND diff < 12"
                + "   AND name = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            for (Employee empl : employees) {
                try (PreparedStatement pstatement = connection.prepareStatement(SQL)) {
                    pstatement.setString(1, empl.getName());
                    ResultSet rs = pstatement.executeQuery();
                    while (rs.next()) {
                        if (empl.getName().equals(rs.getString("name"))) {
                            empl.setHalfWorkDaysCount(rs.getInt("half_work_day"));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error execute query prepare statment getEmployeeHalfWorksDay");
                }
            }
            System.out.println("DB connection getEmployeeHalfWorksDay");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getEmployeeHalfWorksDay");
        }
    }
    
    private static void readStorage() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage";
            System.out.println(!connection.isClosed() ? "DB connected! readStorage"
                    : "Error DB connecting");
            MainForm.storageList.clear();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                MainForm.storageList.add(
                        new Ingredient(
                                rs.getInt("Id"),
                                rs.getString("title"),
                                rs.getDouble("count")
                        ));
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readStorage");
        }

    }
    
    private static List<Ingredient> getRemovedIngredients(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from storage_removed where"
                + " date >= '" + start
                + "' AND date <= '" + end
                + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getRemovedIngredients"
                    : "Error DB connecting");
            List<Ingredient> removedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinIngLists(removedList,
                            JSONUtils.convertJSONToRemovedIng(
                                    rs.getString("removed_ingredients"))
                    );
                }
                System.out.println("read removedList size = " + removedList.size());
                return removedList;
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getRemovedIngredients ");
            return null;
        }
    }
    
    private static List<Ingredient> getAddedIngredients(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from storage_added where"
                + " date >= '" + start
                + "' AND date <= '" + end
                + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getAddedIngredients"
                    : "Error DB connecting");
            List<Ingredient> addedList = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinIngLists(addedList,
                            JSONUtils.convertJSONToRemovedIng(
                                    rs.getString("added_ingredients"))
                    );
                }
                System.out.println("read addedList size = " + addedList.size());
                return addedList;
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAddedIngredients ");
            return null;
        }
    }
    
    private static List<OrderItem> getOrderedDishes(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' AND sum >= 0 ";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getOrderedDishes"
                    : "Error DB connecting");
            List<OrderItem> orderedDishes = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    fullJoinOrderItemLists(orderedDishes,
                            convertJSONToOrder(rs.getString("order_items"))
                    );
                }
                System.out.println("read orderedDishes size = " + orderedDishes.size());
                return orderedDishes;
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getOrderedDishes ");
            return null;
        }
    }
    
    private static void getCustomSumKeyMoneyForUserBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(sum) from orders where"
                + " operator  = ?"
                + "AND sum < 0 AND coments = ''"
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement pstatement = connection.prepareStatement(SQL)) {
            System.out.println(!connection.isClosed() ? "DB connected! "
                    : "Error DB connecting");

            for (Employee employee : employees) {
                pstatement.setString(1, employee.getName());
                int sum;
                try (ResultSet rs = pstatement.executeQuery()) {
                    sum = 0;
                    while (rs.next()) {
                        sum = rs.getInt(1);
                    }
                }
                employee.setKeyMoney(sum);
                System.out.println("getSumKeyMoneyForUser = " + employee.getName());
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getSumKeyMoney= ");
        }
    }
    
    private static List<Order> getInkassOrders(Timestamp start, Timestamp end) {
        final String SQL = "select * from orders where coments != ''"
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        List<Order> inkassOrders = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getInkassOrders"
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    Order tmpOrder = new Order();
                    tmpOrder.setOrderSum(rs.getInt("sum"));
                    tmpOrder.setDate(rs.getTimestamp("datatime"));
                    tmpOrder.setUser(rs.getString("operator"));
                    tmpOrder.setComent(rs.getString("coments"));

                    inkassOrders.add(tmpOrder);
                }
            }
            return inkassOrders;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getInkassOrders");
            return null;
        }
    }
    
    private static void getUserKasa(Timestamp start, Timestamp end) {
        final String SQL = "SELECT SUM(sum) from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' AND sum > 0"
                + " AND operator = ? ";
        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement pstatement = connection.prepareStatement(SQL)) {
            for (User user : userList) {
                pstatement.setString(1, user.getName());
                int kasa = 0;
                try (ResultSet rs = pstatement.executeQuery()) {
                    while (rs.next()) {
                        kasa = rs.getInt(1);
                    }
                }
                user.setKasa(kasa);
                System.out.println("getUserKasa" + user.getName() + " kasa = " + kasa);
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getUserKasa ");
        }

    }
    
    
    
    
}
