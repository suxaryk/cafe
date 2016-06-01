package cafe.Utils.db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author suxarina
 */
public class DbConnect {  
    
    public static String dbName = "luckyroger";
    public static String URL = "jdbc:mysql://localhost:3306/luckyroger";
    public static String USERNAME = "root";
    public static String PASSWORD = "root";

    public static final ArrayList<String> sqlSelectList = new ArrayList<>();
    public static final ArrayList<String> sqlSelectByIdList = new ArrayList<>();
    public static final ArrayList<String> sqlInsertList = new ArrayList<>();
    public static final ArrayList<String> sqlRemoveList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdateTitleList = new ArrayList<>();
    public static final ArrayList<String> sqlUpdatePriceList = new ArrayList<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
        }
      
        

        initQueries();
    }

    public static void ConnectDb() {

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting");

        } catch (SQLException e) {
            System.out.println("Connection to DB Failed! ");
            JFrame frame = new JFrame();
            int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
                    "Помилка підключення до бази данних!\nВихід з програми", "ПОМИЛКА!",
                    0, JOptionPane.YES_NO_OPTION, null, new String[]{"OK"}, null);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } 

    }
    
    public static void chooseServer(int cafeId) {
        
        if (cafeId == 0) {
            //shep
            dbName = "shep";
//            URL = "jdbc:mysql://93.183.216.29:3306/luckyroger";
        } else if (cafeId == 1) {
            //star
            dbName = "star";
//            URL = "jdbc:mysql://185.15.6.103:3306/luckyroger";
        } else if (cafeId == 2) {
            //slav
            dbName = "slav"; 
//            URL = "jdbc:mysql://82.207.112.48:3306/luckyroger";         
        }
    }
    public static void chooseLocalServer(int cafeId) {
        if (cafeId == 0) {
            //shep
            URL = "jdbc:mysql://192.168.0.111:3306/luckyroger";
        } else if (cafeId == 1) {
            //star
            URL = "jdbc:mysql://185.15.6.103:3306/luckyroger";
        } else if (cafeId == 2) {
            //slav          
            URL = "jdbc:mysql://192.168.1.51:3306/luckyroger";
        }
    }
    
    public static void doDBDump() {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 2) {
            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH-mm");
            String command = "cmd /c  mysqldump -u" + USERNAME + " -p" + PASSWORD + " "
                    + "luckyroger > C:/dump/" + dateFormat.format(new Date()) + "_dump.sql";
            try {
                 Runtime.getRuntime().exec(command);
            } catch (IOException ex) {
            }
        }
    }

    public static void doDBDumpToClientMachine() {
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 2) {
            DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH-mm");
            String command = "cmd /c  mysqldump -u" + USERNAME + " -p" + PASSWORD + " "
                    + dbName + " > C:/dump/" + dbName + "/" + dbName + dateFormat.format(new Date()) + "_dump.sql";
            try {
                Runtime.getRuntime().exec(command);
            } catch (IOException ex) {
            }
        }
    }

    public static void doDBImport() {
        URL = "jdbc:mysql://localhost:3306/" + dbName;
        USERNAME = PASSWORD = "root";
        DateFormat dateFormat = new SimpleDateFormat(
                "ddMMyyyy_HH-mm");
        String command = "cmd /c  mysql -u" + USERNAME + " -p" + PASSWORD + " "
                + dbName + " < C:/dump/" + dbName + "/" + dbName + dateFormat.format(new Date()) + "_dump.sql";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
        }
    }

    public static Date getLastModifiedDate() {
        String path = "C:\\dump\\" + dbName + "\\";

        File dir = new File(path);
        File[] files = dir.listFiles();

        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return Long.valueOf(f2.lastModified()).compareTo(
                        f1.lastModified());
            }
        });
        SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");

//        String actualDBDate = df2.format(new Date(files[0].lastModified()));
        Date actualDBDate = new Date(files[0].lastModified());
        System.out.println("actualDBDate " + df2.format(actualDBDate));
        return actualDBDate;

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
