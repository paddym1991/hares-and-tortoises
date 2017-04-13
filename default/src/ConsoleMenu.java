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
        GameController.println("**************************************");
        GameController.println("                WELCOME");
        GameController.println("                  TO");
        GameController.println("          THE HARE & TORTOISE");
        GameController.println("                 GAME");
        GameController.println("**************************************");
        GameController.println("        Press ENTER to continue");
        GameController.getInput("");
        runMenu();
    }

    public int mainMenu(){
        GameController.println("**************************************");
        GameController.println("*********** MENU SELECTION ***********");
        GameController.println("======================================");
        GameController.println("| Select and Press Enter:            |");
        GameController.println("|   1) Introduction                  |");
        GameController.println("|     2) Quick Reference Guide       |");
        GameController.println("|       3) Getting Ready             |");
        GameController.println("|        4) Race Card                |");
        GameController.println("|         5) Object of the Game      |");
        GameController.println("|          6) How to Move            |");
        GameController.println("|           7) Getting Home          |");
        GameController.println("|            8) Can't Move           |");
        GameController.println("|             9) LETS PLAY THE GAME  |");
        GameController.println("|              0) Exit               |");
        GameController.println("+************************************+");
        return GameController.getPosInt("> ");
    }

    public void runMenu()
    {
        int option = mainMenu();
        while (option != 0)
        {
            switch (option)
            {
                case 1:
                    Introduction.intro();
                    break;
                case 2:
                     Introduction.guide();
                    break;
                case 3:
                    Introduction.ready();
                    break;
                case 4:
                    Introduction.raceCard();
                    break;
                case 5:
                    Introduction.object();
                    break;
                case 6:
                    Introduction.move();
                    break;
                case 7:
                    Introduction.home();
                    break;
                case 8:
                    Introduction.cantMove();
                    break;
                case 9:
                    new GameController();
                    break;
                default:
                    GameController.printlnErr(">>>>>>>>>>> INVALID OPTION <<<<<<<<<<<\n");
                    GameController.println("           Please try again\n");
                    break;
            }
            GameController.println("======================================");
            GameController.println("Press \"Enter\" to Return to Main Menu");
            GameController.println("======================================\n\n");
            option = mainMenu();
        }
        GameController.println("\n**************************************");
        GameController.println(">>> Hope to see you back here soon <<<");
        GameController.println("**************************************\n");
        System.exit(0);
    }

}





