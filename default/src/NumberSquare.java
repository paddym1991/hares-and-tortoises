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
 */
public class NumberSquare extends Square {
    public int[] numbers;

    public NumberSquare(int... numbers) {
        this.numbers = numbers;
    }

    @Override
    public void onTurnStart(Player player) {
        int racePosition = player.getRacePosition();
        for (int i=0; i<numbers.length; i++) {
            if (racePosition == numbers[i]) {
                player.addCarrots(racePosition * 10);
                System.out.println(player.getName() + " gained " + (racePosition * 10) + " carrots for being in position " + racePosition);
                System.out.println("You now have a total of " + player.getCarrots() + " carrots.");
                return;
            }
        }
    }

}
