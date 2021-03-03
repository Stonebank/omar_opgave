import movie.Action;
import movie.Comedy;
import movie.DVD;

import java.util.*;

public class Controller {

    private final ArrayList<DVD> movie = new ArrayList<>();

    private final Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;

        System.out.println("--- MENU ---");
        printMenu(false);

    }

    public void handleInput(String option) {
        switch (option) {
            case "1":
                System.out.println("What type would you like to create? Choose between 'Action', 'War' and 'Comedy");
                createFilm(scanner.nextLine().toLowerCase());
                break;
            case "2":
                sortList();
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
            case "exit":
                System.exit(0);
                break;
            default:
               printMenu(true);
        }
    }

    private void printMenu(boolean errorMessage) {

        if (errorMessage)
            System.err.println("Could not register input");

        System.out.println("Press 1 to create a film");
        System.out.println("Press 2 to list all films alphabetically");
        System.out.println("Press 3 to list all films of a subgenre");
        System.out.println("Press 4 to delete a film");
        System.out.println("Press 5 to search for a film by title");
        System.out.println("Type 'exit' to close the menu and exit the program.");
    }


    private void createFilm(String input) {
        switch (input) {
            case "action":
                System.out.println("Enter title of the movie:");
                String title = scanner.nextLine();

                System.out.println("Enter subgenre:");
                String subgenre = scanner.nextLine();

                System.out.println("Enter the duration:");
                String duration = scanner.nextLine();

                System.out.println("Enter the main characters (use comma if there are more);");
                String[] mainCharacters = scanner.nextLine().split(",");

                movie.add(new Action(title, subgenre, duration, mainCharacters));
                break;
            case "war":
                break;
            case "comedy":
                break;
            default:
                printMenu(true);
        }
    }

    private void sortList() {
        movie.sort((o1, o2) -> o1.title().compareToIgnoreCase(o2.title()));
        movie.forEach(movie -> System.out.println(movie.title()));
        System.out.println("---The movies has been sorted alphabetically---");
        printMenu(false);
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
