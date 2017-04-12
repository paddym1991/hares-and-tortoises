import java.util.Scanner;

/**
 *

 *
 */
public class GameController {

    private static Scanner input = new Scanner(System.in);
    private Board board;

    public static void main(String[] args) {
        new GameController();
    }

    public GameController() {
        Player player;
        HareSquare.shuffle();

        //TODO: Get number of players
        board = new Board(4);
        int currentPlayer = 0;

        boolean continueFlag = true;
        while (continueFlag) {
            player = board.getPlayer(currentPlayer);
            //int boardPosition = player.getBoardPosition();
            println("------------------------------------");
            println(
                    board.getPlayerName(currentPlayer) + " position: "
                            + player.getFormattedBoardPosition()
                            + " (" + player.getFormattedRacePosition()
                            + ")\nCarrots: " + player.getCarrots()
                            + ", Lettuce: " + player.getLettuce()
            );
            println("------------------------------------");
            player.resetTurnStatus();

            player.getSquare().onTurnStart(player);

            if (player.isFaceDown()) { //House rule: All "skip next turn" effects flip the player face-down for easier tracking
                player.flipFaceUp();
                player.endTurn();
            }

            if (player.hasTurnEnded()) {
                println(player.getName() + " skips a turn");
            } else {
                int lastTortoise = board.getClosestTortoise(player.getBoardPosition());
                boolean tortoiseAvailable = lastTortoise > -1 && board.getSquare(lastTortoise).isOccupied(player);

                int numSquares = 0;
                boolean retry = false;

                do {
                    //TODO: Accept 'W' (wait) if on carrot square
                    if (tortoiseAvailable) {
                        println("Enter number of squares to move, or enter 'T' to move back to the last tortoise (Square " + lastTortoise + "): ");
                    } else {
                        println("Enter number of squares to move: ");
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
                                            println("You don't have enough carrots ");
                                            //Error message: not enough carrots
                                            retry = true;
                                        }
                                    } else {
                                        if (board.getSquare(player.getBoardPosition() + numSquares) instanceof TortoiseSquare) {
                                            println("You cannot move forwards onto a Tortoise square");
                                        } else if (board.getSquare(player.getBoardPosition() + numSquares) instanceof EndSquare) {
                                            println("You must have 0 Lettuce and no more than "
                                                    + ((board.noOfPlayersFinished() + 1) * 10) + " Carrots to cross the finish line");
                                        } else {
                                            println("The square you want to travel onto is occupied ");
                                        }
                                        //Error message: Square not free
                                        retry = true;
                                    }
                                } else {
                                    println("You cannot move past the end of the board");
                                    retry = true;
                                }
                            } else {
                                //Error message: Must move at least one square
                                println("You must move at least one square");
                                retry = true;
                            }
                        } catch (NumberFormatException e) {
                            println("Invalid entry !  ");
                            //Error message: not a number
                            retry = true;
                        }
                    }
                } while (retry);

                if (player.atEnd()) {
                    continueFlag = false;
                    println(player.getName() + " Wins!");
                }
            }
            if (player.hasAnotherTurn()) {
                player.noMoreTurns();
            } else {
                currentPlayer++;
                if (currentPlayer == board.noOfPlayers()) currentPlayer = 0;
                println("");
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


    public static void println(String text) {
        System.out.println(text);
    }
    public static void printlnErr(String text) {
        System.err.println(text);
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * Returns positive integer value. If input cannot be parsed as an integer, return -1
     */
    public static int getPosInt(String prompt) {
        String text = getInput(prompt);
        try {
            return Math.abs(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}