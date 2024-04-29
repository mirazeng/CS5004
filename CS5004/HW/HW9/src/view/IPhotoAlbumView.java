package view;

import model.snapshot.ISnapshot;

import java.awt.event.ActionListener;

/**
 * The interface Photo album view.
 */
public interface IPhotoAlbumView {
  /**
   * Add last button listener.
   *
   * @param listener the listener
   */
  void addLastButtonListener(ActionListener listener);

  /**
   * Add select button listener.
   *
   * @param listener the listener
   */
  void addSelectButtonListener(ActionListener listener);

  /**
   * Add next button listener.
   *
   * @param listener the listener
   */
  void addNextButtonListener(ActionListener listener);

  /**
   * Add quit button listener.
   *
   * @param listener the listener
   */
  void addQuitButtonListener(ActionListener listener);

  /**
   * Update display.
   *
   * @param currentSnapshot the current snapshot
   */
  void updateDisplay(ISnapshot currentSnapshot);

  void setVisible(boolean b);
}