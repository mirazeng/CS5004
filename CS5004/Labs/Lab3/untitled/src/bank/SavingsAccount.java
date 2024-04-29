package bank;

/**
 * The type Savings account.
 */
public class SavingsAccount extends BankAccount {

  private int transactionCount;

  private static final double MONTHLY_FEE = 14;
  private static final double MAX_FREE_TRANSACTIONS = 6;

  /**
   * Instantiates a new Savings account.
   *
   * @param initialBalance the initial balance
   */
  public SavingsAccount(double initialBalance) {
    super(initialBalance);
  }

  @Override
  public boolean withdraw(double amount) {
    boolean withdrawSuccess = super.withdraw(amount);
    if (withdrawSuccess) {
      // increment transaction count
      transactionCount += 1;
    }
    return withdrawSuccess;
  }

  /**
   * Perform monthly maintenance.
   *
   */
  public void performMonthlyMaintenance() {
    if (transactionCount > MAX_FREE_TRANSACTIONS) {
      this.amount -= MONTHLY_FEE;
    }
    // reset transaction count
    this.transactionCount = 0;
  }
}
