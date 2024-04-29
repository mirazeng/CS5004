package TestModel;

import model.canvasDisplay.Canvas;
import model.canvasDisplay.ICanvas;
import model.shape.*;
import model.snapshot.ISnapshot;
import model.snapshot.Snapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The type Test canvas.
 */
public class TestCanvas {

  /**
   * The Canvas.
   */
  ICanvas canvas;

  /**
   * The Test oval.
   */
  IShape testOval;

  /**
   * The Test rectangle.
   */
  IShape testRectangle;

  /**
   * The Test color.
   */
  ShapeColor testShapeColor;

  /**
   * The Pos 1.
   */
  ShapePosition pos1;

  /**
   * The Pos 2.
   */
  ShapePosition pos2;

  /**
   * The Test snapshot.
   */
  ISnapshot testSnapshot;

  /**
   * Sets .
   */
  @BeforeEach
  public void setup() {
    canvas = new Canvas();
    testShapeColor = new ShapeColor(55, 55, 55);
    pos1 = new ShapePosition(100, 100);
    pos2 = new ShapePosition(200, 200);

    testOval = new Oval("oval", "oval", pos1, 50, 50, testShapeColor);
    testRectangle = new Rectangle("rect", "rectangle", pos2, 40, 60, testShapeColor);

    List<IShape> testList = new ArrayList<>();
    testList.add(testOval);
    testList.add(testRectangle);
    testSnapshot =
            new Snapshot("testIDFromTime", "right now", "Snapshot for testing Canvas class", testList);
  }

  /**
   * Test canvas constructor.
   */
  @Test
  public void testCanvasConstructor() {
    assertEquals(0, canvas.getShapes().size());
  }

  /**
   * Test reset canvas.
   */
  @Test
  public void testResetCanvas() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    canvas.addShape("rect", "rectangle", 200, 200, 40, 60, 55, 55, 55);
    assertEquals(2, canvas.getShapes().size());
    canvas.resetCanvas();
    assertEquals(0, canvas.getShapes().size());
  }

  /**
   * Test add shape.
   */
  @Test
  public void testAddShape() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    assertEquals(1, canvas.getShapes().size());
  }

  /**
   * Test add shape throws.
   */
  @Test
  public void testAddShapeThrows() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    assertEquals(1, canvas.getShapes().size());
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
            });

    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.addShape("", "oval", 100, 100, 50, 50, 55, 55, 55);
            });

    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.addShape(null, "oval", 100, 100, 50, 50, 55, 55, 55);
            });
  }

  /**
   * Test remove shape.
   */
  @Test
  public void testRemoveShape() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    canvas.addShape("rect", "rectangle", 200, 200, 40, 60, 55, 55, 55);
    assertEquals(2, canvas.getShapes().size());
    canvas.removeShape("oval");
    assertEquals(1, canvas.getShapes().size());
    assertEquals("rect", canvas.getShapes().get(0).getName());
  }

  /**
   * Test remove shape throws.
   */
  @Test
  public void testRemoveShapeThrows() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    canvas.addShape("rect", "rectangle", 200, 200, 40, 60, 55, 55, 55);
    assertEquals(2, canvas.getShapes().size());
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.removeShape("circle");
            });
  }

  /**
   * Test move shape.
   */
  @Test
  public void testMoveShape() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    canvas.moveShape("oval", 200, 200);
    assertEquals(200, canvas.getShapes().get(0).getPosition().getX());
  }

  /**
   * Test move shape throws.
   */
  @Test
  public void testMoveShapeThrows() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.moveShape("circle", 200, 200);
            });
  }

  /**
   * Test scale shape.
   */
  @Test
  public void testScaleShape() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    canvas.scaleShape("oval", 2, 2);
    assertEquals(100, canvas.getShapes().get(0).getPosition().getX());
  }

  /**
   * Test scale shape throws.
   */
  @Test
  public void testScaleShapeThrows() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.scaleShape("circle", 2, 2);
            });
  }

  /**
   * Test change shape color.
   */
  @Test
  public void testChangeShapeShapeColor() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    canvas.changeShapeColor("oval", 255, 255, 255);
    assertEquals(255, canvas.getShapes().get(0).getColor().getRed());
    assertEquals(255, canvas.getShapes().get(0).getColor().getGreen());
    assertEquals(255, canvas.getShapes().get(0).getColor().getBlue());
  }

  /**
   * Test change shape color throws.
   */
  @Test
  public void testChangeShapeShapeColorThrows() {
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    assertThrows(
            IllegalArgumentException.class,
            () -> {
              canvas.changeShapeColor("circle", 255, 255, 255);
            });
  }

  /**
   * Test display shapes from snapshot.
   */
  @Test
  public void testDisplayShapesFromSnapshot() {
    canvas.displayShapesFromSnapshot((Snapshot) testSnapshot);
    assertEquals(2, canvas.getShapes().size());
  }

  /**
   * Gets shapes.
   */
  @Test
  public void getShapes() {
    assertEquals(0, canvas.getShapes().size());
    canvas.addShape("oval", "oval", 100, 100, 50, 50, 55, 55, 55);
    assertEquals(1, canvas.getShapes().size());
    assertEquals("oval", canvas.getShapes().get(0).getName());
  }
}