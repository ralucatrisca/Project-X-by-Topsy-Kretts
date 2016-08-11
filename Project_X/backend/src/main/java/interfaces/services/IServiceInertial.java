package interfaces.services;

import entities.BaseEntity;
import entities.Inertial;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public interface IServiceInertial <ENTITY extends BaseEntity> {

    public void storeEntity(Inertial entity);

    public Inertial retrieveEntity(int key);

    public void updateEntity(Inertial entity);

    public void removeEntity(int key);

    public Collection<Inertial> getData();

    public int timeDifference(Inertial e);

//    static List<Inertial> findAllInertials();




}
