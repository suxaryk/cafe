package cafe.model;

import java.util.Date;

public class Employee extends User {

    public Employee(int dbId, String name, int pass) {
        super(dbId, name, pass);
    }

    public Employee(int dbId, String name, Date date_in, Date date_out) {
        this.dbId = dbId;
        this.name = name;
        this.startTime = date_in;
        this.endTime = date_out;

    }

}
