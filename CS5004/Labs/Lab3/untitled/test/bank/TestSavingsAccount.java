package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


/**
 * The type Test savings account.
 */
public class TestSavingsAccount {

  /**
   * Test good constructor.
   */
  @Test
  public void testGoodConstructor() {

    // test super class constructor
    BankAccount savings1 = new SavingsAccount(1000.0);
    BankAccount savings2 = new SavingsAccount(20500.0);
    assertEquals(1000.0, savings1.getBalance());
    assertEquals(20500.0, savings2.getBalance());

    // test inherited constructor
    SavingsAccount savings3 = new SavingsAccount(1000.0);
    SavingsAccount savings4 = new SavingsAccount(20500.0);
    assertEquals(1000.0, savings3.getBalance());
    assertEquals(20500.0, savings4.getBalance());
  }

  /**
   * Test bad constructor.
   */
  @Test
  public void testBadConstructor() {
    // negative initial balance
    assertThrows(IllegalArgumentException.class, () -> new SavingsAccount(-100.0));
    // zero initial balance
    assertThrows(IllegalArgumentException.class, () -> new SavingsAccount(0.0));
    // initial balance less than 0.01
    assertThrows(IllegalArgumentException.class, () -> new SavingsAccount(0.005));
  }

  /**
   * Test good withdraw.
   */
  @Test
  public void testGoodWithdraw() {
    // test super class withdraw
    BankAccount savings1 = new SavingsAccount(150.0);
    assertTrue(savings1.withdraw(50.0));
    assertEquals(100.0, savings1.getBalance());

    // test inherited withdraw
    SavingsAccount savings2 = new SavingsAccount(150.0);
    assertTrue(savings2.withdraw(50.0));
    assertEquals(100.0, savings2.getBalance());
  }

  /**
   * Test bad withdraw.
   */
  @Test
  public void testBadWithdraw() {
    // test super class withdraw
    BankAccount savings1 = new SavingsAccount(150.0);
    assertFalse(savings1.withdraw(200.0));
    assertEquals(150.0, savings1.getBalance());

    // test super class withdraw with negative amount
    BankAccount savings2 = new SavingsAccount(150.0);
    assertFalse(savings2.withdraw(-50.0));
    assertEquals(150.0, savings2.getBalance());

    // test inherited withdraw
    SavingsAccount savings3 = new SavingsAccount(150.0);
    assertFalse(savings3.withdraw(200.0));
    assertEquals(150.0, savings3.getBalance());

    // test inherited withdraw with negative amount
    SavingsAccount savings4 = new SavingsAccount(150.0);
    assertFalse(savings4.withdraw(-50.0));
    assertEquals(150.0, savings4.getBalance());
  }

  /**
   * Test multiple withdraws.
   */
  @Test
  public void testMultipleWithdraws() {

    // each time did not exceed the balance
    SavingsAccount savings1 = new SavingsAccount(1500.0);
    assertTrue(savings1.withdraw(500.0));
    assertEquals(1000.0, savings1.getBalance());
    assertTrue(savings1.withdraw(200.0));
    assertEquals(800.0, savings1.getBalance());
    assertTrue(savings1.withdraw(100.0));
    assertEquals(700.0, savings1.getBalance());
    assertTrue(savings1.withdraw(500.0));
    assertEquals(200.0, savings1.getBalance());
    assertTrue(savings1.withdraw(200.0));
    assertEquals(0.0, savings1.getBalance());

  }

  /**
   * Test multiple withdraws bad.
   */
  @Test
  public void testMultipleWithdrawsBad() {
    // one time exceeded the balance
    SavingsAccount savings1 = new SavingsAccount(1500.0);
    assertTrue(savings1.withdraw(500.0));
    assertEquals(1000.0, savings1.getBalance());
    assertTrue(savings1.withdraw(200.0));
    assertEquals(800.0, savings1.getBalance());
    assertFalse(savings1.withdraw(900.0));
    assertEquals(800.0, savings1.getBalance());
  }

  /**
   * Test good deposit.
   */
  @Test
  public void testGoodDeposit() {
    // test super class deposit
    BankAccount savings1 = new SavingsAccount(150.0);
    savings1.deposit(50.0);
    assertEquals(200.0, savings1.getBalance());

    // test inherited deposit
    SavingsAccount savings2 = new SavingsAccount(150.0);
    savings2.deposit(50.0);
    assertEquals(200.0, savings2.getBalance());
  }

  /**
   * Test bad deposit.
   */
  @Test
  public void testBadDeposit() {
    // test super class deposit with negative amount
    BankAccount savings1 = new SavingsAccount(150.0);
    assertThrows(IllegalArgumentException.class, () -> savings1.deposit(-50.0));
    assertEquals(150.0, savings1.getBalance());

    // test inherited deposit with negative amount
    SavingsAccount savings2 = new SavingsAccount(150.0);
    assertThrows(IllegalArgumentException.class, () -> savings2.deposit(-50.0));
    assertEquals(150.0, savings2.getBalance());
  }

  /**
   * Test default monthly maintenance.
   */
  @Test
  public void testDefaultMonthlyMaintenance() {
    // test super class monthly maintenance
    BankAccount savings1 = new SavingsAccount(1500.0);
    savings1.performMonthlyMaintenance();
    assertEquals(1500.0, savings1.getBalance());

    // test inherited monthly maintenance
    SavingsAccount savings2 = new SavingsAccount(1500.0);
    savings2.performMonthlyMaintenance();
    assertEquals(1500.0, savings2.getBalance());
  }

  /**
   * Test monthly maintenance.
   */
  @Test
  public void testMonthlyMaintenance() {
    // test super class monthly maintenance
    BankAccount savings1 = new SavingsAccount(1000.0);
    savings1.withdraw(100.0);
    savings1.withdraw(100.0);
    savings1.withdraw(100.0);
    savings1.withdraw(100.0);
    savings1.withdraw(100.0);
    savings1.withdraw(100.0);
    savings1.withdraw(100.0);
    savings1.performMonthlyMaintenance();
    assertEquals(286.0, savings1.getBalance());

    // test inherited monthly maintenance
    SavingsAccount savings2 = new SavingsAccount(1000.0);
    savings2.withdraw(100.0);
    savings2.withdraw(100.0);
    savings2.withdraw(100.0);
    savings2.withdraw(100.0);
    savings2.withdraw(100.0);
    savings2.withdraw(100.0);
    savings2.withdraw(100.0);
    savings2.performMonthlyMaintenance();
    assertEquals(286.0, savings2.getBalance());
  }
}
