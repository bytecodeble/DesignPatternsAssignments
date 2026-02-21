package Assignment07;

public class Expert extends State{
    public Expert(Character character){
        super(character);
    }

    @Override
    public void train() {
        character.addExp(20);
        checkLevelUp();
    }

    @Override
    public void meditate() {
        character.addHp(30);
    }

    @Override
    public void fight() {
        character.addExp(40);
        character.addHp(-30);
        checkHP();
        checkLevelUp();
    }

    private void checkLevelUp() {
        if (character.getExp() >= 100) {
            character.setState(new Master(character));
        }
    }

    private void checkHP() {
        if (character.getHp() >= 100) {
            character.setHp(100);
        }
        if (character.getHp() <= 0) {
            System.out.println("You have been defeated! Returning to Noob level.");
            character.setState(new Noob(character));
        }
    }

        @Override
    public String getStateName() { return "Expert"; }
}
