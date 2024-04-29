package chess;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The type Test queen. */
public class TestQueen {

  private Queen queen1 = new Queen(3, 2, Color.WHITE);
  private Queen queen2 = new Queen(4, 3, Color.BLACK);

  //  /**
  //   * Test bad constructor.
  //   */
  // @Test
  //  public void testBadConstructor() {
  //    assertThrows(IllegalArgumentException.class, () -> new Queen(-1, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Queen(0, -1, Color.BLACK));
  //    assertThrows(IllegalArgumentException.class, () -> new Queen(8, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Queen(0, 8, Color.BLACK));
  //  }
  //
  //  /**
  //   * Test good constructor.
  //   */
  // @Test
  //  public void testGoodConstructor() {
  //    Queen queen3 = new Queen(5, 2, Color.WHITE);
  //    assertEquals(5, queen3.getRow());
  //    assertEquals(2, queen3.getColumn());
  //    assertEquals(Color.WHITE, queen3.getColor());
  //
  //    Queen queen4 = new Queen(3, 4, Color.BLACK);
  //    assertEquals(3, queen4.getRow());
  //    assertEquals(4, queen4.getColumn());
  //    assertEquals(Color.BLACK, queen4.getColor());
  //  }

  /** Test can move. */
  @Test
  public void testCanMove() {
    // Up-left
    assertTrue(queen1.canMove(5, 0));
    assertTrue(queen2.canMove(6, 1));
    // Up-right
    assertTrue(queen1.canMove(5, 4));
    assertTrue(queen2.canMove(6, 5));

    // Down-left
    assertTrue(queen1.canMove(2, 1));
    assertTrue(queen2.canMove(2, 1));

    // Down-right
    assertTrue(queen1.canMove(2, 3));
    assertTrue(queen2.canMove(2, 5));
  }

  /** Test invalid move. */
  @Test
  public void testInvalidMove() {
    // move outside the board
    assertFalse(queen1.canMove(-1, 3));
    assertFalse(queen2.canMove(4, 8));

    // move to the invalid location
    assertFalse(queen1.canMove(4, 4));
    assertFalse(queen2.canMove(5, 1));
  }

  /** Test not move. */
  @Test
  public void testNotMove() {
    assertFalse(queen1.canMove(3, 2));
    assertFalse(queen2.canMove(4, 3));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {
    // test canKill method from SinglePiece

    // piece can kill the other piece because the location
    assertTrue(queen1.canKill(queen2));
    assertTrue(queen2.canKill(queen1));

    // piece cant kill the other piece because their location
    queen1 = new Queen(3, 3, Color.WHITE);
    queen2 = new Queen(5, 4, Color.BLACK);
    assertFalse(queen1.canKill(queen2));
    assertFalse(queen2.canKill(queen1));

    // piece can't kill the other piece because they are in the same color
    queen1 = new Queen(3, 2, Color.BLACK);
    queen2 = new Queen(5, 4, Color.BLACK);
    assertFalse(queen1.canKill(queen2));
    assertFalse(queen2.canKill(queen1));
  }
}
