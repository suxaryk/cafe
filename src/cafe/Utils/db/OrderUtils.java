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
import cafe.Utils.json.JSONUtils;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author suxarina
 */
public class OrderUtils {


    public static void addOrder(Order order, User user) {
        final String sql = "INSERT INTO orders(orderId, sum, cookCount, drinkCount, datatime, operator, order_items, removed_items)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(sql);
            for (OrderItem item : order.getItems()) {
                System.out.println("----------title " + item.getDish().getTitle() + " count "+ item.getCount());
            }
            pstatement.setInt(1, order.getDayId());
            pstatement.setInt(2, order.calcOrderSum());
            pstatement.setInt(3, order.getCookCount());
            pstatement.setInt(4, order.getDrinkCount());
            pstatement.setTimestamp(5, getCurrentTimeStamp());
            pstatement.setString(6, user.getName());
            pstatement.setString(7, order.getJSONItems(false));
            pstatement.setString(8, order.getJSONRemovedItems(false));

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addOrder");
        }

    }
   
    public static void updateTable(Order order, User user, int activeTable) {
        final String SQL = "UPDATE tables set sum=?, cookCount=?, drinkCount=?, datatime=?, operator=?, order_items=?, removed_items=? where Id = ?";       

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(SQL);            
         
            pstatement.setInt(1, order.calcOrderSum());                
            pstatement.setInt(2, order.getCookCount());
            pstatement.setInt(3, order.getDrinkCount());
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, user.getName());
            pstatement.setString(6, order.getJSONItems(true));
            pstatement.setString(7, order.getJSONRemovedItems(true));
            pstatement.setInt(8, activeTable);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateTable");
        }

    }
    public static void fillAllTables() {
        final String SQL = "UPDATE tables set sum=?,  cookCount=?, drinkCount=?, datatime=?, operator=?, order_items=?, removed_items=? where Id > 0";       

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            PreparedStatement pstatement = connection.prepareStatement(SQL);            
         
            pstatement.setInt(1, 0);
            pstatement.setInt(2, 0);
            pstatement.setInt(3, 0);
            pstatement.setTimestamp(4, getCurrentTimeStamp());
            pstatement.setString(5, "");
            pstatement.setString(6, "");
            pstatement.setString(7, "");
          

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new check was added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - fillTable");
        }
    }
    public static void fillTableById(int activeTable) {
        final String SQL = "UPDATE tables set sum=?,  cookCount=?, drinkCount=?, datatime=?, operator=?, order_items=?, removed_items=? where Id = ?";       

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected!"
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

            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");

            Statement statement = connection.createStatement();
            Map<Integer, Order> loadOrders = new HashMap();
            try (ResultSet rs = statement.executeQuery(SQL)) {               
                while (rs.next()) {
                    Order tmpOrder = new Order();
                    tmpOrder.setOrderSum(rs.getInt("sum"));                   
                    tmpOrder.setCookCount(rs.getInt("cookCount"));                    
                    tmpOrder.setDrinkCount(rs.getInt("drinkCount"));
                    tmpOrder.setItems(JSONUtils.convertJSONToOrderTables(rs.getString("order_items")));
                    tmpOrder.setRemovedItems(JSONUtils.convertJSONToOrderTables(rs.getString("removed_items")));
                    loadOrders.put(rs.getInt("Id"), tmpOrder);
                }                
            } 
            return loadOrders;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateTable");
            return null;
        }

    }

    public static int getDaySum() {
        final String SQL = "select SUM(sum) from (SELECT * FROM orders order by id desc limit ?) as daysum";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, getDayOrdersCount());
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
    
    public static int getCookCount() {
        final String SQL = "select SUM(cookCount) from (SELECT * FROM orders order by id desc limit ?) as daysum";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, getDayOrdersCount());
            int sum;
            try (ResultSet rs = pst.executeQuery()) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getCookCount");
            return 0;
        }
    }
    public static int getDrinkCount() {
        final String SQL = "select SUM(drinkCount) from (SELECT * FROM orders order by id desc limit ?) as daysum";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, getDayOrdersCount());
            int sum;
            try (ResultSet rs = pst.executeQuery()) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getDrinkCount");
            return 0;
        }
    }
    
    public static int getDayRemoveSum() {
        final String SQL = "select SUM(sum) from (SELECT * FROM orders order by id desc limit ?) as dayDiff where sum < 0";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, getDayOrdersCount());
            int sum;
            try (ResultSet rs = pst.executeQuery()) {
                sum = 0;
                while (rs.next()) {
                    sum = rs.getInt(1);
                }
            }
            return sum;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getDayRemoveSum");
            return 0;
        }
    }
    public static int getAllSum() {
        final String SQL = "select SUM(sum) from orders";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
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

//    public static int getLastCheckId() {
//        final String SQL = "SELECT orderId FROM orders"
//                + "order by id desc limit 1";
//
//        try (Connection connection = DriverManager
//                .getConnection(URL, USERNAME, PASSWORD)) {
//            System.out.println(!connection.isClosed() ? "DB connected!"
//                    : "Error DB connecting");
//            Statement statement = connection.createStatement();
//            int last;
//            try (ResultSet rs = statement.executeQuery(SQL)) {
//                last = 0;
//                while (rs.next()) {
//                    last = rs.getInt(1);
//                }
//            }
//            return last;
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console - getLastCheckId");
//            return 0;
//        }
//    }

    public static int getDayOrdersCount() {
        final String SQL = "SELECT orderId FROM orders order by id desc limit 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
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
            System.out.println("Connection Failed! Check output console - getDayCount");
            return 0;
        }
    }

}
