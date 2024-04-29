package chess;

/** The type Bishop. */
public class Bishop extends SinglePiece {
  /**
   * Instantiates a new Bishop.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Bishop(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!super.canMove(row, column)) {
      return false;
    }
    // this piece is moving diagonally
    if (Math.abs(row - this.getRow()) == Math.abs(column - this.getColumn())) {
      return true;
    }
    return false;
  }
}
