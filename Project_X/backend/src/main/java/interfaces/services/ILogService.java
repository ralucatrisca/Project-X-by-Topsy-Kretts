package interfaces.services;

/**
 * Created by POF4CLJ on 01.08.2016.
 */
public interface ILogService {

    public void debug(String message);

    public void error(String message, Exception e);

    public void info(String message);

}
