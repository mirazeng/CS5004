package student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * The type Salaried employee.
 */
public class SalariedEmployee implements IEmployee {
  /**
   * Constant for months in a year.
   */
  private static final int MONTHS_IN_YEAR = 12;
  /**
   * The constant ZERO.
   */
  private static final double ZERO = 0.0;
  /**
   * Constant for maximum raise percentage.
   */
  private static final double MAX_RAISE_PERCENT = 10.0;
  /**
   * Constant for maximum salary.
   */
  private static final double MAX_SALARY = 1000000.0;
  /**
   * Constant for converting percentage to decimal.
   */
  private static final double PERCENTAGE_CONVERTER = 100.0;
  /**
   * Employee's name.
   */
  private final String name;
  /**
   * Employee's ID.
   */
  private final String id;
  /**
   * Employee's yearly salary.
   */
  private double yearlySalary;

  /**
   * Instantiates a new Salaried employee.
   *
   * @param newName         the name
   * @param newId           the id
   * @param newYearlySalary the yearly salary
   * @throws IllegalArgumentException the illegal argument exception
   */
  public SalariedEmployee(final String newName,
                          final String newId, final double newYearlySalary)
          throws IllegalArgumentException {
    this.name = validStringInput(newName);
    this.id = validStringInput(newId);
    this.yearlySalary = validYearlySalary(newYearlySalary);
  }

  /**
   * Instantiates a new Salaried employee.
   *
   * @param copy the copy
   */
  public SalariedEmployee(SalariedEmployee copy) {
    this.name = copy.name;
    this.id = copy.id;
    this.yearlySalary = copy.yearlySalary;
  }

  /**
   * Hourly employees are paid weekly based on the number of hours worked.
   * Salaried employees are paid monthly,
   * with a given paycheck of 1/12 their yearly salary
   *
   * @return the employee's pay for the given period.
   */
  @Override
  public double getPayForThisPeriod() {
    return twoDecimal(this.yearlySalary / MONTHS_IN_YEAR);
  }

  /**
   * Hourly employees answer their hourly rate.
   * Salaried employees answer their yearly salary
   *
   * @return the employee's base salary.
   */
  @Override
  public double getBaseSalary() {
    return this.yearlySalary;
  }

  /**
   * This method calculates how much
   * the employee's salary should be raised by.
   *
   * @param raisePercent raises the employee's base salary
   *                    from 0% (minimum) to 10% maximum
   * @throws IllegalArgumentException the illegal argument exception
   */

  @Override
  public void giveRaiseByPercent(double raisePercent)
          throws IllegalArgumentException {
    if (raisePercent < ZERO || raisePercent > MAX_RAISE_PERCENT) {
      throw new IllegalArgumentException("Invalid raise percentage");
    } else {
      double raise = this.yearlySalary * (raisePercent / PERCENTAGE_CONVERTER);
      double raisedSalary = this.yearlySalary + raise;
      if (raisedSalary < MAX_SALARY) {
        this.yearlySalary += raise;
      }
    }
  }

  /**
   * Function to get employee ID.
   *
   * @return Returns employee ID.
   */
  @Override
  public String getID() {
    return this.id;
  }

  /**
   * Getter for Employee name.
   *
   * @return Returns employee name.
   */
  @Override
  public String getName() {
    return this.name;
  }

  private String validStringInput(String input)
          throws IllegalArgumentException {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("The name or ID cannot be empty");
    } else {
      return input;
    }
  }

  /**
   * This method checks if the yearly salary is valid.
   *
   * @param newYearlySalary the new yearly salary
   * @return the yearly salary
   * @throws IllegalArgumentException the illegal argument exception
   */
  private double validYearlySalary(double newYearlySalary)
          throws IllegalArgumentException {
    if (newYearlySalary < ZERO || newYearlySalary > MAX_SALARY) {
      throw new IllegalArgumentException("Invalid yearly salary for employee");
    } else {
      return newYearlySalary;
    }
  }

  /**
   * This method returns the employee's information
   * in a formatted output.
   *
   * @return Formatted String output
   */
  @Override
  public String toString() {
    return String.format("""
            Name: %s
            ID: %s
            Base Salary: $%.2f""",
            this.name, this.id, twoDecimal(this.getBaseSalary()));
  }

  /**
   * This method checks if two employees are the same.
   *
   * @param object the object to compare with
   * @return boolean condition depending on the comparison
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    } else if (object == null) {
      return false;
    } else if (getClass() != object.getClass()) {
      return false;
    }
    SalariedEmployee otherSalariedE = (SalariedEmployee) object;
    return this.name.equals(otherSalariedE.name)
            && this.id.equals(otherSalariedE.id);
  }

  /**
   * This method calculates the hash based on
   * employee's various information.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, id, yearlySalary);
  }

  /**
   * This method rounds the salary to two decimal places.
   *
   * @param salary the salary
   * @return rounded-up value of the salary
   */
  private double twoDecimal(double salary) {
    BigDecimal twoDecimal = BigDecimal.valueOf(salary);
    twoDecimal = twoDecimal.setScale(2, RoundingMode.HALF_UP);
    return twoDecimal.doubleValue();
  }

}
