package cafe.model;

import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class Dish {
    private int dbId;
    private String title;
    private int price;
    private boolean cook;
    private ArrayList<Ingredient> recipe = new ArrayList<>();     
    
    public Dish(){}      

    public Dish(int dbId, String title, int price) {
        this.dbId = dbId;
        this.title = title;
        this.price = price;   
    }
    public Dish(String title, int price) {        
        this.title = title;
        this.price = price;        
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

    public ArrayList<Ingredient> getRecipe() {
        return recipe;
    }

    public void setRecipe(ArrayList<Ingredient> list) {
        this.recipe = list;
    }

    public boolean isCook() {
        if (recipe.size() > 1) {
            return cook = true;
        }
        else return cook = false;        
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }   
    @Override
    public String toString() {
        return title;
    } 
    
}
