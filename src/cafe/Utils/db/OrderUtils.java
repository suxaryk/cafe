package cafe.Utils.db;

import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;

import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.Utils.json.JSONUtils;
import cafe.model.Employee;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.User;
import cafe.view.LoginForm;
import static cafe.view.LoginForm.userList;
import static cafe.view.MainForm.DAY_START_TIME;
import static cafe.view.MainForm.employees;
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
import org.apache.log4j.Logger;

public class OrderUtils {
    private static final Logger log = Logger.getLogger(OrderUtils.class);

    public static void getUserKasa(Timestamp start, Timestamp end) {
        final String SQL = "SELECT SUM(sum) from orders where"
                + " datatime >= '" + start
                + "' AND datatime <= '" + end
                + "' AND sum > 0"
                + " AND operator = ? ";
        try (
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement pstatement = connection.prepareStatement(SQL)) { 
            for(User user: userList){
                pstatement.setString(1, user.getName());
                int kasa = 0;
                try (ResultSet rs = pstatement.executeQuery()) {                    
                    while (rs.next()) {
                        kasa = rs.getInt(1);
                    }
                }
                user.setKasa(kasa);
                log.debug("getUserKasa" + user.getName() + " kasa = " + kasa);                         
            }              
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getUserKasa ");          
        }
    
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
                + " operator, order_items, removed_items, coments, pay_card)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstatement = connection.prepareStatement(sql);         
            pstatement.setInt(1, order.getDayId());
            pstatement.setInt(2, order.getOrderSum());
            pstatement.setInt(3, order.getCookCount());
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, user.getName());
            pstatement.setString(6, order.getJSONItems());
            pstatement.setString(7, order.getJSONRemovedItems());
            pstatement.setString(8, message);
            pstatement.setBoolean(9, order.isCardPayed());

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new ORDER was added successfully! + dayId = " + order.getDayId());
                for (OrderItem item : order.getItems()) {
                    log.debug("----------title " + item.getDish().getTitle() + " count " + item.getCount());
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addOrder");
        }
    }

    public static void addDayInfo(String info) {
        final String sql = "UPDATE day_info SET time_end=?, info=? where id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setTimestamp(1, getCurrentTimeStamp());
            pstatement.setString(2, info);
            pstatement.setInt(3, getLastDayInfoId());

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new DayInfo was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addDayInfo");
        }
    }
    public static void addDayStartTime() {        
        final String sql = "INSERT INTO day_info(time_start) VALUES(?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setTimestamp(1, new Timestamp(new Date().getTime()));

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("StartTime was added successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - addDayStartTime");
        }
    }    
        
    public static Date getDayEndTime() {
        final String SQL = "SELECT time_end FROM day_info order by id desc limit 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            Date endTime = null;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    endTime = rs.getTimestamp(1);
                }
            }
            return endTime;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDayEndTime");
            return null;
        }
    }
    
    private static int getLastDayInfoId() {
        final String SQL = "SELECT max(id) FROM day_info";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            int  id = 0;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    id  = rs.getInt(1);
                }
            }
            return id;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDayStartTime");
            return 0;
        }
    }
    
    public static Date getDayStartTime() {
        final String SQL = "SELECT time_start FROM day_info order by id desc limit 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            Date startTime = null;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    startTime = rs.getTimestamp(1);
                }
            }
            return startTime;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDayStartTime");
            return null;
        }
    }

    public static String getDayInfo() {
        final String SQL = "SELECT * FROM day_info ORDER BY Id DESC LIMIT 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            String info = "";
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    info = rs.getString("info");
                }
            }
            log.debug("getDayInfo = " + info);
            return info;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDaySum");
            return "";
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
                log.debug("updateTable(backupOrder to tables) was added successfully! " + activeTable);
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateTable(backupOrder to tables)" + activeTable + " " + user.getName());
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
                log.debug("fillTableById was added successfully!");
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
            log.error("Connection Failed! Check output console - loadTables");
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
            log.debug("getDaySum " + sum);
            return sum;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getDaySum");
            return 0;
        }
    }

    ///TEST
    //for hm
    public static int getAllCashSumBefore(Timestamp time) {
        final String SQL = "select SUM(sum) from orders where "
                + "(operator != '" + userList.get(5).getName() + "'  "
                + "OR (operator = '" + userList.get(5).getName() + "' AND sum < 0)"
                + "OR datatime < '2015-11-17 10:40:00'"
                + ")"
                + "AND pay_card = false "
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
            log.debug("getAllCashSumBefore(only for hm) " + sum);
            return sum;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getAllCashSumBefore");
            return 0;
        }
    }
    
    
    public static int getAllCashSumBeforeBK(Timestamp time) {
        final int startKasaFrom_28__01 = 9622;
        final String SQL = "select SUM(sum) from orders where "
                + "(operator != '" + userList.get(5).getName() + "'  "
                + "OR (operator = '" + userList.get(5).getName() + "' AND sum < 0)"
                + "OR datatime < '2015-11-17 10:40:00'"
                + ")"
                + "AND Id > 2586 "
                + "AND pay_card = false "
                + "AND datatime <= '" + time + "'";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {
            

            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            log.debug("getAllCashSumBeforeBK(only for bk) сума к касі " +( sum + startKasaFrom_28__01));
            return sum + startKasaFrom_28__01;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getAllCashSumBeforeBK");
            return 0;
        }
    }
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
            log.error("Connection Failed! Check output console - getAllSumBefore");
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
            Statement statement = connection.createStatement();
            int sum;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            log.debug("getAllBarmenSumBetween (сума кас) " + sum);
            return sum;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getAllBarmenSumBetween");
            return 0;
        }
    }
    
    public static int getAllBarmenSumWithCardBetween(Timestamp start, Timestamp end, boolean isCard) {
        String SQL = " select SUM(sum) from orders where sum > 0 "
                + "    AND datatime >= '" + start + "' "
                + "    AND datatime <= '" + end + "'"
                + "    AND pay_card = " + isCard + ""
                + "    AND operator != '" + userList.get(5).getName() + "'";
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
            log.debug("getAllBarmenSumWithCardBetween (безнал або налічка) = " +  sum);
            return sum;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getAllBarmenSumWithCardBetween");
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
            log.debug("getAllRemovedSumBetween (інкасація) = " + sum);
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
            log.debug("getAllCookCountBetween (кількість страв) = " + sum);
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
    
    public static Date getFirstOrderTime(){
        final String SQL = "SELECT datatime FROM orders where dayId = 1 and date(datatime) = date(curdate()) order by datatime asc limit 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            Date date = null;
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    date = rs.getTimestamp(1);
                }
            }
            return date;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getFirstOrderTime ");
            return null;
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
    
    public static void getCustomSumKeyMoneyForUserBetween(Timestamp start, Timestamp end) {
        final String SQL = "select SUM(sum) from orders where"
                + " operator  = ?"
                + "AND sum < 0 AND coments = ''"
                + "AND datatime >= '" + start + "' "
                + "AND datatime <= '" + end + "'";     
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement pstatement = connection.prepareStatement(SQL)) {
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
                log.debug("getSumKeyMoneyForUser(Аванс) = " + employee.getName());
            }       
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getSumKeyMoney(Аванс)= ");
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
