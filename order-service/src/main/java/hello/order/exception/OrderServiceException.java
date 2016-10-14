package hello.order.exception;

public class OrderServiceException extends RuntimeException {

    public OrderServiceException(String error) {
        super(error);
    }

    public OrderServiceException(String error, Object arg) {
        super(String.format(error,arg));
    }
}
