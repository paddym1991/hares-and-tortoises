import java.util.Scanner;

/**
 * The GameController Class is where the game start takes place for the players
 * It is here where the user is asked to input the number of players that wish to play
 *
 * It shows >> the players name
 *          >> the players position
 *          >> the number square they are on
 *          >> the amount of carrots they hold
 *          >> the amount of lettuce cards they hold
 *
 * Controls the moves of the player around the board
 * ====================================================================================
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
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

        //Gives user the choice to input number of players to play the game
        int numPlayers = 0;
        while (numPlayers < 2 || numPlayers > 6)
            numPlayers = getPosInt("\nEnter number of players (2-6): ");
        println("");
        board = new Board(numPlayers);


        int currentPlayer = 0;
        while ( board.noOfPlayersFinished() < (board.noOfPlayers()-1) ) {
            player = board.getPlayer(currentPlayer);

            if (!player.atEnd()) {
                println("-------------------------------------");
                println("========== " + player.getName() + "'s Turn ==========");
                if (player.noValidMoves()) {
                    println("*** No valid moves-----returning to start");
                    println("        Carrots have been reset to 65.");
                    player.resetCarrots();
                    player.returnToStart();
                }
                println(
                        "Position: " + player.getFormattedBoardPosition()
                                + " (" + formatPosition(player.getRacePosition())
                                + ")\nCarrots: " + player.getCarrots()
                                + ", Lettuce: " + player.getLettuce()
                );
                println("-------------------------------------");
                player.resetTurnStatus();

                player.getSquare().onTurnStart(player);


                 /* If the player is not at the end then print out the Players Name + Turn
                 * If the player has no valid moves
                 * Return the player to the starting square
                 * Update his/her carrots balance to 65
                 * Print Players position and carrots and lettuce balance
                 */
                if (player.isFaceDown()) { //House rule: All "skip next turn" effects flip the player face-down for easier tracking
                    player.flipFaceUp();
                    player.endTurn();
                }

                if (player.hasTurnEnded()) {
                    println(player.getName() + " skips a turn");
                } else {
                    int numSquares = 0;
                    boolean retry = false;

                    do {
                        if (player.tortoiseAvailable()) {
                            println("Enter number of squares to move, or enter 'T' to move back to the last tortoise (Square " + player.lastTortoise() + "), or 'M' to show possible moves: ");
                        } else {
                            println("\nEnter number of squares to move or " +
                                    "\nPress 'M' to show possible moves: ");
                        }

                        String choice = getInput("> ");
                        if (player.tortoiseAvailable() && choice.trim().equalsIgnoreCase("T")) {
                            player.backToTortoise();
                            retry = false;
                        } else if (choice.trim().equalsIgnoreCase("M")) {
                            player.printValidMoves();
                            retry = true;

                            // CHEAT CODES - Set number of carrots to 5 with "CHEAT CARROTS 5"; comment out when unneeded
                        //} else if (choice.toUpperCase().startsWith("CHEAT CARROTS")) {player.addCarrots(Integer.parseInt(choice.split(" ")[2]) - player.getCarrots()); retry = true;
                        //} else if (choice.equalsIgnoreCase("CHEAT LETTUCE")) {player.takeLettuce(); retry = true;
                        //} else if (choice.equalsIgnoreCase("CHEAT ALL LETTUCE")) {player.takeLettuce(); player.takeLettuce(); player.takeLettuce(); retry = true;
                        //} else if (choice.toUpperCase().startsWith("CHEAT JUMP")) {player.movePlayer(Integer.parseInt(choice.split(" ")[2]) - player.getBoardPosition()); retry = true;

                        } else {
                            try {
                                numSquares = Integer.parseInt(choice);
                                if (numSquares > 0) {
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
                        println(player.getName() + " finishes in " + formatPosition(board.noOfPlayersFinished()) + " place" );
                    }
                }
            }
            if (player.hasAnotherTurn()) {
                player.noMoreTurns();
            } else {
                currentPlayer++;
                if (currentPlayer == board.noOfPlayers()) currentPlayer = 0;
                println("");
               //clearScreen();
            }
        }
        println("Game Over");
        println("");
    }

/*
    private void clearScreen() {
        System.out.print("\u001b[2J" + "\u001b[H");
        System.out.flush();
    }
*/

    /**
     * @param text Helper method for System print out on screen
     *
     */
    public static void println(String text) {
        System.out.println(text);
    }

    /**
     * @param text Helper method for System print out err on screen
     */
    public static void printlnErr(String text) {
        System.err.println(text);
    }


    /**
     * @param prompt Helper method for when player is prompted to input value
     * @return next line
     */
    public static String getInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * @param prompt Helper method for checking if the value is a positive value
     * @return positive integer value. If input cannot be parsed as an integer, return -1
     */
    public static int getPosInt(String prompt) {
        String text = getInput(prompt);
        try {
            return Math.abs(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * @param number Number format type as a String:
     *               1st, 2nd, 3rd etc...
     * @return players race position in correct format
     */
    public String formatPosition(int number) {
        String position = number + "";
        char endDigit = position.charAt(position.length() - 1);
        switch (endDigit) {
            case '1': return position + "st";
            case '2': return position + "nd";
            case '3': return position + "rd";
            default: return position + "th";
        }
    }
}