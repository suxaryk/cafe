package cafe.model;

import java.util.ArrayList;
import java.util.Objects;

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

    public Dish(int dbID, String title, int price, boolean cook) {
        this.dbId = dbID;
        this.title = title;
        this.price = price;        
        this.cook = cook;
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
