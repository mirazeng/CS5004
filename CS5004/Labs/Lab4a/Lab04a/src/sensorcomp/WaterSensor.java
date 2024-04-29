package sensorcomp;

/**
 * The type Water sensor.
 */
public class WaterSensor extends AtmosphericSensor implements IDiscreteSensor {

  private boolean floodingYes;

  /**
   * Instantiates a new Water sensor.
   *
   * @param value the value
   */
  public WaterSensor(double value) {
    super(value);
    checkFlood(value);
  }

  /**
   * Instantiates a Water sensor starting at 0.
   */
  public WaterSensor() {
    super();
    this.floodingYes = false;
  }

  /**
   * Flip status of flooding.
   */
  public void flipStatus() {
    this.floodingYes = !this.floodingYes;
  }

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
    return super.lastReading();
  }

  /**
   * take new reading of water sensor.
   */
  public double takeNewReading() {
    double currentReading = super.takeNewReading();
    checkFlood(currentReading);
    return currentReading;
  }

  private void checkFlood(double currentReading) {
    if (currentReading > 0.5) {
      this.floodingYes = true;
    } else {
      this.floodingYes = false;
    }
  }
}