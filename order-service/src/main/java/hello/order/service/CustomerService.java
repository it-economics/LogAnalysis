package hello.order.service;

import hello.order.data.Customer;
import hello.order.exception.CustomerServiceException;
import hello.order.exception.PersistenceException;
import hello.order.persistence.CustomerPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private static int ID_COUNTER = 0;

    @Autowired
    private CustomerPersistence customerPersistence;

    public Customer createCustomer(String name, String lastName) {
        log.info("Create new customer");

        Customer customer = new Customer(++ID_COUNTER, name, lastName);

        log.info("Customer {} created", customer.getId());

        try {
            customerPersistence.persist(customer);
        } catch (PersistenceException e) {
            log.error("Error persisting new customer", e);
            throw new CustomerServiceException("Customer could not be created");
        }

        return customer;
    }

    public Customer getCustomer(int id) {
        log.info("Get customer with id {}", id);

        Customer customer = customerPersistence.getCustomerById(id);

        if(customer == null) {
            log.warn("No customer with id {} not found", id);
        }

        return customer;
    }
}
