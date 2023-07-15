import java.util.List;
import java.util.Scanner;

public class Menu {
    private Stopwatch stopwatch;
    private long elapsedTime;

    public Menu(Stopwatch stopwatch) {
        // Initialize the Menu with a Stopwatch instance
        this.stopwatch = stopwatch;
        elapsedTime = 0;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    stopwatch.start();
                    break;
                case 2:
                    stopwatch.stop();
                    break;
                case 3:
                    stopwatch.split();
                    break;
                case 4:
                    saveHistoryToFile();
                    break;
                case 5:
                    loadHistoryFromFile();
                    break;
                case 6:
                    displayHistory();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
    public void updateElapsedTime(long elapsedTime) {
        // Update the elapsed time in the Menu
        this.elapsedTime = elapsedTime;
    }
    private void displayMenu() {
    System.out.println("Menu:");
    System.out.println("1. Start");
    System.out.println("2. Stop");
    System.out.println("3. Split");
    System.out.println("4. Save history to file");
    System.out.println("5. Load history from file");
    System.out.println("6. Display history");
    System.out.println("7. Exit");
    System.out.println("Elapsed Time: " + (elapsedTime / 1000) + " seconds");

    // Display the split times
    List<Long> splits = stopwatch.getSplits();
    if (!splits.isEmpty()) {
        System.out.println("Split Times:");
        for (int i = 0; i < splits.size(); i++) {
            System.out.println("Split " + (i + 1) + ": " + (splits.get(i) / 1000) + " seconds");
        }
    }
    }
    private void saveHistoryToFile() {
        // Code to save the history to a file
        System.out.println("History saved to file.");
    }
    private void loadHistoryFromFile() {
        // Code to load the history from a file
        System.out.println("History loaded from file.");
    }
    private void displayHistory() {
        // Code to display the history of the stopwatch
        System.out.println("History:");
    }
}