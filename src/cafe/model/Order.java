package cafe.model;

import cafe.Utils.json.JSONUtils;
import cafe.view.MainForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author suxarina
 */
public class Order {
    
    private int dayId;
    private int cookCount;    
    private int orderSum;
    private boolean payed;
    private Date date;
    private String user;
    private ArrayList<OrderItem> items = new ArrayList<>();
    private ArrayList<OrderItem> removeditems = new ArrayList<>();

    public  int getDayId() {
        return dayId;
    }
    public  void incDayId() {
         dayId++;
    }

    public  void setDayId(int dayId) {
        this.dayId = dayId;
    }
    
    
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

    

    public int getCookCount() {
        if (cookCount != 0) {
            return cookCount;
        }else{
            int count = 0;
            for (OrderItem orderItem : items) {
                count += orderItem.getCookCount();
                System.out.println("count" + count);
            }
            return count;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
      
    
    
    public String getJSONItems(boolean includePrice, int activeCat) {
        if (!items.isEmpty()) {
            if (includePrice) {
                return JSONUtils.convertOrderToJSONTables(items, activeCat);
            } else {
                return JSONUtils.convertOrderToJSON(items, activeCat);
            }
        } else {
            return "";
        }
    }

    public String getJSONRemovedItems(boolean includePrice, int activeCat) {
        if (!items.isEmpty()) {
            if (includePrice) {
                return JSONUtils.convertOrderToJSONTables(removeditems, activeCat);
            }
            return JSONUtils.convertOrderToJSON(removeditems, activeCat);
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
