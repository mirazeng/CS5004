package hw2;

/**
 * Wenqing Zeng - HW2
 * This class represents a Recipient class.
 */
public class Recipient {
  private final String firstName;
  private final String lastName;
  private String email;

  /**
   * Instantiates a new Recipient.
   *
   * @param firstName the first name
   * @param lastName the last name
   * @param email the email
   * @throws IllegalArgumentException the
   *
   */
  public Recipient(String firstName, String lastName, String email)
          throws IllegalArgumentException {
    // Check if any of the recipient information is empty or null
    // If yes, then throw an IllegalArgumentException
    // And print appropriate message to show what is going on
    if (firstName == null || firstName.isEmpty()) {
      throw new IllegalArgumentException("First name can not be empty.");
    } else if (lastName == null || lastName.isEmpty()) {
      throw new IllegalArgumentException("Last name can not be empty.");
    } else if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Email can not be empty.");
    }
    // If everything is valid, set them respectively
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Sets email.
   *
   * @param email the email string
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Print the recipient's information in a formatted way.
   *
   * @return formatted printed string representing recipient
   */
  public String toString() {
    return String.format("%s %s Email:%s",
            this.firstName,
            this.lastName,
            this.email);
  }

  /**
   * Compare this Recipient with another Object,
   * to see if they are the same.
   *
   * @param other the object to compare with
   * @return boolean condition: equal or not
   */
  @Override
  public boolean equals(Object other) {
    // If the two objects are the same,
    // Then they are the same
    if (this == other) {
      return true;
    }

    // If the other object is null,
    // Or if their class do not even match,
    // Then they are not the same thing.
    if (other == null || this.getClass() != other.getClass()) {
      return false;
    }

    // If everything else passed,
    // Compare their respective info fields
    // Any mismatch means not the same
    Recipient otherRecipient = (Recipient) other;
    return this.firstName.equals(otherRecipient.firstName)
        && this.lastName.equals(otherRecipient.lastName)
        && this.email.equals(otherRecipient.email);
  }

  /**
   * Customized hash method for Recipient class,
   * Hashes each instance using the sum of all the info fields' hashes.
   *
   * @return hash for recipient instance
   */
  @Override
  public int hashCode() {
    return this.firstName.hashCode()
            + this.lastName.hashCode()
            + this.email.hashCode();
  }
}
