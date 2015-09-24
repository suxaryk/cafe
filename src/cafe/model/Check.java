/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;

import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class Check {   
    private int cookCount;
    private int totalsum;
    private ArrayList<CheckItem> checkList = new ArrayList<>();
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private boolean payed;

     

    public int getTotalsum() {
        int sum = 0;
        for (CheckItem checkList1 : checkList) {
            sum += checkList1.getSum();            
        }
        return totalsum = sum;
    }

    public int getCookCount() {        
        for (CheckItem checkList1 : checkList) {
            if (checkList1.getDish().isCook()) {
                cookCount+=checkList1.getCount();                  
            }
        }
        return cookCount;
    }

    public void setCookCount(int totalCount) {
        this.cookCount = totalCount;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }

    public ArrayList<CheckItem> getCheckList() {
        return checkList;
    }

    public void setCheckList(ArrayList<CheckItem> checkList) {
        this.checkList = checkList;
    }
    
    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
   
    
    
}
