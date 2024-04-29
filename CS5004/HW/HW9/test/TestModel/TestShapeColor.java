package TestModel;

import model.shape.ShapeColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The type Test color.
 */
public class TestShapeColor {

  /**
   * The Test shape color.
   */
  ShapeColor testShapeColor;
  /**
   * The R.
   */
  int r, /**
   * The G.
   */
  g, /**
   * The B.
   */
  b;

  /**
   * Sets up before each test.
   */
  @BeforeEach
  public void setup() {
    r = 128;
    g = 128;
    b = 128;
    testShapeColor = new ShapeColor(r, g, b);
  }

  /**
   * Test color constructor.
   */
  @Test
  public void testShapeColorConstructor() {
    ShapeColor newShapeColor = new ShapeColor(r, g, b);
    assertEquals(128, newShapeColor.getRed());
    assertEquals(128, newShapeColor.getGreen());
    assertEquals(128, newShapeColor.getBlue());
  }

  /**
   * Test color constructor throws negative values.
   */
  @Test
  public void testShapeColorConstructorThrowsNegativeValues() {
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              new ShapeColor(-1, -1, -1);
            });
  }

  /**
   * Test color constructor throws values above 255.
   */
  @Test
  public void testShapeColorConstructorThrowsValuesAbove255() {
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              new ShapeColor(256, 256, 256);
            });
  }

  /**
   * Test get red.
   */
  @Test
  public void testGetRed() {
    assertEquals(128, testShapeColor.getRed());
  }

  /**
   * Test get green.
   */
  @Test
  public void testGetGreen() {
    assertEquals(128, testShapeColor.getGreen());
  }

  /**
   * Test get blue.
   */
  @Test
  public void testGetBlue() {
    assertEquals(128, testShapeColor.getBlue());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("128,128,128", testShapeColor.toString());
  }
}