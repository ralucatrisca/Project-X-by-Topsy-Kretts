package interfaces.services;

import entities.BaseEntity;
import entities.Config;

import java.util.Collection;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public interface IConfigurationService <ENTITY extends BaseEntity>{

    public void storeEntity(Config entity);

    public Config retrieveEntity(int key);

    public void updateEntity(Config entity);

    public void removeEntity(int key);

    public Collection<Config> getData();

    public int timeDifference(Config e);

}
