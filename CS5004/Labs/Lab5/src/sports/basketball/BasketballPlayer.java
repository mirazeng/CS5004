package sports.basketball;

import java.util.Objects;

import sports.IPlayer;

/**
 * The type Basketball player.
 */
public class BasketballPlayer implements IPlayer<BasketballStats> {
  private final String name;
  private final int age;
  private final double height;
  private BasketballStats stats;

  /**
   * Instantiates a new Basketball player.
   *
   * @param name   the name
   * @param age    the age
   * @param height the height
   * @param stats  the stats
   */
  public BasketballPlayer(String name, int age,
                          double height, BasketballStats stats) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.stats = stats;
  }

  /**
   * Instantiates a new Basketball player.
   *
   * @param player the player
   */
  public BasketballPlayer(BasketballPlayer player) {
    this.name = player.name;
    this.age = player.age;
    this.height = player.height;
    this.stats = new BasketballStats(player.stats.getPointsPerGame(),
            player.stats.getReboundsPerGame(),
            player.stats.getAssistsPerGame());
  }

  @Override
  public BasketballStats getStats() {
    return this.stats;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getAge() {
    return this.age;
  }

  @Override
  public double getHeight() {
    return this.height;
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || (this.getClass() != other.getClass())) {
      return false;
    }
    BasketballPlayer p = (BasketballPlayer) other;
    if (this.name == p.name
            && this.age == p.age
            && this.height == p.height) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age,
            this.height, this.stats);
  }

  @Override
  public String toString() {
    return "Name: "
            + this.name
            + ", Age: "
            + this.age
            + ", Height: "
            + this.height
            + "; Stats: "
            + this.stats.toString();
  }
}