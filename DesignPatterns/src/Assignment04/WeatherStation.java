package Assignment04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// observer interface
interface WeatherObserver {
    void update(int temp);
}

class MobileDisplay implements WeatherObserver {
    private final String name;

    public MobileDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temp) {
        System.out.println(name + " received update: Wow, it's " + temp + "°C out there!");
    }
}

class WeatherStation implements Runnable {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;
    private final int MAX_TEMP = 40;
    private final int MIN_TEMP = -10;
    private final Random random = new Random();

    public WeatherStation() {
        // Initial random temp between min and max
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
    }

    // synchronized make sure the thread safety
    // only one thread can excute at a time
    public synchronized void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Sleep for 1-5 seconds
                Thread.sleep((random.nextInt(5) + 1) * 1000);
                
                // Update temperature by +/- 1
                int change = random.nextBoolean() ? 1 : -1;
                int nextTemp = temperature + change;
                
                if (nextTemp <= MAX_TEMP && nextTemp >= MIN_TEMP) {
                    temperature = nextTemp;
                    System.out.println("\n[Station] Temperature is now: " + temperature + "°C");
                    notifyObservers();
                }
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted.");
                break;
            }
        }
    }
}
