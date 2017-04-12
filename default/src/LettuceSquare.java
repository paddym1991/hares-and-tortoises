/**
 * <pre>
 * This class handles the Lettuce Square on the game board.
 * The Rules with the Lettuce Square are :
 * -- You may only land on a Lettuce square if you hold at least one Lettuce card
 * -- When you do so, turn your token upside-down.
 * -- At the start of your next turn, discard 1 Lettuce card and gain carrots equal to 10x your position in the race
 *    (e.g. 5th place gets 50 carrots).
 * -- On the turn after that, you return to moving as normal
 *
 *
 * </pre>
 *
 * @author
 * @version
 */
public class LettuceSquare extends Square {

    @Override
    public boolean canLandOn(Player player) {
        //If the player could land on a regular Square here, AND has 1+ lettuce, return true. Otherwise return false.
        return (super.canLandOn(player) && player.getLettuce() > 0);
    }

    @Override
    public void onLandOn(Player player) {
        player.flipFaceDown();
    }

    @Override
    public void onTurnStart(Player player) {
        if (player.isFaceDown()) {
            player.takeLettuce();
            int carrotsEarned = 10 * player.getRacePosition();
            player.addCarrots(carrotsEarned);
            // Preferably hand this off to a GameController; it decides how messages are actually displayed
            GameController.println(player.getName() + " spent their turn chewing on lettuce and earned " + carrotsEarned + " carrots.");
        }

        //If the player isn't face-down, do nothing; proceed as a regular turn
    }
}