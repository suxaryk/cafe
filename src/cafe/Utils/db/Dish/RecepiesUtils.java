/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils.db.Dish;

import static cafe.Utils.db.Dish.DishUtils.PASSWORD;
import static cafe.Utils.db.Dish.DishUtils.URL;
import static cafe.Utils.db.Dish.DishUtils.USERNAME;
import static cafe.Utils.db.Dish.DishUtils.sqlSelectByIdList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class RecepiesUtils {
    private static final ArrayList<String> sqlUpdateRecepiesById = new ArrayList<>();
    
    static {
        
        sqlUpdateRecepiesById.add("UPDATE firstdishes SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE salats SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE rogerdishes SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE pandishes SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE meat SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE pizzaS SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE pizzaB SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE sushi SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE dessert SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE drinks SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE bear SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE alcohol SET ingredients = ? WHERE Id = ?");
        sqlUpdateRecepiesById.add("UPDATE not_alcohol SET ingredients = ? WHERE Id = ?");
        
    }
    
    public static void addRecipes(int dishDbId, String ingredients){
        System.out.println("dvID" + dishDbId);
        final String SQL = "INSERT INTO recipes(dishId, ingredients) VALUES(?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! addRecipes"
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

    public static void updateRecipes(int activeCat, int dishDbId, String ingredients) {
        for (int i = 0; i < sqlUpdateRecepiesById.size(); i++) {
            if (i == activeCat) {
                try (Connection connection = DriverManager
                        .getConnection(URL, USERNAME, PASSWORD)) {
                    System.out.println(!connection.isClosed() ? "DB connected! updateRecipes"
                            : "Error DB connecting");
                    PreparedStatement pstatement = connection.
                            prepareStatement(sqlUpdateRecepiesById.get(i));

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
    }
    public static String readRecipeFromDB(int activeCat, int dishDbId) {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {

            System.out.println(!connection.isClosed() ? "DB connected! readRecipeFromDB"
                    : "Error DB connecting");
            PreparedStatement pst = connection.prepareStatement(sqlSelectByIdList.get(activeCat));
            pst.setInt(1, dishDbId);           
            
            String jsonRecepies = "";
            try (ResultSet rs = pst.executeQuery()) {                 
                while (rs.next()) {
                        jsonRecepies += rs.getString("ingredients");
                }
            }           
            return jsonRecepies;                            
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - readRecipesFromDB");
            return null;            
        }
    }
}
