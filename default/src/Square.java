/**
 * This contains the Function of the Square Class
 * The methods function of the squares are:
 * -- Can a player land on that square
 * -- Is that square occupied
 * -- Return nothing when landed on
 * -- Return nothing when turn start
 *
 * @author Gary Fleming 17/04/2017
 * @version
 */

public class Square {

    private String squareType = "Blank";

    /**
     * The default constructor.
     */
    public Square() {

    }

    /**
     * @param player
     * @return  Returns true if the square not occupied
     */
    public boolean canLandOn(Player player) {
        return !isOccupied(player);
    }

    /**
     * @param player
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
     * @param player
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
