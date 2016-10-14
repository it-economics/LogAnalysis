package hello.order.persistence;

import hello.order.data.Order;
import hello.order.exception.PersistenceException;
import hello.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistence {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void persist(Order order) {
        log.info("Persisting order {}", order.getId());

        if(order.getId()%5 == 0) {
            throw new PersistenceException("Unable to persist order " + order.getId());
        }

        log.info("Order {} persisted", order.getId());
    }
}
