import java.util.Scanner;

/**
 * Created by Paddym1991 on 24/03/2017.
 *
 * Barebones implementation of a one-player boardgame. Player can move any number of squares each turn, squares have no
 * effects, and the game ends when they reach the end of the board.
 */
public class GameController {

    private Scanner input;
    private Board board;

    public static void main(String[] args) {
        new GameController();
    }

    public GameController() {
        input = new Scanner(System.in);
        board = new Board(1);
        Player player;
        HareSquare.shuffle();
        boolean continueFlag = true;
        while (continueFlag) {
            player = board.getPlayer(0);
            //int boardPosition = player.getBoardPosition();
            System.out.println(
                    board.getPlayerName(0) + " position: "
                    + player.getFormattedBoardPosition()
                    + " (" + player.getFormattedRacePosition()
                    + ") Carrots: " + player.getCarrots()
                    + ", Lettuce: " + player.getLettuce()
            );

            player.resetTurnStatus();

            player.getSquare().onTurnStart(player);

            if (player.isFaceDown()) { //House rule: All "skip next turn" effects flip the player face-down for easier tracking
                player.flipFaceUp();
                player.endTurn();
            }

            if (player.hasTurnEnded()) {
                System.out.println(player.getName() + " skips a turn");
            } else {
                int lastTortoise = board.getClosestTortoise(player.getBoardPosition());
                boolean tortoiseAvailable = lastTortoise > -1 && board.getSquare(lastTortoise).canLandOn(player);

                int numSquares = 0;
                boolean retry = false;

                do {
                    if (tortoiseAvailable) {
                        System.out.println("Enter number of squares to move, or enter 'T' to move back to the last tortoise: ");
                    } else {
                        System.out.println("Enter number of squares to move: ");
                    }

                    String choice = input.nextLine();
                    if (tortoiseAvailable && choice.trim().toUpperCase().equals("T")) {
                        player.backToTortoise();
                        retry = false;

                    // CHEAT CODES - Set number of carrots to 5 with "CHEAT CARROTS 5"; comment out when unneeded
                    } else if (choice.toUpperCase().startsWith("CHEAT CARROTS")) { player.addCarrots(Integer.parseInt(choice.split(" ")[2]) - player.getCarrots());
                    } else if (choice.toUpperCase().equals("CHEAT LETTUCE")) { player.takeLettuce();

                    } else {
                        try {
                            numSquares = Integer.parseInt(choice);
                            if (numSquares > 0) {
                                //Move the player
                                if (player.canMove(numSquares)) { //Split this up
                                    //One of the tests is (theSquareInQuestion instanceof TortoiseSquare)
                                    //Check if (numSquares+player.getBoardPosition()) > board length
                                    player.movePlayer(numSquares);
                                    player.getSquare().onLandOn(player);
                                    retry = false;
                                } else {
                                    //Error message: cannot move to square
                                    retry = true;
                                }
                            } else {
                                //Error message: negative number
                                retry = true;
                            }
                        } catch (NumberFormatException e) {
                            //Error message: not a number
                            retry = true;
                        }
                    }
                } while (retry);

                if (player.atEnd()) {
                    continueFlag = false;
                    System.out.println(player.getName() + " Wins!");
                }
            }
        }

    }

}