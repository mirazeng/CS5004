package model.snapshot;

import model.shape.IShape;

import java.util.List;

/**
 * The interface Snapshot.
 */
public interface ISnapshot {
  /**
   * Gets snapshot id.
   *
   * @return the snapshot id
   */
  String getSnapshotID();

  /**
   * Sets snapshot id.
   *
   * @param snapshotID the snapshot id
   */
  void setSnapshotID(String snapshotID);

  /**
   * Gets time stamp.
   *
   * @return the time stamp
   */
  String getTimeStamp();

  /**
   * Sets time stamp.
   *
   * @param timeStamp the time stamp
   */
  void setTimeStamp(String timeStamp);

  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();

  /**
   * Sets description.
   *
   * @param description the description
   */
  void setDescription(String description);

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  List<IShape> getShapes();

  String toString();
}