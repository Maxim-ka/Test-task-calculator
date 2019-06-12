
public class RomanNumerals {

    private static final int BASE = 10;
    private static final String ABSENCE_OF = "";
    private boolean isNegativeNumber;

    public String determineRomanNumber(int result){
        if (result == 0) return String.valueOf(0);
        isNegativeNumber = result < 0;
        return checkForNegativeNumber(divideNumber(Math.abs(result)));
    }

    private String divideNumber(int result){
        int numeral = result % BASE;
        int decade = ((numeral != 0)) ? result -  numeral : result;
        return  checkNum(decade) + checkNum(numeral);
    }

    private String checkForNegativeNumber(String romanNumber){
        if (isNegativeNumber) return Calculator.MINUS + romanNumber;
        return romanNumber;
    }

    private String checkNum(int result) {
        if (result == 0) return ABSENCE_OF;
        for (int i = 0; i < Num.values().length; i++) {
            if (result == Num.values()[i].getNumber()) return Num.values()[i].getRomanNumber();
        }
        return ABSENCE_OF;
    }
}
