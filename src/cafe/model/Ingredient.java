
package cafe.model;

import java.io.Serializable;

/**
 *
 * @author suxarina
 * @date 28.08.15
 */
public class Ingredient implements Serializable{
    private int dbId;
   // private String title; 
    private double count;

    public Ingredient() {
    }

    public Ingredient(int Id, double count) {
        this.dbId = Id;
        this.count = count;
    }

    public int getId() {
        return dbId;
    }

    public void setId(int Id) {
        this.dbId = Id;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Ingredient other = (Ingredient) obj;
        return true;
    }
    
    
    
}

