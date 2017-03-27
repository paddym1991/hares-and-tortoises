
/* You have the opportunity to travel back to a tortoise square
     * This wil not cost the player any carrots
      * The player will earn 10 carrots for every square traveled backwards */



public class TortoiseSquare extends Square {

    public void onLandOn(Player player) {
        player.moveBackwards();
    }

    public int getNumberOfSquares() {
        int numberOfSquares = 1;
        return numberOfSquares;
    }

    public void onTurnStart(Player player) {
        if ( player.getTortoise() ) {
            int costOfCarrots = 0;
            /* It costs no carrots to move back to a tortoise square */

            int carrotsEarned = 10 * player.numberOfSquares();
            player.addCarrots(carrotsEarned);
            /* If player decides to travel backwards to a tortoise square , they earn 10 carrots for ever number of squares traveled */
            player.endTurn();
        }


    }

}
