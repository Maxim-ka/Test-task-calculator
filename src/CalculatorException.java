public class CalculatorException extends Exception {

    private String message;

    public CalculatorException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
