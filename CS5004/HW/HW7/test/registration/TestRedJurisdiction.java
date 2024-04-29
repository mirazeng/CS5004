package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** The type Test red jurisdiction. */
public class TestRedJurisdiction {

  private IVehicle auto;
  private IVehicle boat;
  private IVehicle motorcycle;

  private IJurisdiction redJur;

  /** Sets up. */
  @BeforeEach
  public void setUp() {
    auto = new Vehicle("Auto", "Toyota", 2021, 10000.00);
    boat = new Vehicle("Boat", "Boston Whaler", 2022, 100000.00);
    motorcycle = new Vehicle("Motorcycle", "Harley", 2023, 20000.00);

    redJur = new RedJurisdiction();
  }

  /** Test excise tax. */
  @Test
  public void testExciseTax() {
    assertEquals(500.00, redJur.exciseTax(auto), 0.001);
    assertEquals(5000.00, redJur.exciseTax(boat), 0.001);
    assertEquals(1000.00, redJur.exciseTax(motorcycle), 0.001);
  }

  /** Test to string. */
  @Test
  public void testToString() {
    assertEquals("Red Jurisdiction", redJur.toString());
  }
}