package distance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/**
 * A JUnit test class for class Point3D.
 * Four Point3D objects constructed:
 * pointOne, pointTwo,
 * pointThree, pointFour, pointFive
 */
public class TestPoint3D {
  private Point3D pointOne;
  private Point3D pointTwo;
  private Point3D pointThree;
  private Point3D pointFour;
  private Point3D pointFive;

  /**
   * Set up parameters
   * for Point3D objects.
   */
  @Before
  public void setUp() {
    this.pointOne = new Point3D(3, 4, 5);
    this.pointTwo = new Point3D(1, 2, 3);
    this.pointThree = new Point3D();
    this.pointFour = new Point3D(pointTwo);
    this.pointFive = new Point3D(3,4,5);
  }

  /**
   * Test default point for Point3D objects
   * Implementing a getter method
   * to ensure the value is correct.
   */
  @Test
  public void testDefaultPoint() {
    assertEquals(0, this.pointThree.getX());
    assertEquals(0, this.pointThree.getY());
    assertEquals(0, this.pointThree.getZ());
  }

  /**
   * Test point constructor for Point3D objects
   * Implementing a getter method
   * to ensure the value is correct.
   */
  @Test
  public void testPointConstructor() {
    assertEquals(3, this.pointOne.getX());
    assertEquals(4, this.pointOne.getY());
    assertEquals(5, this.pointOne.getZ());
  }

  /**
   * Test point copy constructor for Point3D objects
   * Implementing a getter method
   * to ensure the value is correct.
   */
  @Test
  public void testPointCopy() {
    assertEquals(1, this.pointFour.getX());
    assertEquals(2, this.pointFour.getY());
    assertEquals(3, this.pointFour.getZ());
  }

  /**
   * Test of getting the x
   * of Point3D objects.
   */
  @Test
  public void testGetX() {
    assertEquals(3, pointOne.getX());
    assertEquals(1, pointTwo.getX());
  }

  /**
   * Test of getting the y
   * of Point3D objects.
   */
  @Test
  public void testGetY() {
    assertEquals(4, pointOne.getY());
    assertEquals(2, pointTwo.getY());
  }

  /**
   * Test of getting the z
   * of Point3D objects.
   */
  @Test
  public void testGetZ() {
    assertEquals(5, pointOne.getZ());
    assertEquals(3, pointTwo.getZ());
  }

  /**
   * Test distance to.
   */
  @Test
  public void testDistanceTo() {
    assertEquals(Math.sqrt(12), pointOne.distanceTo(pointTwo), 0.0000001);
    assertEquals(Math.sqrt(50), pointOne.distanceTo(pointThree), 0.0000001);
  }

  /**
   * Test of calculation of distance
   * between two Point3D objects.
   */
  @Test
  public void testEquals() {
    assertFalse("Points are not equal", pointOne.equals(pointTwo));
    assertTrue("Points are equal", pointOne.equals(pointFive));
  }

}