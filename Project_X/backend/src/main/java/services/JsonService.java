package services;

import entities.*;
import interfaces.services.IJsonHandler;
import interfaces.services.IJsonService;

/**
 * Created by POF4CLJ on 26.07.2016.
 */
public class JsonService implements IJsonService {

    private IJsonHandler handler;

    public void setHandler(IJsonHandler handler) {
        this.handler = handler;
    }

    public Environmental createEnvironmentalObject(String data) {
        return handler.createEnvironmentalObject(data);

    }

    public Inertial createInertialObject(String data) {
        return handler.createInertialObject(data);
    }

    public Config createConfigurationObject(String data){
        return handler.createConfigurationObject(data);
    }
}
