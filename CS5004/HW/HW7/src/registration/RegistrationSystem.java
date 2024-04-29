package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type Registration system.
 */
public class RegistrationSystem {

  private static RegistrationSystem systemInstance = null;
  private final List<IRegistration> registrationList;

  private RegistrationSystem() {
    registrationList = new ArrayList<>();
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static RegistrationSystem getInstance() {
    if (systemInstance == null) {
      systemInstance = new RegistrationSystem();
    }
    return systemInstance;
  }

  /**
   * Create vehicle vehicle.
   *
   * @param kind           the kind
   * @param make           the make
   * @param productionYear the production year
   * @param purchasePrice  the purchase price
   * @return the vehicle
   * @throws IllegalArgumentException the illegal argument exception
   */
  public IVehicle createVehicle(String kind, String make,
                                int productionYear, double purchasePrice)
          throws IllegalArgumentException {
    if (kind == null || kind.isEmpty()) {
      throw new IllegalArgumentException("Vehicle kind must be provided.");
    } else if (make == null || make.isEmpty()) {
      throw new IllegalArgumentException("Vehicle make must be provided.");
    } else if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Vehicle production year "
              + "must be between 1900 and 2023.");
    }
    if (purchasePrice < 0) {
      throw new IllegalArgumentException("Vehicle purchase price cannot be negative.");
    }
    Vehicle newVehicle = new Vehicle(kind, make, productionYear, purchasePrice);
    if (newVehicle.getKind() == null) {
      return null;
    } else {
      return newVehicle;
    }
  }

  /**
   * Register.
   *
   * @param vehicle          the vehicle
   * @param jurisdiction     the jurisdiction
   * @param registrationYear the registration year
   * @param owners           the owners
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction,
                       int registrationYear, List<Person> owners) {

    Registration NewRegistration =
            new Registration(vehicle, jurisdiction,
                    registrationYear, owners);

    if (!registrationList.contains(NewRegistration)) {
      registrationList.add(NewRegistration);
    }
  }

  /**
   * Gets all registrations.
   *
   * @return the all registrations
   */
  public List<IRegistration> getAllRegistrations() {
    return Collections.unmodifiableList(registrationList);
  }


  /**
   * Gets filtered list.
   *
   * @param query the query
   * @return the filtered list
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    return registrationList
            .stream()
            .filter(query)
            .collect(Collectors.toUnmodifiableList());
  } // answer an unmodifiable list

  /**
   * reset the system to initial "start state".
   */
  public void reboot() {
    registrationList.clear();
  }
}