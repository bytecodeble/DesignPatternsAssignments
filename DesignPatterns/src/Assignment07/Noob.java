package Assignment07;

public class Noob extends State{
    public Noob(Character character){
        super(character);
    }

    @Override
    public void train() {
        character.addExp(10);
        checkLevelUp();
    }
    @Override
    public String getStateName() { return "Noob"; }

    private void checkLevelUp() {
        if (character.getExp() >= 20) {
            character.setState(new Intermediate(character));
        }
    }
}