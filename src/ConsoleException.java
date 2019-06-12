public class ConsoleException extends Exception {

    public static final String ERROR_WRONG_INPUT = "wrong input";
    public static final String ERROR_DIFFERENT_NUMBER_FORMAT = "different number format: %s and %s";
    public static final String ERROR_UNKNOWN_ACTION = "unknown action: %s";
    public static final String ERROR_OUT_OF_RANGE = "%d - out of range";
    public static final String ERROR_INCORRECT_INPUT = "incorrect input: %s";
    public static final int STATUS_ERR = -888;


    private String message;

    public ConsoleException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
