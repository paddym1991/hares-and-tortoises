
/* You have the opportunity to travel back to a tortoise square
     * This wil not cost the player any carrots
      * The player will earn 10 carrots for every square traveled backwards
      * Paul Harmon 28/07/17  time : 01:21*/

import java.util.Iterator;
import java.util.Scanner;

public class TortoiseSquare extends Square {

    private int numberOfSquares;

    private static  Scanner input;

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        TortoiseSquare.input = input;
    }

    public void onLandOn(Player player) {
        player.moveBackwards();
    }

    public int getNumberOfSquares() {
        return numberOfSquares;
    }

    public void onTurnStart(Player player) {
        if (player.getTortoise()) {
            int costOfCarrots = 0;
            /* It costs no carrots to move back to a tortoise square */

            int carrotsEarned = 10 * player.numberOfSquares();
            player.addCarrots(carrotsEarned);
            /* If player decides to travel backwards to a tortoise square , they earn 10 carrots for ever number of squares traveled */
            player.endTurn();
        }
    }

    public static void main(String[] args) {
        setInput(new Scanner(System.in));
        String a = getInput().next();
        System.out.println("By travelling to a Tortoise Square allows you to earn Carrots");
        System.out.println("Do you Wish to Travel to the Tortoise Square yes/no");

        if( a.equals ("yes") ) {
            System.out.print("You will travel (NumberOfSquares) and you will earn (numberOfCarrots");
        }else if (a.equals ("no")) {
            System.out.print("Choose how many square to move");
        }
        else {
            System.out.print("Exit the game");
        }

    }

}
