package registration;

import java.util.List;

/**
 * The interface Registration.
 */
public interface IRegistration {
  /**
   * Gets registration year.
   *
   * @return the registration year
   */
  int getRegistrationYear();

  /**
   * Gets production year.
   *
   * @return the production year
   */
  int getProductionYear();

  /**
   * Gets jurisdiction.
   *
   * @return the jurisdiction
   */
  IJurisdiction getJurisdiction();

  /**
   * Gets owners.
   *
   * @return the owners
   */
  List<Person> getOwners();

  /**
   * Gets max passengers.
   *
   * @return the max passengers
   */
  int getMaxPassengers();

  /**
   * Calculate excise tax double.
   *
   * @return the double
   */
  double calculateExciseTax();
}