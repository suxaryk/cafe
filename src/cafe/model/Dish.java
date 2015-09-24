package cafe.model;

import cafe.Utils.json.JSONUtils;
import cafe.view.MainForm;
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
    private ArrayList<Ingredient> recipes = new ArrayList<>();
    
    
    public Dish(){} 
    
    

//    public Dish(int dbID, String title, int price, String  recipes) {
//        this.dbId = dbID;
//        this.title = title;
//        this.price = price;         
//       // System.out.println("cat=" + MainForm.activeCat);
//       // System.out.println("Dish=" +MainForm.activeDishes);
//        //JSONUtils.readRecipes(recipes, MainForm.activeCat, MainForm.activeDishes);
//        
//    }

    public Dish(int dbID, String title, int price) {
        this.dbId = dbID;
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
        return recipes;
    }

    public void setListOfIngredients(ArrayList<Ingredient> list) {
        this.recipes = list;
    }

    public boolean isCook() {
        if (recipes.size() > 1) {
            return cook = true;
        }
        else return cook = false;        
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
        if (!Objects.equals(this.recipes, other.recipes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title;
    }
    
    private void clearRecipes(){
        for (Ingredient ing : recipes) {
            ing.setCount(0);
        }   
    }
    

 


    
    
    
    
}
