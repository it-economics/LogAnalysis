package hello.log.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogInfoTask implements LogTask {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        log.info("Info");
    }
}