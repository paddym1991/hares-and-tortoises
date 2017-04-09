/**
 * When you land on a Hare square, draw one Hare card from the deck.
 * Do what it says, then place it at the bottom of the deck.
 * <p>
 * The deck contains 1 "shuffle the deck" card, and 2 cards of each other type, for 15 in total.
 * <p>
 * List of all Hare cards:
 * - If there are more players behind you than in front of you, miss a turn. If not, play again.
 * - If equal, of course play again.
 * <p>
 * - Restore your carrot holding to exactly 65.
 * - If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch.
 * <p>
 * - Free Ride!
 * - Your last turn costs nothing; retrieve the carrots you paid to reach this square.
 * <p>
 * - Draw 10 carrots for each lettuce you still hold.
 * - If you have none left, miss a turn.
 * <p>
 * - Show us your carrots!
 * - Count your carrot cards face up to the table so that everyone will know how many you have left.
 * <p>
 * - Give 10 carrots to each player lying behind you in the race (if any).
 * - If you haven't enough carrots, give them five each; if still not possible, one each. A player who doesn't want extra carrots may discard them to the 'carrot patch'.
 * <p>
 * - Lose half your carrots!
 * - If an odd number, keep the odd one.
 * <p>
 * - Shuffle the hare cards and receive from each player 1 carrot for doing so.
 * - Do not replace this card at the bottom of the pack but include it in the shuffle.
 */
public class HareSquare extends Square {
    private static int[] deck = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
    private static int currentCard = 0;

    /*
    Once Player lands on HareSquare, Player will be told they have landed on this square.
    Next card in Hare deck will then be chosen and instructions will be carried out.
     */
    @Override
    public void onLandOn(Player player) {
        //player is told what square they have landed on.
        //player picks top card from deck of Hare Cards and completes task on card.
        System.out.println("You have landed on a Hare Square. Please pick up a Hare card");
        //System.out.println( getCardText(currentCard) );
        switch (deck[currentCard]) {
            case 0:
                System.out.println("If there are more players behind you than in front of you, miss a turn. If not, play again. If equal, of course play again.");
                if ( player.getRacePosition() > player.getBoard().noOfPlayers() / 2 ) {
                    player.flipFaceDown();
                } else {
                    //TODO: take a second go
                }
                break;
            case 1:
                System.out.println("Restore your carrot holding to exactly 65. If you have more than 65, pay extras to the carrot patch; if fewer, draw extras from the carrot patch.");
                player.resetCarrots();
                break;
            case 2:
                System.out.println("Free Ride! Your last turn costs nothing; retrieve the carrots you paid to reach this square.");
                player.addCarrots(player.getCarrotsSpent());
                break;
            case 3:
                System.out.println("Draw 10 carrots for each lettuce you still hold. If you have none left, miss a turn.\n");
                if (player.getLettuce() == 0) {
                    System.out.println("You will skip your next go");
                    player.flipFaceDown();
                }
                else {
                    player.addCarrots(player.getLettuce() * 10);
                    System.out.println(player.getLettuce() * 10 + " carrots were added to your stock.");
                }
                break;
            case 4:
                System.out.println("Show us your carrots! Count your carrot cards face up to the table so that everyone will know how many you have left.");
                System.out.println(">> You have " + player.getCarrots() + "  carrots left <<");//just added signs on the end
                break;
            case 5:
                System.out.println("Give 10 carrots to each player lying behind you in the race (if any). "
                        + "If you haven't enough carrots, give them five each; if still not possible, one each. "
                        + "A player who doesn't want extra carrots may discard them to the 'carrot patch'.");

                int position = player.getBoardPosition();// gets player position on board
                int howManyCarrotsIHave = player.getCarrots();// returns how many carrots the player has
                int numberOfPlayersOnBoard = player.getBoard().noOfPlayers();// returns the amount of players on board

                if ((howManyCarrotsIHave / numberOfPlayersOnBoard) > 10) {// if amount / players on board greater than 10 then,
                    for (Player currentPlayer : player.getBoard().getPlayers()) {// for each current player that is on the board,
                        if (currentPlayer != player){// and is NOT the current player then,
                            if (currentPlayer.getBoardPosition() < position) {// if their board position is less than your position,
                                currentPlayer.addCarrots(10);// they receive 10 carrots each.
                            }
                        }
                    }
                }else if ((howManyCarrotsIHave / numberOfPlayersOnBoard) > 5) {// if amount / players on board greater than 5 then,
                    for (Player currentPlayer : player.getBoard().getPlayers()) {// for each current player that is on the board,
                        if (currentPlayer != player){// and is NOT the current player then,
                            if (currentPlayer.getBoardPosition() < position) {// if their board position is less than your position,
                                currentPlayer.addCarrots(5);// they receive 5 carrots each.
                            }
                        }
                    }
                }else if ((howManyCarrotsIHave / numberOfPlayersOnBoard) > 1) {// if amount / players on board greater than 1 then,
                    for (Player currentPlayer : player.getBoard().getPlayers()) {// for each current player that is on the board,
                        if (currentPlayer != player){// and is NOT the current player then,
                            if (currentPlayer.getBoardPosition() < position) {// if their board position is less than your position,
                                currentPlayer.addCarrots(1);// they receive 1 carrot each.
                            }
                        }
                    }
                    player.endTurn();//ends the players turn.
                }
                break;
            case 6:
                System.out.println("Lose half your carrots! If an odd number, keep the odd one.");
                player.takeCarrots((int)Math.floor(player.getCarrots()/2)); //take away half the carrots rounded down.
                break;
            case 7:
                System.out.println("Shuffle the hare cards and receive from each player 1 carrot for doing so. Do not replace this card at the bottom of the pack but include it in the shuffle.");
                shuffle();
                //for each currentPlayer within the list of players, if that player is not player(whose turn it is), take 1 carrot from them and add it to player(whose turn it is)
                for(Player currentPlayer : player.getBoard().getPlayers()) {
                    if (currentPlayer != player){
                        currentPlayer.takeCarrots(1);
                        player.addCarrots(1);
                    }
                }
            break;
            default:
                System.err.println("Something has gone wrong!!");
            break;
        }
    currentCard++;
        if(currentCard > deck.length)currentCard = 0;
    }

    //random shuffle of cards
    //found code for this at: https://www.youtube.com/watch?v=8I37elnmZ2I
    //
    public static void shuffle() {
        int noOfElements = deck.length;

        for (int i = 0; i < noOfElements; i++) {
            int s = i + (int) (Math.random() * (noOfElements - i));
            //swaps two values (at index 's' and 'i')
            int temp = deck[s];
            deck[s] = deck[i];
            deck[i] = temp;
        }
    }
}
