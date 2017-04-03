public class EndSquare extends Square {
    @Override
    public boolean canLandOn(Player player) {
        return (player.getLettuce() == 0
                && player.getCarrots() <= player.getRacePosition() * 10);
    }
}
