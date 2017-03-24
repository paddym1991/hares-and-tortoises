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
                new Square(),   //Square 1
                new Square(),   //Square 2
                new Square(),   //Square 3
                new Square(),   //Square 4
                new Square()    //End square
        );
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }
    public String getPlayerName(int index) { //Could be replaced if the players can have custom names
        return "Player " + (index+1);
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
}
