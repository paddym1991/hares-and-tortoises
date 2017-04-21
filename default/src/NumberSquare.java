/**
 * When you start your turn on a Number square, and your position matches one of the numbers on it, gain carrots equal
 * to 10x your position. E.g. starting on a "3" square while in 3rd place would grant 30 carrots. Use the position
 * you're in when you start your turn, not the position you were in when you landed on the Number square.
 *
 * Types of number square:
 * - 1, 5, 6 (same square counts as all three)
 * - 2
 * - 3
 * - 4
 *
 * @author: Gary Fleming, Paddy Murphy, Paul Harmon, Cathal Gahan 21/04/2017
 * @version: 25.0
 */


public class NumberSquare extends Square {
    public int[] numbers;

    /**
     * @param numbers
     */
    public NumberSquare(int... numbers) {
        this.numbers = numbers;
    }

    /**
     * @return Returns an output of a String + numbers
     */
    @Override
    public String toString() {
        String output = "[" + numbers[0];
        for (int i=1; i<numbers.length; i++)
            output += ", " + numbers[i];
        return output + "]";
    }

    /**
     * Overrides from Square Class....When a players turn to start resume as normal
     *
     * @param player Gets players race position number. If position is equal to the number on square then that number
     *                 times * 10 carrots are given to the player
     *                   Prints out the players total carrots after calculation
     */
    @Override
    public void onTurnStart(Player player) {
        int racePosition = player.getRacePosition();
        for (int i=0; i<numbers.length; i++) {
            if (racePosition == numbers[i]) {
                player.addCarrots(racePosition * 10);
                GameController.println(player.getName() + " gained " + (racePosition * 10) + " carrots for being in position " + racePosition);
                GameController.println(">> You now have a total of " + player.getCarrots() + " carrots <<\n");
                return;
            }
        }
    }

}
