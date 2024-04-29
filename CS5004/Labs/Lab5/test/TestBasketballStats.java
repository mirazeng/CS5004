import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import sports.basketball.BasketballStats;

/**
 * The type Test basketball stats.
 */
public class TestBasketballStats {

  /**
   * Test stats constructor.
   */
  @Test
  public void testStatsConstructor() {
    BasketballStats testStats = new BasketballStats(21.5, 10.0, 5.5);

    assertEquals(21.5, testStats.getPointsPerGame());
    assertEquals(10.0, testStats.getReboundsPerGame());
    assertEquals(5.5, testStats.getAssistsPerGame());

  }

  /**
   * Test stats equals.
   */
  @Test
  public void testStatsEquals() {
    BasketballStats testStats1 = new BasketballStats(20.5, 10.5, 10.0);
    BasketballStats testStats2 = new BasketballStats(20.5, 10.5, 10.0);

    BasketballStats testStats3 = new BasketballStats(40.5, 23.2, 5.0);

    assertEquals(testStats1, testStats1);
    assertEquals(testStats2, testStats1);

    assertNotEquals(testStats1, testStats3);
    assertNotEquals("String class", testStats1);
  }

}