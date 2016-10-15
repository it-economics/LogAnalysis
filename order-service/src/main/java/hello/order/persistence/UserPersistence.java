package hello.order.persistence;

import hello.order.data.User;
import hello.order.exception.PersistenceException;
import hello.order.exception.UserServiceException;
import hello.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserPersistence {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private static final List<User> persistedUsers = new ArrayList<>();


    public void persist(User user) {
        log.info("Persisting {}", user);

        if(persistedUsers.contains(user)) {
            throw new PersistenceException("%s already exists", user);
        }

        persistedUsers.add(user);

        log.info("{} successfully persisted", user);
    }

    public User getCustomerById(int id) {
        Optional<User> customer = persistedUsers.stream().filter(c -> c.getId() == id).findFirst();
        return customer.orElse(null);
    }

    public User getUserByUserName(String userName) {
        Optional<User> user = persistedUsers.stream().filter(c -> c.getUserName().equals(userName)).findFirst();
        return user.orElse(null);
    }

    public void clear() {
        persistedUsers.clear();
    }
}
