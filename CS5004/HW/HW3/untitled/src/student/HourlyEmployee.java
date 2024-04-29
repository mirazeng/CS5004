package student;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * The type Hourly employee.
 */
public class HourlyEmployee implements IEmployee {
  /**
   * The constant ZERO.
   */
  private static final double ZERO = 0;
  /**
   * The constant MAX_NORMAL_HOUR.
   */
  private static final double MAX_NORMAL_HOUR = 40.0;
  /**
   * The constant OVERPAY_RATE.
   */
  private static final double OVERPAY_RATE = 1.5;
  /**
   * The constant MAX_RAISE_PERCENT.
   */
  private static final double MAX_RAISE_PERCENT = 10.0;
  /**
   * The constant PERCENTAGE.
   */
  private static final double PERCENTAGE_CONVERTER = 100.0;
  /**
   * The constant MAX_HOURLY_SALARY.
   */
  private static final double MAX_HOURLY_SALARY = 50.0;
  /**
   * The constant MAX_WORK_HOURS.
   */
  private static final double MAX_WORK_HOURS = 80.0;
  /**
   * The employee's name.
   */
  private final String name;
  /**
   * Employee's ID.
   */
  private final String id;
  /**
   * Employee's normal working hours for a period.
   */
  private final double normalHours;
  /**
   * Employee's hourly salary.
   */
  private double hourlySalary;
  /**
   * Employee's special hours, requires manual override.
   */
  private double specialHours = ZERO;
  /**
   * Boolean for keeping track of
   * whether employee worked overtime for current period.
   */
  private boolean overTime = false;


  /**
   * Instantiates a new Hourly employee.
   *
   * @param newName         the new name
   * @param newId           the new id
   * @param newHourlySalary the new hourly salary
   * @param newNormalHours  the new normal hours
   * @throws IllegalArgumentException the illegal argument exception
   */
  public HourlyEmployee(final String newName, final String newId,
                        double newHourlySalary,
                        final double newNormalHours)
          throws IllegalArgumentException {
    this.name = validStringInput(newName);
    this.id = validStringInput(newId);
    this.hourlySalary = validHourlySalary(newHourlySalary);
    this.normalHours = validNormalHours(newNormalHours);
  }

  /**
   * Instantiates a new Hourly employee.
   *
   * @param copy the copy
   */
  public HourlyEmployee(HourlyEmployee copy) {
    this.name = copy.name;
    this.id = copy.id;
    this.hourlySalary = copy.hourlySalary;
    this.normalHours = copy.normalHours;
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
    double result;
    // If special hours is more than 0,
    // means this period the employee worked extra.
    if (this.overTime) {
      // Check if special Hours are actually bigger than 40
      if (this.specialHours > MAX_NORMAL_HOUR) {
        double extraPay = ((this.specialHours - MAX_NORMAL_HOUR)
                * this.hourlySalary * OVERPAY_RATE);
        result = extraPay + (MAX_NORMAL_HOUR * this.hourlySalary);
      } else {
        result = this.hourlySalary * this.specialHours;
      }
    } else {
      result = this.getBasePay();
    }
    this.specialHours = ZERO;
    this.overTime = false;
    return twoDecimal(result);
  }


  /**
   * Hourly employees answer their hourly rate.
   * Salaried employees answer their yearly salary
   *
   * @return the employee's base salary.
   */
  @Override
  public double getBaseSalary() {
    return this.hourlySalary;
  }

  /**
   * Raises the employee's base salary from 0% (minimum) to 10% maximum,
   * This method converts that value to a decimal value
   * of range 0 - 0.10 when required for calculations.
   *
   * @param raisePercent The parameter is a value
   *                    between 0.0 and 10.0.
   *
   */
  @Override
  public void giveRaiseByPercent(double raisePercent)
          throws IllegalArgumentException {
    if (raisePercent < ZERO || raisePercent > MAX_RAISE_PERCENT) {
      throw new IllegalArgumentException("Invalid raise percentage");
    } else {
      double raise = (this.hourlySalary * (raisePercent
              / PERCENTAGE_CONVERTER));
      double raisedSalary = this.hourlySalary + raise;
      if (raisedSalary < MAX_HOURLY_SALARY) {
        this.hourlySalary += raise;
      }
    }

  }

  /**
   * Getter for Employee ID.
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

  /**
   * This method allows HourlyEmployees to
   * supersede the number of hours worked for the week.
   *
   * @param hours the hours.
   * @throws IllegalArgumentException the illegal argument exception.
   */
  public void setSpecialHours(double hours)
          throws IllegalArgumentException {
    if (hours < ZERO || hours > MAX_WORK_HOURS) {
      throw new IllegalArgumentException("Invalid number of hours worked");
    } else {
      this.specialHours = hours;
      this.overTime = true;
    }
  }

  /**
   * This method calculates the base pay for the employee.
   *
   *
   * @return the base pay for employee.
   */
  private double getBasePay() {
    return (this.normalHours * this.hourlySalary);
  }

  /**
   * This helper method validates the input
   * for the employee's information.
   *
   * @param input the input
   * @return the information if valid
   * @throws IllegalArgumentException the illegal argument exception
   *
   */
  private String validStringInput(String input)
          throws IllegalArgumentException {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("The name or ID cannot be empty");
    } else {
      return input;
    }
  }

  /**
   * This helper method validates the input
   * for the employee's hourly salary.
   *
   * @param newHourlySalary the new hourly salary
   * @return new hourly salary if valid
   * @throws IllegalArgumentException the illegal argument exception
   */
  private double validHourlySalary(double newHourlySalary)
          throws IllegalArgumentException {
    if (newHourlySalary < ZERO || newHourlySalary > MAX_HOURLY_SALARY) {
      throw new IllegalArgumentException(
              "Invalid hourly salary input for employee");
    } else {
      return newHourlySalary;
    }
  }

  /**
   * This helper method validates the input
   * for the employee's work hours.
   *
   * @param newNormalHours the new work hours
   * @return new hours if valid
   * @throws IllegalArgumentException the illegal argument exception
   */
  private double validNormalHours(double newNormalHours)
          throws IllegalArgumentException {
    if (newNormalHours < ZERO || newNormalHours > MAX_WORK_HOURS) {
      throw new IllegalArgumentException(
              "Invalid number of hours worked for employee");
    } else {
      return newNormalHours;
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
   * @param o the object to compare with
   * @return boolean condition depending on the comparison
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o == null) {
      return false;
    } else if (this.getClass() != o.getClass()) {
      return false;
    }
    HourlyEmployee otherHourlyE = (HourlyEmployee) o;
    return this.name.equals(otherHourlyE.name)
            && this.id.equals(otherHourlyE.id);
  }

  /**
   * This method calculates the hash based on
   * employee's various information.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, id, hourlySalary, normalHours);
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
