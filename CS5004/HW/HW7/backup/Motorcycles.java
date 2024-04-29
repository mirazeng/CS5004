package registration;

public class Motorcycles implements IVehicle {

  private String kind;
  private String make;
  private int productionYear;
  private double purchasePrice;
  private int maxPassengers;

  public Motorcycles(String make, int productionYear,
                     double purchasePrice) {
    this.kind = "Motorcycle";
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;
    this.maxPassengers = 2;
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
}