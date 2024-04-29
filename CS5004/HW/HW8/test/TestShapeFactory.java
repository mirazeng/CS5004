import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shape.Color;
import shape.Oval;
import shape.Rectangle;
import shape.ShapeFactory;
import shape.ShapePosition;

/** The type Test shape factory. */
public class TestShapeFactory {

  /** The Test position. */
  ShapePosition testPosition;

  /** The Test color. */
  Color testColor;

  /** Sets . */
  @BeforeEach
  public void setup() {
    testPosition = new ShapePosition(10, 20);
    testColor = new Color(255, 0, 0);
  }

  /** Test create shape rectangle. */
  @Test
  public void testCreateShapeRectangle() {
    Rectangle rectangle =
        (Rectangle)
            ShapeFactory.createShape("rect1", "Rectangle", testPosition, 100, 50, testColor);
    assertEquals("rect1", rectangle.getName());
    assertEquals("rectangle", rectangle.getType());
    assertEquals(testPosition, rectangle.getPosition());
    assertEquals(100, rectangle.getWidth());
    assertEquals(50, rectangle.getHeight());
    assertEquals(testColor, rectangle.getColor());
  }

  /** Test create shape oval. */
  @Test
  public void testCreateShapeOval() {
    Oval oval = (Oval) ShapeFactory.createShape("oval1", "oVaL", testPosition, 80, 40, testColor);
    assertEquals("oval1", oval.getName());
    assertEquals("oval", oval.getType());
    assertEquals(testPosition, oval.getPosition());
    assertEquals(80, oval.getRadiusX());
    assertEquals(40, oval.getRadiusY());
    assertEquals(testColor, oval.getColor());
  }

  /** Test create shape invalid type. */
  @Test
  public void testCreateShapeInvalidType() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          ShapeFactory.createShape("shape1", "triangle", testPosition, 100, 100, testColor);
        });
  }
}