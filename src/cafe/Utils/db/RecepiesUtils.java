/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db;

import static cafe.Utils.db.DishUtils.PASSWORD;
import static cafe.Utils.db.DishUtils.URL;
import static cafe.Utils.db.DishUtils.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class RecepiesUtils {
    private static final ArrayList<String> sqlUpdateRecepiesList = new ArrayList<>();
    
    static {
        
    }
    public static void addRecipes(int dishDbId, String ingredients){
//        final String sql = "INSERT INTO recipes(dishId, ingredients)"
//                                                    + " VALUES(?, ?)";
        System.out.println("dvID" + dishDbId);
        final String SQL = "INSERT INTO recipes(dishId, ingredients) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pstatement = connection.prepareStatement(SQL);  
            
            pstatement.setInt(1, dishDbId);
            pstatement.setString(2, ingredients);  
            
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new recipes was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addRecepies");
        }
        
    } 
    public static void updateRecipes(int dishDbId, String ingredients){
//        final String sql = "INSERT INTO recipes(dishId, ingredients)"
//                                                    + " VALUES(?, ?)";
        System.out.println("dvID" + dishDbId);
        final String SQL = "UPDATE sushi SET ingredients = ? WHERE Id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected!"
                    : "Error DB connecting");
            PreparedStatement pstatement = connection.prepareStatement(SQL);  
            
            pstatement.setString(1, ingredients);
            pstatement.setInt(2, dishDbId);  
            
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new recipes was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateRecipes");
        }
        
    } 
    
}
