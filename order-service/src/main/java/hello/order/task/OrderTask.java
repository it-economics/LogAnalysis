package hello.order.task;

import hello.order.data.Item;
import hello.order.data.User;
import hello.order.data.Order;
import hello.order.service.UserService;
import hello.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(OrderTask.class);

    private OrderService orderService;

    private UserService userService;

    public OrderTask(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @Override
    public void run() {
        try {
            // Order for John Doe
            User johnDoe = createUser("JohnDoe", "John", "Doe");
            userService.saveUser(johnDoe);

            try {
                // Throws UserName exists exception
                createUser("JohnDoe", "John", "Doe");
                userService.saveUser(johnDoe);
            } catch (Exception e) {
                log.error("Error in order task", e);
            }

            try {
                // Throws validation exception
                User maxMustermann = createUser("MaxMustermann", null, null);
                userService.saveUser(maxMustermann);
            }  catch (Exception e) {
                log.error("Error in order task", e);
            }

            // Order for Max Mustermann
            User maxMustermann = createUser("MaxMustermann", "Max", "Mustermann");
            userService.saveUser(maxMustermann);

            int johnDoesOrder = orderService.createNewOrder(johnDoe);
            orderService.addItemToOrder(johnDoesOrder, johnDoe, new Item(1, "Item1"));
            orderService.addItemToOrder(johnDoesOrder, johnDoe, new Item(2, "Item2"));
            orderService.purchaseOrder(johnDoesOrder, johnDoe);

            int maxMustermannOrder = orderService.createNewOrder(johnDoe);
            orderService.addItemToOrder(maxMustermannOrder, johnDoe, new Item(1, "Item1"));
            orderService.purchaseOrder(maxMustermannOrder, maxMustermann);

        } catch (Exception e) {
            log.error("Error in order task", e);
        }

        userService.clearUsers();
        orderService.clearOrders();
    }

    private User createUser(String userName, String name, String lastName) {
        User user = userService.createNewUser(userName);
        user.setName(name);
        user.setLastName(lastName);
        return user;
    }
}
