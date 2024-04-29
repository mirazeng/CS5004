package hw2;

/**
 * Wenqing Zeng - HW2
 * This class represents a MailItem class.
 */
public class MailItem {
  private final int width;
  private final int height;
  private final int depth;
  private final Recipient recipient;
  private static final int MINDIMENSION = 1;

  /**
   * Instantiates a new Mailitem.
   * Item dimensions must be valid,
   * And must have a recipient.
   *
   * @param width the width
   * @param height the height
   * @param depth the depth
   * @param recipient the recipient
   * @throws IllegalArgumentException the illegal argument exception
   *
   */
  public MailItem(int width, int height, int depth, Recipient recipient)
          throws IllegalArgumentException {
    if (recipient == null) {
      throw new IllegalArgumentException("Recipient must be provided.");
    }
    // Check if width, height, depth are more than 0,
    // If not, throw IllegalArgumentException and print appropriate message
    if (width < MINDIMENSION) {
      throw new IllegalArgumentException("Width can not be less than 1.");
    } else if (height < MINDIMENSION) {
      throw new IllegalArgumentException("Height can not be less than 1.");
    } else if (depth < MINDIMENSION) {
      throw new IllegalArgumentException("Depth can not be less than 1.");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    // Create a new instance to preserve immutability
    this.recipient = new Recipient(recipient.getFirstName(),
            recipient.getLastName(),
            recipient.getEmail());
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Gets depth.
   *
   * @return the depth
   */
  public int getDepth() {
    return this.depth;
  }

  /**
   * Gets recipient.
   *
   * @return the recipient
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
