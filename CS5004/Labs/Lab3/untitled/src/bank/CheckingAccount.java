package bank;

/**
 * The type Checking account.
 */
public class CheckingAccount extends BankAccount {

  private double fee = 0;
  private static final double MIN_BALANCE = 100;

  private static final double MONTHLY_FEE = 5;

  /**
   * Instantiates a new Checking account.
   *
   * @param initialBalance the initial balance
   */
  public CheckingAccount(double initialBalance) {
    super(initialBalance);
    this.isBelow();
  }

  @Override
  public boolean withdraw(double amount) {
    boolean withdrawSuccess = super.withdraw(amount);
    this.isBelow();
    return withdrawSuccess;
  }

  @Override
  public void performMonthlyMaintenance() {
    // perform monthly maintenance
    this.amount -= this.fee;
    // reset fee
    this.fee = 0;
    // recheck if the balance is below 100
    this.isBelow();
  }

  private void isBelow() {
    // check if the balance is below 100
    if (this.getBalance() < MIN_BALANCE) {
      this.fee = MONTHLY_FEE;
    }
  }
}

