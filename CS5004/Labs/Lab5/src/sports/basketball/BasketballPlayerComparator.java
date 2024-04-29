package sports.basketball;

import java.util.Comparator;

/**
 * The type Basketball player comparator.
 */
public class BasketballPlayerComparator implements Comparator<BasketballPlayer> {

  /**
   * Compare basketball players by points per game.
   *
   * @param player1 the player 1
   * @param player2 the player 2
   * @return the result in int
   */
  @Override
  public int compare(BasketballPlayer player1, BasketballPlayer player2) {
    double pointsPerGameP1 = player1.getStats().getPointsPerGame();
    double pointsPerGameP2 = player2.getStats().getPointsPerGame();
    if (pointsPerGameP1 > pointsPerGameP2) {
      return 1;
    } else if (pointsPerGameP1 < pointsPerGameP2) {
      return -1;
    } else {
      return 0;
    }
  }
}