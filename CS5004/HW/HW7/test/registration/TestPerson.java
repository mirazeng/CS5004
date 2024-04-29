package registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** The type Test person. */
public class TestPerson {

  private Person person1;
  private Person person2;

  /** Sets up. */
  @BeforeEach
  public void setUp() {
    person1 = new Person("Cillian Murphy", "360 Huntington Ave, Boston, MA");
    person2 = new Person("Tom Hardy", "770 Indiana Ave, Bloomington, IN");
  }

  /** Test get name. */
  @Test
  public void testGetName() {
    assertEquals("Cillian Murphy", person1.getName());
    assertEquals("Tom Hardy", person2.getName());
  }

  /** Test get address. */
  @Test
  public void testGetAddress() {
    assertEquals("360 Huntington Ave, Boston, MA", person1.getAddress());
    assertEquals("770 Indiana Ave, Bloomington, IN", person2.getAddress());
  }

  /** Test to string. */
  @Test
  public void testToString() {
    assertEquals("Cillian Murphy, 360 Huntington Ave, Boston, MA", person1.toString());
    assertEquals("Tom Hardy, 770 Indiana Ave, Bloomington, IN", person2.toString());
  }

  /** Test equals. */
  @Test
  public void testEquals() {
    Person person3 = new Person("Cillian Murphy", "360 Huntington Ave, Boston, MA");
    assertEquals(person1, person3);
  }
}