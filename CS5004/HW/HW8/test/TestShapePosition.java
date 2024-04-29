import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shape.ShapePosition;

/** The type Test shape position. */
public class TestShapePosition {

  /** The Test position. */
  ShapePosition testPosition;

  /** Sets . */
  @BeforeEach
  public void setup() {
    testPosition = new ShapePosition(10.5, 20.7);
  }

  /** Test shape position constructor. */
  @Test
  public void testShapePositionConstructor() {
    assertEquals(10.5, testPosition.getX());
    assertEquals(20.7, testPosition.getY());
  }

  /** Test get x. */
  @Test
  public void testGetX() {
    assertEquals(10.5, testPosition.getX());
  }

  /** Test set x. */
  @Test
  public void testSetX() {
    testPosition.setX(15);
    assertEquals(15.0, testPosition.getX());
  }

  /** Test get y. */
  @Test
  public void testGetY() {
    assertEquals(20.7, testPosition.getY());
  }

  /** Test set y. */
  @Test
  public void testSetY() {
    testPosition.setY(30);
    assertEquals(30.0, testPosition.getY());
  }

  /** Test to string. */
  @Test
  public void testToString() {
    String expectedString = "(10.5, 20.7)";
    assertEquals(expectedString, testPosition.toString());
  }
}