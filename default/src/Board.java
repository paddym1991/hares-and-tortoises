import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Player> players = new ArrayList<>();
    private List<Square> squares;

    public Board() {    //One player
        players.add(new Player(this));
        loadDefaultBoard();
    }

    public Board(int numPlayers) {
        for (int i=0; i<numPlayers; i++) {
            players.add(new Player(this));
        }
        loadDefaultBoard();
    }

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
    public String getPlayerName(Player player) {return getPlayerName(players.indexOf(player));}
    public String getPlayerName(int index) { //Could be replaced if the players can have custom names
        return "Player " + (index+1);
    }

    public int getRacePosition(Player player) {
        int playersInFront = 0;
        int pos = player.getBoardPosition();
        for( Player rivalPlayer : players) {
            if( rivalPlayer.getBoardPosition() > pos) { playersInFront++; }
        }
        return playersInFront + 1;
    }

    public Square getSquare(int index) {
        return squares.get(index);
    }

    public boolean atEnd(int position) {
        if (position >= squares.size()-1) {
            return true;
        }
        return false;
    }

    public int noOfPlayers() {
        return players.size();
    }

}
