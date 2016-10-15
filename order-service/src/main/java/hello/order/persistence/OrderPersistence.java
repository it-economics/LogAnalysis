package hello.order.persistence;

import hello.order.data.Order;
import hello.order.exception.PersistenceException;
import hello.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderPersistence {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static final List<Order> orders = new ArrayList<>();

    public void persist(Order order) {
        log.info("Persisting {}", order);

        if(order.getId()%5 == 0) {
            throw new PersistenceException("Unable to persist order %s" + order.getId());
        }

        orders.add(order);

        log.info("{} persisted", order);
    }

    public Order getOrderById(int orderId) {
        return orders.stream().filter(order -> order.getId() == orderId).findFirst().orElse(null);
    }

    public void clear() {
        orders.clear();
    }
}
