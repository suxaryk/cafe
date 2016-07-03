package cafe.model;

/**
 *
 * @author suxarina
 * @date 28.08.15
 */
public class Ingredient {

    private int dbId;
    private String title;
    private double count;
    private boolean active;
    private int dishId;
    
    public Ingredient() {
    }

    public Ingredient(String title) {
        this.title = title;
    }

    public Ingredient(int dbId, double count) {
        this.dbId = dbId;
        this.count = count;
    }

    public Ingredient(int dbId, String title) {
        this.dbId = dbId;
        this.title = title;
    }
    
    public Ingredient(int dbId, String title, double count) {
        this.dbId = dbId;
        this.title = title;
        this.count = count;
    }

    public Ingredient(int dbId, String title, double count, boolean active) {
        this.dbId = dbId;
        this.title = title;
        this.count = count;
        this.active = active;
    }
    

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    
    
    
    //utils tmp
//    public Ingredient(int dbId, int  ing_id, double count) {
//        this.dbId = dbId;
//        this.ing_id = ing_id;
//        this.count = count;
//    }

   

    public int getId() {
        return dbId;
    }

    public void setId(int Id) {
        this.dbId = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public void addCount(double count) {
        this.count += count;

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public int getIng_id() {
//        return ing_id;
//    }
//
//    public void setIng_id(int ing_id) {
//        this.ing_id = ing_id;
//    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return this.getId() == ((Ingredient) obj).getId();
        } catch (Exception e) {
            return false;
        }
    }

}
