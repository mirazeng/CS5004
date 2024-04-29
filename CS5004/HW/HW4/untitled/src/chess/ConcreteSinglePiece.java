package chess;

/** The type Concrete single piece. */
public class ConcreteSinglePiece extends SinglePiece {
  /**
   * Instantiates a new Concrete single piece.
   *
   * @param row the row
   * @param column the column
   * @param color the color
   */
  public ConcreteSinglePiece(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * canMove checks if the piece move to the given position.
   *
   * @param row the row
   * @param column the column
   * @return the boolean
   * @throws IllegalArgumentException the illegal argument exception
   */
  public boolean canMove(int row, int column) throws IllegalArgumentException {
    return super.canMove(row, column);
  }

  /**
   * canKill checks if the piece can kill the enemy piece.
   *
   * @param piece piece
   * @return the boolean
   */
  public boolean canKill(ChessPiece piece) {
    return super.canKill(piece);
  }

  /**
   * a row getter.
   *
   * @return the row of the piece
   */
  public int getRow() {
    return super.getRow();
  }

  /**
   * a column getter.
   *
   * @return the column of the piece
   */
  public int getColumn() {
    return super.getColumn();
  }

  /**
   * a color getter.
   *
   * @return the color of the piece
   */
  public Color getColor() {
    return super.getColor();
  }
}
