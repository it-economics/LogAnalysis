package hello.order;

import hello.order.data.Item;
import hello.order.data.User;
import hello.order.service.OrderService;
import hello.order.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchasingOrderService {

    protected static final Logger log = LoggerFactory.getLogger(PurchasingOrderService.class);

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected UserService userService;

    public static Logger getLog() {
        return log;
    }

    public void purchaseOrder() {
        try {
            // Order for John Doe
            User johnDoe = createUser("JohnDoe", "John", "Doe");
            getUserService().saveUser(johnDoe);

            try {
                // Throws UserName exists exception
                createUser("JohnDoe", "John", "Doe");
                getUserService().saveUser(johnDoe);
            } catch (Exception e) {
                getLog().error("Error in order task", e);
            }

            try {
                // Throws validation exception
                User maxMustermann = createUser("MaxMustermann", null, null);
                getUserService().saveUser(maxMustermann);
            } catch (Exception e) {
                getLog().error("Error in order task", e);
            }

            // Order for Max Mustermann
            User maxMustermann = createUser("MaxMustermann", "Max", "Mustermann");
            getUserService().saveUser(maxMustermann);

            int johnDoesOrder = getOrderService().createNewOrder(johnDoe);
            getOrderService().addItemToOrder(johnDoesOrder, johnDoe, new Item(1, "Item1"));
            getOrderService().addItemToOrder(johnDoesOrder, johnDoe, new Item(2, "Item2"));
            getOrderService().purchaseOrder(johnDoesOrder, johnDoe);

            int maxMustermannOrder = getOrderService().createNewOrder(johnDoe);
            getOrderService().addItemToOrder(maxMustermannOrder, johnDoe, new Item(1, "Item1"));
            getOrderService().purchaseOrder(maxMustermannOrder, maxMustermann);

        } catch (Exception e) {
            getLog().error("Error in order task", e);
        }

        getUserService().clearUsers();
        getOrderService().clearOrders();
    }

    protected User createUser(String userName, String name, String lastName) {
        User user = getUserService().createNewUser(userName);
        user.setName(name);
        user.setLastName(lastName);
        return user;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
