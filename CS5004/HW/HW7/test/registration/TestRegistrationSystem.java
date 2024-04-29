package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/** The type Test registration system. */
public class TestRegistrationSystem {
  private RegistrationSystem system;

  /** Test get instance. */
  @Test
  public void testGetInstance() {
    RegistrationSystem system1 = RegistrationSystem.getInstance();
    RegistrationSystem system2 = RegistrationSystem.getInstance();
    assertEquals(system1, system2, "System instance should be the same");
  }

  /** Test create vehicle. */
  @Test
  public void testCreateVehicle() {
    IVehicle vehicle1 =
        RegistrationSystem.getInstance().createVehicle("Auto", "Honda", 2021, 15000);
    assertEquals("Auto", vehicle1.getKind(), "Vehicle kind should be Auto");
    assertEquals("Honda", vehicle1.getMake(), "Vehicle make should be Honda");
    assertEquals(2021, vehicle1.getProductionYear(), "Vehicle production year should be 2021");
    assertEquals(15000, vehicle1.getPurchasePrice(), "Vehicle purchase price should be 15000");

    IVehicle vehicle2 =
        RegistrationSystem.getInstance().createVehicle("Motorcycle", "Ford", 2022, 25000);
    assertEquals("Motorcycle", vehicle2.getKind(), "Vehicle kind should be Motorcycle");
    assertEquals("Ford", vehicle2.getMake(), "Vehicle make should be Ford");
    assertEquals(2022, vehicle2.getProductionYear(), "Vehicle production year should be 2022");
    assertEquals(25000, vehicle2.getPurchasePrice(), "Vehicle purchase price should be 25000");

    IVehicle vehicle3 =
        RegistrationSystem.getInstance().createVehicle("Boat", "Boston Whales", 2023, 35000);
    assertEquals("Boat", vehicle3.getKind(), "Vehicle kind should be Boat");
    assertEquals("Boston Whales", vehicle3.getMake(), "Vehicle make should be Boston Whales");
    assertEquals(2023, vehicle3.getProductionYear(), "Vehicle production year should be 2023");
    assertEquals(35000, vehicle3.getPurchasePrice(), "Vehicle purchase price should be 35000");

    // Test unsupported vehicle kind
    assertNull(
        RegistrationSystem.getInstance().createVehicle("Truck", "Ford", 2022, 25000),
        "Unsupported vehicle kind should return null");
  }

  /** Test create vehicle throws. */
  @Test
  public void testCreateVehicleThrows() {
    RegistrationSystem system = RegistrationSystem.getInstance();
    // Use assertThrows() to test all the IllegalArgumentExceptions

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle(null, "Honda", 2021, 15000);
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle("", "Honda", 2021, 15000);
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle("Auto", null, 2021, 15000);
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle("Auto", "", 2021, 15000);
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle("Auto", "Honda", 1899, 15000);
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle("Auto", "Honda", 2024, 15000);
        });
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          system.createVehicle("Auto", "Honda", 2021, -1);
        });
  }

  /** Test register. */
  @Test
  public void testRegister() {
    system = RegistrationSystem.getInstance();
    system.reboot();
    IVehicle vehicle1 = system.createVehicle("Auto", "Honda", 2021, 15000);
    IVehicle vehicle2 = system.createVehicle("Motorcycle", "Ford", 2022, 25000);
    IVehicle vehicle3 = system.createVehicle("Boat", "Boston Whales", 2023, 35000);

    IJurisdiction jurisdiction1 = new RedJurisdiction();
    ArrayList<Person> owners1 = new ArrayList<>();
    owners1.add(new Person("John", "123 Main St"));

    system.register(vehicle1, jurisdiction1, 2020, owners1);
    assertEquals(
        1,
        system.getAllRegistrations().size(),
        "Registration list " + "should have 1 registration, " + "after using register()");
  }

  /** Test register duplicates. */
  @Test
  public void testRegisterDuplicates() {
    system = RegistrationSystem.getInstance();
    IVehicle vehicle1 = system.createVehicle("Auto", "Honda", 2021, 15000);
    IVehicle vehicle2 = system.createVehicle("Motorcycle", "Ford", 2022, 25000);
    IVehicle vehicle3 = system.createVehicle("Boat", "Boston Whales", 2023, 35000);

    IJurisdiction jurisdiction1 = new RedJurisdiction();
    ArrayList<Person> owners1 = new ArrayList<>();
    owners1.add(new Person("John", "123 Main St"));

    system.register(vehicle1, jurisdiction1, 2020, owners1);
    system.register(vehicle1, jurisdiction1, 2020, owners1);
    assertEquals(
        1,
        system.getAllRegistrations().size(),
        "Registration list " + "should have 1 registration, " + "ignoring duplicates");
  }

  /** Test get all registrations. */
  @Test
  public void testGetAllRegistrations() {
    system = RegistrationSystem.getInstance();
    system.reboot();

    IJurisdiction jurisdiction1 = new RedJurisdiction();
    ArrayList<Person> owners1 = new ArrayList<>();
    owners1.add(new Person("John", "123 Main St"));

    IVehicle vehicle1 = system.createVehicle("Auto", "Honda", 2021, 15000);
    system.register(vehicle1, jurisdiction1, 2020, owners1);
    IVehicle vehicle2 = system.createVehicle("Motorcycle", "Ford", 2022, 25000);
    system.register(vehicle2, jurisdiction1, 2020, owners1);
    IVehicle vehicle3 = system.createVehicle("Boat", "Boston Whales", 2023, 35000);
    system.register(vehicle3, jurisdiction1, 2020, owners1);

    ArrayList<IRegistration> expected = new ArrayList<>();
    expected.add(new Registration(vehicle1, jurisdiction1, 2020, owners1));
    expected.add(new Registration(vehicle2, jurisdiction1, 2020, owners1));
    expected.add(new Registration(vehicle3, jurisdiction1, 2020, owners1));

    assertEquals(
        expected,
        system.getAllRegistrations(),
        "Registration list " + "should have 3 registrations");
  }

  /** Test get filtered list. */
  @Test
  public void testGetFilteredList() {
    system = RegistrationSystem.getInstance();
    system.reboot();

    ArrayList<Person> owners1 = new ArrayList<>();
    owners1.add(new Person("John", "123 Main St"));
    ArrayList<Person> owners2 = new ArrayList<>();
    owners2.add(new Person("Jane", "456 Main St"));

    IVehicle vehicle1 = system.createVehicle("Auto", "Honda", 2021, 15000);

    IJurisdiction jurisdiction1 = new RedJurisdiction();
    system.register(vehicle1, jurisdiction1, 2020, owners1);

    IVehicle vehicle2 = system.createVehicle("Motorcycle", "Ford", 2022, 25000);
    system.register(vehicle2, jurisdiction1, 2020, owners1);

    IVehicle vehicle3 = system.createVehicle("Boat", "Boston Whales", 2023, 35000);
    IJurisdiction jurisdiction2 = new BlueJurisdiction();
    system.register(vehicle3, jurisdiction2, 2020, owners2);

    ArrayList<IRegistration> expected = new ArrayList<>();
    expected.add(new Registration(vehicle1, jurisdiction1, 2020, owners1));
    expected.add(new Registration(vehicle2, jurisdiction1, 2020, owners1));

    assertEquals(
        expected,
        system.getFilteredList(
            registration -> registration.getJurisdiction().toString().equals("Red Jurisdiction")),
        "Registration list should "
            + "have 2 registrations that meets "
            + "the filter of having Red jurisdiction");
  }

  /** Test reboot. */
  @Test
  public void testReboot() {
    RegistrationSystem systemExisting = RegistrationSystem.getInstance();
    IJurisdiction jurisdiction1 = new RedJurisdiction();

    ArrayList<Person> owners1 = new ArrayList<>();
    owners1.add(new Person("John", "123 Main St"));
    IVehicle vehicle1 = systemExisting.createVehicle("Auto", "Honda", 2021, 15000);
    systemExisting.register(vehicle1, jurisdiction1, 2020, owners1);
    IVehicle vehicle2 = systemExisting.createVehicle("Motorcycle", "Ford", 2022, 25000);
    systemExisting.register(vehicle2, jurisdiction1, 2020, owners1);
    ArrayList<Person> owners2 = new ArrayList<>();
    owners2.add(new Person("Jane", "456 Main St"));
    IVehicle vehicle3 = systemExisting.createVehicle("Boat", "Boston Whales", 2023, 35000);
    IJurisdiction jurisdiction2 = new BlueJurisdiction();
    systemExisting.register(vehicle3, jurisdiction2, 2020, owners2);

    systemExisting.reboot();
    assertEquals(
        0,
        systemExisting.getAllRegistrations().size(),
        "Registration list " + "should be empty after reboot");
  }
}