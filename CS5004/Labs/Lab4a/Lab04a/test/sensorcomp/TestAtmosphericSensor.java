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

  /**
   * Sets up.
   */
  @BeforeEach
  public void setUp() {
    sensor1 = new AtmosphericSensor(0.1);
    sensor2 = new AtmosphericSensor(0.4);
    sensor3 = new AtmosphericSensor(0.0);
  }

  /**
   * Test constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals(0.1, sensor1.lastReading());
    assertEquals(0.4, sensor2.lastReading());
  }

  /**
   * Test take new reading.
   */
  @Test
  public void testTakeNewReading() {

    assertEquals(0.1, sensor3.takeNewReading());
  }

  /**
   * Test last reading.
   */
  @Test
  public void testLastReading() {
    assertEquals(0.1, sensor1.lastReading());
    assertEquals(0.4, sensor2.lastReading());
  }
}