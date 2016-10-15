package hello.order;

import hello.order.scheduler.OrderTaskScheduler;
import hello.order.service.UserService;
import hello.order.service.OrderService;
import hello.order.task.OrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        scheduler.executeOrderTask(orderTask, 30000);
    }

    public void cancelOrderTasks() {
        scheduler.cancelOrderTask();
    }
}
