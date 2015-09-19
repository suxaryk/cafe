/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;


import java.util.Date;


/**
 *
 * @author suxarina
 */
public class CheckItem {
    private Dish dish;
    private int count;    
    private int sum;
    private Date date;  


    
    

    public CheckItem(Dish dish, int count, Date date) {
        this.dish = dish;
        this.count = count;       
        this.date = date;
        sum = dish.getPrice() * count;
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
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  
   
    
    

   
    
}
