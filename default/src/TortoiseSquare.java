/** You have the opportunity to travel back to a tortoise square
 * This will not cost the player any carrots
 * The player will earn 10 carrots for every square traveled backwards
 *
 * @author: Paul Harmon 28/03/17
 * @version:
 * */


public class TortoiseSquare extends Square {

    @Override
    public String toString() {
        return "Tortoise";
    }

    /**
     * Overrides the Square Class... When a player can land on the square
     * @param player
     * @return false when moving forward
     */
    @Override
    public boolean canLandOn(Player player) {
        return false;
    }

}
