package sensorcomp;

/**
 * The interface Discrete sensor.
 */
public interface IDiscreteSensor extends ISensor {
  /**
   * Status boolean.
   *
   * @return the boolean
   */
  boolean status(); // discrete values like "on"/ off modeled here

  /**
   * Flip status.
   */
  void flipStatus();

  /**
   * Sets status.
   *
   * @param value the value
   */
  void setStatus(boolean value);

  /**
   * Last reading double.
   *
   * @return the double
   */
  default double lastReading() {
    return 0;
  }

  @Override
  default double takeNewReading() {
    return 0;
  }
}