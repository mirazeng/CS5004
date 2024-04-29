package chess;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The type Test rook. */
public class TestRook {
  private Rook rook1 = new Rook(0, 7, Color.BLACK);
  private Rook rook2 = new Rook(7, 7, Color.WHITE);
  private final Rook rook3 = new Rook(3, 3, Color.BLACK);

  //  /**
  //   * Test bad constructor.
  //   */
  // @Test
  //  public void testBadConstructor() {
  //    assertThrows(IllegalArgumentException.class, () -> new Rook(-1, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Rook(0, -1, Color.BLACK));
  //    assertThrows(IllegalArgumentException.class, () -> new Rook(8, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Rook(0, 8, Color.BLACK));
  //  }
  //
  //  /**
  //   * Test good constructor.
  //   */
  // @Test
  //  public void testGoodConstructor() {
  //    Rook rook4 = new Rook(5, 2, Color.WHITE);
  //    assertEquals(5, rook4.getRow());
  //    assertEquals(2, rook4.getColumn());
  //    assertEquals(Color.WHITE, rook4.getColor());
  //
  //    Rook rook5 = new Rook(3, 4, Color.BLACK);
  //    assertEquals(3, rook5.getRow());
  //    assertEquals(4, rook5.getColumn());
  //    assertEquals(Color.BLACK, rook5.getColor());
  //  }

  /** Test can move. */
  @Test
  public void testCanMove() {
    // left horizontally
    assertTrue(rook1.canMove(0, 0));
    // right horizontally
    assertTrue(rook3.canMove(3, 6));
    // up vertically
    assertTrue(rook3.canMove(5, 3));
    // down vertically
    assertTrue(rook3.canMove(1, 3));
  }

  /** Test invalid move. */
  @Test
  public void testInvalidMove() {
    // move outside the board
    assertFalse(rook1.canMove(-1, 3));
    assertFalse(rook2.canMove(7, 8));

    // move to the invalid location
    assertFalse(rook1.canMove(1, 1));
    assertFalse(rook2.canMove(6, 6));
  }

  /** Test not move. */
  @Test
  public void testNotMove() {
    assertFalse(rook1.canMove(0, 7));
    assertFalse(rook2.canMove(7, 7));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {
    // test canKill method from SinglePiece

    // piece can kill the other piece because the location
    assertTrue(rook1.canKill(rook2));
    assertTrue(rook2.canKill(rook1));

    // piece cant kill the other piece because their location
    rook1 = new Rook(3, 3, Color.BLACK);
    rook2 = new Rook(5, 4, Color.WHITE);
    assertFalse(rook1.canKill(rook2));
    assertFalse(rook2.canKill(rook1));

    // piece can't kill the other piece because they are in the same color
    rook1 = new Rook(3, 2, Color.WHITE);
    rook2 = new Rook(5, 4, Color.WHITE);
    assertFalse(rook1.canKill(rook2));
    assertFalse(rook2.canKill(rook1));
  }
}
