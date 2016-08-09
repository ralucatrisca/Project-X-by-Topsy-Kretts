package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by POF4CLJ on 27.07.2016.
 */

@Entity
@Table(name="ENVIRONMENTAL")
public class Environmental extends BaseEntity {

    double t;
    float rhw;
    int p;
    int l;
    int n;

    protected Environmental(){

    }

    public Environmental(int t,float rhw,int p,int l, int n){
        this.t = t;
        this.rhw = rhw;
        this.p = p;
        this.l = l;
        this.n = n;
    }

    public double getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public float getRhw() {
        return rhw;
    }

    public void setRhw(float rhw) {
        this.rhw = rhw;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
