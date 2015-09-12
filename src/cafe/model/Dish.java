package cafe.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author suxarina
 */
public class Dish {
    private int dbID;
    private String name = "";
    private int price = 0;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    
    
    public Dish(){} 

    public Dish(int dbID, String name, int price) {
        this.dbID = dbID;
        this.name = name;
        this.price = price;        
    }

    public int getDbID() {
        return dbID;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }  
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!Objects.equals(this.name, other.name)) {
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
        return name;
    }
    

 


    
    
    
    
}
