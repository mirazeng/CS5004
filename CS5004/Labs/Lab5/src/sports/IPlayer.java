package sports;

/**
 * The interface Player.
 *
 * @param <T> the type parameter
 */
public interface IPlayer<T> {

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets age.
   *
   * @return the age
   */
  int getAge();

  /**
   * Gets height.
   *
   * @return the height
   */
  double getHeight();

  /**
   * Gets stats.
   *
   * @param <T> the type parameter
   * @return the stats
   */
  <T> T getStats(); // generic method returns status type T

}