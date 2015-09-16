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
public class Employee extends User{
    private int dbId;

    public Employee(String name, int pass) {
        super(name, pass);
    }

    public Employee(int dbId, String name, int pass) {
        super(name, pass);
        this.dbId = dbId;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    
    
     

    
    
    

   
    
}
