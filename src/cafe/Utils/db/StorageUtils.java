/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.DishUtils.PASSWORD;
import static cafe.Utils.db.DishUtils.URL;
import static cafe.Utils.db.DishUtils.USERNAME;
import cafe.model.Ingredient;
import cafe.view.MainForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author suxarina
 */
public class StorageUtils {

    public static void readStorage() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            String SQL = "SELECT * FROM storage";
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                MainForm.storageList.add(
                        new Ingredient(
                                rs.getInt("Id"),
                                rs.getString("title")
                        ));
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readStorage");
        }

    }

//    public static void addIngredientToDB(Ingredient ingredient) {
//        final String SQL = "INSERT INTO storage(title) VALUES(?)";
//        try (Connection connection = DriverManager
//                .getConnection(URL, USERNAME, PASSWORD)) {
//
//            PreparedStatement pstatement = connection.prepareStatement(SQL);
//            pstatement.setString(1, name);
//            pstatement.setInt(2, pass);
//            int rowsInserted = pstatement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("A new Ingredient was added successfully!");
//                
//            }
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console - addIngredientToDB");
//        }
//
//    }

}
