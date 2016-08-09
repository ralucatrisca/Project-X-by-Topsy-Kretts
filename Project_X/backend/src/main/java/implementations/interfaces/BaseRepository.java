package implementations.interfaces;

import entities.BaseEntity;
import entities.Environmental;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * Created by POF4CLJ on 27.07.2016.
 */
public abstract class BaseRepository<ENTITY extends BaseEntity> {

    protected EntityManagerFactory factory = Persistence.createEntityManagerFactory(getPersistentUnitName());

    protected EntityManager em = factory.createEntityManager();

    public abstract void storeEntity(ENTITY entity);

    public abstract ENTITY retrieveEntity(int key);

    public abstract void updateEntity(ENTITY entity);

    public abstract void removeEntity(int key);

    public abstract Collection<ENTITY> getData();

    public abstract int timeDifference(ENTITY entity);

    protected String getPersistentUnitName() {
        return "persons";
    }

}
