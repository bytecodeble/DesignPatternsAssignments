package Assignment07;

public abstract class State {

    protected Character character;

    public State(Character character) {
        this.character = character;
    }

    public abstract void train();
    public void meditate() {
        System.out.println("Haven't learnt how to heal...");
    }
    public void fight() {
        System.out.println("Haven't learnt how to fight...");
    }
    public abstract String getStateName();
}
