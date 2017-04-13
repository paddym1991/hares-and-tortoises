/**
 * This contains the habits of the Square Class
 *
 *-
 * @author
 * @version
 */

public class Square {

    /**
     * The default constructor.
     *
     */
    public Square() {

    }

    /**
     *
     * @param player
     * @return
     */
    public boolean canLandOn(Player player) {
        return isOccupied(player);
    }

    /**
     *
     * @param player
     * @return
     */
    public boolean isOccupied(Player player) {
        Board board = player.getBoard();
        for (Player p : player.getBoard().getPlayers()) {
            if (board.getSquare(p.getBoardPosition()) == this) return false;
        }
        return true;
    }

    /**
     *
     * @param player
     */
    public void onLandOn(Player player) {
        //Do nothing
    }

    /**
     *
     * @param player
     */
    public void onTurnStart(Player player) {
        //Do nothing
    }
}
