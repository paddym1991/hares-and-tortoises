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
     *
     */
    public Square() {

    }

    /**
     * When a player cannot land on a square or not
     *
     * @param player
     *              Player function when a player cannot land on square
     * @return  Returns if the square is occupied by another player
     */
    public boolean canLandOn(Player player) {
        return !isOccupied(player);
    }

    /**
     * When a square a player picks is occupied
     *
     * @param player
     *              Player function when square is occupied
     * @return  Returns if square is occupied by another player from the board,
     *
     */
    public boolean isOccupied(Player player) {
        Board board = player.getBoard();
        for (Player p : board.getPlayers()) {
            if (board.getSquare(p.getBoardPosition()) == this) return true;
        }
        return false;
    }

    /**
     * When a player lands on a square
     *
     * @param player
     *              Player function when landing on this square
     */
    public void onLandOn(Player player) {
        GameController.println("You have landed on a " + this.toString() + " Square");
    }

    /**
     * When a players turn to start resume as normal
     *
     * @param player
     *              Player function when turn to start
     */
    public void onTurnStart(Player player) {
        //Do nothing
    }

    public String toString() {
        return squareType;
    }
}
