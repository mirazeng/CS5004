package chess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * The type Test chess piece. In this file, I am using the ConcreteSinglePiece class to test all
 * universal methods (same logic shared by all pieces regardless of their special role) declared in
 * the abstract ChessPiece class, for example, out-of-bound constructor, moving to outside chess
 * board, etc.
 */
public class TestChessPiece {

  /**
   * Test inheritance. This is to ensure that all special chess pieces ARE using universal methods
   * declared in the abstract ChessPiece class. After this confirmation we can ensure that all the
   * shared logic in each special chess pieces are indeed tested, via the testing of
   * ConcreteSinglePiece class.
   */
  @Test
  public void testInheritance() {
    Bishop bishop = new Bishop(1, 0, Color.BLACK);
    assertInstanceOf(ChessPiece.class, bishop);

    King king = new King(2, 3, Color.BLACK);
    assertInstanceOf(ChessPiece.class, king);

    Knight knight = new Knight(3, 4, Color.BLACK);
    assertInstanceOf(ChessPiece.class, knight);

    Pawn pawn = new Pawn(4, 5, Color.BLACK);
    assertInstanceOf(ChessPiece.class, pawn);

    Queen queen = new Queen(5, 6, Color.BLACK);
    assertInstanceOf(ChessPiece.class, queen);

    Rook rook = new Rook(6, 7, Color.BLACK);
    assertInstanceOf(ChessPiece.class, rook);

    ConcreteSinglePiece concreteSinglePiece = new ConcreteSinglePiece(7, 0, Color.BLACK);
    assertInstanceOf(ChessPiece.class, concreteSinglePiece);
  }

  /** Test good constructor. */
  @Test
  public void testGoodConstructor() {
    ChessPiece piece = new ConcreteSinglePiece(0, 0, Color.BLACK);
    assertEquals(0, piece.getRow());
    assertEquals(0, piece.getColumn());
    assertEquals(Color.BLACK, piece.getColor());

    piece = new ConcreteSinglePiece(7, 7, Color.WHITE);
    assertEquals(7, piece.getRow());
    assertEquals(7, piece.getColumn());
    assertEquals(Color.WHITE, piece.getColor());
  }

  /** Test bad constructor. */
  @Test
  public void testBadConstructor() {
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(-1, 0, Color.BLACK));
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(0, -1, Color.BLACK));
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(8, 0, Color.BLACK));
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(0, 8, Color.BLACK));

    assertThrows(
        IllegalArgumentException.class, () -> new ConcreteSinglePiece(-1, -1, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(8, 8, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(8, -1, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new ConcreteSinglePiece(-1, 8, Color.WHITE));
  }

  /** Test can move. */
  @Test
  public void testCanMove() {
    ChessPiece piece = new ConcreteSinglePiece(0, 0, Color.BLACK);
    assertTrue(piece.canMove(1, 1));
    assertFalse(piece.canMove(0, 0));
    assertFalse(piece.canMove(8, 8));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {
    ChessPiece piece1 = new ConcreteSinglePiece(0, 0, Color.BLACK);
    ChessPiece piece2 = new ConcreteSinglePiece(1, 1, Color.WHITE);
    ChessPiece piece3 = new ConcreteSinglePiece(1, 1, Color.BLACK);
    assertTrue(piece1.canKill(piece2));
    assertFalse(piece1.canKill(piece3));
  }

  /** Test get row. */
  @Test
  public void testGetRow() {
    ChessPiece piece = new ConcreteSinglePiece(1, 0, Color.BLACK);
    assertEquals(1, piece.getRow());
  }

  /** Test get column. */
  @Test
  public void testGetColumn() {
    ChessPiece piece = new ConcreteSinglePiece(0, 1, Color.BLACK);
    assertEquals(1, piece.getColumn());
  }

  /** Test get color. */
  @Test
  public void testGetColor() {
    ChessPiece piece = new ConcreteSinglePiece(0, 0, Color.BLACK);
    assertEquals(Color.BLACK, piece.getColor());
    ChessPiece piece2 = new ConcreteSinglePiece(0, 0, Color.WHITE);
    assertEquals(Color.WHITE, piece2.getColor());
  }
}
