package humgob;

public class Goblin extends GameCharacter{
    private int health, strength;
    private String gameChar = "G";

    Goblin(int health, int strength) {
        this.health=health;
        this.strength=strength;
    }
    Goblin() {
        this.health=2;
        this.strength=2;
    }

    public String toString() {
        return gameChar;
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

    public int attackStrength() {
        return rand.nextInt(this.strength+1);
    }

}
