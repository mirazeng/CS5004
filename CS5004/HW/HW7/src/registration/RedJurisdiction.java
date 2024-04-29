package registration;

/**
 * The type Red jurisdiction.
 */
public class RedJurisdiction implements IJurisdiction {
  private static final double TAX_RATE = 0.05;

  @Override
  public double exciseTax(IVehicle vehicle) {
    return vehicle.getPurchasePrice() * TAX_RATE;
  }

  @Override
  public String toString() {
    return "Red Jurisdiction";
  }
}