public class EndSquare extends Square {
    @Override
    public boolean canLandOn(Player player) {
        return player.getLettuce() == 0
                && player.getCarrots() - Player.costToMove(player.getBoard().getSquareIndex(this) - player.getBoardPosition())
                <= (player.getBoard().noOfPlayersFinished()+1) * 10;
    }
}
