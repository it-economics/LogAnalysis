package hello.order.scheduler;

import hello.order.task.OrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

@Service
public class OrderTaskScheduler {

    @Autowired
    private TaskScheduler scheduler;

    private List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();

    @Async
    public void executeOrderTask(OrderTask orderTask, long period) {
        ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(orderTask,period);
        scheduledFutures.add(future);
    };

    public void cancelOrderTask() {
        scheduledFutures.forEach(future->future.cancel(false));
    }
}
