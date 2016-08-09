package implementations;


import interfaces.services.ILog;
import org.apache.log4j.Logger;

/**
 * Created by POF4CLJ on 01.08.2016.
 */
public class Log implements ILog {

    final static Logger logger = Logger.getLogger(Log.class);

    public void debug(String message){
        this.logger.debug(message);
    }

    public void error(String message, Exception e){
        this.logger.error(message,e);
    }

    public void info(String message){
        this.logger.info(message);
    }

}
