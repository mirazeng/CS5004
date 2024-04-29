package TestModel;

import model.photoAlbum.IAlbum;
import model.photoAlbum.ShapeAlbum;
import model.snapshot.ISnapshot;
import model.snapshot.Snapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Test shape album.
 */
public class TestShapeAlbum {

  private IAlbum album;

  /**
   * Sets .
   */
  @BeforeEach
  public void setup() {
    album = new ShapeAlbum();
  }

  /**
   * Test shape album constructor.
   */
  @Test
  public void testShapeAlbumConstructor() {
    assertNotNull(album.getCanvas());
    assertNotNull(album.getSnapshots());
    assertEquals(0, album.getSnapshots().size());
  }

  /**
   * Test reset album.
   */
  @Test
  public void testResetAlbum() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    assertEquals(1, album.getSnapshots().size());
    album.resetAlbum();
    assertEquals(0, album.getCanvas().getShapes().size());
    assertEquals(0, album.getSnapshots().size());
  }

  /**
   * Test take snapshot.
   */
  @Test
  public void testTakeSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    assertEquals(1, album.getSnapshots().size());
    Snapshot snapshot = (Snapshot) album.getSnapshots().get(0);
    assertNotNull(snapshot.getSnapshotID());
    assertNotNull(snapshot.getTimeStamp());
    assertEquals("Snapshot 1", snapshot.getDescription());
    assertEquals(1, snapshot.getShapes().size());
  }

  /**
   * Test get snapshot.
   */
  @Test
  public void testGetSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    String snapshotID = album.getSnapshots().get(0).getSnapshotID();
    Snapshot retrievedSnapshot = album.getSnapshot(snapshotID);
    System.out.println(retrievedSnapshot);
    assertNotNull(retrievedSnapshot);
    assertEquals(snapshotID, retrievedSnapshot.getSnapshotID());
    assertNull(album.getSnapshot("nonexistent"));
  }

  /**
   * Test remove snapshot.
   */
  @Test
  public void testRemoveSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50, 55,
            55, 55);
    album.takeSnapshot("Snapshot 1");
    String snapshotID = album.getSnapshots().get(0).getSnapshotID();
    assertEquals(1, album.getSnapshots().size());
    album.removeSnapshot(snapshotID);
    assertEquals(0, album.getSnapshots().size());
    album.removeSnapshot("nonexistent");
    assertEquals(0, album.getSnapshots().size());
  }

  /**
   * Test get current snapshot.
   */
  @Test
  public void testGetCurrentSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    ISnapshot currentSnapshot = album.getCurrentSnapshot();
    assertNotNull(currentSnapshot);
    assertEquals("Snapshot 1", currentSnapshot.getDescription());
  }

  /**
   * Test get current snapshot id.
   */
  @Test
  public void testGetCurrentSnapshotID() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    String currentSnapshotID = album.getCurrentSnapshotID();
    assertNotNull(currentSnapshotID);
    assertEquals(currentSnapshotID, album.getSnapshots().get(0).getSnapshotID());
  }

  /**
   * Test get prev snapshot.
   */
  @Test
  public void testGetPrevSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");

    album.getCanvas().addShape("rect", "rectangle",
            200, 200,
            40, 60,
            55, 55, 55);
    album.takeSnapshot("Snapshot 2");

    int currentSnapshotIndex = album.getSnapshots().indexOf(album.getCurrentSnapshot());
    assertEquals(1, currentSnapshotIndex);
    album.getPrevSnapshot();
    assertEquals(0, album.getSnapshots().indexOf(album.getCurrentSnapshot()));
  }

  /**
   * Test next snapshot.
   */
  @Test
  public void testNextSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");

    album.getCanvas().addShape("rect", "rectangle",
            200, 200,
            40, 60,
            55, 55, 55);
    album.takeSnapshot("Snapshot 2");

    int currentSnapshotIndex = album.getSnapshots().indexOf(album.getCurrentSnapshot());
    assertEquals(1, currentSnapshotIndex);
    album.getPrevSnapshot();
    assertEquals(0, album.getSnapshots().indexOf(album.getCurrentSnapshot()));
    album.getNextSnapshot();
    assertEquals(1, album.getSnapshots().indexOf(album.getCurrentSnapshot()));
  }

  /**
   * Test import snapshot to canvas.
   */
  @Test
  public void testImportSnapshotToCanvas() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    String snapshotID = album.getSnapshots().get(0).getSnapshotID();
    album.getCanvas().resetCanvas();
    assertEquals(0, album.getCanvas().getShapes().size());
    album.importSnapshotToCanvas(snapshotID);
    assertEquals(1, album.getCanvas().getShapes().size());
  }

  /**
   * Test print snapshots' info.
   */
  @Test
  public void testPrintSnapshotsInfo() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");
    album.getCanvas().addShape("rect", "rectangle",
            200, 200,
            40, 60,
            55, 55, 55);
    album.takeSnapshot("Snapshot 2");
    String info = album.printSnapshotsInfo();
    assertTrue(info.contains("Printing Snapshots"));
    assertTrue(info.contains("Snapshot 1"));
    assertTrue(info.contains("Snapshot 2"));
  }

  /**
   * Test set current snapshot by id.
   */
  @Test
  public void testSetCurrentSnapshotByID() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);
    album.takeSnapshot("Snapshot 1");

    album.getCanvas().addShape("rect", "rectangle",
            200, 200,
            40, 60,
            55, 55, 55);
    album.takeSnapshot("Snapshot 2");

    album.setCurrentSnapshotByID(album.getSnapshots().get(0).getSnapshotID());
    assertEquals("Snapshot 1", album.getCurrentSnapshot().getDescription());
    album.setCurrentSnapshotByID(album.getSnapshots().get(1).getSnapshotID());
  }

  /**
   * Test out-of-bounds exception when access snapshots.
   */
  @Test
  public void testOutOfBoundsSnapshot() {
    album.getCanvas().addShape("oval", "oval",
            100, 100,
            50, 50,
            55, 55, 55);

    album.takeSnapshot("Snapshot 1");

    album.setCurrentSnapshotByID(album.getSnapshots().get(0).getSnapshotID());
    assertThrows(IndexOutOfBoundsException.class, () -> album.getPrevSnapshot());
    assertThrows(IndexOutOfBoundsException.class, () -> album.getNextSnapshot());
  }
}