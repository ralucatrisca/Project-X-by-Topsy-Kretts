package services;

import interfaces.services.ILog;
import interfaces.services.ILogService;

/**
 * Created by POF4CLJ on 01.08.2016.
 */
public class LogService implements ILogService {

    private ILog log;

    public void debug(String message){
        log.debug(message);
    }

    public void error(String message, Exception e){
        log.error(message, e);
    }

    public void info(String message){
        log.info(message);
    }

    public ILog getLog() {
        return log;
    }

    public void setLog(ILog log) {
        this.log = log;
    }
}
