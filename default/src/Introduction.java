/**
 * The Introduction pages to the game
 * Quick Reference Guide
 * Getting Ready
 * Race Card
 * Objectives of the Game
 * How to Move
 * Getting Home
 * Can't Move
 */

public class Introduction{

    public static void intro(){
        GameController.println("**************************************");
        GameController.println("            INTRODUCTION");
        GameController.println("**************************************");
        GameController.println("Players:              2 to 6 (age 13+)");
        GameController.println("Playing time:         45-60 minutes");
        GameController.println("Contents:             1 gameboard\n"
                +"                      6 tokens\n"
                +"	                  6 race cards\n"
                +"                      15 hare cards\n"
                +"                      18 lettuce cards\n"
                +"\nCarrot cards in denominations of:\n"
                + "[1, 5, 10, 15, 30, 60]");
        GameController.println("======================================");
        GameController.println("======================================");
        GameController.println("HARE & TORTOISE is a race game with a\n"
                + "difference. you don't move round the\n"
                + "track by a rolling dice and obeying\n"
                + "instructions, BUT by spending carrots\n"
                + "and spending them wisely. In this game\n"
                + "you can always move as far as you like\n"
                + "so long as you have enough carrots to\n"
                + "pay for it.\n\n"
                + "(You start with 65 carrots and earn \n"
                + "more by landing on certain squares.)\n");
        GameController.println("The catch is that the further you move,\n"
                + "the more you have to pay.\n");
        GameController.println("So players who are ahead too fast, run\n"
                +"out of carrots first and then lose\n"
                + "valuable time trying to get them back.\n"
                + "Meanwhile, those who plod along like\n"
                + "tortoise have so many carrots left that\n"
                + "they stand a good chance of overtaking\n"
                + "the hares.\n");
        GameController.println("The skill of the game lies in choosing\n"
                + "the right square to land on and in\n"
                + "playing the hare or tortoise depending\n"
                + "on your position. The fun in it lies in\n"
                + "changing other players positions by\n"
                + "overtaking them-or even moving backwards\n"
                + "Sometimes it's right to leap ahead.\n"
                + "Sometimes it's best to lag behind.\n"
                + "But all the time it's down to YOU to\n"
                + "make the right decision.\n");
        GameController.println("              Off you go. \n"
                + "    And may the best animal win!\n");
    }

    public static void guide(){
        GameController.println("**************************************");
        GameController.println("        QUICK REFERENCE GUIDE");
        GameController.println("**************************************");
        GameController.println("             Rule No. 1");
        GameController.println("You can move forward to any unoccupied\n"
                + "square if you have enough carrots.");
        GameController.println("\n           Number Squares");
        GameController.println("On your next turn check if the number\n"
                + "you are on is the same as your position\n"
                + "in therace. If it is then multiply your\n"
                + "position in the race by 10 and draw that\n"
                + "many Carrot cards. Move on the same turn");
        GameController.println("\n           Carrot Squares");
        GameController.println("Stay as long as you like. Each turn you\n"
                + "miss, collect or pay 10 Carrot cards if\n"
                + "you want to get rid of some.");
        GameController.println("\n           Lettuce Squares");
        GameController.println("You must hold a Lettuce card to land on\n"
                + "this square. Immediately turn your token\n"
                + "upside down. Next turn, discard 1 Lettuce\n"
                + "card and then multiply your position in\n"
                + "the race by 10 and draw that many carrot\n"
                + "cards. Move on next turn, and turn token\n"
                + "right side up");
        GameController.println("\n           Tortoise Squares");
        GameController.println("You can only move backwards to the\n"
                + "nearest Tortoise square if empty.\n"
                + "Immediately collect 10 carrots for each\n"
                + "square you have moved back. Next turn\n"
                + "move on or backwards again-same rules\n"
                + "apply.");
        GameController.println("\n             Hare Squares");
        GameController.println("Draw the top Hare card and follow the\n"
                + "instructions.\n");
    }

    public static void ready(){
        GameController.println("**************************************");
        GameController.println("            GETTING READY");
        GameController.println("**************************************");
        GameController.println("Choose a token each and place it on\n"
                + "the board at the START square.\n");
        GameController.println("Each player gets 65 Carrot cards as:\n"
                + ">> one 30,\n"
                + ">>>> one 15,\n"
                + ">>>>>> one 10,\n"
                + ">>>>>>>> two 5's.\n\n"
                + "During play, hold your carrot cards so\n"
                + "that no-one knows exactly how many you\n"
                + "have left.\n");
        GameController.println("Each player also takes three lettuce\n"
                + "cards and a race card. The race card\n"
                + "contains useful information and is \n"
                + "for reference only.\n");
        GameController.println("Seperate the undealt carrot cards and\n"
                + "place them on the board in the number\n"
                + "spaces called The Carrot Patch\n");
        GameController.println("Throughout play, all carrot payments\n"
                + "are made into or out of this patch.\n");
    }

    /*
    public static void raceCard(){
        GameController.println("**************************************");
        GameController.println("              RACE CARD");
        GameController.println("**************************************");
        GameController.println("Cost of moving: Each square you move\n"
                + "forward on the board costs you carrots\n"
                + "as follows in the list below.");
        GameController.println("=======================================");
        GameController.println("  Squares Moved       Cost in Carrots  ");
        GameController.println("=======================================");
        GameController.println("	1	    	   1");
        GameController.println("	2		       3");
        GameController.println("	3		       6");
        GameController.println("	4          	   10");
        GameController.println(" 	5          	   15");
        GameController.println("	6 		       21");
        GameController.println("	7          	   28");
        GameController.println("  	8          	   36");
        GameController.println("	9              45");
        GameController.println("	10             55");
        GameController.println("	11	    	   66");
        GameController.println("	12		       78");
        GameController.println("	13		       91");
        GameController.println("	14         	   105");
        GameController.println(" 	15         	   120");
        GameController.println("	16 	    	   136");
        GameController.println("	17         	   153");
        GameController.println("  	18         	   171");
        GameController.println("	19             190");
        GameController.println("	20             210");
        GameController.println("	22		       253");
        GameController.println("	23		       276");
        GameController.println("	24             300");
        GameController.println(" 	25         	   325");
        GameController.println("	26 		       351");
        GameController.println("	27             378");
        GameController.println("  	28         	   406");
        GameController.println("	29             435");
        GameController.println("	30                 465");
        GameController.println("	31	    	   496");
        GameController.println("	32		   528");
        GameController.println("	33		   561");
        GameController.println("	34          	   595");
        GameController.println(" 	35          	   630");
        GameController.println("	36 		   666");
        GameController.println("	37          	   703");
        GameController.println("  	38          	   741");
        GameController.println("	39                 780");
        GameController.println("	40                 820\n");
    }
    */

    public static void raceCard() {
        GameController.println("**************************************");
        GameController.println("**********    Race Card       ********");
        GameController.println("**************************************");
        GameController.println("|Cost of moving: Each square you move|\n"
                         + "|   forward on the board costs you   |\n"
                         + "|        carrots as follows:         |");
        GameController.println("======================================");
        GameController.println("|   Squares Moved | Cost in Carrots  |");
        GameController.println("|         1       |       1          |");
        GameController.println("|         2       |       3          |");
        GameController.println("|         3       |       6          |");
        GameController.println("|         4       |       10         |");
        GameController.println("|         5       |       15         |");
        GameController.println("|         6       |       21         |");
        GameController.println("|         7       |       28         |");
        GameController.println("|         8       |       36         |");
        GameController.println("|         9       |       45         |");
        GameController.println("|         10      |       55         |");
        GameController.println("|         11      |       66         |");
        GameController.println("|         12      |       78         |");
        GameController.println("|         13      |       91         |");
        GameController.println("|         14      |       105        |");
        GameController.println("|         15      |       120        |");
        GameController.println("|         16      |       136        |");
        GameController.println("|         17      |       153        |");
        GameController.println("|         18      |       171        |");
        GameController.println("|         19      |       190        |");
        GameController.println("|         20      |       210        |");
        GameController.println("|         21      |       231        |");
        GameController.println("|         22      |       253        |");
        GameController.println("|	      23	  |	      276        |");
        GameController.println("|      	  24      |       300        |");
        GameController.println("|      	  25      |   	  325        |");
        GameController.println("|   	  26 	  |	      351        |");
        GameController.println("|	      27      |       378        |");
        GameController.println("|  	      28      |   	  406        |");
        GameController.println("|	      29      |       435        |");
        GameController.println("|	      30      |       465        |");
        GameController.println("|	      31	  |  	  496        |");
        GameController.println("|	      32	  |	      528        |");
        GameController.println("|	      33	  |	      561        |");
        GameController.println("|	      34      |    	  595        |");
        GameController.println("|	      35      |    	  630        |");
        GameController.println("|	      36 	  |	      666        |");
        GameController.println("|	      37      |    	  703        |");
        GameController.println("|  	      38      |    	  741        |");
        GameController.println("|	      39      |       780        |");
        GameController.println("|	      40      |       820        |");
        GameController.println("|                                    |");
        GameController.println("+************************************+");
    }

    public static void object(){
        GameController.println("**************************************");
        GameController.println("          OBJECT OF THE GAME");
        GameController.println("**************************************");
        GameController.println("To get your player home first you must:\n"
                + "# Get rid of all your lettuces\n"
                + "  (By landing on lettuce squares)\n\n"
                + "# Not have too many carrots left over \n"
                + "  when you reach home.\n\n"
                + ">> 1st over allowed up to 10 carrots\n"
                + ">> 2nd allowed 20 carrots,\n"
                + ">> 3rd allowed 30 carrots and so on..\n");
    }

    public static void move(){
        GameController.println("**************************************");
        GameController.println("             HOW TO MOVE");
        GameController.println("**************************************");
        GameController.println("You may move your player forwards to\n"
                + "any unoccupied square except a \n"
                + "tortoise square. It can be any distance\n"
                + "ahead as long as you have enough\n"
                + "carrots to play the move. The cost is\n"
                + "shown on the race card.\n");
        GameController.println("Later in the game you may move back\n"
                + "instead of forwards, but only to \n"
                + "a tortoise square. Moving backwards\n"
                + "costs nothing--instead, it is a way of\n"
                + "earning carrots, as explained earlier.\n");
    }

    public static void home(){
        GameController.println("**************************************");
        GameController.println("             GETTING HOME");
        GameController.println("**************************************");
        GameController.println("You get home by landing on the HOME\n"
                + "flag beyond the last square and making\n"
                + "the required payment. You may NOT reach\n"
                + "home if you have any lettuces left over\n"
                + "OR if you have too many carrots after\n"
                + "paying for the last move as explained\n"
                + "in the OBJECT OF THE GAME.... If the \n"
                + "others wish to play for positions, the \n"
                + "player who reached home first remains\n"
                + "in the first position as far as the \n"
                + "others are concerned.\n\n"
                + "Thus in a four player game the player\n"
                + "in the rear is always 4th, no matter\n"
                + "how many others have reached home.\n\n"
                + "It is important to remember this when\n"
                + "using lettuce and number squares.\n");
    }

    public static void cantMove(){
        GameController.println("**************************************");
        GameController.println("              CAN'T MOVE");
        GameController.println("**************************************");
        GameController.println("If you cannot make a legal move, say \n"
                + "you ran out of carrots, then you must\n"
                + "start all over again. Place your token\n"
                + "in the start position, restore your\n"
                + "carrot holding to 65 and move off\n"
                + "immediately. You don't have to take\n"
                + "back any lettuce cards.\n");
    }

}
