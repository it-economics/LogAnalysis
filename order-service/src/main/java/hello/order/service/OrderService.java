package hello.order.service;

import hello.order.data.Item;
import hello.order.data.User;
import hello.order.data.Order;
import hello.order.exception.OrderServiceException;
import hello.order.persistence.OrderPersistence;
import hello.order.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static int ID_COUNTER = 0;

    private static final List<Order> orders = new ArrayList<>();

    @Autowired
    private OrderPersistence orderPersistence;

    public int createNewOrder(User user) {
        log.info("Creating order for user {}", user);
        Order order = new Order(++ID_COUNTER, user);
        orderPersistence.persist(order);
        log.info("New order {} created", order);
        return order.getId();
    }

    public void addItemToOrder(int orderId, User user, Item item) {
        Order order = getOrder(orderId);
        log.info("Add {} to order {}", item, order);

        order.getItems().add(item);
        log.info("{} has added {} to {}", user, item, order);

        orderPersistence.persist(order);
    }

    public void purchaseOrder(int orderId, User user) {
        log.info("{} purchases order {}", user, orderId);

        Order order = getOrder(orderId);
        try {
            validateOrder(order);

            orderPersistence.persist(order);

            log.info("{} successfully purchased {}", user, order);
        } catch (Exception e) {
            log.error("Exception occurred while purchasing {}", order, e);
            throw new OrderServiceException("%s could not be purchased", order, e);
        }
    }

    private Order getOrder(int orderId) {
        Order order = orderPersistence.getOrderById(orderId);
        if(order == null) {
            throw new OrderServiceException("Order {} does not exist", orderId);
        }
        return order;
    }

    private void validateOrder(Order order) {

        if(order.getId()%3 == 0) {
            throw new ValidationException("Invalid order %s", order);
        }
    }

    public void clearOrders() {
        orderPersistence.clear();
    }
}
