public class Calculator {

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    public int add(int number1, int number2){
        return number1 + number2;
    }

    public int deduct(int number1, int number2){
        return number1 - number2;
    }

    public int multiply(int number1, int number2){
        return number1 * number2;
    }

    public int toDivide(int number1, int number2){
        return number1 / number2;
    }
}
