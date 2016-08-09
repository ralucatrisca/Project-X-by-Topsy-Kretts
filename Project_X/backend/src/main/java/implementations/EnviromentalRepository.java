package implementations;

import entities.Environmental;
import implementations.interfaces.BaseRepository;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by POF4CLJ on 27.07.2016.
 */
public class EnviromentalRepository extends BaseRepository<Environmental> {

    public void storeEntity(Environmental env) {

        em.getTransaction().begin();
        em.persist(env);
        em.getTransaction().commit();
    }

    public Environmental retrieveEntity(int key) {
        Environmental env = em.find(Environmental.class, key);
        return env;
    }

    public void updateEntity(Environmental env) {
        em.merge(env);
        em.getTransaction().commit();
    }

    public void removeEntity(int key) {
        Environmental environmental = em.find(Environmental.class, key);
        em.getTransaction().begin();
        em.remove(environmental);
        em.getTransaction().commit();
    }

    public Collection<Environmental> getData() {
        return (Collection<Environmental>) em.createQuery("SELECT c FROM Environmental c").getResultList();
    }

    public int timeDifference(Environmental e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil)/1000L/60L/60L;
        return (int) difHour;
    }
}
