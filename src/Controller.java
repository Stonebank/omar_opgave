import movie.Action;
import movie.Comedy;
import movie.DVD;
import movie.War;

import java.util.*;

public class Controller {

    private final ArrayList<DVD> movie = new ArrayList<>();

    private final Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;

        // Adding some default movies
        movie.add(new Action("Bad Boys II", "Comedy action", "2 hours 27 minutes", new String[] { "Will Smith", "Michael Eugene" }));
        movie.add(new War("The Hurt Locker", "2 hours 11 minutes", new String[] { "William James" }, "2001", new String[] { "USA", "Iraq" }));
        movie.add(new Comedy("The hangover part 2", "1 hour 42 minutes", new String[] { "name 1", "name 2", "name 3" }, "Comedy/Action/Drink"));

        System.out.println("--- MENU ---");
        printMenu(false);

    }

    public void handleInput(String option) {
        switch (option) {
            case "1":
                System.out.println("What type would you like to create? Choose between 'Action', 'War' and 'Comedy'");
                createFilm(scanner.nextLine().toLowerCase());
                break;
            case "2":
                sortList();
                break;
            case "3":
                printSubGenre(true);
                break;
            case "4":
                if (movie.isEmpty()) {
                    System.err.println("There are no saved movies.");
                    printMenu(false);
                    return;
                }
                System.out.println("Which movie would you like to delete? You have the following movies:");
                printSubGenre(false);
                deleteMovie(scanner.nextLine().toLowerCase());
                break;
            case "5":
                System.out.println("Enter the name of the film you want to search:");
                search(scanner.nextLine().toLowerCase());
                break;
            case "6":
                printMovies();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
               printMenu(true);
        }
    }

    private void printMenu(boolean errorMessage) {

        System.out.println();

        if (errorMessage)
            System.err.println("Could not register input");

        System.out.println("Press 1 to create a film");
        System.out.println("Press 2 to list all films alphabetically");
        System.out.println("Press 3 to list all films of a subgenre");
        System.out.println("Press 4 to delete a film");
        System.out.println("Press 5 to search for a film by title");
        System.out.println("Press 6 to print all movies and information");
        System.out.println("Type 'exit' to close the menu and exit the program.");
    }


    private void createFilm(String input) {
        switch (input) {
            case "action":
                System.out.println("Enter title of the movie:");
                String action_title = scanner.nextLine();

                System.out.println("Enter subgenre:");
                String action_subgenre = scanner.nextLine();

                System.out.println("Enter the duration:");
                String action_duration = scanner.nextLine();

                System.out.println("Enter the main characters (use comma if there are more):");
                String[] action_mainCharacters = scanner.nextLine().split(",");

                movie.add(new Action(action_title, action_subgenre, action_duration, action_mainCharacters));

                System.out.println("Added a new action movie to the list!");
                printMenu(false);
                break;
            case "war":
                System.out.println("Enter title of the movie:");
                String war_title = scanner.nextLine();

                System.out.println("Enter the duration:");
                String war_duration = scanner.nextLine();

                System.out.println("Enter the main characters (use comma if there are more):");
                String[] war_mainCharacters = scanner.nextLine().split(",");

                System.out.println("Enter the time period:");
                String time_period = scanner.nextLine();

                System.out.println("Enter the countries involved (use comma if there are more):");
                String[] countries = scanner.nextLine().split(",");

                movie.add(new War(war_title, war_duration, war_mainCharacters, time_period, countries));

                System.out.println("Added a new war movie to the list!");
                printMenu(false);
                break;
            case "comedy":
                System.out.println("Enter title of the movie:");
                String comedy_title = scanner.nextLine();

                System.out.println("Enter the duration:");
                String comedy_duration = scanner.nextLine();

                System.out.println("Enter the main characters (use comma if there are more):");
                String[] comedy_mainCharacters = scanner.nextLine().split(",");

                System.out.println("Enter the type of comedy:");
                String type = scanner.nextLine();

                movie.add(new Comedy(comedy_title, comedy_duration, comedy_mainCharacters, type));

                System.out.println("Added a new comedy movie to the list!");
                printMenu(false);
                break;
            default:
                printMenu(true);
        }
    }

    private void printSubGenre(boolean printMenu) {
        if (movie.isEmpty()) {
            System.err.println("There are no saved movies.");
            printMenu(false);
            return;
        }

        System.out.println();

        for (DVD dvd : movie) {
            if (dvd instanceof Action)
                System.out.println(dvd.title() + " (ACTION, " + ((Action) dvd).getSubgenre().toUpperCase() + ")");
            if (dvd instanceof War)
                System.out.println(dvd.title() + " (WAR MOVIE)");
            if (dvd instanceof Comedy)
                System.out.println(dvd.title() + " (COMEDY, " + ((Comedy) dvd).getType().toUpperCase() + ")");
        }

        if (printMenu)
            printMenu(false);

    }

    private void sortList() {
        if (movie.isEmpty()) {
            System.err.println("There are no saved movies.");
            printMenu(false);
            return;
        }
        System.out.println();
        movie.sort((o1, o2) -> o1.title().compareToIgnoreCase(o2.title()));
        movie.forEach(movie -> System.out.println(movie.title()));
        System.out.println("---The movies has been sorted alphabetically---");
        printMenu(false);
    }

    private void deleteMovie(String title) {
        if (movie.isEmpty()) {
            System.err.println("There are no saved movies.");
            printMenu(false);
            return;
        }

        for (int i = 0; i < movie.size(); i++) {
            if (!movie.get(i).title().equalsIgnoreCase(title))
                continue;
            System.out.println("Successfully removed the movie title: " + movie.get(i).title());
            movie.remove(i);
            break;
        }

        printMenu(false);

    }

    private void search(String title) {
        int result = 0;
        for (DVD dvd : movie) {
            if (!dvd.title().toLowerCase().contains(title))
                continue;
            System.out.println("Movie found: " + dvd.title());
            result++;
        }
        System.out.println("Found " + result + " title(s) matching your keywords");
        printMenu(false);
    }

    private void printMovies() {
        if (movie.isEmpty()) {
            System.err.println("There are no saved movies.");
            printMenu(false);
            return;
        }
        for (DVD dvd : movie) {
            if (dvd instanceof Action) {
                System.out.println("Title: " + dvd.title());
                System.out.println("Subgenre: " + ((Action) dvd).getSubgenre());
                System.out.println("Duration: " + dvd.duration());
                System.out.println("Main characters: " + Arrays.toString(dvd.mainCharacters()));
                System.out.println();
            }
            if (dvd instanceof War) {
                System.out.println("Title: " + dvd.title());
                System.out.println("Duration: " + dvd.duration());
                System.out.println("Main characters: " + Arrays.toString(dvd.mainCharacters()));
                System.out.println("Time period: " + ((War) dvd).getTimePeriod());
                System.out.println("Countries involved: " + Arrays.toString(((War) dvd).getCountriesInvolved()));
                System.out.println();
            }
            if (dvd instanceof Comedy) {
                System.out.println("Title: " + dvd.title());
                System.out.println("Duration: " + dvd.duration());
                System.out.println("Main characters: " + Arrays.toString(dvd.mainCharacters()));
                System.out.println("Type of comedy: " + ((Comedy) dvd).getType());
                System.out.println();
            }
        }
        printMenu(false);
    }

    public Scanner getScanner() {
        return scanner;
    }

}
