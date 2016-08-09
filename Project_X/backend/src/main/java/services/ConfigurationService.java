package services;

import entities.Config;
import implementations.interfaces.BaseRepository;
import interfaces.services.IConfigurationService;

import java.util.Collection;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public class ConfigurationService implements IConfigurationService<Config> {

    private BaseRepository<Config> config;

    public void storeEntity(Config entity) {
        config.storeEntity(entity);
    }

    public Config retrieveEntity(int key) {
        return config.retrieveEntity(key);
    }

    public void updateEntity(Config entity) {
        config.updateEntity(entity);
    }

    public void removeEntity(int key) {
        config.removeEntity(key);
    }

    public BaseRepository<Config> getConfig() {
        return config;
    }

    public Collection<Config> getData() {
        return config.getData();
    }

    public void setConfig(BaseRepository<Config> config) {
        this.config = config;
    }

    public int timeDifference(Config e) {
        return config.timeDifference(e);
    }
}
