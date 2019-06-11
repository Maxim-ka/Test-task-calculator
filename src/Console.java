import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {

    private enum NUM{
        ONE(1,"I"), TWO(2, "II"), THREE(3, "III"), FOUR(4,"IV"), FIVE(5, "V"),
        SIX(6, "VI"), SEVEN(7, "VII"), EIGHT(8, "VIII"), NINE(9, "IX"), TEN(10, "X");

        private int number;
        private String romanNumber;

        NUM(int number, String romanNumber) {
            this.number = number;
            this.romanNumber = romanNumber;
        }
    }

    private final Scanner scanner = new Scanner(System.in);
    private final String template= "^(\\d{1,2}|\\w{1,4})\\s+(\\+?|\\*?|-?|/?)\\s+(\\d{1,2}|\\w{1,4})$";
    private int firstNumber;
    private int secondNumber;
    private boolean exit;

    public boolean isExit() {
        return !exit;
    }

    public void listenToInput() throws CalculatorException {
        System.out.println("exit push Q");
        String string = scanner.nextLine().trim();
        if (checkOut(string)) toFinishWork(null);
        if (!checkInput(string)) toFinishWork("wrong input");
        String[] strings = split(string);
        firstNumber = checkNumber(strings[0]);      ;
        secondNumber = checkNumber(strings[2]);
        if (firstNumber == -1 && secondNumber == -1) {
            firstNumber = determineNumber(strings[0]);
            secondNumber = determineNumber(strings[2]);
        } else if (firstNumber < 0 || secondNumber < 0) toFinishWork(String.format("different number format: %s and %s", strings[0], strings[2]));
        performAction(strings[1]);
    }

    private boolean checkOut(String string){
        return string.equals("q") || string.equals("Q");
    }

    private void performAction(String string) throws CalculatorException {
        Calculator calculator = new Calculator();
        switch (string){
            case "+":
                calculator.add(firstNumber, secondNumber);
                break;
            case "-":
                calculator.deduct(firstNumber, secondNumber);
                break;
            case "*":
                calculator.multiply(firstNumber, secondNumber);
                break;
            case "/":
                calculator.toDivide(firstNumber, secondNumber);
                break;
            default:
                toFinishWork(String.format("unknown action: %s", string));
        }
    }

    private int checkNumber(String string) throws CalculatorException {
        int num;
        try {
            num = Integer.parseInt(string);
            if (num < 1 || num > 10) toFinishWork(String.format("%d - out of range", num));;
        }catch (NumberFormatException e){
            return -1;
        }
        return num;
    }

    private int determineNumber(String string) throws CalculatorException {
        for (int i = 0; i < NUM.values().length; i++) {
            if (string.equals(NUM.values()[i].romanNumber)) return NUM.values()[i].number;
        }
        toFinishWork(String.format("incorrect input: %s", string));
        return 0;
    }

    private String[] split(String string){
        return string.split("\\s+");
    }

    private boolean checkInput(String string){
        return Pattern.matches(template, string);
    }

    private void toFinishWork(String error) throws CalculatorException {
        scanner.close();
        if (error != null){
            throw new CalculatorException(error);
        }
        System.exit(0);
    }
}
