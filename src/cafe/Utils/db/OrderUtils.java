package cafe.Utils.db;

import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;

import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.Utils.json.JSONUtils;
import cafe.model.Dish;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.User;
import cafe.view.LoginForm;
import static cafe.view.LoginForm.userList;
import cafe.view.MainForm;
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
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.log4j.Logger;

public class OrderUtils {
    private static final Logger log = Logger.getLogger(OrderUtils.class);

        //check if Admin kasa needed in users Kasa
    public static int getUserKasa(Timestamp start, Timestamp end, int index) {
        final String SQL = "SELECT SUM(sum) from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' AND sum > 0"
                + " AND operator ='"
                + LoginForm.userList.get(index).getName() + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {        
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getUserKasa " + index);
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
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getUserDishCount " + index);
            return 0;
        }
        return 0;
    }

    public static List<Order> getOrdersBetween(Timestamp start, Timestamp end) {
        final String SQL = "SELECT * from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' ORDER BY Id DESC";
        List<Order> loadOrders = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getOrdersBetween");
            return null;
        }
    }

    public static void addOrder(Order order, User user, String message) {
        final String sql = "INSERT INTO orders(dayId, sum, cookCount, datatime,"
                + " operator, removed_items, coments)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! addOrder"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(sql);
            for (OrderItem item : order.getItems()) {
                System.out.println("----------title " + item.getDish().getTitle() + " count " + item.getCount());
            }

            pstatement.setInt(1, order.getDayId());
            pstatement.setInt(2, order.getOrderSum());
            pstatement.setInt(3, order.getCookCount());
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, user.getName());          
            pstatement.setString(6, order.getJSONRemovedItems());
            pstatement.setString(7, message);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new check was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addOrder");
        }
    }
    
    public static void addOrderItems(Order order) throws SQLException {
        final String SQL = "INSERT INTO order_item(order_id, dish_id, quantity)"
                + " VALUES(?, ?, ?)";
        Connection dbConnect = null;
        PreparedStatement pstatement = null;
        try {
            dbConnect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstatement = dbConnect.prepareStatement(SQL);

            dbConnect.setAutoCommit(false);

            for (OrderItem item : order.getItems()) {
                pstatement.setInt(1, order.getId());
                pstatement.setInt(2, item.getDish().getDbID());
                pstatement.setInt(3, item.getCount());
                pstatement.addBatch();
            }         
            pstatement.executeBatch();
            dbConnect.commit();          
        } catch (SQLException e) {
            log.error("addOrderItems Exception " + e.getMessage());
            if (dbConnect != null) {
                dbConnect.rollback();
            }
        } finally {
            if (pstatement != null) {
                pstatement.close();
            }
            if (dbConnect != null) {
                dbConnect.close();
            }
        }
    } 
    
    public static void addDayInfo(Date start, Date end, List<Integer> kasaInfo) {
        final String sql = "INSERT INTO day_info(time_start, time_end, start_kasa, end_kasa,"
                + " sum, spend, dish_count, order_count)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {  
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setTimestamp(1, new Timestamp(start.getTime()));
            pstatement.setTimestamp(2, new Timestamp(end.getTime()));
            pstatement.setInt(3, kasaInfo.get(0));
            pstatement.setInt(4, kasaInfo.get(1));
            pstatement.setInt(5, kasaInfo.get(2));
            pstatement.setInt(6, kasaInfo.get(3));
            pstatement.setInt(7, kasaInfo.get(4));
            pstatement.setInt(8, kasaInfo.get(5));       

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new DayInfo was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addDayInfo");
        }
    }

    public static List<Integer> getDayInfo() {
        final String SQL = "SELECT * FROM day_info ORDER BY Id DESC LIMIT 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            List<Integer> dayInfo= new ArrayList<>();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    dayInfo.add(rs.getInt("start_kasa"));
                    dayInfo.add(rs.getInt("end_kasa"));
                    dayInfo.add(rs.getInt("sum"));
                    dayInfo.add(rs.getInt("spend"));
                    dayInfo.add(rs.getInt("dish_count"));
                    dayInfo.add(rs.getInt("order_count"));
                }
            }
            return dayInfo;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDayInfo");
            return null;
        }
    }
    
    //utils tmp
    public static void getAllDayInfo() {
        final String SQL = "SELECT * FROM day_info";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            String info = "";
            int id;
            
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    info = rs.getString("info");
                    id = rs.getInt("id");
                    
                    String[] tokens = info.split(" ");
                    List<Integer> parsed = new ArrayList<>();
                    for (String t : tokens) {
                        if (t.matches("^[-+]?[0-9]*\\.?[0-9]+$")) {
                            int k = Integer.parseInt(t);
                            parsed.add(k);
                        }
                    }
                    updateDayInfo(parsed, id);                    
                }
            }                     
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDaySum");          
        }
    }
    //utils tmp
    public static void updateDayInfo(List<Integer> numbers, int id) {
        final String sql = "UPDATE day_info set start_kasa=?, end_kasa=?,"
                + " sum=?, spend=?, dish_count=?, order_count=? where Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! updateDayInfo" + id
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, numbers.get(0));
            pstatement.setInt(2, numbers.get(5));
            pstatement.setInt(3, numbers.get(1));
            pstatement.setInt(4, numbers.get(4));
            pstatement.setInt(5, numbers.get(2));
            pstatement.setInt(6, numbers.get(3));
            pstatement.setInt(7, id);
      
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new updateDayInfo was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateDayInfo");
        }
    } 

    //utils tmp
    public static List<Order> getAllOrders() {
        final String SQL = "SELECT * from orders where sum > 0";
        List<Order> loadOrders = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getOrdersBetween");
            return null;
        }
    }
    
    //utils tmp
    public static void convertOrderItems() throws SQLException {
        final String SQL = "INSERT INTO order_item(order_id, dish_id, quantity)"
                + " VALUES(?, ?, ?)";
        Connection dbConnect = null;
        PreparedStatement pstatement = null;
        try {
            dbConnect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstatement = dbConnect.prepareStatement(SQL);

            dbConnect.setAutoCommit(false);

            List<Order> list = OrderUtils.getAllOrders();
            for (Order order : list) {               
                for (OrderItem item : order.getItems()) {
                    pstatement.setInt(1, order.getId());
                    pstatement.setInt(2, MainForm.getDishIdByName(item.getDish().getTitle()));
                    pstatement.setInt(3, item.getCount());
                    pstatement.addBatch();
                }
            }
            pstatement.executeBatch();
            dbConnect.commit();
            System.out.println("------------------End...........");

        } catch (SQLException e) {
            log.error("convertOrderItems Exception" + e.getMessage());
            if (dbConnect != null) {
                dbConnect.rollback();
            }
        } finally {
            if (pstatement != null) {
                pstatement.close();
            }
            if (dbConnect != null) {
                dbConnect.close();
            }
        }           
    }
    //utils tmp
    public static Map<Integer, OrderItem> getMeatOrders(){
        List<Order> list = OrderUtils.getAllOrders();
        Map<Integer, OrderItem> meatList = new TreeMap<>();
        for (Order order : list) {            
            for (OrderItem item : order.getItems()) {
                int orderId = order.getId();
                String dishName = item.getDish().getTitle();
                int dishId = MainForm.getDishIdByName(dishName);
                // meat dishes ids
                if (dishId >= 41 && dishId <= 52 && dishId != 49 && dishId != 50) { 
                    StringBuilder str = new StringBuilder(dishName);
                    StringBuilder masaString = new StringBuilder(str.reverse().substring(5, 9)).reverse(); 
                    int masa = 0;
                    try {
                         masa = Integer.parseInt(masaString.toString());
                    } catch (Exception e) {                        
                        try {
                            masa = Integer.parseInt(masaString.substring(1, 4));
                        } catch (Exception ex) {
                            try {
                                masa = Integer.parseInt(masaString.substring(2, 4));
                            } catch (Exception ext) {
                                System.out.println("---------!!Error" + dishId + " dishName= " + masaString.substring(2, 4) + " masa = " + masa);
                            }                           
                        }               
                    }  
//                    masa /= 100;
                    meatList.put(orderId, new OrderItem(new Dish(dishId, null, 0, true, null), masa));
                    System.out.println(orderId + " dishId = " + dishId + " dish Name =" + dishName + " masa= " + masa);               
                }                
            }
        } 
        return meatList;
    }
    
    //utils tmp
    public static void updateOrderItems(Map<Integer, OrderItem> meatList) throws SQLException {
        final String SQL = "UPDATE order_item SET quantity=?"
                         + "where order_id=? AND  dish_id=?";
        Connection dbConnect = null;
        PreparedStatement pstatement = null;
        try {
            dbConnect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstatement = dbConnect.prepareStatement(SQL);

            dbConnect.setAutoCommit(false);

            List<Order> list = OrderUtils.getAllOrders();
            for (Map.Entry<Integer, OrderItem> entry : meatList.entrySet()) { 
                float masa = (entry.getValue().getCount());
                masa /= 100;
                pstatement.setFloat(1, masa);
                pstatement.setInt(2, entry.getKey());
                pstatement.setInt(3, entry.getValue().getDish().getDbID());
                pstatement.addBatch();
                System.out.println(entry.getKey() + " dishId = " + entry.getValue().getDish().getDbID() + " dish Name =" +  " masa= " + masa);
            }            
            
            pstatement.executeBatch();
            dbConnect.commit();
            System.out.println("------------------End...........");

        } catch (SQLException e) {
            log.error("convertOrderItems Exception" + e.getMessage());
            if (dbConnect != null) {
                dbConnect.rollback();
            }
        } finally {
            if (pstatement != null) {
                pstatement.close();
            }
            if (dbConnect != null) {
                dbConnect.close();
            }
        }

    }
    
    

    public static void updateTable(Order order, User user, int activeTable) {
        final String SQL = "UPDATE tables set dayId=?, sum=?, cookCount=?,"
                + " datatime=?, operator=?, order_items=?,"
                + " removed_items=? where Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
                log.debug("A new check was added successfully!");
            }

        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateTable");
        }

    }

    public static void fillTableById(int activeTable) {
        final String SQL = "UPDATE tables set dayId=?, sum=?,  cookCount=?,"
                + " datatime=?, operator=?, order_items=?,"
                + " removed_items=? where Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
                log.debug("A new check was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - fillTableById");
        }
    }

    public static Map<Integer, Order> loadTables() {
        final String SQL = "SELECT * from tables where sum > 0";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            Map<Integer, Order> loadOrders = new HashMap();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    Order tmpOrder = new Order();
                    tmpOrder.setDayId(rs.getInt("dayId"));
                    tmpOrder.setOrderSum(rs.getInt("sum"));
                    tmpOrder.setCookCount(rs.getInt("cookCount"));
                    tmpOrder.setItems(JSONUtils.convertJSONToOrder(rs.getString("order_items")));
                    tmpOrder.setRemovedItems(JSONUtils.convertJSONToOrder(rs.getString("removed_items")));
                    loadOrders.put(rs.getInt("Id"), tmpOrder);
                }
            }
            return loadOrders;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateTable");
            return null;
        }

    }

    public static int getDaySum(int dayOrderCount) {
        final String SQL = "select SUM(sum) from "
                + "(SELECT * FROM orders order by id desc limit ?) as daysum";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getDaySum");
            return 0;
        }
    }

    ///TEST
    public static int getAllSumBefore(Timestamp time) {
        final String SQL = "select SUM(sum) from orders where "
                + "(operator != '" + userList.get(5).getName() + "'  "
                + "OR (operator = '" + userList.get(5).getName() + "' AND sum < 0)"
                + "OR datatime < '2015-11-17 10:40:00'"
                + ")"
                + "AND datatime <= '" + time + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getAllSum");
            return 0;
        }
    }

    public static int getAllBarmenSumBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(sum) from orders where sum > 0 "
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'"
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
            log.error("Connection Failed! Check output console - getAllBarmenSumBetween");
            return 0;
        }
    }

    public static int getAllRemovedSumBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(sum) from orders where sum < 0 "
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getAllRemovedSumBetween");
            return 0;
        }
    }

    public static int getAllCookCountBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(cookCount) from orders where sum > 0 "
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getAllCookCountBetween");
            return 0;
        }
    }

    public static int getDayOrdersCount() {
        final String SQL = "SELECT COUNT(*) FROM orders "
                + "where datatime >  '" + DAY_START_TIME + "' "
                + "AND sum > 0";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getDayOrdersCount");
            return 0;
        }
    }

    public static List<Order> getInkassOrders(Timestamp start, Timestamp end) {
        final String SQL = "select * from orders where coments != ''" 
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        List<Order> inkassOrders = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getInkassOrders");
            return null;
        }
    }

    public static int getSumKeyMoneyForUserBetween(Timestamp start, Timestamp end, String employeeName) {
        final String SQL = "select SUM(sum) from orders where"
                + " operator  = '" + employeeName + "'"
                + "AND sum < 0 AND coments = ''"
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
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
            log.error("Connection Failed! Check output console - getSumKeyMoneyForUser = " + employeeName);
            return 0;
        }
    }

    public static int getMaxDbDayId() {
        final String SQL = "select  max(dayId) from orders where "
                + "datatime > '" + DAY_START_TIME + "' ";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();

            int max;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                max = 0;
                while (rs.next()) {
                    max = rs.getInt(1);
                }
            }
            return max;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getMaxDbDayId");
            return 0;
        }
    }

}
