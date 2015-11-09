package cafe.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suxarina
 */
public class Dish {
    private int dbId;
    private String title;
    private int price;
    private boolean cook; 
    private List<Ingredient> recipe = new ArrayList<>();     
    
    public Dish(){}      

    public Dish(int dbId, String title, int price, boolean cook, List<Ingredient> recipe) {
        this.dbId = dbId;
        this.title = title;
        this.price = price;   
        this.cook = cook;
        if (recipe != null) {
            this.recipe = recipe;   
        }
        
    }
    public Dish(String title, int price, boolean cook) {        
        this.title = title;
        this.price = price;   
        this.cook = cook;
    }     
    public Dish(String title, int price) {        
        this.title = title;
        this.price = price;          
    }     
    public Dish(String title) {         
        this.title = title;        
    }     
      
    public int getDbID() {
        return dbId;
    }

    public void setDbID(int dbId) {
        this.dbId = dbId;
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

    public List<Ingredient> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Ingredient> list) {
        this.recipe = list;
    }

    public boolean isCook() {
        return this.cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }  

    
    @Override
    public String toString() {
        return title;
    } 
    
}
