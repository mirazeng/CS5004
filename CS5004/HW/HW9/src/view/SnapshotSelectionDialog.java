package view;

import model.snapshot.ISnapshot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Snapshot selection dialog.
 */
public class SnapshotSelectionDialog extends JDialog implements ISnapshotSelectionDialog {
  private final JLabel chooseLabel;
  private final JComboBox<String> snapshotComboBox;
  private final JButton cancelButton;
  private final JButton importButton;
  private String selectedSnapshotID;

  /**
   * Instantiates a new Snapshot selection dialog.
   *
   * @param parent    the parent
   * @param snapshots the snapshots
   */
  public SnapshotSelectionDialog(JFrame parent, List<ISnapshot> snapshots) {
    super(parent, "Select Snapshot", true);

    // Initialize components
    chooseLabel = new JLabel("Choose a snapshot:");
    snapshotComboBox = new JComboBox<>();
    for (ISnapshot snapshot : snapshots) {
      snapshotComboBox.addItem(snapshot.getSnapshotID());
    }

    cancelButton = new JButton("Cancel");
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        selectedSnapshotID = null;
        dispose();
      }
    });

    importButton = new JButton("Import");
    importButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        selectedSnapshotID = (String) snapshotComboBox.getSelectedItem();
        dispose();
      }
    });

    // Set up the layout
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(10, 10, 5, 10);
    add(chooseLabel, gbc);

    gbc.gridy = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    add(snapshotComboBox, gbc);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(cancelButton);
    buttonPanel.add(importButton);

    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.CENTER;
    add(buttonPanel, gbc);

    pack();
    setLocationRelativeTo(parent);
  }

  /**
   * Gets selected snapshot id.
   *
   * @return the selected snapshot id
   */
  public String getSelectedSnapshotID() {
    return selectedSnapshotID;
  }
}