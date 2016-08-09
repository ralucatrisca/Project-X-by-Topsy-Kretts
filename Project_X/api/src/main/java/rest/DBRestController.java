package rest;

import entities.Inertial;
import format.json.JSONDataFormatter;
import interfaces.services.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by POF4CLJ on 21.07.2016.
 */
@RestController
@RequestMapping(value = "/home")
public class DBRestController extends BaseController {

    private enum Sensor {
        Environmental, Inertial, Configuration
    }

    private IEnvironmentalService env;

    private IServiceInertial inertial;

    private IConfigurationService config;

    private IJsonService handler;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setHomePage() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/uploadFileForm.html", method = RequestMethod.GET)
    public ModelAndView getUploadForm() {
        return new ModelAndView("submission");
    }

    @RequestMapping(value = "/view-data.html", method = RequestMethod.GET)
    public ModelAndView getView() {

        return new ModelAndView("view-data");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getThat() {

        Collection<Inertial> col = inertial.getData();
        Iterator it = col.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String csv = "Categories,Ax,Ay,Az,Gx,Gy,Gz,Mx,My,Mz\n";
        while (it.hasNext()) {
            Inertial e = (Inertial) it.next();
            if (inertial.timeDifference(e) <= 60) {
                csv += sdf.format(e.getTime().getTime()) + ",";
                csv += e.getAx() + ",";
                csv += e.getAy() + ",";
                csv += e.getAz() + ",";
                csv += e.getGx() + ",";
                csv += e.getGy() + ",";
                csv += e.getGz() + ",";
                csv += e.getMx() + ",";
                csv += e.getMy() + ",";
                csv += e.getMz() + "\n";
            }
        }
        System.out.println(csv);
        return csv;
    }


    @RequestMapping(value = "/submitUploadFileForm.html", method = RequestMethod.POST)
    public ModelAndView submitUploadFileForm(@RequestParam("data") String data) {
        log.info("Parsing data...");
        String type = null;
        String[] result = null;
        JSONDataFormatter ds = new JSONDataFormatter();
        try {
            result = ds.convertToType(data);
        } catch (Exception e) {
            log.error("ERROR! Invalid Json format!", e);
            return new ModelAndView("fail");
        }
        for (final String jsonRow : result) {
            try {
                JSONObject obj = new JSONObject(jsonRow);
                type = obj.getString("type");
            } catch (JSONException e) {
                log.error("ERROR! The given Json does not have a type!", e);
                e.printStackTrace();
                return new ModelAndView("fail");
            }
            Sensor sensor = Sensor.valueOf(type);

            switch (sensor) {
                case Environmental:
                    try {
                        env.storeEntity(handler.createEnvironmentalObject(jsonRow));
                    } catch (Exception e) {
                        log.error("Failure sending data!", e);
                        e.printStackTrace();
                        return new ModelAndView("fail");
                    }
                    break;
                case Inertial:
                    try {
                        inertial.storeEntity(handler.createInertialObject(jsonRow));
                    } catch (Exception e) {
                        log.error("Failure sending data!", e);
                        e.printStackTrace();
                        return new ModelAndView("fail");
                    }
                    break;
                case Configuration:
                    try {
                        config.storeEntity(handler.createConfigurationObject(jsonRow));
                    } catch (Exception e) {
                        log.error("Failure sending data!", e);
                        e.printStackTrace();
                        return new ModelAndView("fail");
                    }
                    break;
                default:
                    return new ModelAndView("fail");
            }
        }

        ModelAndView model = new ModelAndView("response");
        model.addObject("msg", "SUCCESS! Data sent!");
        log.info("Data successfully sent!");
        return model;
    }

    @Autowired
    public void setEnv(IEnvironmentalService env) {
        this.env = env;
    }

    @Autowired
    public void setInertial(IServiceInertial inertial) {
        this.inertial = inertial;
    }

    @Autowired
    public void setConfig(IConfigurationService config) {
        this.config = config;
    }

    @Autowired
    public void setHandler(IJsonService handler) {
        this.handler = handler;
    }

}

