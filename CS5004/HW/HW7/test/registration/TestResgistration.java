package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Test resgistration.
 */
public class TestResgistration {
  IJurisdiction testJurisdiction1;
  IJurisdiction testJurisdiction2;
  IJurisdiction testJurisdiction3;

  ArrayList<Person> testOwners = new ArrayList<Person>();
  Person testOwners1;
  private IVehicle testVehicle1;
  private IVehicle testVehicle2;
  private IVehicle testVehicle3;

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    testVehicle1 = new Vehicle("Auto", "Toyota", 2020, 10000);
    testVehicle2 = new Vehicle("Boat", "BoatMaker", 1999, 50);
    testVehicle3 = new Vehicle("Motorcycle", "Yamazaki", 2005, 20000);

    testJurisdiction1 = new RedJurisdiction();
    testJurisdiction2 = new GreenJurisdiction();
    testJurisdiction3 = new BlueJurisdiction();
    testOwners1 = new Person("Test Owners", "123 Main St");
    testOwners.add(testOwners1);

  }

  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    Registration testRegistration = new Registration(testVehicle1, testJurisdiction1,
            2020, testOwners);
    assertEquals(2020, testRegistration.getRegistrationYear());
    assertEquals(2020, testRegistration.getProductionYear());
    assertEquals("Red Jurisdiction", testRegistration.getJurisdiction().toString());
    assertEquals(testOwners1, testRegistration.getOwners().getFirst());
    assertEquals(5, testRegistration.getMaxPassengers());
  }

  /**
   * Test get registration year.
   */
  @Test
  public void testGetRegistrationYear() {
    Registration testRegistration = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(2020, testRegistration.getRegistrationYear());
  }

  /**
   * Test get production year.
   */
  @Test
  public void testGetProductionYear() {
    Registration testRegistration = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(2020, testRegistration.getProductionYear());
  }

  /**
   * Test get jurisdiction.
   */
  @Test
  public void testGetJurisdiction() {
    Registration testRegistration = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals("Red Jurisdiction", testRegistration.getJurisdiction().toString());
  }

  /**
   * Test get owners.
   */
  @Test
  public void testGetOwners() {
    Registration testRegistration = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(testOwners, testRegistration.getOwners());
  }

  /**
   * Test get max passengers.
   */
  @Test
  public void testGetMaxPassengers() {
    Registration testRegistration = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(5, testRegistration.getMaxPassengers());
  }

  /**
   * Test calculate excise tax.
   */
  @Test
  public void testCalculateExciseTax() {
    Registration testRegistration1 = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(500.0, testRegistration1.calculateExciseTax());
    Registration testRegistration2 = new Registration(testVehicle2, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(2.5, testRegistration2.calculateExciseTax());
    Registration testRegistration3 = new Registration(testVehicle3, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(1000.0, testRegistration3.calculateExciseTax());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    ArrayList<Person> testOwners2 = new ArrayList<Person>();
    testOwners2.add(testOwners1);
    testOwners2.add(new Person("Test Owner2", "123 Main St"));

    Registration testRegistration = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners2);
    assertEquals("Registration: \n"
            + "AUTO: Toyota Year(2020)  Price = $10000.00\n"
            + "Owned By: Test Owners, Test Owner2\n"
            + "Year: 2020 Excise Tax: $500.00", testRegistration.toString());
  }

  /**
   * Test equals.
   */
  @Test
  public void testEquals() {
    Registration testRegistration1 = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    Registration testRegistration2 = new Registration(testVehicle1, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(testRegistration1, testRegistration2);

    Registration testRegistrationNull = null;
    assertNotEquals(testRegistration1, testRegistrationNull);

    Registration testRegistration3 = new Registration(testVehicle2, new RedJurisdiction(),
            2020, testOwners);
    assertEquals(testRegistration3, testRegistration3);
  }

}