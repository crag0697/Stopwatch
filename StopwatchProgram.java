public class StopwatchProgram {
    public static void main(String[] args) {
        displayInstructions();

        // Create a Stopwatch instance
        Stopwatch stopwatch = new Stopwatch();

        // Create a Menu instance and pass the Stopwatch
        Menu menu = new Menu(stopwatch);

        // Create a separate thread to update the elapsed time every second
        Thread counterThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // Check if the stopwatch is running
                    if (stopwatch.isRunning()) {
                        // Get the elapsed time and update it in the Menu
                        long elapsedTime = stopwatch.getElapsedTime();
                        menu.updateElapsedTime(elapsedTime);
                    }
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        counterThread.start(); // Start the thread

        // Start the menu and run the program
        menu.run();
    }

    private static void displayInstructions() {
        // Display program instructions
        System.out.println("Stopwatch Program");
        System.out.println("Instructions:");
        System.out.println("1. Start - Start the stopwatch");
        System.out.println("2. Stop - Stop the stopwatch");
        System.out.println("3. Split - Record a split time");
        System.out.println("4. Save history to file");
        System.out.println("5. Load history from file");
        System.out.println("6. Display history");
        System.out.println("7. Exit program");
        System.out.println();
    }
}