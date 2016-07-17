package cafe.Utils.db;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
        }
      
        

      
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

        Date actualDBDate = new Date(files[0].lastModified());
        System.out.println("actualDBDate " + df2.format(actualDBDate));
        return actualDBDate;

    }
    

  

    
}
