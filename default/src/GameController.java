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
        return getSafeInt(prompt, 1, 10, "Invalid input. Please try again.");
    }
    private int getSafeInt(String prompt, int minValue, int maxValue, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(input.nextLine());
                if (value >= minValue && value <= maxValue)
                    return value;
                else
                    System.err.println(errorMessage);
            } catch (NumberFormatException e) {
                System.err.println(errorMessage);
            }
        }
    }

}
