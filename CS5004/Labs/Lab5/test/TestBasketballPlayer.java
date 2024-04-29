import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import sports.IPlayer;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;


/**
 * The type Test basketball player.
 */
public class TestBasketballPlayer {

  /**
   * Test player constructor.
   */
  @Test
  public void testPlayerConstructor() {

    BasketballPlayer kobe = new BasketballPlayer("Kobe Bryant", 24, 200.0,
            new BasketballStats(50.0, 20.0, 5.0));

    assertEquals("Kobe Bryant", kobe.getName());
    assertEquals(24, kobe.getAge());
    assertEquals(200.0, kobe.getHeight());
    assertEquals(kobe.getStats(), new BasketballStats(50.0, 20.0, 5.0));
  }

  /**
   * Test player copy constructor.
   */
  @Test
  public void testPlayerCopyConstructor() {
    BasketballStats testStats = new BasketballStats(20.0, 20.0, 10.0);
    BasketballPlayer lonzoBall = new BasketballPlayer("Lonzo Ball", 20, 190.0, testStats);

    BasketballPlayer lonzoBallCopy = new BasketballPlayer(lonzoBall);
    assertEquals("Lonzo Ball", lonzoBallCopy.getName());
    assertEquals(20, lonzoBallCopy.getAge());
    assertEquals(190.0, lonzoBallCopy.getHeight());
    assertEquals(testStats, lonzoBallCopy.getStats());

    assertEquals(lonzoBall, lonzoBallCopy);

  }

  /**
   * Test same player.
   */
  @Test
  public void testSamePlayer() {

    BasketballStats testStats2 = new BasketballStats(30.0, 11.11, 5.5);
    BasketballStats testStats3 = new BasketballStats(40.0, 5.0, 12.0);

    BasketballPlayer testPlayer1 = new BasketballPlayer("Test Player", 15, 210.5, testStats2);
    BasketballPlayer testPlayer2 = new BasketballPlayer("Test Playa", 15, 210.5, testStats3);
    BasketballPlayer testPlayer3 = new BasketballPlayer("Test Player", 50, 210.5, testStats2);
    BasketballPlayer testPlayer4 = new BasketballPlayer("Test Player", 15, 220.0, testStats2);

    // Testing when two players are not the same person
    assertNotEquals(testPlayer1, testPlayer2);
    assertNotEquals(testPlayer1, testPlayer3);
    assertNotEquals(testPlayer1, testPlayer4);

    // Testing when two players ARE the same person
    BasketballPlayer testPlayer5 = new BasketballPlayer("Test Player", 15, 210.5, testStats2);
    assertEquals(testPlayer5, testPlayer1);
    // Stats do not affect whether players are the same
    BasketballPlayer testPlayer6 = new BasketballPlayer("Test Player", 15, 210.5, testStats3);
    assertEquals(testPlayer6, testPlayer1);

    // Testing if class comparison works
    IPlayer testPlayer7 = new BasketballPlayer("Test Player", 15, 210.5, testStats3);
    assertEquals(testPlayer7, testPlayer1);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    BasketballStats testStats = new BasketballStats(30.0, 11.11, 5.5);
    BasketballPlayer testPlayer = new BasketballPlayer("Test Player", 15, 210.5, testStats);
    assertEquals("Name: Test Player,"
                    + " Age: 15,"
                    + " Height: 210.5;"
                    + " Stats: Points per game: 30.0,"
                    + " Rebounds per game: 11.11,"
                    + " Assists per game: 5.5",
            testPlayer.toString());
  }

}