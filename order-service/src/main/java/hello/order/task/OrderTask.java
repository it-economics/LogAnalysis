package hello.order.task;

import hello.order.data.Customer;
import hello.order.data.Order;
import hello.order.service.CustomerService;
import hello.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(OrderTask.class);

    private OrderService orderService;

    private CustomerService customerService;

    private final static Customer customer = new Customer(1, "John", "Doe");

    public OrderTask(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @Override
    public void run() {
        try {
            Order johnDoesOrder = orderService.createOrder(customer);
            orderService.saveOrder(johnDoesOrder);
        } catch (Exception e) {
            log.error("Error in order task", e);
        }
    }
}
