/**
 * Created by admin on 22/03/2017.
 */


import java.util.Scanner;

public class GameController {

    private Scanner input;
    private Player player;
    //private Board board;
    // private Square square;

    public static void main(String[] args) {
        new GameController();
    }

    public GameController() {
        input = new Scanner(System.in);

        System.out.println("Welcome to Hare and Tortoise");
        System.out.println("----------------------------");
        System.out.print("\nPlease enter number of players: ");
        int numOfPlayers = input.nextInt();
    }


}
