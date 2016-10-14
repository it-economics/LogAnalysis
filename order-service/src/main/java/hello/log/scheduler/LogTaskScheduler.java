package hello.log.scheduler;

import hello.log.task.LogTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Component
public class LogTaskScheduler {

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    private List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();

    @Async
    public void executeTask(LogTask logTask, long period) {
        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(logTask, period);

        scheduledFutures.add(future);
    };

    public void cancelTask() {
        scheduledFutures.forEach(future -> future.cancel(false));
    }
}
