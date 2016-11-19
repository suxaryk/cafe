package cafe.Utils.db;


import static cafe.Utils.db.DBUtils.PASSWORD;
import static cafe.Utils.db.DBUtils.URL;
import static cafe.Utils.db.DBUtils.USERNAME;
import cafe.model.Check;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author suxarina
 */
public class CheckUtils {
    private static final Logger log = Logger.getLogger(CheckUtils.class);

    public static void readCheck() {
        final String SQL = "SELECT title, adress, passWifi, wish  from check_info ORDER BY Id";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();

            try (ResultSet rs = statement.executeQuery(SQL)) {
                Check check;
                while (rs.next()) {
                    check = new Check(
                            rs.getString("title"),
                            rs.getString("adress"),
                            rs.getString("passWifi"),
                            rs.getString("wish")
                    );
                }
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - readCheck");
        }
    }

    public static void updateCheck(String title, String adress, String passWifi, String wish) {
        final String SQL = "UPDATE check_info set title=?,  adress=?, passWifi=?, wish=? where Id = 1";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setString(1, title);
            pst.setString(2, adress);
            pst.setString(3, passWifi);
            pst.setString(4, wish);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                log.debug("Check was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - updateCheck");

        }

    }

}
