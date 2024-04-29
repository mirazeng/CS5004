package view;

import javax.swing.*;
import java.awt.*;

/**
 * The type No more snapshots' dialog.
 */
public class NoMoreSnapshotsDialog extends JDialog implements INoMoreSnapshotsDialog {
  /**
   * Instantiates a new No more snapshots' dialog.
   *
   * @param parent  the parent
   * @param message the message
   */
  public NoMoreSnapshotsDialog(JFrame parent, String message) {
    super(parent, "No Snapshot Selected", false);

    // Set up the dialog components and layout
    JLabel messageLabel = new JLabel(message);
    JButton okButton = new JButton("OK");
    okButton.addActionListener(e -> dispose());

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets = new Insets(10, 10, 10, 10);
    add(messageLabel, gbc);

    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    add(okButton, gbc);

    pack();
    setLocationRelativeTo(parent);
  }
}