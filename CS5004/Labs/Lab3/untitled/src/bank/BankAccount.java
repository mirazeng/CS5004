package bank;

/**
 * The type Bank account.
 */
public abstract class BankAccount implements IAccount {
  /**
   * The Amount.
   */
  protected double amount;
  private static final double MINIMUM_BALANCE = 0.01;
  private static final double ZERO = 0.0;


  /**
   * Instantiates a new Bank account.
   *
   * @param initialBalance the initial balance
   */
  public BankAccount(double initialBalance) {
    if (initialBalance < MINIMUM_BALANCE) {
      throw new IllegalArgumentException("Initial balance cannot be negative or less than $0.01");
    }
    this.amount = initialBalance;
  }

  /**
   * deposit money into the account.
   *
   * @param amount the amount of money to deposit
   */
  public void deposit(double amount) {
    if (amount < ZERO) {
      throw new IllegalArgumentException("Deposit amount cannot be negative");
    }
    this.amount += amount;
  }

  /**
   * withdraw money from the account.
   *
   * @param amount the amount of money to withdraw
   */
  public boolean withdraw(double amount) {

    boolean result = false;

    if (amount > this.amount) {
      return result;
    }
    if (amount < ZERO) {
      return result;
    } else {
      this.amount -= amount;
      result = true;
    }
    return result;
  }


  public double getBalance() {
    return this.amount;
  }

  @Override
  public String toString() {
    return String.format("$%.2f", this.getBalance());
  }

}
