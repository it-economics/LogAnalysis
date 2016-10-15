package hello.order.exception;

public class UserServiceException extends RuntimeException {

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Object arg) {
        super(String.format(message, arg));
    }

    public UserServiceException(Exception e) {
        super(e);
    }
}
