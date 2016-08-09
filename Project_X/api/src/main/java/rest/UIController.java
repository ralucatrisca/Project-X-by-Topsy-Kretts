package rest;

import entities.Config;
import entities.Environmental;
import entities.Inertial;
import interfaces.services.IConfigurationService;
import interfaces.services.IEnvironmentalService;
import interfaces.services.IServiceInertial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by POF4CLJ on 01.08.2016.
 */
@RestController
@RequestMapping(value = "/home")
public class UIController extends BaseController {

    private IEnvironmentalService env;

    private IServiceInertial inertial;

    private IConfigurationService config;


    @RequestMapping(value = "/env",method = RequestMethod.GET)
    public List<Environmental> getEnvironmentalObjects() {
        log.info("Receiving environmental data...");
        Collection<Environmental> environmentals = env.getData();
        Iterator it  = environmentals.iterator();
        List<Environmental> environmentalList = new ArrayList<Environmental>();
        while(it.hasNext()){
            Environmental e = (Environmental) it.next();
            environmentalList.add(e);
            System.out.println(e.getType());
        }

        return environmentalList;
    }

    @RequestMapping(value = "/ine",method = RequestMethod.GET)
    public void getInertialObjects() {
        log.info("Receiving inertial data...");
        Collection<Inertial> inertials = inertial.getData();
        Iterator it  = inertials.iterator();
        while(it.hasNext()){
            Inertial i = (Inertial) it.next();
            System.out.println(i.getAx());
        }
    }

    @RequestMapping(value = "/conf",method = RequestMethod.GET)
    public void getConfigurationObjects() {
        log.info("Receiving configuration data...");
        Collection<Config> configs = config.getData();
        Iterator it  = configs.iterator();
        while(it.hasNext()){
            Config c = (Config) it.next();
            System.out.println(c.getType());
        }
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
}