package hello.order.service;

import hello.order.data.Customer;
import hello.order.data.Order;
import hello.order.exception.OrderServiceException;
import hello.order.persistence.OrderPersistence;
import hello.order.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static int ID_COUNTER = 0;

    @Autowired
    private OrderPersistence orderPersistence;

    public Order createOrder(Customer customer) {
        log.info("Creating new order for customer {}", customer);

        Order order = new Order();
        order.setId(++ID_COUNTER);
        order.setCustomer(customer);

        log.info("New order with id {} created", order.getId());
        return order;
    }

    public void saveOrder(Order order) {
        log.info("Save order with id {}", order.getId());

        try {
            validateOrder(order);

            orderPersistence.persist(order);

            log.info("Order {} successfully saved", order.getId());

        } catch (Exception e) {
            log.error("Exception occurred while saving order {}", order.getId(), e);
            throw new OrderServiceException("Order %s could not be saved", order.getId());
        }
    }

    private void validateOrder(Order order) {
        if(order.getId()%3 == 0) {
            throw new ValidationException("Invalid order id");
        }
    }
}
