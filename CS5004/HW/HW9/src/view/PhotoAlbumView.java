package view;

import model.shape.IShape;
import model.snapshot.ISnapshot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Photo album view.
 */
public class PhotoAlbumView extends JFrame implements IPhotoAlbumView {
  private final JLabel bannerLabel;
  private final JLabel descriptionLabel;
  private final JButton lastButton;
  private final JButton selectButton;
  private final JButton nextButton;
  private final JButton quitButton;
  private final CanvasPanel canvasPanel;

  /**
   * Instantiates a new Photo album view.
   */
  public PhotoAlbumView() {
    setTitle("Shapes Photo Album");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(1000, 800));

    // Create the canvas panel to display the shapes
    canvasPanel = new CanvasPanel(new ArrayList<>());

    // Create the banner and description labels
    bannerLabel = new JLabel("Current Snapshot: None");
    bannerLabel.setHorizontalAlignment(SwingConstants.LEFT);

    descriptionLabel = new JLabel("Description: None");
    descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);

    // Create an inner panel to hold the labels
    JPanel labelPanel = new JPanel(new BorderLayout());
    labelPanel.add(bannerLabel, BorderLayout.NORTH);
    labelPanel.add(descriptionLabel, BorderLayout.CENTER);

    // Set up the UI layout
    setLayout(new BorderLayout());
    add(labelPanel, BorderLayout.NORTH);
    add(canvasPanel, BorderLayout.CENTER);

    // Create the buttons
    lastButton = new JButton("<< Prev <<");
    selectButton = new JButton("^^Select^^");
    nextButton = new JButton(">> Next >>");
    quitButton = new JButton("xx Quit xx");

    // create an inner panel to hold the buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(lastButton);
    buttonPanel.add(selectButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(quitButton);
    add(buttonPanel, BorderLayout.SOUTH);

    // display the frame
    pack();
    setVisible(true);
  }

  /**
   * Add last button listener.
   *
   * @param listener the listener
   */
  public void addLastButtonListener(ActionListener listener) {
    lastButton.addActionListener(listener);
  }

  /**
   * Add select button listener.
   *
   * @param listener the listener
   */
  public void addSelectButtonListener(ActionListener listener) {
    selectButton.addActionListener(listener);
  }

  /**
   * Add next button listener.
   *
   * @param listener the listener
   */
  public void addNextButtonListener(ActionListener listener) {
    nextButton.addActionListener(listener);
  }

  /**
   * Add quit button listener.
   *
   * @param listener the listener
   */
  public void addQuitButtonListener(ActionListener listener) {
    quitButton.addActionListener(listener);
  }

  /**
   * Update display.
   *
   * @param currentSnapshot the current snapshot
   */
  public void updateDisplay(ISnapshot currentSnapshot) {
    List<IShape> shapes = currentSnapshot.getShapes();
    // update the canvas panel with the shapes
    canvasPanel.setShapes(shapes);
    canvasPanel.repaint();
    // update the labels with current snapshot information
    updateBanner("Current Snapshot: " + currentSnapshot.getSnapshotID());
    updateDescription(currentSnapshot.getDescription());
  }

  /**
   * Update the banner information.
   *
   * @param banner the current snapshot information
   */
  private void updateBanner(String banner) {
    bannerLabel.setText(banner);
  }

  /**
   * Update the snapshot description.
   *
   * @param description current snapshot information
   */
  private void updateDescription(String description) {
    descriptionLabel.setText(description);
  }

}