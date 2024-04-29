package bank;

/**
 * This interface represents a bank account. It is the super-type for
 * any other type of traditional financial account a bank might offer
 */
public interface IAccount {
  /**
   * Deposit.
   *
   * @param amount the amount
   */
  void deposit(double amount);

  /**
   * Withdraw boolean.
   *
   * @param amount the amount
   * @return the boolean
   */
  boolean withdraw(double amount);

  /**
   * Gets balance.
   *
   * @return the balance
   */
  double getBalance();

  /**
   * Perform monthly maintenance.
   */
  void performMonthlyMaintenance();
}
