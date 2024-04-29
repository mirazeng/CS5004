package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Test blue jurisdiction.
 */
public class TestBlueJurisdiction {

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
   * Test excise tax.
   */
  @Test
  public void testExciseTax() {
    assertEquals(399.00, blueJur.exciseTax(auto1), 0.001);
    assertEquals(750.00, blueJur.exciseTax(auto2), 0.001);

    assertEquals(3099.00, blueJur.exciseTax(boat1), 0.001);
    assertEquals(2250.00, blueJur.exciseTax(boat2), 0.001);

    assertEquals(699.00, blueJur.exciseTax(motorcycle1), 0.001);
    assertEquals(450.00, blueJur.exciseTax(motorcycle2), 0.001);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Blue Jurisdiction", blueJur.toString());
  }
}