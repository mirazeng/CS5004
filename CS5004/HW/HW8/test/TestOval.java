import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shape.Color;
import shape.Oval;
import shape.ShapePosition;

/** The type Test oval. */
public class TestOval {

  /** The Test oval. */
  Oval testOval;

  /** The Test color. */
  Color testColor;

  /** The Test position. */
  ShapePosition testPosition;

  /** Sets . */
  @BeforeEach
  public void setup() {
    testColor = new Color(255, 0, 0);
    testPosition = new ShapePosition(100, 200);
    testOval = new Oval("oval1", "oval", testPosition, 50, 30, testColor);
  }

  /** Test oval constructor. */
  @Test
  public void testOvalConstructor() {
    assertEquals("oval1", testOval.getName());
    assertEquals("oval", testOval.getType());
    assertEquals(testPosition, testOval.getPosition());
    assertEquals(50, testOval.getRadiusX());
    assertEquals(30, testOval.getRadiusY());
    assertEquals(testColor, testOval.getColor());
  }

  /** Test oval copy constructor. */
  @Test
  public void testOvalCopyConstructor() {
    Oval copyOval = new Oval(testOval);
    assertEquals(testOval.getName(), copyOval.getName());
    assertEquals(testOval.getType(), copyOval.getType());
    assertEquals(testOval.getPosition(), copyOval.getPosition());
    assertEquals(testOval.getRadiusX(), copyOval.getRadiusX());
    assertEquals(testOval.getRadiusY(), copyOval.getRadiusY());
    assertEquals(testOval.getColor(), copyOval.getColor());
  }

  /** Test get radius x. */
  @Test
  public void testGetRadiusX() {
    assertEquals(50, testOval.getRadiusX());
  }

  /** Test set radius x. */
  @Test
  public void testSetRadiusX() {
    testOval.setRadiusX(80);
    assertEquals(80, testOval.getRadiusX());
  }

  /** Test get radius y. */
  @Test
  public void testGetRadiusY() {
    assertEquals(30, testOval.getRadiusY());
  }

  /** Test set radius y. */
  @Test
  public void testSetRadiusY() {
    testOval.setRadiusY(60);
    assertEquals(60, testOval.getRadiusY());
  }

  /** Test resize. */
  @Test
  public void testResize() {
    testOval.resize(2, 3);
    assertEquals(100, testOval.getRadiusX());
    assertEquals(90, testOval.getRadiusY());
  }

  /** Test clone shape. */
  @Test
  public void testCloneShape() {
    Oval clonedOval = (Oval) testOval.cloneShape();
    assertEquals(testOval.getName(), clonedOval.getName());
    assertEquals(testOval.getType(), clonedOval.getType());
    assertEquals(testOval.getPosition(), clonedOval.getPosition());
    assertEquals(testOval.getRadiusX(), clonedOval.getRadiusX());
    assertEquals(testOval.getRadiusY(), clonedOval.getRadiusY());
    assertEquals(testOval.getColor(), clonedOval.getColor());
  }

  /** Test to string. */
  @Test
  public void testToString() {
    String expectedString =
        "Name: oval1\n"
            + "Type: oval\n"
            + "Center: (100.0,200.0), X radius: 50.0, Y radius: 30.0, Color: (255.0,0.0,0.0)\n";
    assertEquals(expectedString, testOval.toString());
  }
}