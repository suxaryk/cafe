package cafe.Utils.db;

import static cafe.Utils.db.Dish.DishUtils.PASSWORD;
import static cafe.Utils.db.Dish.DishUtils.URL;
import static cafe.Utils.db.Dish.DishUtils.USERNAME;
import static cafe.Utils.db.Dish.DishUtils.getCurrentTimeStamp;
import cafe.Utils.json.JSONUtils;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.User;
import cafe.view.LoginForm;
import static cafe.view.LoginForm.userList;
import static cafe.view.MainForm.DAY_START_TIME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author suxarina
 */
public class OrderUtils {

    public static int dbId = 1;

    public static int getOrderId() {
        return dbId;
    }

    public static void setOrderId(int checkId) {
        OrderUtils.dbId = checkId;
    }

    public static int getUserKasa(Timestamp start, Timestamp end, int index) {
        final String SQL = "SELECT SUM(sum) from orders where"
                + " datatime >= '" + start 
                + "' AND datatime <= '" + end 
                + "' AND sum > 0"
                + " AND operator ='" 
                + LoginForm.userList.get(index).getName() + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getUserKasa" + index
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }            
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getUserKasa " + index);
            return 0;
        }
        return 0;
    }

    public static int getUserDishCount(Timestamp start, Timestamp end, int index) {
        final String SQL = "SELECT SUM(cookCount) from orders where datatime >= '"
                + start + "' AND datatime <= '"
                + end + "' AND operator ='"
                + LoginForm.userList.get(index).getName() + "'";      
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getUserDishCount" + index
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getUserDishCount " + index);
            return 0;
        }
        return 0;
    }

    public static List<Order> getOrdersBetween(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
//                + "' AND sum > 0"
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
                    tmpOrder.setDayId(rs.getInt("orderId"));
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

    public static void addOrder(Order order, User user, String message) {
        final String sql = "INSERT INTO orders(dayId, orderId, sum, cookCount, datatime, operator, order_items, removed_items, coments)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! addOrder"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(sql);
            for (OrderItem item : order.getItems()) {
                System.out.println("----------title " + item.getDish().getTitle() + " count " + item.getCount());
            }        
           
            pstatement.setInt(1, dbId++);
            pstatement.setInt(2, order.getDayId());
            pstatement.setInt(3, order.getOrderSum());
            pstatement.setInt(4, order.getCookCount());          
            pstatement.setTimestamp(5, getCurrentTimeStamp());
            pstatement.setString(6, user.getName());
            pstatement.setString(7, order.getJSONItems());
            pstatement.setString(8, order.getJSONRemovedItems());
            pstatement.setString(9, message);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addOrder");
        }
    }
    public static void addDayInfo(Date start, Date end, String info) {
        final String sql = "INSERT INTO day_info(time_start, time_end, info)"
                + " VALUES(?, ?, ?)";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! addDayInfo"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(sql);          
          
            pstatement.setTimestamp(1, new Timestamp(start.getTime()));
            pstatement.setTimestamp(2, new Timestamp(end.getTime()));
            pstatement.setString(3, info);          
        

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new DayInfo was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addDayInfo");
        }
    }
    
    public static String getDayInfo() {
        final String SQL = "SELECT * FROM day_info ORDER BY Id DESC LIMIT 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getDaySum"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();            
            String info ="";
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    info = rs.getString("info");
                }
            }
            return info;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getDaySum");
            return "";
        }
    }

    public static void updateTable(Order order, User user, int activeTable) {
        final String SQL = "UPDATE tables set orderId=?, sum=?, cookCount=?, datatime=?, operator=?, order_items=?, removed_items=? where Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! updateTable"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(SQL);

            pstatement.setInt(1, order.getDayId());
            pstatement.setInt(2, order.getOrderSum());
            pstatement.setInt(3, order.getCookCount());
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, user.getName());
            pstatement.setString(6, order.getJSONItems());
            pstatement.setString(7, order.getJSONRemovedItems());
            pstatement.setInt(8, activeTable);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateTable");
        }

    }

    //unused

    public static void updatePrintedTable(Order order, User user, int activeTable) {
        final String SQL = "UPDATE tables set printed=?, where Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! updatePrintedTable"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(SQL);

//            pstatement.setInt(1, order.getPtinted());                       
//            pstatement.setInt(8, activeTable);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateTable");
        }

    }

    //unused

    public static void fillAllTables() {
        final String SQL = "UPDATE tables set sum=?,  cookCount=?, datatime=?, operator=?, order_items=?, removed_items=? where Id > 0";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! fillAllTables"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(SQL);

            pstatement.setInt(1, 0);
            pstatement.setInt(2, 0);
            pstatement.setTimestamp(3, getCurrentTimeStamp());
            pstatement.setString(4, "");
            pstatement.setString(5, "");
            pstatement.setString(6, "");

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - fillTable");
        }
    }

    public static void fillTableById(int activeTable) {
        final String SQL = "UPDATE tables set orderId=?, sum=?,  cookCount=?, datatime=?, operator=?, order_items=?, removed_items=? where Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! fillTableById"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(SQL);

            pstatement.setInt(1, 0);
            pstatement.setInt(2, 0);
            pstatement.setInt(3, 0);
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, "");
            pstatement.setString(6, "");
            pstatement.setString(7, "");
            pstatement.setInt(8, activeTable);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - fillTableById");
        }
    }

    public static Map<Integer, Order> loadTables() {
        final String SQL = "SELECT * from tables where sum > 0";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! loadTables"
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            Map<Integer, Order> loadOrders = new HashMap();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    Order tmpOrder = new Order();
                    tmpOrder.setDayId(rs.getInt("orderId"));
                    tmpOrder.setOrderSum(rs.getInt("sum"));
                    tmpOrder.setCookCount(rs.getInt("cookCount"));
                    tmpOrder.setItems(JSONUtils.convertJSONToOrder(rs.getString("order_items")));
                    tmpOrder.setRemovedItems(JSONUtils.convertJSONToOrder(rs.getString("removed_items")));
                    loadOrders.put(rs.getInt("Id"), tmpOrder);
                }
            }
            return loadOrders;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateTable");
            return null;
        }

    }

    public static int getDaySum(int dayOrderCount) {
        final String SQL = "select SUM(sum) from (SELECT * FROM orders order by id desc limit ?) as daysum";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getDaySum"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, dayOrderCount);
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


    
    ///TEST
    public static int getAllSumBefore(Date date) {
        final String SQL = "select SUM(sum) from orders where (operator != '" + userList.get(5).getName() + "'  "
                           + "OR datatime < '2015-11-17 10:40:00'"
                            + ")"
                           + "AND datatime < '" + date +"'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getAllSum"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();

            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAllSum");
            return 0;
        }
    }

    public static int getAllBarmenSumBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(sum) from orders where sum > 0 AND datatime >= '" + start + "' AND datatime <= '" + end + "'"
                + "AND operator != '" + userList.get(5).getName() + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getAllOrdersSum"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();

            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAllBarmenSumBetween");
            return 0;
        }
    }
    public static int getAllRemovedSumBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(sum) from orders where sum < 0 AND datatime >= '" + start + "' AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getAllRemovedSumBetween"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();

            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAllRemovedSumBetween");
            return 0;
        }
    }
    public static int getAllCookCountBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(cookCount) from orders where sum > 0 AND datatime >= '" + start + "' AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getAllCookCountBetween"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();

            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAllCookCountBetween");
            return 0;
        }
    }
    

    //unsed

    public static int getLastCheckId() {
        final String SQL = "SELECT orderId FROM orders"
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

    public static int getDayOrdersCount() {
        final String SQL = "SELECT COUNT(*) FROM orders where datatime >  '" + DAY_START_TIME + "' "
//                + "AND  operator != '" + userList.get(5).getName() + "'"
                + "AND sum > 0";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getDayOrdersCount"
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
            System.out.println("Connection Failed! Check output console - getDayOrdersCount");
            return 0;
        }
    }
    
    public static int getDayInkassCount() {
        final String SQL = "SELECT COUNT(*) FROM orders where datatime >  '" + DAY_START_TIME + "' AND sum < 0";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getDayInkassCount"
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
            System.out.println("Connection Failed! Check output console - getDayInkassCount");
            return 0;
        }
    }
    
    public static List<Order> getInkassOrders() {
        final String SQL = "select * from orders where coments != ''";
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
    
     public static int getSumKeyMoneyForUserBetween(Timestamp start, Timestamp end, String employeeName) {
        final String SQL = "select SUM(sum) from orders where"
                + " operator  = '" + employeeName +"'"
                + "AND sum < 0 AND coments = ''"
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getAllCookCountBetween"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();

            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAllCookCountBetween");
            return 0;
        }
    }
     
     
    

}
