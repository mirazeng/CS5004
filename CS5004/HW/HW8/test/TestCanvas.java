import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import canvasDisplay.Canvas;
import canvasDisplay.ICanvas;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shape.*;
import snapshot.ISnapshot;
import snapshot.Snapshot;

/** The type Test canvas. */
public class TestCanvas {

  /** The Canvas. */
  ICanvas canvas;

  /** The Test oval. */
  IShape testOval;

  /** The Test rectangle. */
  IShape testRectangle;

  /** The Test color. */
  Color testColor;

  /** The Pos 1. */
  ShapePosition pos1;

  /** The Pos 2. */
  ShapePosition pos2;

  /** The Test snapshot. */
  ISnapshot testSnapshot;

  /** Sets . */
  @BeforeEach
  public void setup() {
    canvas = new Canvas();
    testColor = new Color(55.0, 55.0, 55.0);
    pos1 = new ShapePosition(100.0, 100.0);
    pos2 = new ShapePosition(200.0, 200.0);

    testOval = new Oval("oval", "oval", pos1, 50.0, 50.0, testColor);
    testRectangle = new Rectangle("rect", "rectangle", pos2, 40.0, 60.0, testColor);

    List<IShape> testList = new ArrayList<>();
    testList.add(testOval);
    testList.add(testRectangle);
    testSnapshot =
        new Snapshot("testIDFromTime", "right now", "Snapshot for testing Canvas class", testList);
  }

  /** Test canvas constructor. */
  @Test
  public void testCanvasConstructor() {
    assertEquals(0, canvas.getShapes().size());
  }

  /** Test reset canvas. */
  @Test
  public void testResetCanvas() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    canvas.addShape("rect", "rectangle", 200.0, 200.0, 40.0, 60.0, 55.0, 55.0, 55.0);
    assertEquals(2, canvas.getShapes().size());
    canvas.resetCanvas();
    assertEquals(0, canvas.getShapes().size());
  }

  /** Test add shape. */
  @Test
  public void testAddShape() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    assertEquals(1, canvas.getShapes().size());
  }

  /** Test add shape throws. */
  @Test
  public void testAddShapeThrows() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    assertEquals(1, canvas.getShapes().size());
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
        });

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.addShape("", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
        });

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.addShape(null, "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
        });
  }

  /** Test remove shape. */
  @Test
  public void testRemoveShape() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    canvas.addShape("rect", "rectangle", 200.0, 200.0, 40.0, 60.0, 55.0, 55.0, 55.0);
    assertEquals(2, canvas.getShapes().size());
    canvas.removeShape("oval");
    assertEquals(1, canvas.getShapes().size());
    assertEquals("rect", canvas.getShapes().get(0).getName());
  }

  /** Test remove shape throws. */
  @Test
  public void testRemoveShapeThrows() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    canvas.addShape("rect", "rectangle", 200.0, 200.0, 40.0, 60.0, 55.0, 55.0, 55.0);
    assertEquals(2, canvas.getShapes().size());
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.removeShape("circle");
        });
  }

  /** Test move shape. */
  @Test
  public void testMoveShape() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    canvas.moveShape("oval", 200.0, 200.0);
    assertEquals(200.0, canvas.getShapes().get(0).getPosition().getX());
  }

  /** Test move shape throws. */
  @Test
  public void testMoveShapeThrows() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.moveShape("circle", 200.0, 200.0);
        });
  }

  /** Test scale shape. */
  @Test
  public void testScaleShape() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    canvas.scaleShape("oval", 2, 2);
    assertEquals(100.0, canvas.getShapes().get(0).getPosition().getX());
  }

  /** Test scale shape throws. */
  @Test
  public void testScaleShapeThrows() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.scaleShape("circle", 2, 2);
        });
  }

  /** Test change shape color. */
  @Test
  public void testChangeShapeColor() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    canvas.changeShapeColor("oval", 255.0, 255.0, 255.0);
    assertEquals(255.0, canvas.getShapes().get(0).getColor().getRed());
    assertEquals(255.0, canvas.getShapes().get(0).getColor().getGreen());
    assertEquals(255.0, canvas.getShapes().get(0).getColor().getBlue());
  }

  /** Test change shape color throws. */
  @Test
  public void testChangeShapeColorThrows() {
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          canvas.changeShapeColor("circle", 255.0, 255.0, 255.0);
        });
  }

  /** Test display shapes from snapshot. */
  @Test
  public void testDisplayShapesFromSnapshot() {
    canvas.displayShapesFromSnapshot((Snapshot) testSnapshot);
    assertEquals(2, canvas.getShapes().size());
  }

  /** Gets shapes. */
  @Test
  public void getShapes() {
    assertEquals(0, canvas.getShapes().size());
    canvas.addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    assertEquals(1, canvas.getShapes().size());
    assertEquals("oval", canvas.getShapes().get(0).getName());
  }
}