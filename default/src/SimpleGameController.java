import java.util.Scanner;

/**
 * Created by Paddym1991 on 24/03/2017.
 *
 * Barebones implementation of a one-player boardgame. Player can move any number of squares each turn, squares have no
 * effects, and the game ends when they reach the end of the board.
 */
public class SimpleGameController {

    private Scanner input;
    private Board board;

    public static void main(String[] args) {
        new SimpleGameController();
    }

    public SimpleGameController() {
        input = new Scanner(System.in);
        board = new Board(1);
        Player player;
        boolean continueFlag = true;
        while (continueFlag) {
            player = board.getPlayer(0);
            System.out.println(board.getPlayerName(0) + " position: " + player.getBoardPosition());
            System.out.println("Enter number of squares to move: ");
            // int move = input.nextInt();
            //put input.nextInt() into braces below.
            player.movePlayer(input.nextInt());
            if (player.atEnd()) {
                continueFlag = false;
                System.out.println("You Win");
            }
        }

    }



}