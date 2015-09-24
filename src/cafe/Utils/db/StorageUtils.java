/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.Dish.DishUtils.PASSWORD;
import static cafe.Utils.db.Dish.DishUtils.URL;
import static cafe.Utils.db.Dish.DishUtils.USERNAME;
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
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    MainForm.storageList.add(
                            new Ingredient(
                                    rs.getInt("Id"),
                                    rs.getString("title")
                            ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readStorage");
        }

    }

    public static void addIngredientToDB(Ingredient ingredient) {
        final String SQL = "INSERT INTO storage(title) VALUES(?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setString(1, ingredient.getTitle());       
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Ingredient was added successfully!");
                
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addIngredientToDB");
        }

    }
    
    public static void removeIngredientFromDB(int dbId) {
        final String SQL = "DELETE FROM storage WHERE Id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, dbId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Ingredient was removed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - removeIngredientFromDB");
        }

    }

}
