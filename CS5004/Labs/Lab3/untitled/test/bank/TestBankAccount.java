package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * The type Test bank account.
 */
public class TestBankAccount {

  /**
   * Test to string.
   */
  @Test
  public void testToString() {

    // test subclass with initial balance of 200.0
    BankAccount account1 = new CheckingAccount(200.0);
    assertEquals("$200.00", account1.toString());
    BankAccount account2 = new SavingsAccount(200.0);
    assertEquals("$200.00", account2.toString());

    // test subclass with withdraw of 100.0
    account1.withdraw(30.0);
    assertEquals("$170.00", account1.toString());
    account2.withdraw(30.0);
    assertEquals("$170.00", account2.toString());

    // test subclass with multiple withdraws
    account1.withdraw(30.0);
    account1.withdraw(30.0);
    account1.withdraw(30.0);
    assertEquals("$80.00", account1.toString());
    account2.withdraw(30.0);
    account2.withdraw(30.0);
    account2.withdraw(30.0);
    assertEquals("$80.00", account2.toString());

    // test subclass with monthly maintenance fee
    account1.performMonthlyMaintenance();
    assertEquals("$75.00", account1.toString());
    account2.withdraw(10.0);
    account2.withdraw(10.0);
    account2.withdraw(10.0);
    account2.performMonthlyMaintenance();
    assertEquals("$36.00", account2.toString());

    // test subclass with deposit of 100.0
    account1.deposit(100.0);
    assertEquals("$175.00", account1.toString());
    account2.deposit(100.0);
    assertEquals("$136.00", account2.toString());
  }

}
