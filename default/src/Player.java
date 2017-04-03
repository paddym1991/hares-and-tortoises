public class Player {
    private int boardPosition = 0;
    private Board board;
    private boolean faceDown;

    public Player(Board board) {
        this.board = board;
    }


    public Board getBoard() {
        return board;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

    public Square getSquare() {
        return board.getSquare(boardPosition);
    }

    public void movePlayer(int numberOfSquares) {
        boardPosition += numberOfSquares;
    }

    public boolean atEnd() {

        return board.atEnd(getBoardPosition()); //the board knows the rules for being at the end of the board.
                                                //so ask board are we at the end (.atEnd) by giving it our board position
                                                //(getBoardPosition).
    }

    public int getCarrots() {
        //TODO
        return 0;
    }
    public void addCarrots(int amount) {
        //TODO
    }

    public void takeCarrots(int amount) {
        //TODO
    }

    public int getLettuce() {
        return 0; //TODO: Get actual result
    }

    public void takeLettuce() {
        //TODO: Reduce the player's stock of lettuce by one. No way to gain extra lettuce, an so addLettuce() method isn't needed.
    }

    public String getName() {
        return board.getPlayerName(this);
    }

    public int getRacePosition() {
        return 0; //TODO: Get position in race relative to other players (1st, 2nd, etc.)
    }

    public void endTurn() {
        //TODO: Called whenever an effect would end the player's turn without allowing them to move
    }

    //Used by Lettuce squares
    public boolean isFaceDown() {
        return faceDown;
    }

    public void flipFaceDown() {
        faceDown = true;
    }

    public void flipFaceUp() {
        faceDown = false;
    }






    public void moveBackwards() {
    }


    public boolean getTortoise() {
    return false;
    }

    public int numberOfSquares() {
        int numberOfSquare = 0;
        return numberOfSquare;
    }
}
