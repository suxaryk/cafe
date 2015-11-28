package cafe.model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author suxarina
 */
public class OrderItem {
    private Dish dish;
    private int count;    
    private int itemSum;
    private boolean printed;
    private boolean cook;

    public OrderItem() {
    }
    
    
    
    public OrderItem(Dish dish, int count, boolean cook) {
        this.dish = dish;
        this.count = count;         
        itemSum = dish.getPrice() * count;
        this.cook = cook;
    }
    public OrderItem(Dish dish, int count) {
        this.dish = dish;
        this.count = count;      
        itemSum = dish.getPrice() * count;       
    }
    

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {        
        return count;
    }
   

    public void setCount(int count) {
        this.count = count;
        this.itemSum = this.count * dish.getPrice();
    }
    
    public  int getCookCount(){
        if (dish.isCook()) {
            return count;
        } else {
            return 0;
        }
    }         
    
    
    public void addCount(int count){
        this.count += count;
        this.itemSum = this.count * dish.getPrice();
    }
    
    public void reverseCount(){
        this.count = this.count * (-1);
    }

    public int getSum() {
        return itemSum;
    }

    public void setSum(int sum) {
        this.itemSum = sum;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public boolean isCook() {
        return cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }  
    
    
    
    
    public List<Ingredient> getOrderItemRecipe(){
        List<Ingredient> itemRecipe = new ArrayList<>();        
        for (Ingredient ingredient : dish.getRecipe()) {
            itemRecipe.add(new Ingredient(ingredient.getId(), ingredient.getCount() * count));          
        }
        return itemRecipe;
    }

    @Override
    public boolean equals(Object obj) {
        try{
        return this.getDish().getTitle().equals(((OrderItem)obj).getDish().getTitle()); 
        }catch(Exception e){
            return false;
        }
    }
    
    
}
