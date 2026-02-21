package Assignment07;

public class Intermediate extends State{
    public Intermediate(Character character){
        super(character);
    }

    @Override
    public void train() {
        character.addExp(15);
        checkLevelUp();
    }

    @Override
    public void meditate() {
        character.addHp(20);
    }
    
    private void checkLevelUp() {
        if (character.getExp() >= 50) {
            character.setState(new Expert(character));
        }
    }

    @Override
    public String getStateName() { return "Intermediate"; }
}
