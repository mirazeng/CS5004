package registration;

/**
 * The type Person.
 */
public class Person {
  private final String name;
  private final String address;

  /**
   * Instantiates a new Person.
   *
   * @param name    the name
   * @param address the address
   */
  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return this.address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return name.equals(person.name) && address.equals(person.address);
  }

  @Override
  public String toString() {
    return name + ", " + address;
  }
}