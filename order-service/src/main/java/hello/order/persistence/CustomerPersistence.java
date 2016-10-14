package hello.order.persistence;

import hello.order.data.Customer;
import hello.order.exception.PersistenceException;
import hello.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerPersistence {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static final List<Customer> persistedCustomers = new ArrayList<>();

    public void persist(Customer customer) {
        log.info("Persisting customer");

        if(persistedCustomers.contains(customer)) {
            throw new PersistenceException("Customer %s already exists", customer);
        }

        persistedCustomers.add(customer);

        log.info("Customer {} persisted", customer.getId());
    }

    public Customer getCustomerById(int id) {
        log.info("Get customer by id {}", id);
       Optional<Customer> customer = persistedCustomers.stream().filter(c -> c.getId() == id).findFirst();
        return customer.orElse(null);
    }
}
