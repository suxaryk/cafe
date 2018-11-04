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
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author suxarina
 */
public class DBUtils {
    
    private static final Logger log = Logger.getLogger(DBUtils.class);

    public static String URL = "jdbc:mysql://localhost:3306/luckyroger";
//    public static String URL = "jdbc:mysql://localhost:3306/starkon";
    public static String USERNAME = "root";
    public static String PASSWORD = "root";
//    public static String PASSWORD = "root";

//for stat
    public static final boolean LOCAL = true;
    public static final boolean STATISTIC = true;
    public static final boolean ONLY_BK_CAFE = false;
    
    private static final String PASSWORD_MAIN = "dbiytdbq18";
    private static final String PASSWORD_HM = "___agneshka17";
    
    public static final List<String> LOCAL_HOSTS = new ArrayList<>();
    public static final List<String> HOSTS = new ArrayList<>();
    
    private static final int TIMEOUT = 2_000;
    //for hm = true
    public static final boolean CARD_PAYMENT = true;

    public static final ArrayList<String> sqlSelectList = new ArrayList<>();
    public static final ArrayList<String> sqlSelectByIdList = new ArrayList<>();
    public static final ArrayList<String> sqlInsertList = new ArrayList<>();
    public static final ArrayList<String> sqlRemoveList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdateTitleList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdatePriceList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdateIsCookList = new ArrayList<>();
    

    static {
        createListHosts();
        registerDriver();       
        initQueries();
    }
    
    private static void registerDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            log.debug("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log.debug("MySQL JDBC Driver NOT Registered!");
        }               
    }
    
    private static void createListHosts(){
        LOCAL_HOSTS.add("192.168.0.111");
        LOCAL_HOSTS.add("192.168.0.102");
        LOCAL_HOSTS.add("192.168.0.2");
        LOCAL_HOSTS.add("192.168.0.106");
        LOCAL_HOSTS.add("192.168.0.102");   
        
        HOSTS.add("46.219.43.69");
        HOSTS.add("185.15.6.103");
        HOSTS.add("46.63.96.79");
        HOSTS.add("46.63.25.213");
        HOSTS.add("185.109.54.153");
    }

    public static boolean ConnectDb() {
        DriverManager.setLoginTimeout(TIMEOUT);
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            log.debug(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting "
                    + URL + USERNAME + PASSWORD);
            return true;
        } catch (SQLException e) {
            log.debug("Connection to DB Failed! ");
            showMessage("");
            return false;
        }
    }

    public static String getHost(int cafeId) {
        String HOST = "localhost";
        if (ONLY_BK_CAFE) {
            HOST = HOSTS.get(4);
        } else {
            HOST = getHostById(cafeId);
        }
        if (LOCAL) {
            PASSWORD = "root";
        }else if (cafeId == 3) {
            PASSWORD = PASSWORD_HM;
        } else {
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
                log.debug("Connection is reached " + HOST);
            } else {
                log.debug("Connection ERROR");
            }
            socket.close();
            return isConnected;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void showInfo(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void showConnectionError(){
        if (STATISTIC) {
            showInfo("Проблеми зі з'єднання, дані можуть бути не корректними, спробуйте ще раз!");
        }            
    }

    public static void showMessage(String msg) {
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

    public static boolean setPayMethod(String msg) {
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
        if (ONLY_BK_CAFE) {
            setHost(LOCAL_HOSTS.get(4));
        } else {
            setHost(getHostById(cafeId));
        }
        if (cafeId == 3) {
            PASSWORD = PASSWORD_HM;
        } else {
            PASSWORD = PASSWORD_MAIN;
        }
    }
    
    private static String getHostById(final int cafeId){
        if (LOCAL) {
            return "localhost";
        }else if (isLocalHost) {
          return LOCAL_HOSTS.get(cafeId);            
        }else{
          return HOSTS.get(cafeId);
        }
    }

    private static void setHost(String host) {
        if (!LOCAL) {
            URL = "jdbc:mysql://" + host + ":3306/luckyroger"; 
            log.debug("new url = " + URL);
        }        
    }

    public static Map<String, String> getSystemVariables() {
        final String SQL = "SELECT * from sys_var";
        Map<String, String> sysVar = new HashMap<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {       
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    sysVar.put(rs.getString("name"), rs.getString("value"));
                }
            }
            return sysVar;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getSystemVariables");
            return null;
        }
    }

    public static void updateSystemVariables(String sysVarName, String value) {
        final String SQL = "UPDATE sys_var set value=? where name = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {       
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, value);
            pstatement.setString(2, sysVarName);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("A new sysVarName was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateSystemVariables");
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
        
        sqlUpdateIsCookList.add("UPDATE firstdishes SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE salats SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE rogerdishes SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE pandishes SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE meat SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE pizzaS SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE pizzaB SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE sushi SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE dessert SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE drinks SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE bear SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE alcohol SET isCook = ? WHERE Id = ?");
        sqlUpdateIsCookList.add("UPDATE not_alcohol SET isCook = ? WHERE Id = ?");
    }
}
