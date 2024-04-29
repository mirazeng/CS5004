package chess;

/** The type Rook. */
public class Rook extends SinglePiece {
  /**
   * Instantiates a new Rook.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Rook(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!super.canMove(row, column)) {
      return false;
    }
    // rock moves horizontally or vertically
    if (row == this.getRow() || column == this.getColumn()) {
      return true;
    }
    return false;
  }
}
