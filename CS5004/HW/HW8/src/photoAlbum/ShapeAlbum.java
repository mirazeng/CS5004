package photoAlbum;

import canvasDisplay.Canvas;
import canvasDisplay.ICanvas;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import shape.IShape;
import snapshot.ISnapshot;
import snapshot.Snapshot;

/** The type Shape album. */
public class ShapeAlbum implements IAlbum {

  private ICanvas canvas;
  private List<ISnapshot> snapshots;

  /** Instantiates a new Shape album. */
  public ShapeAlbum() {
    this.initCanvas();
    this.initSnapshotsCollection();
  }

  @Override
  public void resetAlbum() {
    this.initCanvas();
    this.initSnapshotsCollection();
  }

  @Override
  public ICanvas getCanvas() {
    return this.canvas;
  }

  @Override
  public List<ISnapshot> getSnapshots() {
    return this.snapshots;
  }

  @Override
  public void initCanvas() {
    this.canvas = new Canvas();
  }

  @Override
  public void initSnapshotsCollection() {
    this.snapshots = new ArrayList<ISnapshot>();
  }

  @Override
  public void takeSnapshot(String description) {
    LocalDateTime now = LocalDateTime.now();
    String snapshotID = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now);
    String timeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(now);

    List<IShape> onScreenShapesCopy = this.canvas.getShapes();
    Snapshot newSnapshot = new Snapshot(snapshotID, timeStamp, description, onScreenShapesCopy);
    this.snapshots.add(newSnapshot);
  }

  @Override
  public Snapshot getSnapshot(String snapshotID) {
    for (int i = 0; i < snapshots.size(); i++) {
      ISnapshot current = snapshots.get(i);
      if (current.getSnapshotID().equals(snapshotID)) {
        return (Snapshot) current;
      }
    }
    return null;
  }

  @Override
  public void removeSnapshot(String snapshotID) {
    for (int i = 0; i < snapshots.size(); i++) {
      ISnapshot current = snapshots.get(i);
      if (current.getSnapshotID().equals(snapshotID)) {
        snapshots.remove(i);
        break;
      }
    }
  }

  @Override
  public void importSnapshotToCanvas(String snapshotID) {
    this.canvas.displayShapesFromSnapshot(this.getSnapshot(snapshotID));
  }

  @Override
  public String printSnapshotsInfo() {
    StringBuilder snapshotsInfo = new StringBuilder();
    snapshotsInfo.append("Printing Snapshots\n");
    for (int i = 0; i < snapshots.size(); i++) {
      snapshotsInfo.append(snapshots.get(i).toString());
    }
    return snapshotsInfo.toString();
  }
}