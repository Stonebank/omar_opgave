import movie.Action;
import movie.Comedy;
import movie.DVD;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private final ArrayList<DVD> movie = new ArrayList<>();

    private final Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;

        System.out.println("--- MENU ---");
        printMenu(false);

        movie.add(new Action("Bad Boys 2", "Action Comedy", "2 hours and 10 minutes", new String[] { "Will Smith" }));
        movie.add(new Comedy("The hangover", "1 hour and 35 minutes", new String[] { "Ken Jeong", "Bradley Cooper", "Ed Helms" }, "Comedy"));

    }

    public void handleInput(String option) {
        switch (option) {
            case "1":
                // TODO
                break;
            case "2":
                // TODO
                break;
            case "3":
                // TODO
                break;
            case "4":
                // TODO
                break;
            case "5":
                System.out.println("Enter the name of the film you want to search:");
                search(scanner.nextLine().toLowerCase());
                break;
            default:
               printMenu(true);
        }
    }

    private void printMenu(boolean errorMessage) {

        if (errorMessage)
            System.err.println("Could not register output");

        System.out.println("Press 1 to create a film");
        System.out.println("Press 2 to list all films alphabetically");
        System.out.println("Press 3 to list all films of a subgenre");
        System.out.println("Press 4 to delete a film");
        System.out.println("Press 5 to search for a film by title");
    }

    private void search(String title) {
        for (DVD dvd : movie) {
            if (!dvd.title().toLowerCase().contains(title))
                continue;
            System.out.println("Movie found: " + dvd.title());
        }
        printMenu(false);
    }

    public Scanner getScanner() {
        return scanner;
    }

}
