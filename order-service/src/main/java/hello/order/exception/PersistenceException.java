package hello.order.exception;

public class PersistenceException extends RuntimeException {

    public PersistenceException(String error) {
        super(error);
    }

    public PersistenceException(String error, Object arg) {
        super(String.format(error, arg));
    }
}
