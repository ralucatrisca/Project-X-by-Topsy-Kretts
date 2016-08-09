package interfaces.services;

import entities.*;

/**
 * Created by POF4CLJ on 26.07.2016.
 */
public interface IJsonHandler {

    Environmental createEnvironmentalObject(String data);

    Inertial createInertialObject(String data);

    Config createConfigurationObject(String data);

}
