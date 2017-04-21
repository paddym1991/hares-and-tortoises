/**
 * This contains the Function of the Square Class
 * The methods function of the squares are:
 * -- Can a player land on that square
 * -- Is that square occupied
 * -- Return nothing when landed on
 * -- Return nothing when turn start
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
 */

public class Square {

    private String squareType = "Blank";

    /**
     * The default constructor.
     */
    public Square() {

    }

    /**
     * @param player Reaction when asking a player if a player can land on square
     * @return  Returns true if the square not occupied
     */
    public boolean canLandOn(Player player) {
        return !isOccupied(player);
    }

    /**
     * @param player Reaction when asking if a square is occupied
     * @return  Returns true if square is occupied by another player
     */
    public boolean isOccupied(Player player) {
        Board board = player.getBoard();
        for (Player p : board.getPlayers()) {
            if (board.getSquare(p.getBoardPosition()) == this) return true;
        }
        return false;
    }

    /**
     * @param player Reation to when a player lands on a square
     */
    public void onLandOn(Player player) {
        GameController.println("You have landed on a " + this.toString() + " Square");
    }

    /**
     * @param player
     */
    public void onTurnStart(Player player) {
        //Do nothing
    }

    /**
     * @return The name of the square you land on
     */
    public String toString() {
        return squareType;
    }
}
