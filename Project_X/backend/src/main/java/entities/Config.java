package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
@Entity
@Table(name = "CONFIGURATION")
public class Config extends BaseEntity {

    String line;
    String factory;
    String machine_id;

    protected Config(){
    }

    public Config(String line, String factory, String machine_id){
        this.line = line;
        this.factory = factory;
        this.machine_id = machine_id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }
}
