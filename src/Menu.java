import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Controller controller = new Controller(new Scanner(System.in));
        while (controller.getScanner().hasNext())
            controller.handleInput(controller.getScanner().nextLine());
    }

}
