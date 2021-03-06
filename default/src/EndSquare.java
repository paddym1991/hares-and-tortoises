/**
 * The EndSquare Class is the final square on the board
 * It is here where you must have all lettuce cards gone and the right amount of carrot cards
 * left to land on this square or else continue on playing the game until these methods have
 * been met.
 *          >> 1st to finish must have <= 10 carrots
 *          >> 2nd to finish must have <= 20 carrots
 *          >> 3rd to finish must have <= 30 carrots etc....
 * It is then and ONLY then can the player land on the EndSquare.
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
 *
 */

public class EndSquare extends Square {
    @Override
    public String toString() {
        return "Goal";
    }

    @Override
    public void onLandOn(Player player) {
        GameController.println("You have crossed the finish line!");
    }

    /**
     * Overrides the Square Class... Whether a player can land on the end square or not
     * @param player
     *              Player function when the end square can be landed on or not
     * @return  Whether a player can land on the end square or not
     */
    @Override
    public boolean canLandOn(Player player) {
        return player.getLettuce() == 0
                && player.getCarrots() - Player.costToMove(player.getBoard().getSquareIndex(this) - player.getBoardPosition())
                <= (player.getBoard().noOfPlayersFinished()+1) * 10;
    }
}
