package Assignment09;

public class SortContext {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy){
        this.strategy = strategy;
    }

    public void performSort(int[] array){
        if (strategy != null){
            strategy.sort(array);
        }
    }
}
