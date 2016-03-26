package cafe.Utils.db;

import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.model.ReviziaItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReviziaUtils {

    public static void addRevizia(List<ReviziaItem> revizia) 
                                                        throws SQLException {
        final String SQL = "INSERT INTO revizia(date, ingredient_id,"
                                + " old_count, new_count, diff_count) "
                                + "VALUES(?, ?, ?, ?, ?)";
        Connection dbConnect = null;
        PreparedStatement pstatement = null;
        try {
            dbConnect = DriverManager.getConnection(URL, USERNAME, PASSWORD);            
            pstatement = dbConnect.prepareStatement(SQL);
            
            dbConnect.setAutoCommit(false);

            for (ReviziaItem item : revizia) {
                pstatement.setTimestamp(1, getCurrentTimeStamp());
                pstatement.setInt(2, item.getId());
                pstatement.setDouble(3, item.getOldCount());
                pstatement.setDouble(4, item.getNewCount());
                pstatement.setDouble(5, item.getDiffCount());
                pstatement.addBatch();
            }
            pstatement.executeBatch();
            dbConnect.commit();
            System.out.println("Revizia was added successfully!");

        } catch (SQLException e) {
            System.out.println("AddRevizia Exception" + e.getMessage());
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

    public static List<Date> getReviziaDates() {
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
            return reviziaDates;
        }
    }

    public static List<ReviziaItem> getReviziaByDate(Date date) {
        List<ReviziaItem> revizia = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            final String SQL = "SELECT ingredient_id, "
                             + "old_count, new_count, diff_count "
                             + "WHERE DATE(date) = " + date;
            
            

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);            
            while (rs.next()) {
                revizia.add(new ReviziaItem(                       
                        rs.getInt("ingredient_id"), 
                        rs.getDouble("old_count"), 
                        rs.getDouble("new_count"), 
                        rs.getDouble("diff_count")                        
                ));
            }            
        } catch (SQLException e) {
            System.out.println("Connection Failed!"
                            + " Check output console - getReviziaDates" + e);
        } finally {
            return revizia;
        }
    }

}
