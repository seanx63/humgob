package humgob;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Player gamePlayer = new Player();
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Welcome to HumGob, the game of Humans and Goblins!
                You may move with NESW. Have fun!""");
        gameMap map = new gameMap();
        map.print();
        while (map.gameRunning == true) {
            System.out.print("> ");
            String userInput = in.nextLine();
            switch (userInput) {
                case "n":
                case "N":
                    map.moveNorth(gamePlayer);
                    break;
                case "e":
                case "E":
                    map.moveEast(gamePlayer);
                    break;
                case "s":
                case "S":
                    map.moveSouth(gamePlayer);
                    break;
                case "w":
                case "W":
                    map.moveWest(gamePlayer);
                    break;
                default:
                    System.out.println("Invalid input. Input N,E,S,W.");
            }
            map.print();
        }
        in.close();
    }
}
