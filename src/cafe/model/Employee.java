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
public class Employee extends User{   

    public Employee(int dbId, String name, int pass) {
        super(dbId, name, pass);
    }
    public Employee(int dbId, String name, Date date_in, Date date_out){
        this.dbId = dbId;
        this.name = name;
        this.startTime = date_in;
        this.endTime = date_out;
        
    }
  

   

  
  

     

    
    
    

   
    
}
