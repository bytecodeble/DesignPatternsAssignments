package Assignment05;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.setFileName("new_log.txt");

        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        logger.close();

        System.out.println("Log is written to new_log.txt file.");
    }
}