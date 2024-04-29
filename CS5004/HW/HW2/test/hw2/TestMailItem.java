package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for class MailItem.
 * Two MailItem objects constructed:
 * mailItem01, mailItem02
 */
public class TestMailItem {
  private MailItem mailItem01;
  private MailItem mailItem02;

  /**
   * Set up parameters
   * for MailItem objects.
   */
  @BeforeEach
  void setUp() {
    mailItem01 =
            new MailItem(2, 2, 2,
                new Recipient("mira",
                        "ze",
                        "biskent1994@audrianaputri.com"));
    mailItem02 =
            new MailItem(4, 4, 4,
            new Recipient("jason",
                    "Le",
                    "kuhfive@codeledmail.com"));
  }

  /**
   * Test good constructor.
   */
  @Test
  void testGoodConstructor() {
    Assertions.assertEquals(2, mailItem01.getWidth());
    Assertions.assertEquals(2, mailItem01.getHeight());
    Assertions.assertEquals(2, mailItem01.getDepth());

    // Specifically testing whether MailItem's constructor correctly takes in Recipient classes.
    Assertions.assertTrue(
        mailItem01
            .getRecipient()
            .equals(new Recipient(
                    "mira",
                    "ze",
                    "biskent1994@audrianaputri.com")));
  }

  /**
   * Test bad constructor.
   */
  @Test
  void testBadConstructor() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new MailItem(-2, 2, 2,
                new Recipient("bre", "eze", "ezere@outlook.com")));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new MailItem(2, -2, 2,
                new Recipient("bre", "eze", "ezere@outlook.com")));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new MailItem(2, 2, -2,
                new Recipient("bre", "eze", "ezere@outlook.com")));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new MailItem(2, 2, -2,
                new Recipient(null, "eze", "ezere@outlook.com")));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new MailItem(2, 2, -2,
                new Recipient("bre", null, "ezere@outlook.com")));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new MailItem(2, 2, -2,
                new Recipient("bre", "eze", null)));
  }

  /**
   * Test get width.
   */
  @Test
  void testGetWidth() {
    Assertions.assertEquals(2, mailItem01.getWidth());
    Assertions.assertEquals(4, mailItem02.getWidth());
  }

  /**
   * Test get height.
   */
  @Test
  void testGetHeight() {
    Assertions.assertEquals(2, mailItem01.getHeight());
    Assertions.assertEquals(4, mailItem02.getHeight());
  }

  /**
   * Test get depth.
   */
  @Test
  void testGetDepth() {
    Assertions.assertEquals(2, mailItem01.getDepth());
    Assertions.assertEquals(4, mailItem02.getDepth());
  }

  /**
   * Test get recipient.
   */
  @Test
  void testGetRecipient() {
    Assertions.assertEquals("mira", mailItem01.getRecipient().getFirstName());
    Assertions.assertEquals("ze", mailItem01.getRecipient().getLastName());
  }
}
