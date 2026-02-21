package Assignment07;

import java.util.Scanner;

public class Character {
    private static Scanner scanner = new Scanner(System.in);
    private String name;
    private State state;
    private int exp = 0;
    private int hp = 100;
    
    public Character(String name) {
        this.name = name;
        this.state = new Noob(this);
    }
    
    public void setState(State state) {
        this.state = state;
        System.out.println("Congrats! Level up to: " + state.getStateName());
    }

    public String getStateName() {
        return state.getStateName();
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

    public int getExp() {
        return exp;
    }
    
    public void addHp(int hp) {
        this.hp += hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }
    
    public int readUserChoice(String[] options) {
        // print options
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return scanner.nextInt();
    }
}