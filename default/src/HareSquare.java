/**
 * When you land on a Hare square, draw one Hare card from the deck.
 * Do what it says, then place it at the bottom of the deck.
 *
 * The deck contains 1 "shuffle the deck" card, and 2 cards of each other type, for 15 in total.
 *
 * List of all Hare cards:
 * - If there are more players behind you than in front of you, miss a turn. If not, play again.
 * - If equal, of course play again.
 *
 * - Restore your carrot holding to exactly 65.
 * - If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch.
 *
 * - Free Ride!
 * - Your last turn costs nothing; retrieve the carrots you paid to reach this square.
 *
 * - Draw 10 carrots for each lettuce you still hold.
 * - If you have none left, miss a turn.
 *
 * - Show us your carrots!
 * - Count your carrot cards face up to the table so that everyone will know how many you have left.
 *
 * - Give 10 carrots to each player lying behind you in the race (if any).
 * - If you haven't enough carrots, give them five each; if still not possible, one each. A player who doesn't want extra carrots may discard them to the 'carrot patch'.
 *
 * - Lose half your carrots!
 * - If an odd number, keep the odd one.
 *
 * - Shuffle the hare cards and receive from each player 1 carrot for doing so.
 * - Do not replace this card at the bottom of the pack but include it in the shuffle.
 */

import java.util.*;

public class HareSquare extends Square {

    private static Object[] array;

    public HareSquare() {

    }

    @Override
    public boolean canLandOn(Player player) {
        //If the player could land on a regular Square here.
        return (super.canLandOn(player) && player.getLettuce() > 0);
    }

    @Override
    public void onLandOn(Player player) {
        //player picks top card from deck of Hare Cards and completes task on card.
    }

    @Override
    public void onTurnStart(Player player) {
        //player moves square as normal.
    }


    //random shuffle of cards
    //found code for this at: https://www.youtube.com/watch?v=8I37elnmZ2I

    public static void shuffle(Object[] array) {
        HareSquare.array = array;

        int noOfElements = array.length;

       for(int i = 0; i < noOfElements; i++) {
           int s = i + (int)(Math.random() * (noOfElements - i));

           Object temp = array[s];
           array[s] = array[i];
           array[i] = temp;
       }
    }

    public static void main(String[] args) {
       String[] strOfCharacters = {"If there are more players behind you than in front of you, miss a turn. If not, play again. If equal, of course play again.",
                                   "Restore your carrot holding to exactly 65. If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch.",
                                   "Free Ride! Your last turn costs nothing; retrieve the carrots you paid to reach this square.",
                                   "Draw 10 carrots for each lettuce you still hold. If you have none left, miss a turn.",
                                   "Show us your carrots! Count your carrot cards face up to the table so that everyone will know how many you have left.",
                                   "Give 10 carrots to each player lying behind you in the race (if any). If you haven't enough carrots, give them five each; if still not possible, one each. A player who doesn't want extra carrots may discard them to the 'carrot patch'.",
                                   "Lose half your carrots! If an odd number, keep the odd one.",
                                   "Shuffle the hare cards and receive from each player 1 carrot for doing so. Do not replace this card at the bottom of the pack but include it in the shuffle.",
                                   "If there are more players behind you than in front of you, miss a turn. If not, play again. If equal, of course play again.",
                                   "Restore your carrot holding to exactly 65. If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch.",
                                   "Free Ride! Your last turn costs nothing; retrieve the carrots you paid to reach this square.",
                                   "Draw 10 carrots for each lettuce you still hold. If you have none left, miss a turn.",
                                   "Show us your carrots! Count your carrot cards face up to the table so that everyone will know how many you have left.",
                                   "Give 10 carrots to each player lying behind you in the race (if any). If you haven't enough carrots, give them five each; if still not possible, one each. A player who doesn't want extra carrots may discard them to the 'carrot patch'.",
                                   "Lose half your carrots! If an odd number, keep the odd one."};
        HareSquare.shuffle(strOfCharacters);

        for(int i = 0; i < strOfCharacters.length; i++)
            System.out.println(strOfCharacters[i] + " ");
    }
}
