/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author suxarina
 */
public class User {
    
    private int dbId;
    private String name;
    private int pass;    
    private int kasa;
    private int dishCount;    
    private List<Ingredient> dayRemovedProducts = new LinkedList<>();
    public static int active;
 
    public User() {
    }
    
    


    public User(int dbId, String name, int pass) {
        this.name = name;
        this.pass = pass;
        this.dbId = dbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getKasa() {
        return kasa;
    }

    public void setKasa(int kasa) {
        this.kasa = kasa;
    }

    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }

    public List<Ingredient> getDayRemovedProducts() {
        return dayRemovedProducts;
    }

    public void setDayRemovedProducts(List<Ingredient> dayRemovedProducts) {
        this.dayRemovedProducts = dayRemovedProducts;
    }
    
    
    
    
    
    

    @Override
    public String toString() {
        return name;
    }
    
    
    

}
