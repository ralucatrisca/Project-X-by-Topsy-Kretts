package interfaces.services;

import entities.*;

/**
 * Created by POF4CLJ on 26.07.2016.
 */
public interface IJsonService {

    Environmental createEnvironmentalObject(String data);

    Inertial createInertialObject(String data);

    Config createConfigurationObject(String data);

}
