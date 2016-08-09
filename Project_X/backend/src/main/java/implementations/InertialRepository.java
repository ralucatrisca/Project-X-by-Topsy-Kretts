package implementations;

import entities.Environmental;
import entities.Inertial;
import implementations.interfaces.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public class InertialRepository extends BaseRepository<Inertial> {

    public void storeEntity(Inertial entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public Inertial retrieveEntity(int key) {
        Inertial entity = em.find(Inertial.class, key);
        return entity;
    }

    public void updateEntity(Inertial entity) {
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void removeEntity(int key) {
        Inertial entity = em.find(Inertial.class, key);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public Collection<Inertial> getData() {
       // em.getTransaction().begin();
        List<Inertial> inertials = em.createQuery("SELECT i FROM Inertial i").getResultList();
///        em.getTransaction().commit();
     //   em.close();
        return inertials;
    }

    public int timeDifference(Inertial e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil) / 1000L / 60L / 60L;
        return (int) difHour;
    }
}
