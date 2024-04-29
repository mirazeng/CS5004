import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shape.Color;

/** The type Test color. */
public class TestColor {

  Color testColor;
  double r, g, b;

  /** Sets up before each test. */
  @BeforeEach
  public void setup() {
    r = 128.0;
    g = 128.0;
    b = 128.0;
    testColor = new Color(r, g, b);
  }

  /** Test color constructor. */
  @Test
  public void testColorConstructor() {
    Color newColor = new Color(r, g, b);
    assertEquals(128.0, newColor.getRed());
    assertEquals(128.0, newColor.getGreen());
    assertEquals(128.0, newColor.getBlue());
  }

  /** Test color constructor throws negative values. */
  @Test
  public void testColorConstructorThrowsNegativeValues() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Color(-1, -1, -1);
        });
  }

  /** Test color constructor throws values above 255. */
  @Test
  public void testColorConstructorThrowsValuesAbove255() {
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Color(256, 256, 256);
        });
  }

  /** Test get red. */
  @Test
  public void testGetRed() {
    assertEquals(128.0, testColor.getRed());
  }

  /** Test get green. */
  @Test
  public void testGetGreen() {
    assertEquals(128.0, testColor.getGreen());
  }

  /** Test get blue. */
  @Test
  public void testGetBlue() {
    assertEquals(128.0, testColor.getBlue());
  }

  @Test
  public void testToString() {
    assertEquals("128.0,128.0,128.0", testColor.toString());
  }
}