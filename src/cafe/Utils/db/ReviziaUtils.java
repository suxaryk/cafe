package cafe.Utils.db;

import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;
import static cafe.Utils.db.DishUtils.getCurrentTimeStamp;
import cafe.model.ReviziaItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;


public class ReviziaUtils { 
    private static final Logger log = Logger.getLogger(ReviziaUtils.class);

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
            log.debug("Revizia was added successfully!");

        } catch (SQLException e) {
            log.error("AddRevizia Exception" + e.getMessage());
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
            log.error("Connection Failed! Check output console - getReviziaDates" + e);

        } finally {
            log.debug("DB getReviziaDates");
            return reviziaDates;
        }
    }

    public static List<ReviziaItem> getReviziaByDate(Timestamp date, String orderCriteria) {
        List<ReviziaItem> revizia = new ArrayList<>();
        log.debug("date = " + date);
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            final String SQL = "SELECT ingredient_id, old_count, storage.title, "
                               + "new_count, diff_count "
                               + "FROM revizia "
                               + "INNER JOIN storage " 
                               + "ON revizia.ingredient_id = storage.Id "
                               + "WHERE DATE(date) = DATE('"+ date +"') "
                               + "ORDER BY "+ orderCriteria +"";            

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);            
            while (rs.next()) {
                revizia.add(new ReviziaItem(                         
                        rs.getInt("ingredient_id"), 
                        rs.getString("title"),
                        rs.getDouble("old_count"), 
                        rs.getDouble("new_count"), 
                        rs.getDouble("diff_count")                        
                ));
            }            
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getReviziaDates  " + e);
        } finally {
            return revizia;
        }
    }

}
