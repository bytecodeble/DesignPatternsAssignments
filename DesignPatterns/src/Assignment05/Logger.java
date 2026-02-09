package Assignment05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    // The single instance of the class
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    // Private constructor prevents instantiation from other classes
    private Logger() {
        this.fileName = "default_log.txt";
        openFile();
    }

    // Static method to get the single instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Helper to handle the file opening logic
    private void openFile() {
        try {
            // FileWriter(fileName, true) appends to the file instead of overwriting
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Ugh, couldn't open the file: " + e.getMessage());
        }
    }

    public void setFileName(String newFileName) {
        try {
            if (writer != null) {
                writer.close();
            }
            this.fileName = newFileName;
            openFile();
        } catch (IOException e) {
            System.err.println("Error while switching files: " + e.getMessage());
        }
    }

    public void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush(); // Makes sure the message actually hits the disk
            }
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing the logger: " + e.getMessage());
        }
    }
}

