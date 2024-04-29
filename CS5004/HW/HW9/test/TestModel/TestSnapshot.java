package TestModel;

import model.shape.*;
import model.snapshot.ISnapshot;
import model.snapshot.Snapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * The type Test snapshot.
 */
public class TestSnapshot {

  /**
   * The Test snapshot.
   */
  ISnapshot testSnapshot;

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
   * Sets .
   */
  @BeforeEach
  public void setup() {
    testShapeColor = new ShapeColor(55, 55, 55);
    pos1 = new ShapePosition(100, 100);
    pos2 = new ShapePosition(200, 200);

    testOval = new Oval("oval", "oval", pos1, 50, 50, testShapeColor);
    testRectangle = new Rectangle("rect", "rectangle", pos2, 40, 60, testShapeColor);

    List<IShape> testList = new ArrayList<>();
    testList.add(testOval);
    testList.add(testRectangle);
    testSnapshot = new Snapshot("testIDFromTime", "right now", "Snapshot for testing", testList);
  }

  /**
   * Test snapshot constructor.
   */
  @Test
  public void testSnapshotConstructor() {
    assertEquals("testIDFromTime", testSnapshot.getSnapshotID());
    assertEquals("right now", testSnapshot.getTimeStamp());
    assertEquals("Snapshot for testing", testSnapshot.getDescription());
    assertEquals(2, testSnapshot.getShapes().size());
  }

  /**
   * Test get snapshot id.
   */
  @Test
  public void testGetSnapshotID() {
    assertEquals("testIDFromTime", testSnapshot.getSnapshotID());
  }

  /**
   * Test set snapshot id.
   */
  @Test
  public void testSetSnapshotID() {
    testSnapshot.setSnapshotID("newSnapshotID");
    assertEquals("newSnapshotID", testSnapshot.getSnapshotID());
  }

  /**
   * Test get time stamp.
   */
  @Test
  public void testGetTimeStamp() {
    assertEquals("right now", testSnapshot.getTimeStamp());
  }

  /**
   * Test set time stamp.
   */
  @Test
  public void testSetTimeStamp() {
    testSnapshot.setTimeStamp("new timestamp");
    assertEquals("new timestamp", testSnapshot.getTimeStamp());
  }

  /**
   * Test get description.
   */
  @Test
  public void testGetDescription() {
    assertEquals("Snapshot for testing", testSnapshot.getDescription());
  }

  /**
   * Test set description.
   */
  @Test
  public void testSetDescription() {
    testSnapshot.setDescription("new description");
    assertEquals("new description", testSnapshot.getDescription());
  }

  /**
   * Test get shapes.
   */
  @Test
  public void testGetShapes() {
    List<IShape> shapes = testSnapshot.getShapes();
    assertEquals(2, shapes.size());
    assertNotSame(testOval, shapes.get(0));
    assertNotSame(testRectangle, shapes.get(1));
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    String expectedString =
            """
                    Snapshot ID: testIDFromTime
                    Timestamp: right now
                    Description: Snapshot for testing
                    Shape Information:
                    Name: oval
                    Type: oval
                    Center: (100,100), X radius: 50, Y radius: 50, ShapeColor: (55,55,55)

                    Name: rect
                    Type: rectangle
                    Min corner: (200,200), Width: 40, Height: 60, ShapeColor: (55,55,55)
                    """;
    assertEquals(expectedString, testSnapshot.toString());
  }
}