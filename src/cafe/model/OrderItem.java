/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;


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
    
}
