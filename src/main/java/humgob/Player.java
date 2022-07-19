package humgob;

import java.util.Random;

public class Player extends GameCharacter{
    private int health, strength;
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private String gameChar = "@";
    public String toString() {
        return gameChar;
    }

    Random rand = new Random();

    Player() {
        this.health=10;
        this.strength=2;
    }
    
    public int attackStrength() {
        return rand.nextInt(this.strength+1);
    }
}
