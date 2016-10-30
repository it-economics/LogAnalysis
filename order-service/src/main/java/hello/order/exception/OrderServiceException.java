package hello.order.exception;

import hello.order.data.Order;

public class OrderServiceException extends RuntimeException {

    public OrderServiceException(String error) {
        super(error);
    }

    public OrderServiceException(String error, Object order) {
        super(String.format(error, order));
    }

    public OrderServiceException(String error, Order order, Exception e) {
        super(String.format(error,order), e);
    }
}
