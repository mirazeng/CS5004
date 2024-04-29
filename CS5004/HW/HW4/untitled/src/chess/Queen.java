package chess;

/** The type Queen. */
public class Queen extends SinglePiece {
  /**
   * Instantiates a new Queen.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Queen(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!super.canMove(row, column)) {
      return false;
    }
    if (row == this.getRow() // move horizontally
        || column == this.getColumn() // move vertically
        || Math.abs(row - this.getRow()) // move diagonally
            == Math.abs(column - this.getColumn())) {
      return true;
    }
    return false;
  }
}
