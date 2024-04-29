import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballPlayerComparator;
import sports.basketball.BasketballStats;


/**
 * The type Test basketball player comparator.
 */
public class TestBasketballPlayerComparator {

  /**
   * Test player comparator.
   */
  @Test
  public void testPlayerComparator() {
    BasketballStats statsHigh = new BasketballStats(20.0, 20.0, 20.0);
    BasketballStats statsLow = new BasketballStats(10.0, 10.0, 10.0);

    BasketballPlayer superStar = new BasketballPlayer("Super Star", 22, 220.0, statsHigh);
    BasketballPlayer rookie = new BasketballPlayer("Rookie Mcroy", 19, 200.0, statsLow);

    BasketballPlayerComparator comparator = new BasketballPlayerComparator();

    assertEquals(1, comparator.compare(superStar, rookie));
    assertEquals(-1, comparator.compare(rookie, superStar));

    BasketballPlayer kobeBryant = new BasketballPlayer("Kobe Bryant", 22, 220.0, statsHigh);
    assertEquals(0, comparator.compare(superStar, kobeBryant));

  }


}