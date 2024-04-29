package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The type Test vehicle.
 */
public class TestVehicle {

  private IVehicle auto1;
  private IVehicle auto2;

  private IVehicle boat1;
  private IVehicle boat2;

  private IVehicle motorcycle1;
  private IVehicle motorcycle2;

  private IJurisdiction blueJur;

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    auto1 = new Vehicle("Auto", "Toyota", 1997, 10000.00);
    auto2 = new Vehicle("Auto", "Ford", 2021, 25000.00);

    boat1 = new Vehicle("Boat", "Boston Whaler", 1998, 100000.00);
    boat2 = new Vehicle("Boat", "Chris Craft", 2022, 75000.00);

    motorcycle1 = new Vehicle("Motorcycle", "Harley", 1996, 20000.00);
    motorcycle2 = new Vehicle("Motorcycle", "Honda", 2022, 15000.00);

    blueJur = new BlueJurisdiction();
  }

  /**
   * Test get kind.
   */
  @Test
  public void testGetKind() {
    assertEquals("Auto", auto1.getKind());
    assertEquals("Auto", auto2.getKind());
    assertEquals("Boat", boat1.getKind());
    assertEquals("Boat", boat2.getKind());
    assertEquals("Motorcycle", motorcycle1.getKind());
    assertEquals("Motorcycle", motorcycle2.getKind());
  }

  /**
   * Test get make.
   */
  @Test
  public void testGetMake() {
    assertEquals("Toyota", auto1.getMake());
    assertEquals("Ford", auto2.getMake());
    assertEquals("Boston Whaler", boat1.getMake());
    assertEquals("Chris Craft", boat2.getMake());
    assertEquals("Harley", motorcycle1.getMake());
    assertEquals("Honda", motorcycle2.getMake());
  }

  /**
   * Test get production year.
   */
  @Test
  public void testGetProductionYear() {
    assertEquals(1997, auto1.getProductionYear());
    assertEquals(2021, auto2.getProductionYear());
    assertEquals(1998, boat1.getProductionYear());
    assertEquals(2022, boat2.getProductionYear());
    assertEquals(1996, motorcycle1.getProductionYear());
    assertEquals(2022, motorcycle2.getProductionYear());
  }

  /**
   * Test get purchase price.
   */
  @Test
  public void testGetPurchasePrice() {
    assertEquals(10000.00, auto1.getPurchasePrice());
    assertEquals(25000.00, auto2.getPurchasePrice());
    assertEquals(100000.00, boat1.getPurchasePrice());
    assertEquals(75000.00, boat2.getPurchasePrice());
    assertEquals(20000.00, motorcycle1.getPurchasePrice());
    assertEquals(15000.00, motorcycle2.getPurchasePrice());
  }

  /**
   * Test get max passengers.
   */
  @Test
  public void testGetMaxPassengers() {
    assertEquals(5, auto1.getMaxPassengers());
    assertEquals(5, auto2.getMaxPassengers());
    assertEquals(10, boat1.getMaxPassengers());
    assertEquals(10, boat2.getMaxPassengers());
    assertEquals(2, motorcycle1.getMaxPassengers());
    assertEquals(2, motorcycle2.getMaxPassengers());
  }

  /**
   * Test two vehicle equals.
   */
  @Test
  public void testEquals() {
    IVehicle auto3 = new Vehicle("Auto", "Toyota", 1997, 10000.00);
    assertEquals(auto1, auto3);
    IVehicle auto4 = null;
    assertNotEquals(auto1, auto4);
  }
}