import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {

    private static final String PATTERN_SPACE = "\\s+";
    private static final String INPUT_TEMPLATE = "^(\\w{1,4})\\s+(\\+?|\\*?|-?|/?)\\s+(\\w{1,4})$";
    private static final String EXIT_PUSH_Q = "exit push Q";
    private static final String INPUT = "Input: ";
    private static final String OUTPUT_NUMBERS = "Output: %d\n";
    private static final String OUTPUT_ROMAN_NUMBERS = "Output: %s\n";
    private static final String Q = "Q";
    private static final String EXIT = "Exit";
    private static final int COMPLETION_OF_WORK = 0;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 10;
    private static final int NOT_NUMBER = -1;

    private final Scanner scanner = new Scanner(System.in);
    private final Calculator calculator = new Calculator();
    private final RomanNumerals romanNumerals = new RomanNumerals();
    private int firstNumber;
    private int secondNumber;

    public void listenToInput() throws ConsoleException {
        boolean isArabicNumber = true;
        System.out.println(EXIT_PUSH_Q);
        System.out.print(INPUT);
        String string = scanner.nextLine().trim();
        if (checkOut(string)) toFinishWork(null);
        if (!checkInput(string)) toFinishWork(ConsoleException.ERROR_WRONG_INPUT);
        String[] strings = split(string);
        firstNumber = checkNumber(strings[0]);      ;
        secondNumber = checkNumber(strings[2]);
        if (firstNumber == NOT_NUMBER && secondNumber == NOT_NUMBER) {
            firstNumber = determineNumber(strings[0]);
            secondNumber = determineNumber(strings[2]);
            isArabicNumber = false;
        } else if (firstNumber < 0 || secondNumber < 0) toFinishWork(String.format(ConsoleException.ERROR_DIFFERENT_NUMBER_FORMAT, strings[0], strings[2]));
        performAction(strings[1], isArabicNumber);
    }

    private boolean checkOut(String string){
        return string.toUpperCase().equals(Q);
    }

    private void performAction(String string, boolean isArabicNumber) throws ConsoleException {
        int result = 0;
        switch (string){
            case Calculator.PLUS:
                result = calculator.add(firstNumber, secondNumber);
                break;
            case Calculator.MINUS:
                result = calculator.deduct(firstNumber, secondNumber);
                break;
            case Calculator.MULTIPLICATION:
                result = calculator.multiply(firstNumber, secondNumber);
                break;
            case Calculator.DIVISION:
                result = calculator.toDivide(firstNumber, secondNumber);
                break;
            default:
                toFinishWork(String.format(ConsoleException.ERROR_UNKNOWN_ACTION, string));
        }
        if (isArabicNumber) System.out.printf(OUTPUT_NUMBERS, result);
        else System.out.printf(OUTPUT_ROMAN_NUMBERS, romanNumerals.determineRomanNumber(result));
    }

    private int checkNumber(String string) throws ConsoleException {
        int num;
        try {
            num = Integer.parseInt(string);
            if (num < MINIMUM_NUMBER || num > MAXIMUM_NUMBER) toFinishWork(String.format(ConsoleException.ERROR_OUT_OF_RANGE, num));;
        }catch (NumberFormatException e){
            return NOT_NUMBER;
        }
        return num;
    }

    private int determineNumber(String string) throws ConsoleException {
        for (int i = 0; i < Num.values().length; i++) {
            if (string.equals(Num.values()[i].getRomanNumber()) && Num.values()[i].getNumber() <= MAXIMUM_NUMBER) return Num.values()[i].getNumber();
        }
        toFinishWork(String.format(ConsoleException.ERROR_INCORRECT_INPUT, string));
        return 0;
    }

    private String[] split(String string){
        return string.split(PATTERN_SPACE);
    }

    private boolean checkInput(String string){
        return Pattern.matches(INPUT_TEMPLATE, string);
    }

    private void toFinishWork(String error) throws ConsoleException {
        scanner.close();
        if (error != null){
            throw new ConsoleException(error);
        }
        System.out.println(EXIT);
        System.exit(COMPLETION_OF_WORK);
    }
}
