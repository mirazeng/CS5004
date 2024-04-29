package registration;

/**
 * The type Blue jurisdiction.
 */
public class BlueJurisdiction implements IJurisdiction {

  private static final double TAX_RATE = 0.03;
  private static final int YEAR_LIMIT = 2000;
  private static final int ADDITIONAL_TAX = 99;


  @Override
  public double exciseTax(IVehicle vehicle) {
    double exciseTax = vehicle.getPurchasePrice() * TAX_RATE;
    if (vehicle.getProductionYear() < YEAR_LIMIT) {
      exciseTax += ADDITIONAL_TAX;
    }
    return exciseTax;
  }

  @Override
  public String toString() {
    return "Blue Jurisdiction";
  }
}