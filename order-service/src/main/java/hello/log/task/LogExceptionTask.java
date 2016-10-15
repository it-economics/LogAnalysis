package hello.log.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogExceptionTask implements LogTask {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        try {
            doSomething();
        } catch(Exception e) {
            log.error("Exception occured", e);
        }
    }

    private void doSomething() {
        throw new RuntimeException("Can't do something");
    }
}
