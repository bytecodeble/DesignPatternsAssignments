package Assignment04;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();
        
        WeatherObserver phone = new MobileDisplay("Phone App");
        WeatherObserver tablet = new MobileDisplay("Tablet Screen");
        WeatherObserver laptop = new MobileDisplay("Laptop Dashboard");

        station.addObserver(phone);
        station.addObserver(tablet);
        station.addObserver(laptop);

        // Start the simulation thread
        Thread stationThread = new Thread(station);
        stationThread.start();

        // Let it run for 12 seconds
        Thread.sleep(12000);

        // Remove the tablet
        System.out.println("\n--- Removing Tablet Screen from notifications ---");
        station.removeObserver(tablet);

        // Let it run longer to see the change
        Thread.sleep(15000);
        
        System.exit(0); // Stop the eternal loop for the demo
    }
}
