package chess;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** The type Test pawn. */
public class TestPawn {
  private Pawn pawn1 = new Pawn(1, 1, Color.WHITE);
  private Pawn pawn2 = new Pawn(6, 1, Color.BLACK);

  /**
   * Test royal row pawn.
   *
   * @throws IllegalArgumentException the illegal argument exception
   */
  @Test
  public void testRoyalRowPawn() throws IllegalArgumentException {
    assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 1, Color.WHITE));
    assertThrows(IllegalArgumentException.class, () -> new Pawn(7, 1, Color.BLACK));
  }

  //  /**
  //   * Test bad constructor.
  //   */
  // @Test
  //  public void testBadConstructor() {
  //    assertThrows(IllegalArgumentException.class, () -> new Pawn(-1, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Pawn(0, -1, Color.BLACK));
  //    assertThrows(IllegalArgumentException.class, () -> new Pawn(8, 0, Color.WHITE));
  //    assertThrows(IllegalArgumentException.class, () -> new Pawn(0, 8, Color.BLACK));
  //  }
  //
  //  /**
  //   * Test good constructor.
  //   */
  // @Test
  //  public void testGoodConstructor() {
  //    Pawn pawn4 = new Pawn(5, 2, Color.WHITE);
  //    assertEquals(5, pawn4.getRow());
  //    assertEquals(2, pawn4.getColumn());
  //    assertEquals(Color.WHITE, pawn4.getColor());
  //
  //    Pawn pawn5 = new Pawn(3, 4, Color.BLACK);
  //    assertEquals(3, pawn5.getRow());
  //    assertEquals(4, pawn5.getColumn());
  //    assertEquals(Color.BLACK, pawn5.getColor());
  //  }

  /** Test can move. */
  @Test
  public void testCanMove() {

    // white pawn in initial state
    assertTrue(pawn1.canMove(2, 1));
    assertTrue(pawn1.canMove(3, 1));

    // black pawn in initial state
    assertTrue(pawn2.canMove(5, 1));
    assertTrue(pawn2.canMove(4, 1));

    // white pawn not in initial state
    Pawn tempPawn1 = new Pawn(3, 3, Color.WHITE);
    assertTrue(tempPawn1.canMove(4, 3));

    // black pawn not in initial state
    Pawn tempPawn2 = new Pawn(4, 2, Color.BLACK);
    assertTrue(tempPawn2.canMove(3, 2));
  }

  /** Test invalid move. */
  @Test
  public void testInvalidMove() {
    // move outside the board
    assertFalse(pawn1.canMove(-1, 3));
    assertFalse(pawn2.canMove(6, 8));

    // move to the invalid location
    assertFalse(pawn1.canMove(1, 3));
    assertFalse(pawn2.canMove(7, 2));
  }

  /** Test not move. */
  @Test
  public void testNotMove() {
    assertFalse(pawn1.canMove(1, 1));
    assertFalse(pawn2.canMove(6, 1));
  }

  /** Test can kill. */
  @Test
  public void testCanKill() {
    // test canKill method from SinglePiece

    // piece can kill the other piece because the location
    Pawn tempPawn1 = new Pawn(2, 2, Color.WHITE);
    Pawn tempPawn2 = new Pawn(3, 3, Color.BLACK);
    assertTrue(tempPawn1.canKill(tempPawn2));
    assertTrue(tempPawn2.canKill(tempPawn1));

    // piece cant kill the other piece because their location
    pawn1 = new Pawn(3, 3, Color.WHITE);
    pawn2 = new Pawn(5, 4, Color.BLACK);
    assertFalse(pawn1.canKill(pawn2));
    assertFalse(pawn2.canKill(pawn1));

    // piece can't kill the other piece because they are in the same color
    pawn1 = new Pawn(3, 2, Color.BLACK);
    pawn2 = new Pawn(5, 4, Color.BLACK);
    assertFalse(pawn1.canKill(pawn2));
    assertFalse(pawn2.canKill(pawn1));
  }
}
