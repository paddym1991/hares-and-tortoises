import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Player> players;
    private List<Square> squares;

    public Board() {
        players = Arrays.asList(new Player());
        squares = Arrays.asList(
                new Square(),   //Start square
                new Square(),   //Square 1
                new Square(),   //Square 2
                new Square(),   //Square 3
                new Square()    //Square 4
        );
    }

    public Board(int numPlayers) {
        //TODO: Fill "players" with the right number of Player instances
        squares = new ArrayList<>();
    }
}
