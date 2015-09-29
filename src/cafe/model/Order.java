/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;

import cafe.view.MainForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author suxarina
 */
public class Order {   
    private int cookCount;
    private int orderSum;
    private boolean payed;
    private ArrayList<OrderItem> items = new ArrayList<>();
   // private ArrayList<Ingredient> ingredients = new ArrayList<>();
    

     

    public int getOrderSum() {
        int sum = 0;
        for (OrderItem orderItem : items) {
            sum += orderItem.getSum();            
        }
        return orderSum = sum;
    }

    public int getCookCount() {        
        for (OrderItem checkItem : items) {
            if (checkItem.getDish().isCook()) {
                cookCount+=checkItem.getCount();                  
            }
        }
        return cookCount;
    }

    public void setCookCount(int cookCount) {
        this.cookCount = cookCount;
    }

    public void setTotalsum(int orderSum) {
        this.orderSum = orderSum;
    }

    public ArrayList<OrderItem> getCheckList() {
        return items;
    }

    public void setCheckList(ArrayList<OrderItem> checkList) {
        this.items = checkList;
    }
    
    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
    
    public Map<Integer, Double> getOrderIngredients() {
        Map<Integer, Double> diffMap = new HashMap<>();
        for (Ingredient ingredient : MainForm.storageList) {
            diffMap.put(ingredient.getId(), 0.0);
        }
        for (OrderItem item : items) {
            for (Ingredient ingredient : item.getOrderItemRecipe()) {
                double oldCount = diffMap.get(ingredient.getId());
                diffMap.put(ingredient.getId(), oldCount + ingredient.getCount());
            }
        }
//        for (Entry<Integer, Double> entry: diffMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//            
//        }
        return diffMap;
    }
    
    
}
