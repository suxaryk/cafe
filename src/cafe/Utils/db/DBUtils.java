package cafe.Utils.db;

import static cafe.view.ClientForm.isLocalHost;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author suxarina
 */
public class DBUtils {  

//    public static String URL = "jdbc:mysql://localhost:3306/luckyroger_prod";
//    public static String URL = "jdbc:mysql://localhost:3306/luckyroger";
    public static String URL = "jdbc:mysql://46.63.25.213:3306/luckyroger";
    public static String USERNAME = "root";   
    public static String PASSWORD = "root";
    private static final String PASSWORD_MAIN = "dbiytdbq18";
    public static String PASSWORD_HM = "___agneshka17";
    
    private static final String HOST_0 = "93.183.216.29";
    private static final String HOST_1 = "185.15.6.103";
    private static final String HOST_2 = "46.63.96.79";
    private static final String HOST_3 = "46.63.25.213";
    
    private static final String LOCALHOST_0 = "192.168.0.111";
    private static final String LOCALHOST_1 = "185.15.6.103";
    private static final String LOCALHOST_2 = "192.168.0.102";
    private static final String LOCALHOST_3 = "192.168.0.106";
    
    private static final int TIMEOUT = 2_000;

    public static final ArrayList<String> sqlSelectList = new ArrayList<>();
    public static final ArrayList<String> sqlSelectByIdList = new ArrayList<>();
    public static final ArrayList<String> sqlInsertList = new ArrayList<>();
    public static final ArrayList<String> sqlRemoveList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdateTitleList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdatePriceList = new ArrayList<>();

    static {
        try {
            setHost(HOST_0);
            PASSWORD = PASSWORD_MAIN;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
        }   
        initQueries();
    }

    public static boolean ConnectDb() {
            DriverManager.setLoginTimeout(2);
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting " +
                        URL + USERNAME+PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Connection to DB Failed! ");
            showMessage("");           
            return false;
        }         
    }
    public static String getHost(int cafeId){
        String HOST = "localhost";
        if (cafeId == 0) {
            HOST = HOST_0;
        } else if (cafeId == 1) {
            //star
            HOST = HOST_1;
        } else if (cafeId == 2) {
            //slav
            HOST = HOST_2;        
        } else if (cafeId == 3) {
            //hm

            HOST = HOST_2;
        } else if (cafeId == 3) {
            //slav
            HOST = HOST_3;
        }
        if (isLocalHost) {
            if (cafeId == 0) {
                HOST = LOCALHOST_0;
            } else if (cafeId == 1) {
                //star
                HOST = LOCALHOST_1;
            } else if (cafeId == 2) {
                //slav
                HOST = LOCALHOST_2;            
            } else if (cafeId == 3) {
                //hm
                HOST = LOCALHOST_2;
            } else if (cafeId == 3) {
                //slav
                HOST = LOCALHOST_3;
            }
        }
        if (cafeId == 3) {
            PASSWORD = PASSWORD_HM;
        }else{
            PASSWORD = PASSWORD_MAIN;
        }
        return HOST;
    }
    
    public static boolean checkConnection(int cafeId) {
        String HOST = getHost(cafeId);
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(HOST, 3306), TIMEOUT);
            boolean isConnected = socket.isConnected();
            if (isConnected) {
                System.out.println("Connection is reached");
            } else {
                System.out.println("Connection ERROR");
            }
            return isConnected;
        } catch (Exception e) {                
            return false;                   
        }
    }
    
    public static void showMessage(String msg){
        String defaultMessage = "Помилка підключення до бази данних!\n"
                              + "Перевірте підклюення до інтернету \n"
                              + "або перезавантажте роутер в кафе\n";
        if (!msg.equals("")) {
            defaultMessage = msg;                        
        }        
        JFrame frame = new JFrame();
        int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
                defaultMessage, null,
                0, JOptionPane.YES_NO_OPTION, null, new String[]{"OK"}, null);
    }
    public static boolean showMessageYesNo(String msg){
        String defaultMessage = "Помилка підключення до бази данних!\n"
                              + "Перевірте підклюення до інтернету \n"
                              + "або перезавантажте роутер в кафе\n";
        if (!msg.equals("")) {
            defaultMessage = msg;                        
        }        
        JFrame frame = new JFrame();
        int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
                defaultMessage, null,
                0, JOptionPane.YES_NO_OPTION, null, new String[]{"Карта", "Готівка"}, null);
        
        return (reply == JOptionPane.YES_OPTION);        
    }
    
    public static void chooseServer(int cafeId) {  
        if (isLocalHost) {
            if (cafeId == 0) {
                //shep
                setHost(LOCALHOST_0);
            } else if (cafeId == 1) {
                //star
                setHost(LOCALHOST_1);;
            } else if (cafeId == 2) {
                //slav          
                setHost(LOCALHOST_2);            
            } else if (cafeId == 3) {
                //hm         
                setHost(LOCALHOST_3);
            }
        }else{
            if (cafeId == 0) {
                //shep
                setHost(HOST_0);
            } else if (cafeId == 1) {
                //star
                setHost(HOST_1);
            } else if (cafeId == 2) {
                //slav
                setHost(HOST_2);            
            } else if (cafeId == 3) {
                //hm
                setHost(HOST_3);             
            }
        }
        if (cafeId == 3) {
            PASSWORD = PASSWORD_HM;            
        }else{
            PASSWORD = PASSWORD_MAIN;
        }      
    } 

    private static void setHost(String host) { 
        URL = "jdbc:mysql://" + host + ":3306/luckyroger";
    }
 
    
    public static Map<String, String> getSystemVariables(){
        final String SQL = "SELECT * from sys_var";  
        Map<String, String> sysVar = new HashMap<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! getSystemVariables"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    sysVar.put(rs.getString("name"), rs.getString("value"));           
                }
            }
            return sysVar;
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getSystemVariables");
            return null;
        }    
    }
    
    public static void updateSystemVariables(String sysVarName, String value){
        final String SQL = "UPDATE sys_var set value=? where name = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! updateSystemVariables"
                    : "Error DB connecting");
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, value);         
            pstatement.setString(2, sysVarName);         
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new sysVarName was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateSystemVariables");
        }
    }
    

    private static void initQueries() {
        sqlSelectList.add("select * from firstdishes");
        sqlSelectList.add("select * from salats");
        sqlSelectList.add("select * from rogerdishes");
        sqlSelectList.add("select * from pandishes");
        sqlSelectList.add("select * from meat");
        sqlSelectList.add("select * from pizzaS");
        sqlSelectList.add("select * from pizzaB");
        sqlSelectList.add("select * from sushi");
        sqlSelectList.add("select * from dessert");
        sqlSelectList.add("select * from drinks");
        sqlSelectList.add("select * from bear");
        sqlSelectList.add("select * from alcohol");
        sqlSelectList.add("select * from not_alcohol");

        sqlSelectByIdList.add("select * from firstdishes WHERE Id = ?");
        sqlSelectByIdList.add("select * from salats WHERE Id = ?");
        sqlSelectByIdList.add("select * from rogerdishes WHERE Id = ?");
        sqlSelectByIdList.add("select * from pandishes WHERE Id = ?");
        sqlSelectByIdList.add("select * from meat WHERE Id = ?");
        sqlSelectByIdList.add("select * from pizzaS WHERE Id = ?");
        sqlSelectByIdList.add("select * from pizzaB WHERE Id = ?");
        sqlSelectByIdList.add("select * from sushi WHERE Id = ?");
        sqlSelectByIdList.add("select * from dessert WHERE Id = ?");
        sqlSelectByIdList.add("select * from drinks WHERE Id = ?");
        sqlSelectByIdList.add("select * from bear WHERE Id = ?");
        sqlSelectByIdList.add("select * from alcohol WHERE Id = ?");
        sqlSelectByIdList.add("select * from not_alcohol WHERE Id = ?");

        sqlInsertList.add("INSERT INTO firstdishes(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO salats(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO rogerdishes(title, price, isCook,  ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO pandishes(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO meat(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO pizzaS(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO pizzaB(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO sushi(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO dessert(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO drinks(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO bear(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO alcohol(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");
        sqlInsertList.add("INSERT INTO not_alcohol(title, price, isCook, ingredients) VALUES(?, ?, ?, ?)");

        sqlRemoveList.add("DELETE FROM firstdishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM salats WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM rogerdishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pandishes WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM meat WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pizzaS WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM pizzaB WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM sushi WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM dessert WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM drinks WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM bear WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM alcohol WHERE Id = ?");
        sqlRemoveList.add("DELETE FROM not_alcohol WHERE Id = ?");

        sqlUpdateTitleList.add("UPDATE firstdishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE salats SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE rogerdishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pandishes SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE meat SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pizzaS SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE pizzaB SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE sushi SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE dessert SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE drinks SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE bear SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE alcohol SET title = ? WHERE Id = ?");
        sqlUpdateTitleList.add("UPDATE not_alcohol SET title = ? WHERE Id = ?");

        sqlUpdatePriceList.add("UPDATE firstdishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE salats SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE rogerdishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pandishes SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE meat SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pizzaS SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE pizzaB SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE sushi SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE dessert SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE drinks SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE bear SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE alcohol SET price = ? WHERE Id = ?");
        sqlUpdatePriceList.add("UPDATE not_alcohol SET price = ? WHERE Id = ?");
    }

    
}
