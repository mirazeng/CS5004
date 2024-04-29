package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



/**
 * The type Test checking account.
 */
public class TestCheckingAccount {

  /**
   * Test good constructor.
   */
  @Test
  public void testGoodConstructor() {

    // test super class constructor
    BankAccount checking1 = new CheckingAccount(100.0);
    BankAccount checking2 = new CheckingAccount(10500.0);
    assertEquals(100.0, checking1.getBalance());
    assertEquals(10500.0, checking2.getBalance());

    // test inherited constructor
    CheckingAccount checking3 = new CheckingAccount(100.0);
    CheckingAccount checking4 = new CheckingAccount(10500.0);
    assertEquals(100.0, checking3.getBalance());
    assertEquals(10500.0, checking4.getBalance());
  }

  /**
   * Test bad constructor.
   */
  @Test
  public void testBadConstructor() {
    // negative initial balance
    assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(-100.0));
    // zero initial balance
    assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(0.0));
    // initial balance less than 0.01
    assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(0.005));
  }

  /**
   * Test good withdraw.
   */
  @Test
  public void testGoodWithdraw() {
    // test super class withdraw
    BankAccount checking1 = new CheckingAccount(150.0);
    assertTrue(checking1.withdraw(50.0));
    assertEquals(100.0, checking1.getBalance());

    // test inherited withdraw
    CheckingAccount checking2 = new CheckingAccount(150.0);
    assertTrue(checking2.withdraw(50.0));
    assertEquals(100.0, checking2.getBalance());

    // test inherited withdraw with fee
    CheckingAccount checking3 = new CheckingAccount(55.0);
    assertTrue(checking3.withdraw(50.0));
    assertEquals(5.0, checking3.getBalance());
  }

  /**
   * Test bad withdraw.
   */
  @Test
  public void testBadWithdraw() {

    // test with insufficient balance

    // test super class withdraw
    BankAccount checking1 = new CheckingAccount(150.0);
    assertFalse(checking1.withdraw(200.0));
    assertEquals(150.0, checking1.getBalance());

    // test inherited withdraw
    CheckingAccount checking2 = new CheckingAccount(150.0);
    assertFalse(checking2.withdraw(200.0));
    assertEquals(150.0, checking2.getBalance());

    // test inherited withdraw with fee
    CheckingAccount checking3 = new CheckingAccount(55.0);
    assertFalse(checking3.withdraw(60.0));
    assertEquals(55.0, checking3.getBalance());

    // test invalid withdraw with negative amount
    CheckingAccount checking5 = new CheckingAccount(100.0);
    assertFalse(checking5.withdraw(-50.0));
    assertEquals(100.0, checking5.getBalance());
  }

  /**
   * Test multiple withdraw.
   */
  @Test
  public void testMultipleWithdraw() {

    // each time did not exceed the balance
    CheckingAccount checking1 = new CheckingAccount(200.0);
    checking1.withdraw(50.0);
    checking1.withdraw(30.0);
    checking1.withdraw(20.0);
    checking1.withdraw(100.0);
    assertEquals(0.0, checking1.getBalance());

    CheckingAccount checking2 = new CheckingAccount(150.0);
    checking2.withdraw(100.0);
    checking2.withdraw(30.0);
    assertTrue(checking2.withdraw(5.0));
    assertEquals(15.0, checking2.getBalance());
  }

  /**
   * Test multiple withdraw bad.
   */
  @Test
  public void testMultipleWithdrawBad() {

    // one time exceeded the balance
    CheckingAccount checking1 = new CheckingAccount(150.0);
    checking1.withdraw(100.0);
    checking1.withdraw(30.0);
    assertFalse(checking1.withdraw(25.0));
    assertEquals(20.0, checking1.getBalance());
  }

  /**
   * Test good deposit.
   */
  @Test
  public void testGoodDeposit() {

    // test super class deposit
    BankAccount checking1 = new CheckingAccount(100.0);
    checking1.deposit(50.0);
    assertEquals(150.0, checking1.getBalance());

    BankAccount checking2 = new CheckingAccount(50.0);
    checking2.deposit(50.0);
    assertEquals(100.0, checking2.getBalance());

    // test inherited deposit
    CheckingAccount checking3 = new CheckingAccount(100.0);
    checking3.deposit(50.0);
    assertEquals(150.0, checking3.getBalance());

    CheckingAccount checking4 = new CheckingAccount(50.0);
    checking4.deposit(50.0);
    assertEquals(100.0, checking4.getBalance());
  }

  /**
   * Test bad deposit.
   */
  @Test
  public void testBadDeposit() {
    // test invalid deposit amount (negative)
    CheckingAccount checking1 = new CheckingAccount(100.0);
    assertThrows(IllegalArgumentException.class, () -> checking1.deposit(-50.0));
    assertEquals(100.0, checking1.getBalance());
  }

  /**
   * Test default monthly maintenance.
   */
  @Test
  public void testDefaultMonthlyMaintenance() {
    // test super class monthly maintenance
    BankAccount checking1 = new CheckingAccount(100.0);
    checking1.performMonthlyMaintenance();
    assertEquals(100.0, checking1.getBalance());

    // test inherited monthly maintenance
    CheckingAccount checking2 = new CheckingAccount(100.0);
    checking2.performMonthlyMaintenance();
    assertEquals(100.0, checking2.getBalance());
  }

  /**
   * Test monthly maintenance.
   */
  @Test
  public void testMonthlyMaintenance() {
    // test super class when account open and it is below 100
    BankAccount checking1 = new CheckingAccount(50.0);
    checking1.performMonthlyMaintenance();
    assertEquals(45.0, checking1.getBalance());

    // test super class when account after withdraw and it is below 100
    BankAccount checking2 = new CheckingAccount(100.0);
    checking2.withdraw(50.0);
    checking2.performMonthlyMaintenance();
    assertEquals(45.0, checking2.getBalance());

    //test inherited when account open and it is below 100
    CheckingAccount checking3 = new CheckingAccount(50.0);
    checking3.performMonthlyMaintenance();
    assertEquals(45.0, checking3.getBalance());

    //test inherited when account after withdraw and it is below 100
    CheckingAccount checking4 = new CheckingAccount(100.0);
    checking4.withdraw(50.0);
    checking4.performMonthlyMaintenance();
    assertEquals(45.0, checking4.getBalance());
  }


}
