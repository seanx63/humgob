package humgob;

import java.util.Random;

class GameCharacter {
    private int health, strength;
    private String gameChar = "";
    Random rand = new Random();
    GameCharacter(int health, int strength) {
        this.health=health;
        this.strength=strength;
    }
    GameCharacter() {
        
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String toString() {
        return this.gameChar;
    }

    public int attackStrength() {
        return rand.nextInt(this.strength+1);
    }

}