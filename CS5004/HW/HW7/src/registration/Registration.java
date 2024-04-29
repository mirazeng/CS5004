package registration;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Registration.
 */
public class Registration implements IRegistration {

  private final IVehicle vehicle;
  private final int registrationYear;
  private final IJurisdiction jurisdiction;
  private final List<Person> owners;

  /**
   * Instantiates a new Registration.
   *
   * @param vehicle          the vehicle
   * @param jurisdiction     the jurisdiction
   * @param registrationYear the registration year
   * @param owners           the owners
   */
  public Registration(IVehicle vehicle, IJurisdiction jurisdiction,
                      int registrationYear, List<Person> owners) {
    this.vehicle = vehicle;
    this.jurisdiction = jurisdiction;
    this.registrationYear = registrationYear;
    this.owners = Collections.unmodifiableList(owners);
  }

  @Override
  public int getRegistrationYear() {
    return this.registrationYear;
  }

  @Override
  public int getProductionYear() {
    return this.vehicle.getProductionYear();
  }

  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }

  @Override
  public List<Person> getOwners() {
    return this.owners;
  }

  @Override
  public int getMaxPassengers() {
    return this.vehicle.getMaxPassengers();
  }

  @Override
  public double calculateExciseTax() {
    return this.jurisdiction.exciseTax(vehicle);
  }


  @Override
  public String toString() {
    StringBuilder aString = new StringBuilder();

    aString.append("Registration: ").append("\n");

    aString.append(vehicle.getKind().toUpperCase()).append(": ")
            .append(vehicle.getMake()).append(" ")
            .append("Year(" + vehicle.getProductionYear() + ") ").append(" ")
            .append("Price = $").append(String.format("%.2f",
                    vehicle.getPurchasePrice())).append("\n")
            .append("Owned By: ");

    for (int i = 0; i < owners.size(); i++) {
      aString.append(owners.get(i).getName());
      if (owners.size() > 1 && i < owners.size() - 1) {
        aString.append(", ");
      }
    }

    aString.append("\n")
            .append("Year: ").append(this.registrationYear)
            .append(" Excise Tax: $").append(String.format("%.2f", this.calculateExciseTax()));

    return aString.toString();
  }


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Registration registration = (Registration) object;
    return registrationYear == registration.registrationYear
            && vehicle.equals(registration.vehicle)
            && owners.equals(registration.owners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicle,
            registrationYear,
            owners);
  }
}