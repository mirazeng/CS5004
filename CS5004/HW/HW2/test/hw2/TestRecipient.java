package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for class Recipient.
 * Two Recipient constructed:
 * recipient01, recipient02
 */
public class TestRecipient {

  private Recipient recipient01;
  private Recipient recipient02;

  /**
   * Sets up parameters
   * for Recipient objects.
   */
  @BeforeEach
  void setUp() {
    recipient01 = new Recipient("mira", "eoe", "miraeoe@email.com");
    recipient02 = new Recipient("kuaile", "xiaogou", "gougou@google.com");
  }

  /**
   * Test good constructor.
   */
  @Test
  void testGoodConstructor() {
    Assertions.assertEquals("mira", recipient01.getFirstName());
    Assertions.assertEquals("eoe", recipient01.getLastName());
    Assertions.assertEquals("miraeoe@email.com", recipient01.getEmail());
  }

  /**
   * Test bad constructor.
   */
  @Test
  void testBadConstructor() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () ->
                    new Recipient(null, "eoe", "miraeoe@email.com"));
    Assertions.assertThrows(
        IllegalArgumentException.class, () ->
                    new Recipient("mira", null, "miraeoe@email.com"));
    Assertions.assertThrows(
        IllegalArgumentException.class, () ->
                    new Recipient("mira", "eoe", null));
  }

  /**
   * Test get first name.
   */
  @Test
  void testGetFirstName() {
    Assertions.assertEquals("mira", recipient01.getFirstName());
    Assertions.assertEquals("kuaile", recipient02.getFirstName());
  }

  /**
   * Test get last name.
   */
  @Test
  void testGetLastName() {
    Assertions.assertEquals("eoe", recipient01.getLastName());
    Assertions.assertEquals("xiaogou", recipient02.getLastName());
  }

  /**
   * Test get email.
   */
  @Test
  void testGetEmail() {
    Assertions.assertEquals("miraeoe@email.com", recipient01.getEmail());
    Assertions.assertEquals("gougou@google.com", recipient02.getEmail());
  }

  /**
   * Test set email.
   * Implement getter method to test.
   */
  @Test
  void testSetEmail() {
    Recipient recipientNew = new Recipient("xiaomao", "xi", "xxii@paw.edu");
    recipientNew.setEmail("zzuu@imail.iu.edu");
    Assertions.assertEquals("zzuu@imail.iu.edu", recipientNew.getEmail());
  }

  /**
   * Test ToString
   * to see if this method return
   * the correct string information of a recipient.
   */
  @Test
  void testToString() {
    Assertions.assertEquals("mira eoe Email:miraeoe@email.com", recipient01.toString());
    Assertions.assertEquals("kuaile xiaogou Email:gougou@google.com", recipient02.toString());
  }

  /** Test equals
   * to ensure the equal method
   * will check two recipients are the same.
   */
  @Test
  void testEquals() {
    Assertions.assertTrue((recipient01.equals(recipient01)));
    Assertions.assertFalse(recipient01.equals(null));
    Assertions.assertFalse(recipient01.equals(recipient02));
    Assertions.assertFalse(recipient01.equals(new Recipient("WRONG", "eoe", "miraeoe@email.com")));
    Assertions.assertFalse(recipient01.equals(new Recipient("mira", "WRONG", "miraeoe@email.com")));
    Assertions.assertFalse(recipient01.equals(new Recipient("mira", "eoe", "WRONG")));
  }
}
