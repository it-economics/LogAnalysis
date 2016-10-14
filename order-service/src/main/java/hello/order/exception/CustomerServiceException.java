package hello.order.exception;

public class CustomerServiceException extends RuntimeException {

    public CustomerServiceException(String message) {
        super(message);
    }
}
