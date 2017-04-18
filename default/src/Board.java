/**
 * This class handles the collection of Board squares.
 * The details stored include
 * --Name and position of board squares.
 * --Number of players
 *
 *
 * Along with the standard constructors, getters and setters there are methods that :
 *-- List current Race Position
 *-- List current Square
 *-- List number of players playing
 *-- List player name by using the String "Player" followed by the index number
 *-- Display the position of the nearest Tortoise Square
 *
 * @author: Gary Fleming 17/04/2017
 * @version
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Player> players = new ArrayList<>();
    private List<Square> squares;

    /**
     * Constructor for objects of Board Class
     */
    public Board() {    //One player
        players.add(new Player(this));
        loadDefaultBoard();
    }

    /**
     * Adding new players to the board.
     *
     * @param numPlayers
     *              Adding players to the Board
     */
    public Board(int numPlayers) {
        for (int i=0; i<numPlayers; i++) {
            players.add(new Player(this));
        }
        loadDefaultBoard();
    }

    /**
     * This mutator method sets the list of each square on the board
     */
    private void loadDefaultBoard() {
        squares = Arrays.asList(
                new Square(),   //Start square
                new HareSquare(),   //Square 1
                new CarrotSquare(),   //Square 2
                new HareSquare(),   //Square 3
                new NumberSquare(3),   //Square 4
                new CarrotSquare(),     //Square 5
                new HareSquare(),     //Square 6
                new NumberSquare(1,5,6),     //Square 7
                new NumberSquare(2),     //Square 8
                new NumberSquare(4),     //Square 9
                new LettuceSquare(),         //Square 10
                new HareSquare(),     //Square 11
                new NumberSquare(3),     //Square 12
                new CarrotSquare(),     //Square 13
                new HareSquare(),     //Square 14
                new TortoiseSquare(),     //Square 15
                new NumberSquare(1,5,6),     //Square 16
                new NumberSquare(2),     //Square 17
                new NumberSquare(4),     //Square 18
                new TortoiseSquare(),     //Square 19
                new NumberSquare(3),     //Square 20
                new CarrotSquare(),     //Square 21
                new LettuceSquare(),     //Square 22
                new NumberSquare(2),     //Square 23
                new TortoiseSquare(),     //Square 24
                new HareSquare(),     //Square 25
                new CarrotSquare(),     //Square 26
                new NumberSquare(4),     //Square 27
                new NumberSquare(3),     //Square 28
                new NumberSquare(2),     //Square 29
                new TortoiseSquare(),     //Square 30
                new HareSquare(),     //Square 31
                new NumberSquare(1,5,6),     //Square 32
                new CarrotSquare(),     //Square 33
                new HareSquare(),     //Square 34
                new NumberSquare(2),     //Square 35
                new NumberSquare(3),     //Square 36
                new TortoiseSquare(),     //Square 37
                new CarrotSquare(),     //Square 38
                new HareSquare(),     //Square 39
                new CarrotSquare(),     //Square 40
                new NumberSquare(2),     //Square 41
                new LettuceSquare(),     //Square 42
                new TortoiseSquare(),     //Square 43
                new NumberSquare(3),     //Square 44
                new NumberSquare(4),     //Square 45
                new HareSquare(),     //Square 46
                new NumberSquare(2),     //Square 47
                new NumberSquare(1,5,6),     //Square 48
                new CarrotSquare(),     //Square 49
                new TortoiseSquare(),     //Square 50
                new HareSquare(),     //Square 51
                new NumberSquare(3),     //Square 52
                new NumberSquare(2),     //Square 53
                new NumberSquare(4),     //Square 54
                new CarrotSquare(),     //Square 55
                new TortoiseSquare(),     //Square 56
                new LettuceSquare(),     //Square 57
                new HareSquare(),     //Square 58
                new CarrotSquare(),     //Square 59
                new NumberSquare(1,5,6),     //Square 60
                new CarrotSquare(),     //Square 61
                new HareSquare(),     //Square 62
                new CarrotSquare(),     //Square 63
                new EndSquare()    //End square
        );
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Returns The List of players
     * @return the list of players
     */
    public List<Player> getPlayers() {return players;}

    /**
     * Gets the name of the player
     *
     * @param player
     *         The player
     * @return Returns a String containing the name of the players and their indexes
     */
    public String getPlayerName(Player player) {return getPlayerName(players.indexOf(player));}

    /**
     * Returns a String containing the name of the player and its index number
     *
     * @param index
     *         The index number of the player
     * @return String containing the name of the player and its index number
     */
    public String getPlayerName(int index) { //Could be replaced if the players can have custom names
        return "Player " + (index+1);
    }

    /**
     * Gets the players race position
     *
     * @param player
     *         The player
     * @return The number of rival players in front
     */
    public int getRacePosition(Player player) {
        int playersInFront = 0;
        int pos = player.getBoardPosition();
        for( Player rivalPlayer : players) {
            if( rivalPlayer.getBoardPosition() > pos) {
                playersInFront++;
            }
        }
        return playersInFront + 1;
    }

    /**
     * Gets the Square index.
     * @param index
     *         The index number of the square
     * @return The squares index number.
     */
    public Square getSquare(int index) {
        return squares.get(index);
    }

    /**
     * Gets the index number of the square from the squares
     *
     * @param square
     *         The square
     * @return The index of the square
     */
    public int getSquareIndex(Square square) {
        return squares.indexOf(square);
    }

    /**
     * Returns true or false if at the position number at the end
     *
     * @param position
     *         Number of the position
     * @return
     */
    public boolean atEnd(int position) {
        if (position >= squares.size()-1) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of squares
     * @return the number of squares
     */
    public int length() {return squares.size();}

    /**
     * Number of players
     * @return the number of players on the board
     */
    public int noOfPlayers() {
        return players.size();
    }

    /**
     * Gets the closest tortoise available to player
     *
     * @param position
     *                The position where the tortoise square is
     * @return
     */
    public int getClosestTortoise(int position) {
        for (int i = position-1; i > 0; i--) {
            if (getSquare(i) instanceof TortoiseSquare) return i;
        }
        return -1; //Nothing found
    }

    /**
     * Returns Number of players Finished
     * @return number of players finished
     */
    public int noOfPlayersFinished() {
        int result = 0;
        for (Player player : players) {
            if (player.atEnd()) result++;
        }
        return result;
    }

}
