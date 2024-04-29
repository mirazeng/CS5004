package chess;

/** The type King. */
public class King extends SinglePiece {
  public static final int MOVEMENT = 1;

  /**
   * Instantiates a new King.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public King(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!super.canMove(row, column)) {
      return false;
    }
    // King can move one step in any direction
    if (this.getRow() == row && Math.abs(this.getColumn() - column) == MOVEMENT) {
      return true;
    }
    if (this.getColumn() == column && Math.abs(this.getRow() - row) == MOVEMENT) {
      return true;
    }
    if (Math.abs(this.getRow() - row) == MOVEMENT
        && Math.abs(this.getColumn() - column) == MOVEMENT) {
      return true;
    }
    return false;
  }
}
