import java.text.DecimalFormat;

/**
 * Wenqing Zeng - homework_1
 * This class represents a ElectricVehicle class
 * with following attributes:
 * name, batterySize,stateOfCharge,
 * defaultEfficiency, currentEfficiency.
 */
public final class ElectricVehicle {
  private static final double MAXDEFAULTEFFICIENCY = 4.5;
  private static final double MINDEFAULTEFFICIENCY = 0.5;
  private static final double MINBATTERY = 10.0;
  private static final double MAXBATTERY = 150.0;
  private static final double MINSOC = 0.15;
  private static final double MAXSOC = 1.0;
  private static final double MAXTEMP = 77.0;
  private static final double MIDTEMP = 65.0;
  private static final double MINTEMP = 15.0;
  private static final double EFIDISCOUNT1 = 0.85;
  private static final double TWODECIMAL = 0.01;
  private static final double ONE = 1;
  private final String name;
  private final double batterySize;
  private final double defaultEfficiency;
  private double stateOfCharge;
  private double currentEfficiency;

  /**
   * Instantiates a new Electric vehicle.
   *
   * @param name              the name
   * @param batterySize       the battery size
   * @param stateOfCharge     the state of charge
   * @param defaultEfficiency the default efficiency
   */
  public ElectricVehicle(String name, double batterySize,
                         double stateOfCharge, double defaultEfficiency) {
    this.name = this.checkName(name);
    this.batterySize = Math.max(MINBATTERY, Math.min(MAXBATTERY, batterySize));
    this.stateOfCharge = this.stateOfChargeRange(stateOfCharge);
    this.defaultEfficiency = Math.max(MINDEFAULTEFFICIENCY,
            Math.min(MAXDEFAULTEFFICIENCY, defaultEfficiency));
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * a method to get efficiency
   * of a ElectricVehicle object.
   *
   * @return the efficiency
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }

  /**
   * a method to get name
   * of a ElectricVehicle object.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * a method to get battery size
   * of a ElectricVehicle object.
   *
   * @return the battery size
   */
  public double getBatterySize() {
    return this.batterySize;
  }

  /**
   * a method to get state of charge
   * of a ElectricVehicle object.
   *
   * @return the state of charge
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }

  /**
   * a method to set new state of charge
   * of a ElectricVehicle object.
   *
   * @param newStateOfCharge the new state of charge
   */
  public void setStateOfCharge(double newStateOfCharge) {
    this.stateOfCharge = this.stateOfChargeRange(newStateOfCharge);
  }

  /**
   * a method to calculate range
   * of a ElectricVehicle object.
   *
   * @return the range
   */
  public double range() {
    return this.currentEfficiency
            * this.stateOfCharge
            * this.batterySize;
  }

  /**
   * a method to update efficiency
   * based on current temperature
   * of a ElectricVehicle object.
   *
   * @param currentTemp the current temp
   */
  public void updateEfficiency(double currentTemp) {
    if (currentTemp > MAXTEMP) {
      this.currentEfficiency = EFIDISCOUNT1 * this.defaultEfficiency;
    }
    if (currentTemp >= MIDTEMP && currentTemp <= MAXTEMP) {
      this.currentEfficiency = this.defaultEfficiency;
    }
    if (currentTemp >= MINTEMP && currentTemp < MIDTEMP) {
      this.currentEfficiency = (this.defaultEfficiency
              * (ONE - (MIDTEMP - currentTemp) * TWODECIMAL));
    }
    if (currentTemp < MINTEMP) {
      this.currentEfficiency = this.defaultEfficiency * MINDEFAULTEFFICIENCY;
    }
  }

  /**
   * a method to check passed in
   * name, and return default if
   * name is empty.
   *
   * @return the name
   */
  private String checkName(String name) {
    if (name != null && !name.isEmpty()) {
      return name;
    } else {
      return "unknown EV";
    }
  }

  /**
   * a method to make sure state of charge
   * falls into the right range
   * of a ElectricVehicle object.
   *
   * @return the state of charge
   */
  private double stateOfChargeRange(double SoC) {
    return Math.max(MINSOC, Math.min(MAXSOC, SoC));
  }

  /**
   * a method to represent ElectricVehicle
   * objects in String format.
   *
   * @return the formatted string of object information
   */
  public String toString() {
    DecimalFormat decimalFormat = new DecimalFormat("#.0%");
    return String.format("%s SOC: %s Range (miles): %.1f",
            getName(),
            decimalFormat.format(getStateOfCharge()),
            range());
  }
}

