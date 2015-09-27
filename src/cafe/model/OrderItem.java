/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    }

    public int getSum() {
        return itemSum;
    }

    public void setSum(int sum) {
        this.itemSum = sum;
    }
    public List<Ingredient> getOrderItemRecipe(){
        List<Ingredient> itemRecipe = new ArrayList<>();        
        for (Ingredient ingredient : dish.getRecipe()) {
            itemRecipe.add(new Ingredient(ingredient.getId(), ingredient.getCount() * count));          
        }
        return itemRecipe;
    }
    
}
