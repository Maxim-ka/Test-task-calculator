
public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        while (true){
            try {
                console.listenToInput();
            } catch (ConsoleException e) {
                e.printStackTrace();
                System.exit(ConsoleException.STATUS_ERR);
            }
        }
    }
}
