package TestModel;

import model.shape.Rectangle;
import model.shape.ShapeColor;
import model.shape.ShapePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Test rectangle.
 */
public class TestRectangle {

  /**
   * The Test rectangle.
   */
  Rectangle testRectangle;

  /**
   * The Test color.
   */
  ShapeColor testShapeColor;

  /**
   * The Test position.
   */
  ShapePosition testPosition;

  /**
   * Sets .
   */
  @BeforeEach
  public void setup() {
    testShapeColor = new ShapeColor(0, 255, 0);
    testPosition = new ShapePosition(50, 100);
    testRectangle = new Rectangle("rect1", "rectangle", testPosition, 80, 40, testShapeColor);
  }

  /**
   * Test rectangle constructor.
   */
  @Test
  public void testRectangleConstructor() {
    assertEquals("rect1", testRectangle.getName());
    assertEquals("rectangle", testRectangle.getType());
    assertEquals(testPosition, testRectangle.getPosition());
    assertEquals(80, testRectangle.getWidth());
    assertEquals(40, testRectangle.getHeight());
    assertEquals(testShapeColor, testRectangle.getColor());
  }

  /**
   * Test rectangle copy constructor.
   */
  @Test
  public void testRectangleCopyConstructor() {
    Rectangle copyRectangle = new Rectangle(testRectangle);
    assertEquals(testRectangle.getName(), copyRectangle.getName());
    assertEquals(testRectangle.getType(), copyRectangle.getType());
    assertEquals(testRectangle.getPosition(), copyRectangle.getPosition());
    assertEquals(testRectangle.getWidth(), copyRectangle.getWidth());
    assertEquals(testRectangle.getHeight(), copyRectangle.getHeight());
    assertEquals(testRectangle.getColor(), copyRectangle.getColor());
  }

  /**
   * Test get width.
   */
  @Test
  public void testGetWidth() {
    assertEquals(80, testRectangle.getWidth());
  }

  /**
   * Test set width.
   */
  @Test
  public void testSetWidth() {
    testRectangle.setWidth(120);
    assertEquals(120, testRectangle.getWidth());
  }

  /**
   * Test get height.
   */
  @Test
  public void testGetHeight() {
    assertEquals(40, testRectangle.getHeight());
  }

  /**
   * Test set height.
   */
  @Test
  public void testSetHeight() {
    testRectangle.setHeight(60);
    assertEquals(60, testRectangle.getHeight());
  }

  /**
   * Test resize.
   */
  @Test
  public void testResize() {
    testRectangle.resize(2, 2);
    assertEquals(2, testRectangle.getWidth());
    assertEquals(2, testRectangle.getHeight());
  }

  /**
   * Test clone shape.
   */
  @Test
  public void testCloneShape() {
    Rectangle clonedRectangle = (Rectangle) testRectangle.cloneShape();
    assertEquals(testRectangle.getName(), clonedRectangle.getName());
    assertEquals(testRectangle.getType(), clonedRectangle.getType());
    assertEquals(testRectangle.getPosition(), clonedRectangle.getPosition());
    assertEquals(testRectangle.getWidth(), clonedRectangle.getWidth());
    assertEquals(testRectangle.getHeight(), clonedRectangle.getHeight());
    assertEquals(testRectangle.getColor(), clonedRectangle.getColor());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    String expectedString =
            "Name: rect1\n"
                    + "Type: rectangle\n"
                    + "Min corner: (50,100), Width: 80, Height: 40, ShapeColor: (0,255,0)\n";
    assertEquals(expectedString, testRectangle.toString());
  }
}