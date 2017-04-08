/**
 * The Welcome page to the console game
 * Has a selection of options of the game
 *
 */

import java.util.Scanner;

public class ConsoleMenu{

    private Scanner input;

    public static void main(String []args) {
        new ConsoleMenu();
    }

    public ConsoleMenu(){
        System.out.println("**************************************");
        System.out.println("                WELCOME");
        System.out.println("                  TO");
        System.out.println("          THE HARE & TORTOISE");
        System.out.println("                 GAME");
        System.out.println("**************************************");
        input = new Scanner(System.in);
        System.out.println("        Press ENTER to continue");
        input.nextLine();
        runMenu();
    }

    public int mainMenu(){
        System.out.println("**************************************");
        System.out.println("*********** MENU SELECTION ***********");
        System.out.println("======================================");
        System.out.println("| Select and Press Enter:            |");
        System.out.println("|   1) Introduction                  |");
        System.out.println("|     2) Quick Reference Guide       |");
        System.out.println("|       3) Getting Ready             |");
        System.out.println("|        4) Race Card                |");
        System.out.println("|         5) Object of the Game      |");
        System.out.println("|          6) How to Move            |");
        System.out.println("|           7) Getting Home          |");
        System.out.println("|            8) Can't Move           |");
        System.out.println("|             9) LETS PLAY THE GAME  |");
        System.out.println("|              0) Exit               |");
        System.out.println("+************************************+");
        return input.nextInt();
    }

    public void runMenu()
    {
        int option = mainMenu();
        while (option != 0)
        {
            switch (option)
            {
                case 1:
                    new Introduction().intro();
                    break;
                case 2:
                    new Introduction().guide();
                    break;
                case 3:
                    new Introduction().ready();
                    break;
                case 4:
                    new Introduction().raceCard();
                    break;
                case 5:
                    new Introduction().object();
                    break;
                case 6:
                    new Introduction().move();
                    break;
                case 7:
                    new Introduction().home();
                    break;
                case 8:
                    new Introduction().cantMove();
                    break;
                case 9:
                    new GameController();
                    break;
                default:
                    System.out.println(">>>>>>>>>>> INVALID OPTION <<<<<<<<<<<\n");
                    System.out.println("           Please try again\n");
                    break;
            }
            System.out.println("======================================");
            System.out.println("Press \"Enter\" to Return to Main Menu");
            System.out.println("======================================\n\n");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("\n**************************************");
        System.out.println(">>> Hope to see you back here soon <<<");
        System.out.println("**************************************\n");
        System.exit(0);
    }
}





