package hello.order;

import hello.order.scheduler.OrderTaskScheduler;
import hello.order.service.UserService;
import hello.order.service.OrderService;
import hello.order.task.OrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OrderPurchaseService {

    @Autowired
    private OrderTaskScheduler scheduler;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService customerService;

    public void scheduleOrderTasks() {
        OrderTask orderTask = new OrderTask(orderService, customerService);
        List<Long> periods = Arrays.asList(30000L, 12000L, 3000L, 6000L, 1000L, 9000L);
        scheduler.executeOrderTask(orderTask, periods);
    }

    public void cancelOrderTasks() {
        scheduler.cancelOrderTask();
    }
}
