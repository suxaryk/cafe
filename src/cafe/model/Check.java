/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;

import cafe.model.CheckItem;
import java.util.ArrayList;

/**
 *
 * @author suxarina
 */
public class Check {   
    private int totalsum;
    private ArrayList<CheckItem> checkList = new ArrayList<>();
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private boolean payed;

     

    public int getTotalsum() {
        int sum = 0;
        for (int i = 0; i < checkList.size(); i++) {
            sum += checkList.get(i).getSum();            
        }
        return totalsum = sum;
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
