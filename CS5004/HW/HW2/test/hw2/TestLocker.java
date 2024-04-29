package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for class Locker.
 * Two Locker objects constructed:
 * locker01, locker02
 */
public class TestLocker {
  private Locker locker01;
  private Locker locker02;

  /**
   * Set up parameters
   * for Locker objects.
   */
  @BeforeEach
  void setUp() {
    locker01 = new Locker(10, 10, 10);
    locker02 = new Locker(20, 20, 20);
  }

  /**
   * Test bad constructor.
   * throw exception when the dimensions are invalid.
   */
  @Test
  void testBadConstructor() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new Locker(0, 30, 30));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new Locker(30, 0, 30));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> new Locker(30, 30, 0));
  }

  /**
   * Test add mail
   * and also pick up mail success
   * by adding a mail item and then picking it up.
   */
  @Test
  void testAddMailSuccess() {
    Recipient recipient01 = new Recipient("tianyu", "Co", "coty@kappa.edu");
    MailItem mailItem01 = new MailItem(5, 5, 5, recipient01);
    locker02.addMail(mailItem01);
    MailItem temp = locker02.pickupMail(recipient01);
    Assertions.assertEquals(mailItem01, temp);
  }

  /**
   * Test add mail fails
   * when the item is too big or null
   * and also did not match with the recipient.
   */
  @Test
  void testAddMailFail() {
    Recipient recipient02 = new Recipient("ross", "geller", "rg@friends.com");
    MailItem mailItem02 = new MailItem(25, 25, 25, recipient02);
    locker01.addMail(mailItem02);



  }

  /**
   * Test pickup mail fails
   * when the locker is empty and wrong recipient comes to pick up.
   */
  @Test
  void testPickupMailFail() {
    Recipient recipient03 = new Recipient("rachel", "green", "ragreen@friends.com");
    Recipient recipientFake = new Recipient("rachel", "red", "rared@friends.com");
    MailItem mailItem03 = new MailItem(5, 5, 5, recipient03);

    // Testing empty locker's pickup
    Locker lockerEmpty = new Locker(3, 3, 3);
    Assertions.assertNull(lockerEmpty.pickupMail(recipient03));

    // Testing if wrong recipient comes to pick up
    locker01.addMail(mailItem03);
    MailItem pickedUpMail03 = locker01.pickupMail(recipientFake);
    Assertions.assertNull(pickedUpMail03);
  }
}
