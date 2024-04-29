package chess;

/** The type Single piece. */
public abstract class SinglePiece implements ChessPiece {
  public static final int FIRST_ROW = 0;
  public static final int LAST_ROW = 7;
  private final int row;
  private final int column;
  private final Color color;

  /**
   * Instantiates a new Single piece.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public SinglePiece(int row, int column, Color color) throws IllegalArgumentException {
    setUpValidation(row, column);
    this.row = row;
    this.column = column;
    this.color = color;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public Color getColor() {
    return this.color;
  }

  /**
   * Test whether a piece can move to target position.
   *
   * @param row the row
   * @param column the column
   * @return boolean the boolean to show valid or not
   */
  @Override
  public boolean canMove(int row, int column) {
    boolean result = false;
    if (row < FIRST_ROW || row > LAST_ROW || column < FIRST_ROW || column > LAST_ROW) {
      result = false;
    } else if (row == this.getRow() && column == this.getColumn()) {
      result = false;
    } else {
      result = true;
    }
    return result;
  }

  /**
   * Instantiates a new Single piece.
   *
   * @param piece the piece to kill
   */
  public boolean canKill(ChessPiece piece) {
    if (piece.getColor() != this.getColor()) {
      return this.canMove(piece.getRow(), piece.getColumn());
    }
    return false;
  }

  private void setUpValidation(int row, int column) throws IllegalArgumentException {
    if (row < FIRST_ROW || row > LAST_ROW || column < FIRST_ROW || column > LAST_ROW) {
      throw new IllegalArgumentException("Invalid row or column");
    }
  }
}
