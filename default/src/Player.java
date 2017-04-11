/**
 * <pre>
 * This class handles the Player on the game board.
 * Along with the standard constructors, getters and setters there are methods that :
 * -- Calculate the cost of carrots needed to move to a square chosen by the player
 * --
 *
 *
 *
 * </pre>
 *
 * @author
 * @version
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

    public Player(Board board) {
        this.board = board;
    }


    public Board getBoard() {
        return board;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

    public String getFormattedBoardPosition() {
        if (atEnd()) return "Finished";
        if (boardPosition == 0) return "Start";
        return boardPosition + "";
    }

    public Square getSquare() {
        return board.getSquare(boardPosition);
    }

    public static int costToMove(int numSquares) {
        return (numSquares * (numSquares + 1))/2;
    }



    public void movePlayer(int numSquares) {
        carrotsSpent = costToMove(numSquares);
        takeCarrots(carrotsSpent);
        boardPosition += numSquares;
    }

    public boolean atEnd() {

        return board.atEnd(getBoardPosition()); //the board knows the rules for being at the end of the board.
                                                //so ask board are we at the end (.atEnd) by giving it our board position
                                                //(getBoardPosition).
    }

    public void resetCarrots() {
        carrots = 65;
    }

    public int getCarrots() {
        return carrots;
    }
    public void addCarrots(int amount) {
        carrots += amount;
    }

    public void takeCarrots(int amount) {
       carrots -= amount;
    }

    public int getCarrotsSpent() {
        return carrotsSpent;
    }

   // public boolean canMove(int numSquares) {return enoughCarrots( numSquares) && getSquareFree(numSquares);}

    public boolean getSquareFree(int numSquares) {
        return board.getSquare(boardPosition + numSquares).canLandOn(this);
    }

    public boolean enoughCarrots(int numSquares){
        return (costToMove(numSquares) <= carrots);
    }

    public int getLettuce() {
        return lettuce;
    }

    public void takeLettuce() {
        //Reduce the player's stock of lettuce by one. No way to gain extra lettuce, an so addLettuce() method isn't needed.
        lettuce--;
    }

    public String getName() {
        return board.getPlayerName(this);
    }

    public int getRacePosition() {
        return board.getRacePosition(this);

        //Get position in race relative to other players (1st, 2nd, etc.)

    }
    public String getFormattedRacePosition() {
        String position = getRacePosition() + "";
        char endDigit = position.charAt(position.length() - 1);
        switch (endDigit) {
            case '1': return position + "st";
            case '2': return position + "nd";
            case '3': return position + "rd";
            default: return position + "th";
        }
    }

    public void endTurn() {
        //TODO: Called whenever an effect would end the player's turn without allowing them to move
        turnEnded = true;
    }
    public boolean hasTurnEnded() {
        return turnEnded;
    }

    /**
     * Clears the turn ended flag.
     */
    public void resetTurnStatus() {
        turnEnded = false;
    }

    //Used by Lettuce squares
    public boolean isFaceDown() {
        return faceDown;
    }

    public void flipFaceDown() {
        faceDown = true;
    } //House rule:    If you have to skip your next go, flip your token face down to keep track of it. On your next go, flip it up and skip your go.

    public void flipFaceUp() {
        faceDown = false;
    }

    public boolean hasAnotherTurn() {
        return anotherTurn;
    }

    public void noMoreTurns() {
        anotherTurn = false;
    }

    public void takeAnotherTurn() {
        anotherTurn = true;
    }

    public void backToTortoise() {
        int newPosition = board.getClosestTortoise(boardPosition);
        addCarrots(10 * (boardPosition - newPosition));
        boardPosition = newPosition;
    }
    
}

    //If player has no valid moves. Return to start square. restore carrots to 65, don't change lettuce


