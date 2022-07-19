package humgob;

import java.util.Random;

public class gameMap {
    Player gamePlayer = new Player();
    Goblin newGoblin = new Goblin();
    Random rand = new Random();
    String map[][] = new String[5][5];
    public boolean gameRunning = true;
    {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = ".";
            }
        }
        spawnObject(gamePlayer);
        spawnObject(newGoblin);
        spawnObject(newGoblin);
    }

    public void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(); // carriage return after every row
        }
    }

    public void spawnObject(Object obj) {
        for (int i = 0; i < map.length * map.length; i++) { // attempt to spawn object in an empty space, don't spawn if
                                                            // no empty space.
            int randX = rand.nextInt(map.length);
            int randY = rand.nextInt(map.length);
            if (map[randX][randY] == ".") {
                map[randX][randY] = obj.toString();
                break;
            } else {
                continue;
            }
        }
    }

    public void moveNorth(Object obj) throws Exception {
        boolean objFound = false;
        int col = -1, row = -1;
        for (int i = 0; i < map.length && !objFound; i++) {
            for (int j = 0; j < map.length && !objFound; j++) {
                if (map[i][j] == obj.toString()) {
                    objFound = true;
                    col = j;
                    row = i;
                }
            }
        }
        if (row == 0) {
            System.out.println("Can't move that way!");
        } else {
            if (map[row - 1][col] != ".") {
                combatStart(newGoblin, gamePlayer);
                clearIfDead(newGoblin, row - 1, col);
            } else {
                if (objFound == false) {
                    throw new Exception();
                }
                map[row][col] = ".";
                map[row - 1][col] = obj.toString();
            }
        }
        if (rand.nextInt(3) == 0) {
            spawnObject(newGoblin);
        }
    }

    public void moveEast(Object obj) throws Exception {
        boolean objFound = false;
        int col = -1, row = -1;
        for (int i = 0; i < map.length && !objFound; i++) {
            for (int j = 0; j < map.length && !objFound; j++) {
                if (map[i][j] == obj.toString()) {
                    objFound = true;
                    col = j;
                    row = i;
                }
            }
        }
        if (col == map.length - 1) {
            System.out.println("Can't move that way!");
        } else {
            if (map[row][col + 1] != ".") {
                combatStart(newGoblin, gamePlayer);
                clearIfDead(newGoblin, row, col + 1);
            } else {
                if (objFound == false) {
                    throw new Exception();
                }
                if (map[row][col + 1] != ".") {

                }
                map[row][col] = ".";
                map[row][col + 1] = obj.toString();
            }
        }
        if (rand.nextInt(3) == 0) {
            spawnObject(newGoblin);
        }
    }

    public void moveSouth(Object obj) throws Exception {
        boolean objFound = false;
        int col = -1, row = -1;
        for (int i = 0; i < map.length && !objFound; i++) {
            for (int j = 0; j < map.length && !objFound; j++) {
                if (map[i][j] == obj.toString()) {
                    objFound = true;
                    col = j;
                    row = i;
                }
            }
        }
        if (row == map.length - 1) {
            System.out.println("Can't move that way!");
        } else {
            if (map[row + 1][col] != ".") {
                combatStart(newGoblin, gamePlayer);
                clearIfDead(newGoblin, row + 1, col);
            } else {
                if (objFound == false) {
                    throw new Exception();
                }
                map[row][col] = ".";
                map[row + 1][col] = obj.toString();
            }
        }
        if (rand.nextInt(3) == 0) {
            spawnObject(newGoblin);
        }
    }

    public void moveWest(Object obj) throws Exception {
        boolean objFound = false;
        int col = -1, row = -1;
        for (int i = 0; i < map.length && !objFound; i++) {
            for (int j = 0; j < map.length && !objFound; j++) {
                if (map[i][j] == obj.toString()) {
                    objFound = true;
                    col = j;
                    row = i;
                }
            }
        }
        if (col == 0) {
            System.out.println("Can't move that way!");
        } else {
            if (map[row][col - 1] != ".") {
                combatStart(newGoblin, gamePlayer);
                clearIfDead(newGoblin, row, col -1);
            } else {
                if (objFound == false) {
                    throw new Exception();
                }
                map[row][col] = ".";
                map[row][col - 1] = obj.toString();
            }
        }
        if (rand.nextInt(3) == 0) {
            spawnObject(newGoblin);
        }
    }

    private void combatStart(GameCharacter char1, GameCharacter char2) {
        char1.setHealth(char1.getHealth() - char2.attackStrength());
        char2.setHealth(char2.getHealth() - char1.attackStrength());
        if (char1.getHealth() < 0) {
            char1.setHealth(0);
        } // set opponents health to 0 if negative for convenience
        System.out.println(char1.getClass().getSimpleName() + "'s health is: " + char1.getHealth());
        System.out.println(char2.getClass().getSimpleName() + "'s health is: " + char2.getHealth());
        if (char2.getHealth() <= 0) {
            System.out.println("Game over!");
            gameRunning = false;
        }

    }

    private void clearIfDead(GameCharacter c1, int x, int y) {
        if (c1.getHealth() == 0) {
            map[x][y] = ".";
        }
        gamePlayer.setHealth(gamePlayer.getHealth()+1);
    }
}