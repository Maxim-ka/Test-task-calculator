
public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        do{
            try {
                console.listenToInput();
            } catch (CalculatorException e) {
                e.printStackTrace();
                System.exit(-888);
            }
        }while (console.isExit());
    }
}
