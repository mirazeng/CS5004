package hw2;

/** Wenqing Zeng - HW_2 This class represents a Locker class. */
public class Locker {
  private static final int MINDIMENSION = 1;
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private MailItem mailItem;

  /**
   * Instantiates a new Locker. Locker dimensions must be valid, And new Locker should be empty
   *
   * @param maxWidth the max width
   * @param maxHeight the max height
   * @param maxDepth the max depth
   * @throws IllegalArgumentException the illegal argument exception
   *
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth)
          throws IllegalArgumentException {
    // Check that maxWidth, maxHeight, maxDepth are bigger than 0
    // If not, throw IllegalArgumentException error and print appropriate message for each
    if (maxWidth < MINDIMENSION) {
      throw new IllegalArgumentException("Max width must be bigger than 1.");
    } else if (maxHeight < MINDIMENSION) {
      throw new IllegalArgumentException("Max height must be bigger than 1.");
    } else if (maxDepth < MINDIMENSION) {
      throw new IllegalArgumentException("Max depth must be bigger than 1.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Add mail into this locker, But if the dimensions do not fit, throw an exception and warn; Or
   * warn when the locker is already occupied.
   *
   * @param mailitem the mailitem to be put in
   */
  public void addMail(MailItem mailitem) {
    if (this.mailItem == null) {
      if (mailitem.getWidth() <= this.maxWidth
          && mailitem.getHeight() <= this.maxHeight
          && mailitem.getDepth() <= this.maxDepth) {
        this.mailItem = mailitem;
      }
    }
  }

  /**
   * Pickup mail (mailitem). Return null if 1) the locker is empty, or 2) the recipient does not
   * match the one on record within the mailItem.
   *
   * @param recipient the recipient
   * @return picked-up mail item or null
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem == null) {
      return null;
    } else if (!this.mailItem.getRecipient().equals(recipient)) {
      return null;
    }
    MailItem temp = this.mailItem;
    this.mailItem = null;
    return temp;
  }
}
