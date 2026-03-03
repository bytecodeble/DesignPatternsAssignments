package Assignment09;

import java.util.Random;
import java.util.Arrays;

public class SortPerformanceTest {
    public static void main(String[] args) {
        SortContext context = new SortContext();
        int[] sizes = {30, 100000}; // two array sizes

        for (int size : sizes) {
            System.out.println("\nTest array size: " + size + " ---");
            int[] originalArray = new Random().ints(size, 0, 100000).toArray();

            testStrategy("Bubble Sort", new BubbleSort(), context, originalArray);
            testStrategy("Quick Sort", new QuickSort(), context, originalArray);
            testStrategy("Merge Sort", new MergeSort(), context, originalArray);
        }
    }

    private static void testStrategy(String name, SortingStrategy strategy, SortContext context, int[] original) {
        int[] copy = Arrays.copyOf(original, original.length);
        context.setStrategy(strategy);

        long startTime = System.nanoTime();
        context.performSort(copy);
        long endTime = System.nanoTime();

        System.out.println(name + " Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
