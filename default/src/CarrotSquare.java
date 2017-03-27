/**
 * When you start your turn on a Carrot square, choose one of three options:
 * - End your turn without moving, gain 10 carrots
 * - End your turn without moving, pay 10 carrots
 * - Take your turn (and movement) as normal
 *
 * Gary Fleming 27/03/2017
 */
import java.util.Scanner;

public class CarrotSquare extends Square {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);//Scanner class used to read input from keyboard
            System.out.print("============Enter your choice============\n ");
            System.out.print("1) Stay where you are and gain 10 carrots?\n ");
            System.out.print("2) Stay where you are an discard 10 carrots?\n ");
            System.out.print("3) Or take your turn as normal?\n ");
            int num;
            num = input.nextInt();//returns next int by user
            switch (num) {
                case 1:
                    System.out.println("You have chosen to stay where you are and gain 10 carrots");
                    break;
                case 2:
                    System.out.println("You have chosen to stay where you are an discard 10 carrots");
                    break;
                case 3:
                    System.out.println("You have chosen to take your turn as normal");
                    break;
                default:
                    System.out.println("Invalid Option... Try Again");
                    break;
            }
        }
    }



