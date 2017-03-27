public class Player {
	private int boardPosition = 0;
	private Board board;

	public Player(Board board) {
		this.board = board;
	}

	public int getBoardPosition() {
		return boardPosition;
	}

	public void movePlayer(int numberOfSquares) {
		boardPosition += numberOfSquares;
	}

	public boolean atEnd() {

		return board.atEnd(getBoardPosition()); // the board knows the rules for
												// being at the end of the
												// board.
												// so ask board are we at the
												// end (.atEnd) by giving it our
												// board position
												// (getBoardPosition).
	}

}