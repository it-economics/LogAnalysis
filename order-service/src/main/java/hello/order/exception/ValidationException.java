package hello.order.exception;

import hello.order.data.Order;

public class ValidationException extends RuntimeException {

    public ValidationException(String error) {
        super(error);
    }

    public ValidationException(String error, Order order) {
        super(String.format(error, order));
    }
}
