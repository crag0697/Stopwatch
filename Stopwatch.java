import java.util.ArrayList;
import java.util.List;

public class Stopwatch {
    private boolean isRunning;
    private long startTime;
    private long stopTime;
    private List<Long> splits;

    public Stopwatch() {
        // Initialize the stopwatch
        isRunning = false;
        splits = new ArrayList<>();
    }

    public void start() {
        // Start the stopwatch if it is not already running
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    public void stop() {
        // Stop the stopwatch if it is currently running
        if (isRunning) {
            stopTime = System.currentTimeMillis();
            isRunning = false;
        }
    }

    public void split() {
        // Record a split time if the stopwatch is running
        if (isRunning) {
            long currentTime = System.currentTimeMillis();
            splits.add(currentTime - startTime);
        }
    }

    public boolean isRunning() {
        // Check if the stopwatch is currently running
        return isRunning;
    }

    public long getStartTime() {
        // Get the start time of the stopwatch
        return startTime;
    }

    public long getStopTime() {
        // Get the stop time of the stopwatch
        return stopTime;
    }

    public long getElapsedTime() {
        // Calculate and return the elapsed time
        if (isRunning) {
            return System.currentTimeMillis() - startTime;
        } else {
            return stopTime - startTime;
        }
    }

    public List<Long> getSplits() {
        // Get the list of split times recorded by the stopwatch
        return splits;
    }
}