package chess;

/** The type Knight. */
public class Knight extends SinglePiece {
  public static final int MOVEMENT = 1;
  public static final int MOVEMENT2 = 2;

  /**
   * Instantiates a new Knight.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Knight(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int row, int column) throws IllegalArgumentException {
    if (!super.canMove(row, column)) {
      return false;
    }
    // this piece moves 2 steps in row and 1 step in column
    // or 2 steps in column and 1 step in row
    // above are both move in L shape
    if ((Math.abs(row - this.getRow()) == MOVEMENT2
            && Math.abs(column - this.getColumn()) == MOVEMENT)
        || (Math.abs(row - this.getRow()) == MOVEMENT
            && Math.abs(column - this.getColumn()) == MOVEMENT2)) {
      return true;
    }
    return false;
  }
}
