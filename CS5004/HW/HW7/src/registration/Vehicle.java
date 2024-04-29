package registration;

import java.util.Objects;

/**
 * The type Vehicle.
 */
// Vehicle class implements the IVehicle interface,
// and decide different kind of vehicles by enumeration
// Different kind of vehicles determine the max passengers
public class Vehicle implements IVehicle {
  public static final String AUTO = "Auto";
  public static final String BOAT = "Boat";
  public static final String MOTORCYCLE = "Motorcycle";
  private final String make;
  private final int productionYear;
  private final double purchasePrice;
  private String kind;
  private int maxPassengers; // Determined by the kind of vehicle

  /**
   * Instantiates a new Vehicle.
   *
   * @param kind           the kind
   * @param make           the make
   * @param productionYear the production year
   * @param purchasePrice  the purchase price
   */
  public Vehicle(String kind, String make, int productionYear, double purchasePrice) {
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;
    this.kind = null; // To handle unsupported kinds of vehicles
    if (kind.equalsIgnoreCase("Auto")) {
      this.kind = AUTO;
      this.maxPassengers = 5;
    } else if (kind.equalsIgnoreCase("Boat")) {
      this.kind = BOAT;
      this.maxPassengers = 10;
    } else if (kind.equalsIgnoreCase("Motorcycle")) {
      this.kind = MOTORCYCLE;
      this.maxPassengers = 2;
    }
  }

  @Override
  public String getKind() {
    return this.kind;
  }

  @Override
  public String getMake() {
    return this.make;
  }

  @Override
  public int getProductionYear() {
    return this.productionYear;
  }

  @Override
  public double getPurchasePrice() {
    return this.purchasePrice;
  }

  @Override
  public int getMaxPassengers() {
    return this.maxPassengers;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) obj;
    return productionYear == vehicle.productionYear
            && Double.compare(vehicle.purchasePrice, purchasePrice) == 0
            && make.equals(vehicle.make)
            && kind.equals(vehicle.kind);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, productionYear,
            purchasePrice, kind, maxPassengers);
  }

}