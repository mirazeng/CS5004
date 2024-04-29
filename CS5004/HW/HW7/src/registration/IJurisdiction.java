package registration;

/**
 * The interface Jurisdiction.
 */
public interface IJurisdiction {
  /**
   * Excise tax double.
   *
   * @param vehicle the vehicle
   * @return the double
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}