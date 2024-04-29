package photoAlbum;

import canvasDisplay.ICanvas;
import java.util.List;
import snapshot.ISnapshot;
import snapshot.Snapshot;

/** The interface Album. */
public interface IAlbum {
  /** Init canvas. */
  void initCanvas();

  /** Init snapshots collection. */
  void initSnapshotsCollection();

  /**
   * Take snapshot.
   *
   * @param description the description
   */
  void takeSnapshot(String description);

  /**
   * Gets snapshot.
   *
   * @param snapshotID the snapshot id
   * @return the snapshot
   */
  Snapshot getSnapshot(String snapshotID);

  /**
   * Remove snapshot.
   *
   * @param snapshotID the snapshot id
   */
  void removeSnapshot(String snapshotID);

  /**
   * Import snapshot to canvas.
   *
   * @param snapshotID the snapshot id
   */
  void importSnapshotToCanvas(String snapshotID);

  /**
   * Print snapshots info string.
   *
   * @return the string
   */
  String printSnapshotsInfo();

  /** Reset album. */
  void resetAlbum();

  /**
   * Gets canvas.
   *
   * @return the canvas
   */
  ICanvas getCanvas();

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  List<ISnapshot> getSnapshots();
}