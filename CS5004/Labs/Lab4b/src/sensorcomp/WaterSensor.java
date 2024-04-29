package sensorcomp;

/**
 * The type Water sensor.
 */
public class WaterSensor implements IDiscreteSensor {

  private final AtmosphericSensor atmSensor;
  private boolean floodingYes;

  /**
   * Instantiates a new Water sensor.
   */
  public WaterSensor() {
    this.atmSensor = new AtmosphericSensor();
    this.floodingYes = false;
  }

  /**
   * Instantiates a new Water sensor.
   *
   * @param value the value
   */
  public WaterSensor(double value) {
    this.atmSensor = new AtmosphericSensor(value);
    checkFlooding(value);
  }

  /**
   * Flip status of flooding.
   */
  public void flipStatus() {
    this.floodingYes = !this.floodingYes;
  }

  /**
   * Sets status of flooding.
   */
  @Override
  public void setStatus(boolean value) {
    this.floodingYes = value;
  }

  /**
   * get status of water sensor.
   */
  public boolean status() {
    return this.floodingYes;
  }

  /**
   * get last reading of water sensor.
   */
  public double lastReading() {
    return this.atmSensor.lastReading();
  }

  /**
   * take new reading of water sensor.
   */
  public double takeNewReading() {
    double currentReading = this.atmSensor.takeNewReading();
    checkFlooding(currentReading);
    return currentReading;
  }

  private void checkFlooding(double currentReading) {
    if (currentReading > 0.5) {
      this.floodingYes = true;
    } else {
      this.floodingYes = false;
    }
  }

}