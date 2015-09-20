package cafe.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author suxarina
 */
public class Dish {
    private int dbId;
    private String title = "";
    private int price = 0;
    private boolean cook;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    
    
    public Dish(){} 
    
    

    public Dish(int dbID, String title, int price, String  recipes) {
        this.dbId = dbID;
        this.title = title;
        this.price = price;   
//        if (!"".equals(recipes)) {
//            try {
//                JSONParser parser = new JSONParser();
//                
//                Object obj = parser.parse(recipes);
//                JSONObject jsonObj = (JSONObject) obj;
//                for (int i = 0; i < ingredients.size(); i++) {
//                    ingredients.add(new Ingredient(i, i));
//                }
//                jsonObj.ge
//                System.out.println(jsonObj.get("paramsStr"));
//            } catch (ParseException ex) {
//                Logger.getLogger(Dish.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("Error parse =" + Dish.class.getName());
//            }
//        }
        
    }

    public Dish(int dbID, String title, int price) {
        this.dbId = dbID;
        this.title = title;
        this.price = price;   
    }
    public Dish(String title, int price) {        
        this.title = title;
        this.price = price;
        this.cook = true;
    }
    

    public int getDbID() {
        return dbId;
    }

    public void setDbID(int dbID) {
        this.dbId = dbID;
    }  
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Ingredient> getListOfIngredients() {
        return ingredients;
    }

    public void setListOfIngredients(ArrayList<Ingredient> list) {
        this.ingredients = list;
    }

    public boolean isCook() {
        return cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dish other = (Dish) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    

 


    
    
    
    
}
