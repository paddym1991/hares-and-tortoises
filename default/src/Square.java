public class Square {

    public Square() {
        //
    }

    public boolean canLandOn(Player player) {
        Board board = player.getBoard();
        for (Player p : player.getBoard().getPlayers()) {
            if (board.getSquare(p.getBoardPosition()) == this) return false;
        }
        return true;
    }

    public void onLandOn(Player player) {
        //Do nothing
    }

    public void onTurnStart(Player player) {
        //Do nothing
    }
}
