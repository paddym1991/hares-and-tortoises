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
        int numOfPlayers = getSafeInt("\nPlease enter number of players: ");
    }

    private int getSafeInt(String prompt) {
        return getSafeInt(prompt, "");
    }
    private int getSafeInt(String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                if (errorMessage != "") System.err.println(errorMessage);
            }
        }
    }

}
