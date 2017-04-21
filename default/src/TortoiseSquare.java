/** You have the opportunity to travel back to a tortoise square
 * This will not cost the player any carrots
 * The player will earn 10 carrots for every square traveled backwards
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
 * */


public class TortoiseSquare extends Square {

    @Override
    public String toString() {
        return "Tortoise";
    }

    /**
     * Overrides the Square Class... When a player can land on the square
     * @param player When a can land on a square is not possible
     * @return false when moving forward
     */
    @Override
    public boolean canLandOn(Player player) {
        return false;
    }

}
