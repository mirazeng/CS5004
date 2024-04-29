package sensorcomp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * The type Test atmospheric sensor.
 */
public class TestAtmosphericSensor {
  private AtmosphericSensor sensor1;
  private AtmosphericSensor sensor2;
  private AtmosphericSensor sensor3;
  private AtmosphericSensor sensor4;

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    sensor1 = new AtmosphericSensor(0.1);
    sensor2 = new AtmosphericSensor(0.4);
    sensor3 = new AtmosphericSensor(0.0);
    sensor4 = new AtmosphericSensor(0.51);
  }

  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals(0.1, sensor1.lastReading());
    assertEquals(0.4, sensor2.lastReading());
    assertEquals(0.0, sensor3.lastReading());
    assertEquals(0.51, sensor4.lastReading());
  }

  /**
   * Test take new reading.
   */
  @Test
  public void testTakeNewReading() {
    assertEquals(0.1, sensor1.takeNewReading());
  }

  /**
   * Test last reading.
   */
  @Test
  public void testLastReading() {
    assertEquals(0.1, sensor1.lastReading());
    assertEquals(0.4, sensor2.lastReading());
    assertEquals(0.0, sensor3.lastReading());
    assertEquals(0.51, sensor4.lastReading());
  }

}