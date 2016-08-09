package implementations;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import interfaces.services.IJsonHandler;

import java.io.IOException;

/**
 * Created by POF4CLJ on 26.07.2016.
 */
public class JsonHandler implements IJsonHandler {

    public Environmental createEnvironmentalObject(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Environmental p = null;
        try {
            p = mapper.readValue(data, Environmental.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public Inertial createInertialObject(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Inertial p = null;
        try {
            p = mapper.readValue(data, Inertial.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public Config createConfigurationObject(String data) {
        ObjectMapper mapper = new ObjectMapper();
        Config p = null;
        try {
            p = mapper.readValue(data, Config.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}
