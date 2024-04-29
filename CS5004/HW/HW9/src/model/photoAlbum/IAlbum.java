package model.photoAlbum;

import model.canvasDisplay.ICanvas;
import model.snapshot.ISnapshot;
import model.snapshot.Snapshot;

import java.util.List;

/**
 * The interface Album.
 */
public interface IAlbum {
  /**
   * Init canvas.
   */
  void initCanvas();

  /**
   * Init snapshots collection.
   */
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

  /**
   * Reset album.
   */
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

  /**
   * Gets current snapshot.
   *
   * @return the current snapshot
   */
  ISnapshot getCurrentSnapshot();

  /**
   * Gets prev snapshot.
   *
   * @throws IndexOutOfBoundsException the index out of bounds exception
   */
  void getPrevSnapshot() throws IndexOutOfBoundsException;

  /**
   * Gets next snapshot.
   *
   * @throws IndexOutOfBoundsException the index out of bounds exception
   */
  void getNextSnapshot() throws IndexOutOfBoundsException;

  /**
   * Sets current snapshot by id.
   *
   * @param selectedSnapshotID the selected snapshot id
   */
  void setCurrentSnapshotByID(String selectedSnapshotID);

  /**
   * Gets current snapshot id.
   *
   * @return the current snapshot id
   */
  String getCurrentSnapshotID();

}