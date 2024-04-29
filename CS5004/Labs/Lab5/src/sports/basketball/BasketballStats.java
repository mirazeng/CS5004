package sports.basketball;

import java.util.Objects;

/**
 * The type Basketball stats.
 */
public class BasketballStats {
  private double pointsPerGame;
  private double reboundsPerGame;
  private double assistsPerGame;

  /**
   * Instantiates a new Basketball stats.
   *
   * @param pointsPerGame   the points per game
   * @param reboundsPerGame the rebounds per game
   * @param assistsPerGame  the assists per game
   */
  public BasketballStats(double pointsPerGame, double reboundsPerGame,
                         double assistsPerGame) {
    this.pointsPerGame = pointsPerGame;
    this.reboundsPerGame = reboundsPerGame;
    this.assistsPerGame = assistsPerGame;
  }

  /**
   * Gets points per game.
   *
   * @return the points per game
   */
  public double getPointsPerGame() {
    return this.pointsPerGame;
  }

  /**
   * Gets rebounds per game.
   *
   * @return the rebounds per game
   */
  public double getReboundsPerGame() {
    return this.reboundsPerGame;
  }

  /**
   * Gets assists per game.
   *
   * @return the assists per game
   */
  public double getAssistsPerGame() {
    return this.assistsPerGame;
  }

  /**
   * Equals method to compare two BasketballStats objects.
   *
   * @param other the other object
   * @return true if the two objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    } else if (other == null || this.getClass() != other.getClass()) {
      return false;
    } else {
      BasketballStats o = (BasketballStats) other;
      if (this.assistsPerGame == o.assistsPerGame
              && this.reboundsPerGame == o.reboundsPerGame
              && this.pointsPerGame == o.pointsPerGame) {
        return true;
      }
      return false;
    }
  }


  @Override
  public int hashCode() {
    return Objects.hash(this.assistsPerGame, this.reboundsPerGame, this.pointsPerGame);
  }

  @Override
  public String toString() {
    return "Points per game: "
            + this.pointsPerGame
            + ", Rebounds per game: "
            + this.reboundsPerGame
            + ", Assists per game: "
            + this.assistsPerGame;
  }
}