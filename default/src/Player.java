/**
 * This class handles the Player on the game board.
 * Along with the standard constructors, getters and setters there are methods that :
 * --Calculate the coat to move
 * --Moves the player
 * --Determines if player at the end of the board
 * --Resets players carrots back to 65
 * --Add carrots to the player
 * --Takes away carrots from the player
 * --Takes a lettuce from player by 1
 * --Tells if a players turn has ended or restarted their go
 * --If a player has another turn or no more turns
 * --Gets the closest tortoise position and returns the if tortoise is available or not
 * --Player has no valid moves
 *
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
 */

public class Player {
    private int boardPosition = 0;
    private Board board;
    private boolean faceDown;
    private int carrots = 65;
    private int lettuce = 3;
    private boolean turnEnded = false;
    private int carrotsSpent = 0; //when player moves, carrotsSpent is assigned costToMove
    private boolean anotherTurn;

    /**
     * Constructor of object for class player
     * @param board no validation on the players board
     */
    public Player(Board board) {
        this.board = board;
    }

    /**
     * @return returns the player's board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return returns players position on board
     */
    public int getBoardPosition() {
        return boardPosition;
    }

    /**
     * @return return formatted players board position
     */
    public String getFormattedBoardPosition() {
        if (atEnd()) return "Finished";
        if (boardPosition == 0) return "Start";
        return boardPosition + "";
    }

    /**
     * @return The square where the player is positioned
     */
    public Square getSquare() {
        return board.getSquare(boardPosition);
    }

    /**
     * @param numSquares Calculates the cost to move by using equation n(n+1)/2
     * @return cost to move
     */
    public static int costToMove(int numSquares)
    {
        return (numSquares * (numSquares + 1))/2;
    }

    /**
     * Actions that happen when moving the player
     * @param numSquares Number of squares the player will move
     */
    public void movePlayer(int numSquares) {
        carrotsSpent = costToMove(numSquares);
        takeCarrots(carrotsSpent);
        boardPosition += numSquares;
    }

    /**
     * @return player is at end
     */
    public boolean atEnd() {

        return board.atEnd(getBoardPosition()); //the board knows the rules for being at the end of the board.
                                                //so ask board are we at the end (.atEnd) by giving it our board position
                                                //(getBoardPosition).
    }

    /**
     * resets carrots to 65
     */
    public void resetCarrots() {
        carrots = 65;
    }

    /**
     * @return how much carrots the player has
     */
    public int getCarrots() {
        return carrots;
    }

    /**
     * @param amount amount of carrots to add to players stash
     */
    public void addCarrots(int amount) {
        carrots += amount;
    }

    /**
     * @param amount amount of carrots to take away from player stash
     */
    public void takeCarrots(int amount) {
       carrots -= amount;
    }

    /**
     * @return amount of carrots spent for player to move forward
     */
    public int getCarrotsSpent() {
        return carrotsSpent;
    }

   // public boolean canMove(int numSquares) {return enoughCarrots( numSquares) && getSquareFree(numSquares);}

    /**
     * @param numSquares number of squares to move
     * @return if player can land on the square
     */
    public boolean getSquareFree(int numSquares) {
        return board.getSquare(boardPosition + numSquares).canLandOn(this);
    }

    /**
     * @param numSquares number of squares to move
     * @return if player have enough carrots to make the move
     */
    public boolean enoughCarrots(int numSquares){
        return (costToMove(numSquares) <= carrots);
    }

    /**
     * @return how much lettuce a player has
     */
    public int getLettuce() {
        return lettuce;
    }

    /**
     * Reduce the player's stock of lettuce by one. No way to gain extra lettuce, an so addLettuce() method isn't needed.
     */
    public void takeLettuce() {
        lettuce--;
    }

    /**
     * @return the player name from the board
     */
    public String getName() {
        return board.getPlayerName(this);
    }

    /**
     * @return position in race relative to other players (1st, 2nd, etc.)
     */
    public int getRacePosition() {
        return board.getRacePosition(this);
    }

    /**
     * Called whenever an effect would end the player's turn without allowing them to move
     */
    public void endTurn() {
        turnEnded = true;
    }

    /**
     * @return If the players turn has ended
     */
    public boolean hasTurnEnded() {
        return turnEnded;
    }

    /**
     * Clears the turn ended flag.
     */
    public void resetTurnStatus() {
        turnEnded = false;
    }

    /**
     * @return when token is face down
     */
    //Used by Lettuce squares
    public boolean isFaceDown() {
        return faceDown;
    }

    /**
     * If the players token is face down results in him/her missing a turn
     */
    public void flipFaceDown() {
        faceDown = true;
    } //House rule:    If you have to skip your next go, flip your token face down to keep track of it. On your next go, flip it up and skip your go.

    /**
     * When token is flipped face up
     */
    public void flipFaceUp() {
        faceDown = false;
    }

    /**
     * @return when player has another turn
     */
    public boolean hasAnotherTurn() {
        return anotherTurn;
    }

    /**
     * When player has no more turns
     */
    public void noMoreTurns() {
        anotherTurn = false;
    }

    /**
     * When player gets to take another turn
     */
    public void takeAnotherTurn() {
        anotherTurn = true;
    }

    /**
      * @return The last tortoise square closest to player to move too
     */
    public int lastTortoise() {
        return board.getClosestTortoise(getBoardPosition());
    }

    /**
     * @return if the last tortoise square is occupied or available
     */
    public boolean tortoiseAvailable() {
        return lastTortoise() > -1 && !board.getSquare(lastTortoise()).isOccupied(this);
    }
    /**
     * The amount of carrots added to the player for every space they move to it
     */
    public void backToTortoise() {
        addCarrots(10 * (boardPosition - lastTortoise()));
        boardPosition = lastTortoise();
    }

    /**
     * @return Checks for each square the player can move to, including Tortoise square. See if all are occupied.
     */
    public boolean noValidMoves() {
        int total, i;
        for (total = i = 1; (total+i < carrots) && (getBoardPosition()+i < board.length()); total += ++i) { //total = 1, 3, 6, 10, etc.; i = 1, 2, 3, 4, etc.
            if (board.getSquare(getBoardPosition() + i).canLandOn(this)) {
                return false;
            }
        }
        return !tortoiseAvailable();
    }

    /**
     * Prints a list of possible moves to the player
     */
    public void printValidMoves() {
        int total, i;
        Square square;
        if (tortoiseAvailable())
            GameController.println("T: Tortoise @ " + lastTortoise() + " (gain +" + 10*(boardPosition - lastTortoise()) + " carrots)");
        for (total = i = 1; (total <= carrots) && (getBoardPosition() + i < board.length()); total += ++i) { //total = 1, 3, 6, 10, etc.; i = 1, 2, 3, 4, etc.
            square = board.getSquare(getBoardPosition() + i);
            if (square.canLandOn(this))
                GameController.println(i + ": " + square.toString() + " (-" + total + " carrot[s])");
        }
    }

    /**
     * Returns player to start square
     */
    public void returnToStart() {
        boardPosition = 0;
    }

}




