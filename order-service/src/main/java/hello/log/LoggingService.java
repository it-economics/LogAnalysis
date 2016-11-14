package hello.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggingService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void logInfo() {
        log.info("Info");
    }

    public void logWarn() {
        log.warn("Warning");
    }

    public void logError() {
        try {
            doSomething();
        } catch (Exception e) {
            log.error("Exception occured", e);
        }
    }

    private void doSomething() {
        throw new RuntimeException("Can't do something");
    }
}
