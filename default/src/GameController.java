import java.util.Scanner;

/**
 *

 *
 */
public class GameController {

    private Scanner input;
    private Board board;

    public static void main(String[] args) {
        new GameController();
    }

    public GameController() {
        input = new Scanner(System.in);
        Player player;
        HareSquare.shuffle();

        //TODO: Get number of players
        board = new Board(4);
        int currentPlayer = 0;

        boolean continueFlag = true;
        while (continueFlag) {
            player = board.getPlayer(currentPlayer);
            //int boardPosition = player.getBoardPosition();
            System.out.println("------------------------------------");
            System.out.println(
                    board.getPlayerName(currentPlayer) + " position: "
                            + player.getFormattedBoardPosition()
                            + " (" + player.getFormattedRacePosition()
                            + ")\nCarrots: " + player.getCarrots()
                            + ", Lettuce: " + player.getLettuce()
            );
            System.out.println("------------------------------------");
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
                boolean tortoiseAvailable = lastTortoise > -1 && board.getSquare(lastTortoise).isOccupied(player);

                int numSquares = 0;
                boolean retry = false;

                do {
                    //TODO: Accept 'W' (wait) if on carrot square
                    if (tortoiseAvailable) {
                        System.out.println("Enter number of squares to move, or enter 'T' to move back to the last tortoise (Square " + lastTortoise + "): ");
                    } else {
                        System.out.println("Enter number of squares to move: ");
                    }

                    String choice = input.nextLine();
                    if (tortoiseAvailable && choice.trim().toUpperCase().equals("T")) {
                        player.backToTortoise();
                        retry = false;

                        // CHEAT CODES - Set number of carrots to 5 with "CHEAT CARROTS 5"; comment out when unneeded
                    } else if (choice.toUpperCase().startsWith("CHEAT CARROTS")) {
                        player.addCarrots(Integer.parseInt(choice.split(" ")[2]) - player.getCarrots());
                        retry = true;
                    } else if (choice.toUpperCase().equals("CHEAT LETTUCE")) {
                        player.takeLettuce();
                        retry = true;

                    } else {
                        try {
                            numSquares = Integer.parseInt(choice);
                            if (numSquares >= 0) {
                                if ((player.getBoardPosition() + numSquares) < board.length()) {
                                    //Move the player
                                    if (player.getSquareFree(numSquares)) {
                                        if (player.enoughCarrots(numSquares)) {
                                            player.movePlayer(numSquares);
                                            player.getSquare().onLandOn(player);
                                            retry = false;
                                        } else {
                                            System.out.println("You don't have enough carrots ");
                                            //Error message: not enough carrots
                                            retry = true;
                                        }
                                    } else {
                                        if (board.getSquare(player.getBoardPosition() + numSquares) instanceof TortoiseSquare) {
                                            System.out.println("You cannot move forwards onto a Tortoise square");
                                        } else if (board.getSquare(player.getBoardPosition() + numSquares) instanceof EndSquare) {
                                            System.out.println("You must have 0 Lettuce and no more than "
                                                    + ((board.noOfPlayersFinished() + 1) * 10) + " Carrots to cross the finish line");
                                        } else {
                                            System.out.println("The square you want to travel onto is occupied ");
                                        }
                                        //Error message: Square not free
                                        retry = true;
                                    }
                                } else {
                                    System.out.println("You cannot move past the end of the board");
                                    retry = true;
                                }
                            } else {
                                //Error message: Must move at least one square
                                System.out.println("You must move at least one square");
                                retry = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid entry !  ");
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
            if (player.hasAnotherTurn()) {
                player.noMoreTurns();
            } else {
                currentPlayer++;
                if (currentPlayer == board.noOfPlayers()) currentPlayer = 0;
                System.out.println();
               // clearScreen();
            }
        }
    }

    /*
    private void clearScreen() {
        System.out.print("\u001b[2J" + "\u001b[H");
        System.out.flush();
    }
    */
}