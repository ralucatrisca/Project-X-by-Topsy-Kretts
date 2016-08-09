package rest;

import interfaces.services.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by POF4CLJ on 01.08.2016.
 */

@RestController
public abstract class BaseController {

    public ILogService log;

    @Autowired
    public void setLog(ILogService log) {
        this.log = log;
    }
}
