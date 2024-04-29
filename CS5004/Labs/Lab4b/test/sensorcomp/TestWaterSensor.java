package sensorcomp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Test waster sensor.
 */
public class TestWaterSensor {

  private WaterSensor sensor1;
  private WaterSensor sensor2;
  private WaterSensor sensor3;
  private WaterSensor sensor4;

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    sensor1 = new WaterSensor(0.1);
    sensor2 = new WaterSensor(0.4);
    sensor3 = new WaterSensor(0.0);
    sensor4 = new WaterSensor(0.51);
  }

  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals(sensor1.lastReading(), 0.1);
    assertEquals(sensor2.lastReading(), 0.4);
    assertEquals(sensor3.lastReading(), 0.0);
    assertEquals(sensor4.lastReading(), 0.51);
  }

  /**
   * Test if flooding.
   */
  @Test
  public void testIfFlooding() {
    assertFalse(sensor1.status());
    assertFalse(sensor2.status());
    assertFalse(sensor3.status());
    assertTrue(sensor4.status());
  }

  /**
   * Test flip status.
   */
  @Test
  public void testFlipStatus() {
    sensor1.flipStatus();
    assertTrue(sensor1.status());
    sensor1.flipStatus();
    assertFalse(sensor1.status());
  }

  /**
   * Test set status.
   */
  @Test
  public void testSetStatus() {
    sensor1.setStatus(true);
    assertTrue(sensor1.status());
    sensor1.setStatus(false);
    assertFalse(sensor1.status());
  }

  /**
   * Test take new reading.
   */
  @Test
  public void testTakeNewReading() {

    // test if the sensor is working properly
    // and if the status is being updated
    assertEquals(0.1, sensor1.takeNewReading());
    assertFalse(sensor1.status());
    sensor1 = new WaterSensor(0.4);
    assertEquals(0.4, sensor1.takeNewReading());
    assertFalse(sensor1.status());
    sensor1 = new WaterSensor(0.0);
    assertEquals(0.0, sensor1.takeNewReading());
    assertFalse(sensor1.status());
    sensor1 = new WaterSensor(0.51);
    assertEquals(0.51, sensor1.takeNewReading());
    assertTrue(sensor1.status());
  }

}