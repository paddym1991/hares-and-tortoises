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

    public void intro(){
        System.out.println("**************************************");
        System.out.println("            INTRODUCTION");
        System.out.println("**************************************");
        System.out.println("Players:              2 to 6 (age 13+)");
        System.out.println("Playing time:         45-60 minutes");
        System.out.println("Contents:             1 gameboard\n"
                +"                      6 tokens\n"
                +"	              6 race cards\n"
                +"                      15 hare cards\n"
                +"                      18 lettuce cards\n"
                +"\nCarrot cards in denominations of:\n"
                + "[1, 5, 10, 15, 30, 60]");
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("HARE & TORTOISE is a race game with a\n"
                + "difference. you don't move round the\n"
                + "track by a rolling dice and obeying\n"
                + "instructions, BUT by spending carrots\n"
                + "and spending them wisely. In this game\n"
                + "you can always move as far as you like\n"
                + "so long as you have enough carrots to\n"
                + "pay for it.\n\n"
                + "(You start with 65 carrots and earn \n"
                + "more by landing on certain squares.)\n");
        System.out.println("The catch is that the further you move,\n"
                + "the more you have to pay.\n");
        System.out.println("So players who are ahead too fast, run\n"
                +"out of carrots first and then lose\n"
                + "valuable time trying to get them back.\n"
                + "Meanwhile, those who plod along like\n"
                + "tortoise have so many carrots left that\n"
                + "they stand a good chance of overtaking\n"
                + "the hares.\n");
        System.out.println("The skill of the game lies in choosing\n"
                + "the right square to land on and in\n"
                + "playing the hare or tortoise depending\n"
                + "on your position. The fun in it lies in\n"
                + "changing other players positions by\n"
                + "overtaking them-or even moving backwards\n"
                + "Sometimes it's right to leap ahead.\n"
                + "Sometimes it's best to lag behind.\n"
                + "But all the time it's down to YOU to\n"
                + "make the right decision.\n");
        System.out.println("              Off you go. \n"
                + "    And may the best animal win!\n");
    }

    public void guide(){
        System.out.println("**************************************");
        System.out.println("        QUICK REFERENCE GUIDE");
        System.out.println("**************************************");
        System.out.println("             Rule No. 1");
        System.out.println("You can move forward to any unoccupied\n"
                + "square if you have enough carrots.");
        System.out.println("\n           Number Squares");
        System.out.println("On your next turn check if the number\n"
                + "you are on is the same as your position\n"
                + "in therace. If it is then multiply your\n"
                + "position in the race by 10 and draw that\n"
                + "many Carrot cards. Move on the same turn");
        System.out.println("\n           Carrot Squares");
        System.out.println("Stay as long as you like. Each turn you\n"
                + "miss, collect or pay 10 Carrot cards if\n"
                + "you want to get rid of some.");
        System.out.println("\n           Lettuce Squares");
        System.out.println("You must hold a Lettuce card to land on\n"
                + "this square. Immediately turn your token\n"
                + "upside down. Next turn, discard 1 Lettuce\n"
                + "card and then multiply your position in\n"
                + "the race by 10 and draw that many carrot\n"
                + "cards. Move on next turn, and turn token\n"
                + "right side up");
        System.out.println("\n           Tortoise Squares");
        System.out.println("You can only move backwards to the\n"
                + "nearest Tortoise square if empty.\n"
                + "Immediately collect 10 carrots for each\n"
                + "square you have moved back. Next turn\n"
                + "move on or backwards again-same rules\n"
                + "apply.");
        System.out.println("\n             Hare Squares");
        System.out.println("Draw the top Hare card and follow the\n"
                + "instructions.\n");
    }

    public void ready(){
        System.out.println("**************************************");
        System.out.println("            GETTING READY");
        System.out.println("**************************************");
        System.out.println("Choose a token each and place it on\n"
                + "the board at the START square.\n");
        System.out.println("Each player gets 65 Carrot cards as:\n"
                + ">> one 30,\n"
                + ">>>> one 15,\n"
                + ">>>>>> one 10,\n"
                + ">>>>>>>> two 5's.\n\n"
                + "During play, hold your carrot cards so\n"
                + "that no-one knows exactly how many you\n"
                + "have left.\n");
        System.out.println("Each player also takes three lettuce\n"
                + "cards and a race card. The race card\n"
                + "contains useful information and is \n"
                + "for reference only.\n");
        System.out.println("Seperate the undealt carrot cards and\n"
                + "place them on the board in the number\n"
                + "spaces called The Carrot Patch\n");
        System.out.println("Throughout play, all carrot payments\n"
                + "are made into or out of this patch.\n");
    }

    public void raceCard(){
        System.out.println("**************************************");
        System.out.println("              RACE CARD");
        System.out.println("**************************************");
        System.out.println("Cost of moving: Each square you move\n"
                + "forward on the board costs you carrots\n"
                + "as follows in the list below.");
        System.out.println("=======================================");
        System.out.println("  Squares Moved       Cost in Carrots  ");
        System.out.println("=======================================");
        System.out.println("	1	    	   1");
        System.out.println("	2		   3");
        System.out.println("	3		   6");
        System.out.println("	4          	   10");
        System.out.println(" 	5          	   15");
        System.out.println("	6 		   21");
        System.out.println("	7          	   28");
        System.out.println("  	8          	   36");
        System.out.println("	9                  45");
        System.out.println("	10                 55");
        System.out.println("	11	    	   66");
        System.out.println("	12		   78");
        System.out.println("	13		   91");
        System.out.println("	14          	   105");
        System.out.println(" 	15          	   120");
        System.out.println("	16 		   136");
        System.out.println("	17          	   153");
        System.out.println("  	18          	   171");
        System.out.println("	19                 190");
        System.out.println("	20                 210");
        System.out.println("	22		   253");
        System.out.println("	23		   276");
        System.out.println("	24          	   300");
        System.out.println(" 	25          	   325");
        System.out.println("	26 		   351");
        System.out.println("	27          	   378");
        System.out.println("  	28          	   406");
        System.out.println("	29                 435");
        System.out.println("	30                 465");
        System.out.println("	31	    	   496");
        System.out.println("	32		   528");
        System.out.println("	33		   561");
        System.out.println("	34          	   595");
        System.out.println(" 	35          	   630");
        System.out.println("	36 		   666");
        System.out.println("	37          	   703");
        System.out.println("  	38          	   741");
        System.out.println("	39                 780");
        System.out.println("	40                 820\n");
    }

    public void object(){
        System.out.println("**************************************");
        System.out.println("          OBJECT OF THE GAME");
        System.out.println("**************************************");
        System.out.println("To get your player home first you must:\n"
                + "# Get rid of all your lettuces\n"
                + "  (By landing on lettuce squares)\n\n"
                + "# Not have too many carrots left over \n"
                + "  when you reach home.\n\n"
                + ">> 1st over allowed up to 10 carrots\n"
                + ">> 2nd allowed 20 carrots,\n"
                + ">> 3rd allowed 30 carrots and so on..\n");
    }

    public void move(){
        System.out.println("**************************************");
        System.out.println("             HOW TO MOVE");
        System.out.println("**************************************");
        System.out.println("You may move your player forwards to\n"
                + "any unoccupied square except a \n"
                + "tortoise square. It can be any distance\n"
                + "ahead as long as you have enough\n"
                + "carrots to play the move. The cost is\n"
                + "shown on the race card.\n");
        System.out.println("Later in the game you may move back\n"
                + "instead of forwards, but only to \n"
                + "a tortoise square. Moving backwards\n"
                + "costs nothing--instead, it is a way of\n"
                + "earning carrots, as explained earlier.\n");
    }

    public void home(){
        System.out.println("**************************************");
        System.out.println("             GETTING HOME");
        System.out.println("**************************************");
        System.out.println("You get home by landing on the HOME\n"
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

    public void cantMove(){
        System.out.println("**************************************");
        System.out.println("              CAN'T MOVE");
        System.out.println("**************************************");
        System.out.println("If you cannot make a legal move, say \n"
                + "you ran out of carrots, then you must\n"
                + "start all over again. Place your token\n"
                + "in the start position, restore your\n"
                + "carrot holding to 65 and move off\n"
                + "immediately. You don't have to take\n"
                + "back any lettuce cards.\n");
    }

}
