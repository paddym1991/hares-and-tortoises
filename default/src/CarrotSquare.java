/**
 * When you start your turn on a Carrot square, choose one of three options:
 * - End your turn without moving, gain 10 carrots
 * - End your turn without moving, pay 10 carrots
 * - Take your turn (and movement) as normal
 */
import java.util.Scanner;

public class CarrotSquare extends Square {

        public void onTurnStart(Player player) {
            Scanner input = new Scanner(System.in);
            System.out.println("      You are on a Carrot Square");
            System.out.println("**************************************");
            System.out.println("==========Enter your choice===========");
            System.out.println("1) Stay where you are and gain 10 carrots?");
            System.out.println("2) Stay where you are an discard 10 carrots?");
            System.out.println("3) Or take your turn as normal?");
            int num;
            num = input.nextInt();//returns next int by user
            switch (num) {
                case 1:
                    System.out.println("You have chosen to stay and gained 10 carrots!\n");
                    player.addCarrots(10);
                    player.endTurn();
                    break;
                case 2:
                    System.out.println("You have chosen to stay and discarded 10 carrots!\n");
                    player.takeCarrots(10);
                    player.endTurn();
                    break;
                case 3:
                    System.out.println("You have chosen to take your turn as normal!\n");
                    break;
                default:
                    System.err.println("***** Invalid Option... Try Again *****\n");
            }
        }
    }



