package registration;

/**
 * The type Green jurisdiction.
 */
public class GreenJurisdiction implements IJurisdiction {

  private static final double TAX_RATE = 0.04;
  private static final int PASSENGER_TAX = 100;

  @Override
  public double exciseTax(IVehicle vehicle) {
    return vehicle.getPurchasePrice() * TAX_RATE
            + vehicle.getMaxPassengers() * PASSENGER_TAX;
  }

  @Override
  public String toString() {
    return "Green Jurisdiction";
  }
}