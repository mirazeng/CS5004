package TestModel;

import model.shape.Oval;
import model.shape.ShapeColor;
import model.shape.ShapePosition;
import model.shape.SuperShape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Test super shape.
 */
public class TestSuperShape {

  /**
   * The Test shape.
   */
  SuperShape testShape;

  /**
   * The Name.
   */
  String name;

  /**
   * The Type.
   */
  String type;

  /**
   * The Position.
   */
  ShapePosition position;

  /**
   * The ShapeColor.
   */
  ShapeColor color;

  /**
   * Sets .
   */
  @BeforeEach
  public void setup() {
    name = "testShape";
    type = "oval";
    position = new ShapePosition(10, 20);
    color = new ShapeColor(255, 0, 0);
    testShape = new Oval(name, type, position, 50, 30, color);
  }

  /**
   * Test super shape constructor.
   */
  @Test
  public void testSuperShapeConstructor() {
    assertEquals(name, testShape.getName());
    assertEquals(type, testShape.getType());
    assertEquals(position, testShape.getPosition());
    assertEquals(color, testShape.getColor());
  }

  /**
   * Test super shape copy constructor.
   */
  @Test
  public void testSuperShapeCopyConstructor() {
    SuperShape copyShape = new Oval((Oval) testShape);
    assertEquals(testShape.getName(), copyShape.getName());
    assertEquals(testShape.getType(), copyShape.getType());
    assertEquals(testShape.getPosition(), copyShape.getPosition());
    assertEquals(testShape.getColor(), copyShape.getColor());
  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals(name, testShape.getName());
  }

  /**
   * Test get type.
   */
  @Test
  public void testGetType() {
    assertEquals(type, testShape.getType());
  }

  /**
   * Test get position.
   */
  @Test
  public void testGetPosition() {
    assertEquals(position, testShape.getPosition());
  }

  /**
   * Test set position.
   */
  @Test
  public void testSetPosition() {
    ShapePosition newPosition = new ShapePosition(30, 40);
    testShape.setPosition(newPosition);
    assertEquals(newPosition, testShape.getPosition());
  }

  /**
   * Test get color.
   */
  @Test
  public void testGetShapeColor() {
    assertEquals(color, testShape.getColor());
  }

  /**
   * Test change color.
   */
  @Test
  public void testChangeShapeColor() {
    ShapeColor newShapeColor = new ShapeColor(0, 255, 0);
    testShape.changeColor(newShapeColor);
    assertEquals(newShapeColor, testShape.getColor());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    String expectedString =
            """
                    Name: testShape
                    Type: oval
                    Center: (10,20), X radius: 50, Y radius: 30, ShapeColor: (255,0,0)
                    """;
    assertEquals(expectedString, testShape.toString());
  }
}