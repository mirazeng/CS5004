package controller;

import java.awt.event.ActionListener;

/**
 * The interface Album controller.
 */
public interface IAlbumController {
  /**
   * Update view.
   */
  void updateView();

  /**
   * Gets prev snapshot.
   *
   * @return the prev snapshot
   */
  ActionListener getPrevSnapshot();

  /**
   * Gets next snapshot.
   *
   * @return the next snapshot
   */
  ActionListener getNextSnapshot();

  /**
   * Pop snapshot list action listener
   * will pop up a dialog to select a snapshot.
   *
   * @return the action listener
   */
  ActionListener popSnapshotList();

  /**
   * Quit game action listener.
   *
   * @return the action listener
   */
  ActionListener quitGame();

  /**
   * Show snapshot selection dialog.
   */
  void showSnapshotSelectionDialog();

  /**
   * Show no more snapshots' dialog.
   *
   * @param message the message
   */
  void showNoMoreSnapshotsDialog(String message);
}