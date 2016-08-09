package services;

import entities.Config;
import entities.Inertial;
import implementations.interfaces.BaseRepository;
import interfaces.services.IServiceInertial;

import java.util.Collection;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public class InertialService implements IServiceInertial<Inertial> {

    private BaseRepository<Inertial> inertial;

    public void storeEntity(Inertial entity) {
        inertial.storeEntity(entity);
    }

    public Inertial retrieveEntity(int key) {
        return inertial.retrieveEntity(key);
    }

    public void updateEntity(Inertial entity) {
        inertial.updateEntity(entity);
    }

    public void removeEntity(int key) {
        inertial.removeEntity(key);
    }

    public BaseRepository<Inertial> getInertial() {
        return inertial;
    }

    public Collection<Inertial> getData(){
        return inertial.getData();
    }

    public int timeDifference(Inertial e){
        return inertial.timeDifference(e);
    }

    public void setInertial(BaseRepository<Inertial> inertial) {
        this.inertial = inertial;
    }
}
