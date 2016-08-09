package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
@Entity
@Table(name="INNERTIAL")
public class Inertial extends BaseEntity{

    int ax;
    int ay;
    int az;
    int gx;
    int gy;
    int gz;
    int mx;
    int my;
    int mz;

    protected Inertial(){
    }

    public Inertial(int ax, int ay, int az, int gx, int gy, int gz, int mx, int my, int mz){
        this.ax = ax;
        this.ay = ay;
        this.az = az;
        this.gx = gx;
        this.gy = gy;
        this.gz = gz;
        this.mx = mx;
        this.my = my;
        this.mz = mz;
    }

    public int getAx() {
        return ax;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getAz() {
        return az;
    }

    public void setAz(int az) {
        this.az = az;
    }

    public int getGx() {
        return gx;
    }

    public void setGx(int gx) {
        this.gx = gx;
    }

    public int getGy() {
        return gy;
    }

    public void setGy(int gy) {
        this.gy = gy;
    }

    public int getGz() {
        return gz;
    }

    public void setGz(int gz) {
        this.gz = gz;
    }

    public int getMx() {
        return mx;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMy() {
        return my;
    }

    public void setMy(int my) {
        this.my = my;
    }

    public int getMz() {
        return mz;
    }

    public void setMz(int mz) {
        this.mz = mz;
    }
}
