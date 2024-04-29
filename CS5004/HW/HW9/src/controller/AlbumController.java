package controller;

import model.photoAlbum.IAlbum;
import view.INoMoreSnapshotsDialog;
import view.NoMoreSnapshotsDialog;
import view.IPhotoAlbumView;
import view.SnapshotSelectionDialog;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The type Album controller.
 */
public class AlbumController implements IAlbumController {
  private final IPhotoAlbumView photoAlbumView;
  private final IAlbum shapeAlbumModel;

  /**
   * Instantiates a new Album controller.
   *
   * @param photoAlbumView  the photo album view
   * @param shapeAlbumModel the shape album model
   */
  public AlbumController(IPhotoAlbumView photoAlbumView, IAlbum shapeAlbumModel) {
    this.photoAlbumView = photoAlbumView;
    this.shapeAlbumModel = shapeAlbumModel;
    this.photoAlbumView.addLastButtonListener(getPrevSnapshot());
    this.photoAlbumView.addNextButtonListener(getNextSnapshot());
    this.photoAlbumView.addSelectButtonListener(popSnapshotList());
    this.photoAlbumView.addQuitButtonListener(quitGame());
  }

  @Override
  public void updateView() {
    photoAlbumView.updateDisplay(shapeAlbumModel.getCurrentSnapshot());
  }

  @Override
  public ActionListener getPrevSnapshot() {
    return e -> {
      try {
        shapeAlbumModel.getPrevSnapshot();
      } catch (Exception ex) {
        showNoMoreSnapshotsDialog("No more snapshots available before this one.");
      }
      updateView();
    };
  }

  @Override
  public ActionListener getNextSnapshot() {
    return e -> {
      try {
        shapeAlbumModel.getNextSnapshot();
      } catch (Exception ex) {
        showNoMoreSnapshotsDialog("No more snapshots available after this one.");
      }
      updateView();
    };
  }

  // select button will pop up a dialog to select a snapshot
  @Override
  public ActionListener popSnapshotList() {
    return e -> showSnapshotSelectionDialog();
  }

  // quit button will exit the program
  @Override
  public ActionListener quitGame() {
    return e -> System.exit(0);
  }

  @Override
  public void showSnapshotSelectionDialog() {
    SnapshotSelectionDialog dialog =
            new SnapshotSelectionDialog((JFrame) photoAlbumView, shapeAlbumModel.getSnapshots());
    dialog.setVisible(true);

    if (dialog.getSelectedSnapshotID() != null) {
      String selectedSnapshotID = dialog.getSelectedSnapshotID();
      shapeAlbumModel.setCurrentSnapshotByID(selectedSnapshotID);
      updateView();
    }
  }

  @Override
  public void showNoMoreSnapshotsDialog(String message) {
    SwingUtilities.invokeLater(() -> {
      INoMoreSnapshotsDialog dialog = new NoMoreSnapshotsDialog((JFrame) photoAlbumView, message);
      dialog.setVisible(true);
    });
  }
}