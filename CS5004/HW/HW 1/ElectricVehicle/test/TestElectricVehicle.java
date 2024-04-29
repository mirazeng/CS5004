import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for class ElectricVehicle.
 * Four ElectricVehicle  objects constructed:
 * Tesla, Lucid, Xpeng, Empty
 */
public class TestElectricVehicle {
  private ElectricVehicle Tesla;
  private ElectricVehicle Lucid;
  private ElectricVehicle Xpeng;
  private ElectricVehicle Empty;

  /**
   * Set up parameters for ElectricVehicle objects.
   */
  @Before
  public void setUp() {
    this.Tesla = new ElectricVehicle("tesla", 100.0, 0.8, 3.0);
    this.Lucid = new ElectricVehicle("lucid", 200.0, 2.0, 6.0);
    this.Xpeng = new ElectricVehicle("xpeng", 5.0, 0.1, 0.2);
    this.Empty = new ElectricVehicle("", 0.0, 0.0, 0.0);
  }

  /**
   * Test of getting the name
   * of ElectricVehicle objects.
   */
  @Test
  public void testName() {
    assertEquals("tesla", this.Tesla.getName());
    assertEquals("lucid", this.Lucid.getName());
    assertEquals("xpeng", this.Xpeng.getName());
    assertEquals("unknown EV", this.Empty.getName());
  }

  /**
   * Test of getting the battery size
   * of ElectricVehicle objects.
   */
  @Test
  public void testBatterySize() {
    assertEquals(100.0, this.Tesla.getBatterySize(), 0.01);
    assertEquals(150.0, this.Lucid.getBatterySize(), 0.01);
    assertEquals(10.0, this.Xpeng.getBatterySize(), 0.01);
  }

  /**
   * Test of getting the state of charge
   * of ElectricVehicle objects.
   */
  @Test
  public void testStateOfCharge() {
    assertEquals(0.8, this.Tesla.getStateOfCharge(), 0.01);
    assertEquals(1.0, this.Lucid.getStateOfCharge(), 0.01);
    assertEquals(0.15, this.Xpeng.getStateOfCharge(), 0.001);
  }

  /**
   * Test of getting the efficiency
   * of ElectricVehicle objects.
   */
  @Test
  public void testDefaultEfficiency() {
    assertEquals(3.0, this.Tesla.getEfficiency(), 0.01);
    assertEquals(4.5, this.Lucid.getEfficiency(), 0.01);
    assertEquals(0.5, this.Xpeng.getEfficiency(), 0.01);
  }

  /**
   * Test of calculation of the range
   * of ElectricVehicle objects.
   */
  @Test
  public void testRange() {
    assertEquals(100.0 * 0.8 * 3.0, this.Tesla.range(), 0.0001);
    assertEquals(150.0 * 1.0 * 4.5, this.Lucid.range(), 0.0001);
    assertEquals(10.0 * 0.15 * 0.5, this.Xpeng.range(), 0.0001);
  }

  /**
   * Test of calculation of the updated efficiency
   * based on current temperature
   * of ElectricVehicle objects.
   * Implementing a getter method
   * to ensure the value is correct.
   */
  @Test
  public void testUpdateEfficiency() {
    final double temp1 = 85.0;
    final double temp2 = 70.0;
    final double temp3 = 45.0;
    final double temp4 = 10.0;

    this.Tesla.updateEfficiency(temp1);
    assertEquals(3.0 * 0.85, this.Tesla.getEfficiency(), 0.0001);
    this.Tesla.updateEfficiency(temp2);
    assertEquals(3.0, this.Tesla.getEfficiency(), 0.01);
    this.Tesla.updateEfficiency(temp3);
    assertEquals((1 - (65 - temp3) * 0.01) * 3.0, this.Tesla.getEfficiency(), 0.00001);
    this.Tesla.updateEfficiency(temp4);
    assertEquals(3.0 * 0.5, this.Tesla.getEfficiency(), 0.001);
  }

  /**
   * Test of ElectricVehicle object string output
   * Implementing a setter method to
   * ensure number values to a string.
   */
  @Test
  public void testToString() {
    assertEquals("tesla SOC: 80.0% Range (miles): 240.0", this.Tesla.toString());
  }

  /**
   * Test of setting of the new state of charge
   * of ElectricVehicle objects.
   * Implementing a getter method
   * to ensure the value is correct.
   */
  @Test
  public void testSetStateOfCharge() {
    final double SoC1 = 2.0;
    final double SoC2 = 0.6;
    final double SoC3 = 0.12;

    this.Tesla.setStateOfCharge(SoC1);
    assertEquals(1.0, this.Tesla.getStateOfCharge(), 0.001);
    this.Tesla.setStateOfCharge(SoC2);
    assertEquals(0.6, this.Tesla.getStateOfCharge(), 0.001);
    this.Tesla.setStateOfCharge(SoC3);
    assertEquals(0.15, this.Tesla.getStateOfCharge(), 0.001);
  }
}
