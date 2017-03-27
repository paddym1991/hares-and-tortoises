/**
 * You may only land on a Lettuce square if you hold at least one Lettuce card. When you do so, turn your token upside-
 * down.
 * At the start of your next turn, discard 1 Lettuce card and gain carrots equal to 10x your position in the race
 * (e.g. 5th place gets 50 carrots). Then turn your token right side up and end your turn.
 * On the turn after that, you return to moving as normal.
 */
public class LettuceSquare extends Square {

    @Override
    public boolean canLandOn(Player player) {
        //If the player could land on a regular Square here.
        return (super.canLandOn(player) && player.getLettuce() > 0);
    }

    @Override
    public void onLandOn(Player player) {
        player.flipFaceDown();
    }

    @Override
    public void onTurnStart(Player player) {

        }

        //If the player isn't face-down, do nothing; proceed as a regular turn
    }

}
