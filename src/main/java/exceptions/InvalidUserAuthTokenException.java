package exceptions;

public class InvalidUserAuthTokenException extends RuntimeException {

    public InvalidUserAuthTokenException(String message) {
        super(message);
    }
}
