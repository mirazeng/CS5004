package model.photoAlbum;

import model.canvasDisplay.Canvas;
import model.canvasDisplay.ICanvas;
import model.shape.IShape;
import model.snapshot.ISnapshot;
import model.snapshot.Snapshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Shape album.
 */
public class ShapeAlbum implements IAlbum {

  private ICanvas canvas;
  private List<ISnapshot> snapshots;
  private ISnapshot currentSnapshot;
  private int currentSnapshotIndex = 0;

  /**
   * Instantiates a new Shape album.
   */
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
    this.currentSnapshot = newSnapshot;
    this.currentSnapshotIndex = this.snapshots.size() - 1;
  }

  @Override
  public Snapshot getSnapshot(String snapshotID) {
    for (ISnapshot current : snapshots) {
      if (current.getSnapshotID().equals(snapshotID)) {
        return (Snapshot) current;
      }
    }
    return null;
  }

  @Override
  public String getCurrentSnapshotID() {
    return this.currentSnapshot.getSnapshotID();
  }

  @Override
  public ISnapshot getCurrentSnapshot() {
    return this.currentSnapshot;
  }

  @Override
  public void getPrevSnapshot() throws IndexOutOfBoundsException {
    // handle the case where the current snapshot is the first snapshot
    if (this.currentSnapshotIndex == 0) {
      throw new IndexOutOfBoundsException
              ("No more snapshots available before this one.");
    } else {
      this.currentSnapshotIndex--;
      this.currentSnapshot = this.snapshots.get(this.currentSnapshotIndex);
      this.importSnapshotToCanvas(this.getCurrentSnapshotID());
    }
//    Print tracker to debug
    System.out.println("Current Snapshot Index: " + this.currentSnapshotIndex);
  }

  @Override
  public void getNextSnapshot() throws IndexOutOfBoundsException {
    // handle the case where the current snapshot is the last snapshot
    if (this.currentSnapshotIndex == this.snapshots.size() - 1) {
      throw new IndexOutOfBoundsException
              ("No more snapshots available after this one.");
    } else {
      this.currentSnapshotIndex++;
      this.currentSnapshot = this.snapshots.get(this.currentSnapshotIndex);
      this.importSnapshotToCanvas(this.getCurrentSnapshotID());
    }
    //    Print tracker to debug
    System.out.println("Current Snapshot Index: " + this.currentSnapshotIndex);
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
    for (ISnapshot snapshot : snapshots) {
      snapshotsInfo.append(snapshot.toString());
    }
    return snapshotsInfo.toString();
  }

  /**
   * Sets current snapshot by index.
   *
   * @param snapshotID the snapshot id
   */
  public void setCurrentSnapshotByID(String snapshotID) {
    for (int i = 0; i < snapshots.size(); i++) {
      ISnapshot snapshot = snapshots.get(i);
      if (snapshot.getSnapshotID().equals(snapshotID)) {
        currentSnapshotIndex = i;
        currentSnapshot = snapshot;
        importSnapshotToCanvas(snapshotID);
        break;
      }
    }
  }
}