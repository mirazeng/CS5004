package chess;

/** The type Pawn. */
public class Pawn extends SinglePiece {

  public static final int ONE = 1;
  public static final int BLACK_PAWN_INITIAL_ROW = 6;
  public static final int INITIAL_ROW_WHITE_TWO = 2;
  public static final int INITIAL_ROW_WHITE_THREE = 3;
  public static final int INITIAL_ROW_BLACK_FIVE = 5;
  public static final int INITIAL_ROW_BLACK_FOUR = 4;
  public static final int FIRST_ROW = 0;
  public static final int LAST_ROW = 7;

  /**
   * Instantiates a new Pawn.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public Pawn(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
    // white pawn can not be in the first row
    // and the column can not be out of the board
    if (color == Color.WHITE) {
      if (row <= FIRST_ROW || row > LAST_ROW || column < FIRST_ROW || column > LAST_ROW) {
        throw new IllegalArgumentException("Invalid row or column for white pawn");
      }
    }
    // black pawn can not be in the last row
    // and the column can not be out of the board
    if (color == Color.BLACK) {
      if (row < FIRST_ROW || row >= LAST_ROW || column < FIRST_ROW || column > LAST_ROW) {
        throw new IllegalArgumentException("Invalid row or column for black pawn");
      }
    }
  }

  @Override
  public boolean canMove(int row, int column) {
    if (!super.canMove(row, column)) {
      return false;
    }
    // pawn has different color
    if (this.getColor() == Color.WHITE) {
      // initialize the state of white pawn
      if (this.getRow() == ONE) {
        // if the pawn is in the initial state, it can move 1 step
        if (row == INITIAL_ROW_WHITE_TWO && column == this.getColumn()) {
          return true;
        }
        // or it can move 2 steps at its initial state
        if (row == INITIAL_ROW_WHITE_THREE && column == this.getColumn()) {
          return true;
        }
      }
      // if the pawn is not in the initial state, it can only move 1 step
      if (row == this.getRow() + ONE && column == this.getColumn()) {
        return true;
      }
    }
    if (this.getColor() == Color.BLACK) {
      if (this.getRow() == BLACK_PAWN_INITIAL_ROW) {
        // if the pawn is in the initial state, it can move 1 step
        if (row == INITIAL_ROW_BLACK_FIVE && column == this.getColumn()) {
          return true;
        }
        // or it can move 2 steps at its initial state
        if (row == INITIAL_ROW_BLACK_FOUR && column == this.getColumn()) {
          return true;
        }
      }
      // if the pawn is not in the initial state, it can only move 1 step
      if (row == this.getRow() - ONE && column == this.getColumn()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    // make sure the piece is not the same color
    if (piece.getColor() != this.getColor())
      ;
    if (Math.abs(piece.getColumn() - this.getColumn()) == ONE) {
      // if the piece is in the next row, the black pawn can kill the opponent
      if (piece.getRow() == this.getRow() + ONE && this.getColor() == Color.WHITE) {
        return true;
      }
      // if the piece is in the previous row, the white pawn can kill the opponent
      if (piece.getRow() == this.getRow() - ONE && this.getColor() == Color.BLACK) {
        return true;
      }
    }
    return false;
  }
}
