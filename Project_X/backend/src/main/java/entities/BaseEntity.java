package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by POF4CLJ on 27.07.2016.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int baseId;

    private String id;

    private Date time;

    private String type;
    private String gw_id;
    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getGw_id() {
        return gw_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGw_id(String gw_id) {
        this.gw_id = gw_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }
}
