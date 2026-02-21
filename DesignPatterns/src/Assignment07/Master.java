package Assignment07;

public class Master extends State{
    public Master(Character character){
        super(character);
    }

    @Override
    public void train() {}
    @Override
    public void meditate() {};
    @Override
    public void fight() {};
    @Override
    public String getStateName() { return "Master"; }
}
