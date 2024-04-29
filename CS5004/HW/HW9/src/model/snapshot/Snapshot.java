package model.snapshot;

import model.shape.IShape;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Snapshot.
 */
public class Snapshot implements ISnapshot {

  private final List<IShape> listOfShapes;
  private String snapshotID;
  private String timeStamp;
  private String description;

  /**
   * Instantiates a new Snapshot.
   *
   * @param snapshotID   the snapshot id
   * @param timeStamp    the time stamp
   * @param description  the description
   * @param listOfShapes the list of shapes
   */
  public Snapshot(
          String snapshotID, String timeStamp, String description, List<IShape> listOfShapes) {
    this.snapshotID = snapshotID;
    this.timeStamp = timeStamp;
    this.description = description;
    this.listOfShapes = listOfShapes;
  }

  @Override
  public String getSnapshotID() {
    return this.snapshotID;
  }

  @Override
  public void setSnapshotID(String snapshotID) {
    this.snapshotID = snapshotID;
  }

  @Override
  public String getTimeStamp() {
    return this.timeStamp;
  }

  @Override
  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public List<IShape> getShapes() {

    // make a new list to store copy of shapes
    List<IShape> copyOfShapes = new ArrayList<>();

    // deep copy of list of shapes to copyOfShapes
    for (IShape shape : this.listOfShapes) {
      copyOfShapes.add(shape.cloneShape());
    }
    return copyOfShapes;
  }

  @Override
  public String toString() {
    StringBuilder snapshotString = new StringBuilder();
    snapshotString.append("Snapshot ID: ").append(this.snapshotID).append("\n");
    snapshotString.append("Timestamp: ").append(this.timeStamp).append("\n");
    snapshotString.append("Description: ").append(this.description).append("\n");
    snapshotString.append("Shape Information:\n");
    for (IShape shape : this.listOfShapes) {
      snapshotString.append(shape.toString()).append("\n");
    }
    // delete last new line character
    snapshotString.deleteCharAt(snapshotString.length() - 1);
    return snapshotString.toString();
  }
}