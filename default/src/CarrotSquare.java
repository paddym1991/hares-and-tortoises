/**
 * When you start your turn on a Carrot square, choose one of three options:
 * - End your turn without moving, gain 10 carrots
 * - End your turn without moving, pay 10 carrots
 * - Take your turn (and movement) as normal
 */

/**
 * <pre>
 * This class handles the Carrot Square on the game board.
 * The Rules with the Carrot Square are :
 * -- Nothing happens immediately when you land on the square
 * -- On the next turn you may stay where you are and earn 10 carrots
 * -- Once you are on a Carrot Square you may miss as many turns as you like earning 10 Carrots each turn.
 *
 * </pre>
 *
 * @author
 * @version
 */



public class CarrotSquare extends Square {

    public void onTurnStart(Player player) {
        GameController.println("      You are on a Carrot Square");
        GameController.println("**************************************");

        boolean invalidInput = true;
        while (invalidInput) {
            GameController.println("==========Enter your choice===========");
            GameController.println("1) Stay where you are and gain 10 carrots?");
            GameController.println("2) Stay where you are an discard 10 carrots?");
            GameController.println("3) Or take your turn as normal?");

            int num;
            num = GameController.getPosInt("> ");//returns next int by use
            switch (num) {
                case 1:
                    invalidInput = false;
                    GameController.println("You have chosen to stay and gained 10 carrots!\n");
                    player.addCarrots(10);
                    player.endTurn();
                    break;
                case 2:
                    invalidInput = false;
                    GameController.println("You have chosen to stay and discarded 10 carrots!\n");
                    player.takeCarrots(10);
                    player.endTurn();
                    break;
                case 3:
                    invalidInput = false;
                    GameController.println("You have chosen to take your turn as normal!\n");
                    break;
                default:
                    invalidInput = true;
                    GameController.printlnErr("***** Invalid Option... Try Again *****\n");
            }
        }
    }

}
