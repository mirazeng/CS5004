package chess;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The type Test bishop. */
public class TestBishop {

  private Bishop bishop1 = new Bishop(3, 2, Color.WHITE);
  private Bishop bishop2 = new Bishop(4, 3, Color.BLACK);

  //  /**
  //   * Test bad constructor.
  //   */
  // @Test
  //  public void testBadConstructor() {
  //    assertThrows(IllegalArgumentException.class, () -> new Bishop(-1, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Bishop(0, -1, Color.BLACK));
  //    assertThrows(IllegalArgumentException.class, () -> new Bishop(8, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Bishop(0, 8, Color.BLACK));
  //  }
  //
  //  /**
  //   * Test good constructor.
  //   */
  // @Test
  //  public void testGoodConstructor() {
  //    Bishop bishop3 = new Bishop(5, 2, Color.WHITE);
  //    assertEquals(5, bishop3.getRow());
  //    assertEquals(2, bishop3.getColumn());
  //    assertEquals(Color.WHITE, bishop3.getColor());
  //
  //    Bishop bishop4 = new Bishop(3, 4, Color.BLACK);
  //    assertEquals(3, bishop4.getRow());
  //    assertEquals(4, bishop4.getColumn());
  //    assertEquals(Color.BLACK, bishop4.getColor());
  //  }

  /** Test can move. */
  @Test
  public void testCanMove() {
    // move to the left bottom
    assertTrue(bishop1.canMove(2, 1));
    assertTrue(bishop2.canMove(3, 2));

    // move to the right bottom
    assertTrue(bishop1.canMove(2, 3));
    assertTrue(bishop2.canMove(5, 2));

    // move to the left top
    assertTrue(bishop1.canMove(4, 1));
    assertTrue(bishop2.canMove(3, 4));

    // move to the right top
    assertTrue(bishop1.canMove(4, 3));
    assertTrue(bishop2.canMove(5, 4));
  }

  /** Test invalid move. */
  @Test
  public void testInvalidMove() {

    // move outside the board
    assertFalse(bishop1.canMove(-1, 3));
    assertFalse(bishop2.canMove(4, -1));

    // move to the invalid location
    assertFalse(bishop1.canMove(3, 3));
    assertFalse(bishop1.canMove(3, 1));

    assertFalse(bishop1.canMove(4, 2));
    assertFalse(bishop1.canMove(2, 2));

    assertFalse(bishop2.canMove(4, 4));
    assertFalse(bishop2.canMove(2, 2));

    assertFalse(bishop2.canMove(5, 3));
    assertFalse(bishop2.canMove(3, 3));
  }

  /** Test not move. */
  @Test
  public void testNotMove() {
    assertFalse(bishop1.canMove(3, 2));
    assertFalse(bishop2.canMove(4, 3));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {
    // test canKill method from SinglePiece

    // piece can kill the other piece because the location
    assertTrue(bishop1.canKill(bishop2));
    assertTrue(bishop2.canKill(bishop1));

    // piece cant kill the other piece because their location
    bishop1 = new Bishop(3, 3, Color.WHITE);
    bishop2 = new Bishop(5, 4, Color.BLACK);
    assertFalse(bishop1.canKill(bishop2));
    assertFalse(bishop2.canKill(bishop1));

    // piece can't kill the other piece because they are in the same color
    bishop1 = new Bishop(3, 2, Color.BLACK);
    bishop2 = new Bishop(5, 4, Color.BLACK);
    assertFalse(bishop1.canKill(bishop2));
    assertFalse(bishop2.canKill(bishop1));
  }
}
