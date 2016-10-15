package hello.order.service;

import hello.order.data.User;
import hello.order.exception.UserServiceException;
import hello.order.exception.PersistenceException;
import hello.order.exception.ValidationException;
import hello.order.persistence.UserPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private static int ID_COUNTER = 0;

    @Autowired
    private UserPersistence userPersistence;

    public User createNewUser(String userName) {
        log.info("Create new user with userName {}", userName);

        User user = userPersistence.getUserByUserName(userName);
        if(user != null) {
            throw new UserServiceException("Username %s already exists", userName);
        }

        user = new User(++ID_COUNTER, userName);
        log.info("{} created", user);
        return user;
    }

    public void saveUser(User user) {
        log.info("Save {}", user);
        try {
            validateUser(user);
            userPersistence.persist(user);
        }
        catch (ValidationException | PersistenceException e) {
            throw new UserServiceException(e);
        }
    }

    public User getCustomer(int id) {
        log.info("Get customer with id {}", id);

        User customer = userPersistence.getCustomerById(id);
        if(customer == null) {
            log.warn("No user found for id {}", id);
        }

        return customer;
    }

    private void validateUser(User user) {
        if(user.getName() == null) {
            throw new ValidationException("Name is empty");
        }
        if(user.getLastName() == null) {
            throw new ValidationException("LastName is empty");
        }
    }

    public void clearUsers() {
        userPersistence.clear();
    }
}
