package registration;

/**
 * The interface Vehicle.
 */
public interface IVehicle {
  /**
   * Gets kind.
   *
   * @return the kind
   */
  String getKind();

  /**
   * Gets make.
   *
   * @return the make
   */
  String getMake();

  /**
   * Gets production year.
   *
   * @return the production year
   */
  int getProductionYear();

  /**
   * Gets purchase price.
   *
   * @return the purchase price
   */
  double getPurchasePrice();

  /**
   * Gets max passengers.
   *
   * @return the max passengers
   */
  int getMaxPassengers();
}