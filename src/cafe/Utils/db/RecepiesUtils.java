package cafe.Utils.db;


import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import cafe.Utils.json.JSONUtils;
import cafe.model.Ingredient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;

public class RecepiesUtils {  
    private static final Logger log = Logger.getLogger(RecepiesUtils.class);
    //unused
    public static void addDishIngredient(int dishId, int storageId, double count) {       
        final String SQL = "INSERT INTO dish_product(dishId, storage_id, count) VALUES(?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! addDishIngredient"
                    : "Error DB connecting");
            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setInt(1, dishId);
            pstatement.setInt(2, storageId);
            pstatement.setDouble(3, count);

            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new addDishIngredient was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - addDishIngredient");
        }
    }

    public static void updateDishIngredient(int receptId, double count) { 
        final String SQL = "UPDATE dish SET count = ? WHERE Id = ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println(!connection.isClosed() ? "DB connected! updateDishIngredient"
                    : "Error DB connecting");
            PreparedStatement pstatement = connection.prepareStatement(SQL);

            pstatement.setDouble(1, count);
            pstatement.setInt(2, receptId);
            
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new dish_product was updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - updateDishIngredient");
        } 
    }

    public static Map<Integer, Ingredient> getRecipeByDishId(int dishDbId) {
        final String SQL = "SELECT * FROM luckyroger.dish_product where dish_id = ?";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {                    
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, dishDbId);

            Map<Integer, Ingredient> recipe = new TreeMap<>();
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    recipe.put(rs.getInt("id"), new Ingredient(rs.getInt("ingredient_id"), rs.getDouble("count")));                  
                }
            }
            return recipe;
        } catch (SQLException e) {
            log.error("Connection Failed! Check output console - getRecipeByDishId " + e.toString());
            return null;
        }
    }
    
    public static void removeIngredientInAllDishes(int ingredientId) {
        final String SQL = "DELETE FROM luckyroger.dish_product where ingredient_id = ?";

        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement pst = connection.prepareStatement(SQL);
            pst.setInt(1, ingredientId);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Ingredient was removed successfully in all dishes!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - removeIngredientInAllDishes");
        }

    }
    
    //utils tmp
    public static void readCustomDishes() {
        final String SQL = "select * from dish";
    
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println(!connection.isClosed() ? "DB connected! getAddedIngredients"
                    : "Error DB connecting");
            List<Ingredient> jsons = new ArrayList<>();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(SQL)) {
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                       jsons = JSONUtils.getRecipeFromJSON(rs.getString("ingredients"));
                       for (Ingredient json : jsons) {
                           insertAddedUtilits(dishId, json.getId(), json.getCount());
                    }
                }              
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - getAddedIngredients ");           
        }
    }
    
    //utils tmp
    public static void insertAddedUtilits(int dish_id, int ingredient_id, double count) {
        final String SQL = "INSERT INTO recipe(dish_id, ingredient_id, count) VALUES(?, ?, ?)";
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement pstatement = connection.prepareStatement(SQL);
            pstatement.setInt(1, dish_id);
            pstatement.setInt(2, ingredient_id);         
            pstatement.setDouble(3, count);
            int rowsInserted = pstatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Ingredient was added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console - insertAddedUtilits");
        }

    }
}
