/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;

import cafe.Utils.json.JSONUtils;
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
    private int drinkCount;
    private int orderSum;
    private boolean payed;    
    private String JSONItems;
    private ArrayList<OrderItem> items = new ArrayList<>();
    private ArrayList<OrderItem> removeditems = new ArrayList<>();

    public int calcOrderSum() {
        int sum = 0;
        if (!items.isEmpty()) {
            for (OrderItem orderItem : items) {
                sum += orderItem.getSum();
            }
        }
        if (orderSum < 0) {
            return orderSum;
        } else {
            return orderSum = sum;
        }
    }

    public int getOrderSum() {
        return orderSum;
    }

    public int getDrinkCount() {
        drinkCount = 0; 
            for (OrderItem orderItem : items) {
                if (orderItem.getDish().isDrink()) {
                    drinkCount += orderItem.getCount();
                }
            }            
        return drinkCount;
    }

    public void setDrinkCount(int drinkCount) {
        this.drinkCount = drinkCount;
    }

    public int getCookCount() {
        int recipeSize = 0;
        for (OrderItem item : items) {
            recipeSize += item.getDish().getRecipe().size();
        }
        if (recipeSize == 0) {
            return cookCount;
        } else {
            cookCount = 0;
            for (OrderItem orderItem : items) {
                if (orderItem.getDish().isCook()) {
                    this.cookCount += orderItem.getCount();
                }
            }
            System.out.println("cookCount= " + cookCount);
            return cookCount;
        }
    }

    public void setCookCount(int cookCount) {
        this.cookCount = cookCount;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> checkList) {
        this.items = checkList;
    }

    public ArrayList<OrderItem> getRemovedItems() {
        return removeditems;
    }

    public void setRemovedItems(ArrayList<OrderItem> removeditems) {
        this.removeditems = removeditems;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

   
    
    
    public String getJSONItems(boolean includePrice) {
        if (!items.isEmpty()) {
            if (includePrice) {
                return JSONUtils.convertOrderToJSONTables(items);
            } else {
                return JSONUtils.convertOrderToJSON(items);
            }
        } else {
            return "";
        }
    }

    public String getJSONRemovedItems(boolean includePrice) {
        if (!items.isEmpty()) {
            if (includePrice) {
                return JSONUtils.convertOrderToJSONTables(removeditems);
            }
            return JSONUtils.convertOrderToJSON(removeditems);
        }
        return "";
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
        return diffMap;
    }

}
