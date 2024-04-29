package view;

/**
 * The interface Snapshot selection dialog.
 */
public interface ISnapshotSelectionDialog {
  /**
   * Gets selected snapshot id.
   *
   * @return the selected snapshot id
   */
  String getSelectedSnapshotID();

  /**
   * Sets visible.
   *
   * @param b the b
   */
  void setVisible(boolean b);
}