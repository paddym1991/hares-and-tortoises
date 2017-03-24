import java.util.Scanner;

/**
 * Created by Paddym1991 on 24/03/2017.
 */
public class SimpleGameController {

    private Scanner input;
    private Board board;

public static void main(String[] args) {
    new SimpleGameController();
}
public SimpleGameController() {

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
        System.out.println(board.getPlayerName(0) + " position: " + player.getBoardPosition());
        if (player.atEnd()) {
            continueFlag = false;
            System.out.println("You Win");
        }

    }

}

}



