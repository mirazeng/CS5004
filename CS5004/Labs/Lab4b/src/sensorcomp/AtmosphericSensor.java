package sensorcomp;

/**
 * The type Atmospheric sensor.
 */
public class AtmosphericSensor implements ISensor {

  private double currentValue;
  private double lastValue;

  /**
   * Instantiates a new Atmospheric sensor.
   *
   * @param value the value
   */
  public AtmosphericSensor(double value) {

    this.currentValue = this.lastValue = value;

  }

  /**
   * Instantiates a new Atmospheric sensor.
   */
  public AtmosphericSensor() {
    this(0);
  }

  /**
   * Take new reading double.
   *
   * @return the double
   */
  @Override
  public double takeNewReading() {
    // Simulate a sensor reading
    this.lastValue = this.currentValue; // save previous
    this.currentValue = SensorData.currentReading();

    return this.currentValue;
  }

  /**
   * Last reading double.
   *
   * @return the double
   */
  @Override
  public double lastReading() {
    return this.lastValue;
  }

}