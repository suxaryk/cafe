/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;


import java.util.Date;
import java.util.Objects;


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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.dish);
        hash = 97 * hash + this.count;    
        hash = 97 * hash + this.sum;
        hash = 97 * hash + Objects.hashCode(this.date);
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
        final CheckItem other = (CheckItem) obj;
        if (!Objects.equals(this.dish, other.dish)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }      
        if (this.sum != other.sum) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
   
    
    

   
    
}
