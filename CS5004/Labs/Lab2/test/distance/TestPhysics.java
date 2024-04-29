package distance;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for class Physics.
 * Two Point3D  objects constructed as test examples:
 * point1, point2
 */
public class TestPhysics {
  private Point3D point1;
  private Point3D point2;

  /**
   * Set up parameters for Point3D objects.
   */
  @Before
  public void setUp() {
    this.point1 = new Point3D();
    this.point2 = new Point3D(2,3,4);
  }

  /**
   * Test the calculation of velocity
   * between two points.
   */
  @Test
  public void testVelocity() {
    assertEquals(0, Physics.velocity(point1, point1, 10), 0.0001);
    assertEquals(Math.sqrt(29) / 10.0, Physics.velocity(point1, point2, 10), 0.001);
  }

  /**
   * Test the velocity calculation
   * when input elapsedTime is invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidVelocity() {
    double elapsedTime1 = Physics.velocity(point1, point2, -100);
    double elapsedTime2 = Physics.velocity(point1, point2, 0);
  }
}

