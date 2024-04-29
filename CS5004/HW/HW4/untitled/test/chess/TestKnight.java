package chess;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The type Test knight. */
public class TestKnight {

  private Knight knight1 = new Knight(2, 2, Color.WHITE);
  private Knight knight2 = new Knight(5, 7, Color.BLACK);
  private final Knight knight3 = new Knight(3, 3, Color.WHITE);

  //  /**
  //   * Test bad constructor.
  //   */
  // @Test
  //  public void testBadConstructor() {
  //    assertThrows(IllegalArgumentException.class, () -> new Knight(-1, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Knight(0, -1, Color.BLACK));
  //    assertThrows(IllegalArgumentException.class, () -> new Knight(8, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Knight(0, 8, Color.BLACK));
  //  }
  //
  //  /**
  //   * Test good constructor.
  //   */
  // @Test
  //  public void testGoodConstructor() {
  //    Knight knight4 = new Knight(5, 2, Color.WHITE);
  //    assertEquals(5, knight4.getRow());
  //    assertEquals(2, knight4.getColumn());
  //    assertEquals(Color.WHITE, knight4.getColor());
  //
  //    Knight knight5 = new Knight(3, 4, Color.BLACK);
  //    assertEquals(3, knight5.getRow());
  //    assertEquals(4, knight5.getColumn());
  //    assertEquals(Color.BLACK, knight5.getColor());
  //  }

  /** Testcan move. */
  @Test
  public void testcanMove() {
    // move 2 steps in row and 1 step in column
    assertTrue(knight1.canMove(4, 3));
    // move 2 steps in column and 1 step in row
    assertTrue(knight2.canMove(4, 5));

    // upright
    assertTrue(knight3.canMove(5, 4));
    assertTrue(knight3.canMove(4, 5));
    // upleft
    assertTrue(knight3.canMove(5, 2));
    assertTrue(knight3.canMove(4, 1));
    // downright
    assertTrue(knight3.canMove(2, 5));
    assertTrue(knight3.canMove(1, 4));
    // downleft
    assertTrue(knight3.canMove(1, 2));
    assertTrue(knight3.canMove(2, 1));
  }

  /** Test invalid move. */
  @Test
  public void testInvalidMove() {
    // move outside the board
    assertFalse(knight1.canMove(-1, 7));
    assertFalse(knight2.canMove(1, -2));

    // move to the invalid location
    assertFalse(knight1.canMove(3, 3));
    assertFalse(knight2.canMove(6, 6));
  }

  /** Test not move. */
  @Test
  public void testNotMove() {
    assertFalse(knight1.canMove(2, 2));
    assertFalse(knight2.canMove(5, 7));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {
    // test canKill method from SinglePiece

    // piece can't kill the other piece because the location
    assertFalse(knight1.canKill(knight2));
    assertFalse(knight2.canKill(knight1));

    // piece can kill the other piece because their location
    knight1 = new Knight(2, 2, Color.WHITE);
    knight2 = new Knight(4, 3, Color.BLACK);
    assertTrue(knight1.canKill(knight2));
    assertTrue(knight2.canKill(knight1));

    // piece can't kill the other piece because they are in the same color
    knight1 = new Knight(2, 2, Color.WHITE);
    knight2 = new Knight(4, 3, Color.WHITE);
    assertFalse(knight1.canKill(knight2));
    assertFalse(knight2.canKill(knight1));
  }
}
