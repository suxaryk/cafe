
package cafe.model;

import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class Category {
    private String title; 
    private ArrayList<Dish> dishes = new ArrayList<>();

    public Category() {}  

    public Category(String title) {
        this.title = title;
    }       
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }    
    
    public  ArrayList<Dish> getDishes() {
        return dishes;
    }

    public  void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }
    
    
}
