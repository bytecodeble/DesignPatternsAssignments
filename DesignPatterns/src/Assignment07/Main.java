package Assignment07;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("Christine");
        while (!character.getStateName().equals("Master")) {
            System.out.println("Current State: " + character.getStateName());
            System.out.println("HP: " + character.getHp() + ", EXP: " + character.getExp());
            int choice = character.readUserChoice(new String[]{"Train", "Meditate", "Fight"});
            switch (choice) {
            case 1:
                character.train();
                break;
            case 2:
                character.meditate();
                break;
            case 3:
                character.fight();
                break;
            }
        }
        if (character.getStateName().equals("Master")) {
            System.out.println("Congratulations! You won the game!");
            System.exit(0);
        
        }
    }
}