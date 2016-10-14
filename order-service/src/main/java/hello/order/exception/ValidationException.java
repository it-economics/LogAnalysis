package hello.order.exception;

/**
 * Created by fdorau on 14.10.2016.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String error) {
        super(error);
    }
}
