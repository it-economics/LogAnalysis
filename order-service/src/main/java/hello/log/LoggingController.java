package hello.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    @RequestMapping("/info")
    public String info() {
        loggingService.logInfo();
        return "Logging info";
    }

    @RequestMapping("/error")
    public String error() {
        loggingService.logError();
        return "Logging error";
    }

    @RequestMapping("/warn")
    public String warn() {
        loggingService.logWarn();
        return "Logging warning";
    }
}
