public class Calculator {

    private static final String OUTPUT = "Output: %d\n";

    public void add(int number1, int number2){
        System.out.printf(OUTPUT, number1 + number2);
    }

    public void deduct(int number1, int number2){
        System.out.printf(OUTPUT, number1 - number2);
    }

    public void multiply(int number1, int number2){
        System.out.printf(OUTPUT, number1 * number2);
    }

    public void toDivide(int number1, int number2){
        System.out.printf(OUTPUT, number1 / number2);
    }
}
