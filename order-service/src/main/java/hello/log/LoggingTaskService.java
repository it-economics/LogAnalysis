package hello.log;

import hello.log.scheduler.LogTaskScheduler;
import hello.log.task.LogExceptionTask;
import hello.log.task.LogInfoTask;
import hello.log.task.LogTask;
import hello.log.task.LogWarningTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggingTaskService {

    @Autowired
    private LogTaskScheduler logTaskScheduler;

    public void scheduleLogTasks() {
        LogTask exceptionTask = new LogExceptionTask();
        logTaskScheduler.executeTask(exceptionTask, 10000);

        LogTask infoTask = new LogInfoTask();
        logTaskScheduler.executeTask(infoTask, 5000);

        LogTask warningTask = new LogWarningTask();
        logTaskScheduler.executeTask(warningTask, 9000);
    }

    public void cancelLogTasks() {
        logTaskScheduler.cancelTask();
    }
}
