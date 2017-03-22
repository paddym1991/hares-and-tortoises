import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Player> players;
    private List<Square> squares;

    public Board() {
        players = new ArrayList<>();
        squares = new ArrayList<>();
    }
}
