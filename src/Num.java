public enum Num {

    ONE(1,"I"), TWO(2, "II"), THREE(3, "III"), FOUR(4,"IV"),
    FIVE(5, "V"), SIX(6, "VI"), SEVEN(7, "VII"), EIGHT(8, "VIII"),
    NINE(9, "IX"), TEN(10, "X"), TWENTY(20, "XX"), THIRTY(30, "XXX"),
    FORTY(40, "XL"), FIFTY(50, "L"), SIXTY(60, "LX"), SEVENTY(70, "LXX"),
    EIGHTY(80, "LXXX"), NINETY(90, "XC"), HUNDRED(100, "C");

    private int number;
    private String romanNumber;

    public int getNumber() {
        return number;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    Num(int number, String romanNumber) {
        this.number = number;
        this.romanNumber = romanNumber;
    }
}
