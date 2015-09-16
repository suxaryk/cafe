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
public class User {
    private int dbID;
    private String name;
    private int pass;
    private int active;
    public static int activeUserOfList;

    public User(int id, String name, int pass) {
        this.dbID = id;
        this.name = name;
        this.pass = pass;
    }

    public User(String name, int pass) {
        this.name = name;
        this.pass = pass;
    }
    

    public int getDbID() {
        return dbID;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
