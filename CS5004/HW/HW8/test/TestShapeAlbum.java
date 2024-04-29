import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import photoAlbum.IAlbum;
import photoAlbum.ShapeAlbum;
import shape.*;
import snapshot.Snapshot;

/** The type Test shape album. */
public class TestShapeAlbum {

  private IAlbum album;

  /** Sets . */
  @BeforeEach
  public void setup() {
    album = new ShapeAlbum();
  }

  /** Test shape album constructor. */
  @Test
  public void testShapeAlbumConstructor() {
    assertNotNull(album.getCanvas());
    assertNotNull(album.getSnapshots());
    assertEquals(0, album.getSnapshots().size());
  }

  /** Test reset album. */
  @Test
  public void testResetAlbum() {
    album.getCanvas().addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 1");
    assertEquals(1, album.getSnapshots().size());
    album.resetAlbum();
    assertEquals(0, album.getCanvas().getShapes().size());
    assertEquals(0, album.getSnapshots().size());
  }

  /** Test take snapshot. */
  @Test
  public void testTakeSnapshot() {
    album.getCanvas().addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 1");
    assertEquals(1, album.getSnapshots().size());
    Snapshot snapshot = (Snapshot) album.getSnapshots().get(0);
    assertNotNull(snapshot.getSnapshotID());
    assertNotNull(snapshot.getTimeStamp());
    assertEquals("Snapshot 1", snapshot.getDescription());
    assertEquals(1, snapshot.getShapes().size());
  }

  /** Test get snapshot. */
  @Test
  public void testGetSnapshot() {
    album.getCanvas().addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 1");
    String snapshotID = album.getSnapshots().get(0).getSnapshotID();
    Snapshot retrievedSnapshot = album.getSnapshot(snapshotID);
    System.out.println(retrievedSnapshot);
    assertNotNull(retrievedSnapshot);
    assertEquals(snapshotID, retrievedSnapshot.getSnapshotID());
    assertNull(album.getSnapshot("nonexistent"));
  }

  /** Test remove snapshot. */
  @Test
  public void testRemoveSnapshot() {
    album.getCanvas().addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 1");
    String snapshotID = album.getSnapshots().get(0).getSnapshotID();
    assertEquals(1, album.getSnapshots().size());
    album.removeSnapshot(snapshotID);
    assertEquals(0, album.getSnapshots().size());
    album.removeSnapshot("nonexistent");
    assertEquals(0, album.getSnapshots().size());
  }

  /** Test import snapshot to canvas. */
  @Test
  public void testImportSnapshotToCanvas() {
    album.getCanvas().addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 1");
    String snapshotID = album.getSnapshots().get(0).getSnapshotID();
    album.getCanvas().resetCanvas();
    assertEquals(0, album.getCanvas().getShapes().size());
    album.importSnapshotToCanvas(snapshotID);
    assertEquals(1, album.getCanvas().getShapes().size());
  }

  /** Test print snapshots info. */
  @Test
  public void testPrintSnapshotsInfo() {
    album.getCanvas().addShape("oval", "oval", 100.0, 100.0, 50.0, 50.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 1");
    album.getCanvas().addShape("rect", "rectangle", 200.0, 200.0, 40.0, 60.0, 55.0, 55.0, 55.0);
    album.takeSnapshot("Snapshot 2");
    String info = album.printSnapshotsInfo();
    assertTrue(info.contains("Printing Snapshots"));
    assertTrue(info.contains("Snapshot 1"));
    assertTrue(info.contains("Snapshot 2"));
  }
}