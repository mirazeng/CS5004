package chess;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The type Test king. */
public class TestKing {

  private King king1 = new King(0, 2, Color.WHITE);
  private King king2 = new King(4, 3, Color.BLACK);

  //  /**
  //   * Test bad constructor.
  //   */
  // @Test
  //  public void testBadConstructor() {
  //    assertThrows(IllegalArgumentException.class, () -> new King(-1, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new King(0, -1, Color.BLACK));
  //    assertThrows(IllegalArgumentException.class, () -> new King(8, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new King(0, 8, Color.BLACK));
  //  }
  //
  //  /**
  //   * Test good constructor.
  //   */
  // @Test public void testGoodConstructor() {
  //    King king3 = new King(5, 2, Color.WHITE);
  //    assertEquals(5, king3.getRow());
  //    assertEquals(2, king3.getColumn());
  //    assertEquals(Color.WHITE, king3.getColor());
  //
  //    King king4 = new King(3, 4, Color.BLACK);
  //    assertEquals(3, king4.getRow());
  //    assertEquals(4, king4.getColumn());
  //    assertEquals(Color.BLACK, king4.getColor());
  //  }

  /** Test can move. */
  @Test
  public void testCanMove() {
    // move normally
    assertTrue(king1.canMove(1, 1));
    assertTrue(king2.canMove(3, 2));

    // move to the same column
    assertTrue(king1.canMove(0, 3));
    assertTrue(king1.canMove(1, 3));
    assertTrue(king1.canMove(1, 2));
    assertTrue(king1.canMove(1, 1));

    // move to the same row
    assertTrue(king2.canMove(5, 4));
    assertTrue(king2.canMove(4, 4));

    // move to the diagonal
    assertTrue(king2.canMove(5, 4));
    assertTrue(king2.canMove(3, 2));
    assertTrue(king2.canMove(5, 2));
    assertTrue(king2.canMove(3, 4));
  }

  /** Test invalid move. */
  @Test
  public void testInvalidMove() {
    // move outside the board
    assertFalse(king1.canMove(-1, 3));
    assertFalse(king2.canMove(4, 8));

    // move to the invalid location
    assertFalse(king1.canMove(3, 2)); // up
    assertFalse(king2.canMove(6, 3)); // up
    assertFalse(king2.canMove(2, 3)); // down

    assertFalse(king1.canMove(0, 0)); // left
    assertFalse(king2.canMove(4, 5)); // right

    assertFalse(king1.canMove(1, 4)); // diagonal right up
    assertFalse(king2.canMove(2, 1)); // diagonal right down

    assertFalse(king2.canMove(2, 5)); // diagonal left up
    assertFalse(king2.canMove(6, 0)); // diagonal left down
  }

  /** Test not move. */
  @Test
  public void testNotMove() {
    assertFalse(king1.canMove(0, 2));
    assertFalse(king2.canMove(4, 3));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {

    // piece can kill the other piece because the location
    king1 = new King(3, 2, Color.WHITE);
    king2 = new King(4, 3, Color.BLACK);
    assertTrue(king1.canKill(king2));
    assertTrue(king2.canKill(king1));

    // piece cant kill the other piece because their location
    king1 = new King(3, 3, Color.WHITE);
    king2 = new King(5, 4, Color.BLACK);
    assertFalse(king1.canKill(king2));
    assertFalse(king2.canKill(king1));

    // piece can't kill the other piece because they are in the same color
    king1 = new King(3, 2, Color.BLACK);
    king2 = new King(5, 4, Color.BLACK);
    assertFalse(king1.canKill(king2));
    assertFalse(king2.canKill(king1));
  }
}
