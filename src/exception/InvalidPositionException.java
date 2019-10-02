package exception;

public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException(final String message) {
        super(message);
    }
}
