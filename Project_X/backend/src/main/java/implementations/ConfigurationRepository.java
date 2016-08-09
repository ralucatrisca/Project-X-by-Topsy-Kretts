package implementations;

import entities.Config;
import entities.Environmental;
import entities.Inertial;
import implementations.interfaces.BaseRepository;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public class ConfigurationRepository extends BaseRepository<Config> {

    public void storeEntity(Config entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public Config retrieveEntity(int key) {
        return em.find(Config.class, key);
    }

    public void updateEntity(Config entity) {
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void removeEntity(int key) {
        Inertial entity = em.find(Inertial.class, key);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public Collection<Config> getData() {
        return (Collection<Config>) em.createQuery("SELECT c FROM Config c").getResultList();
    }

    public int timeDifference(Config e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil) / 1000L / 60L / 60L;
        return (int) difHour;
    }
}
