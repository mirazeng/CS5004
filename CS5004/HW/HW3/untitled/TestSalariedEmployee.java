package student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSalariedEmployee {
  private SalariedEmployee employee01;
  private SalariedEmployee employee02;
  private SalariedEmployee employee03;

  @BeforeEach
  void setUp() {
    employee01 = new SalariedEmployee("Pam", "001", 800000.0);
    employee02 = new SalariedEmployee("Michael", "002", 1000000.0);
    employee03 = new SalariedEmployee("Jim", "003", 500000.0);
  }

  @Test
  public void testBadConstructor() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new SalariedEmployee(null, "004", 800000.0);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new SalariedEmployee("", "004", 800000.0);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new SalariedEmployee("Dwight", null, 800000.0);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new SalariedEmployee("Dwight", "", 800000.0);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new SalariedEmployee("Kelly", "005", -0.1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      new SalariedEmployee("Kelly", "005", 1000005.5);
    });
  }

  @Test
  public void testGoodConstructor() {
    Assertions.assertEquals("Pam", employee01.getName());
    Assertions.assertEquals("001", employee01.getID());

    // test for yearly salary if it is set correctly
    // by implementing the getBaseSalary method and the getPayForThisPeriod method
    Assertions.assertEquals(800000.0, employee01.getBaseSalary());
    Assertions.assertEquals(800000.0 / 12, employee01.getPayForThisPeriod());
  }

  @Test
  public void testGetPayForThisPeriod() {
    Assertions.assertEquals(800000.0 / 12, employee01.getPayForThisPeriod());
    Assertions.assertEquals(1000000.0 / 12, employee02.getPayForThisPeriod());
    Assertions.assertEquals(500000.0 / 12, employee03.getPayForThisPeriod());
  }

  @Test
  public void testGetBaseSalary() {
    Assertions.assertEquals(800000.0, employee01.getBaseSalary());
    Assertions.assertEquals(1000000.0, employee02.getBaseSalary());
    Assertions.assertEquals(500000.0, employee03.getBaseSalary());
  }

  @Test
  public void testBadRaise() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      employee01.giveRaiseByPercent(-0.1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      employee01.giveRaiseByPercent(10.1);
    });
  }

  @Test
  public void testGoodRaise() {
    employee01.giveRaiseByPercent(5.0);
    Assertions.assertEquals((800000 + (800000 * (5.0 / 100))), employee01.getBaseSalary());
    employee03.giveRaiseByPercent(10.0);
    Assertions.assertEquals(550000.0, employee03.getBaseSalary());
  }

  @Test
  public void testNoRaise() {
    employee02.giveRaiseByPercent(10.0);
    Assertions.assertEquals(1000000, employee02.getBaseSalary());
  }

  @Test
  public void testGetID() {
    Assertions.assertEquals("001", employee01.getID());
    Assertions.assertEquals("002", employee02.getID());
    Assertions.assertEquals("003", employee03.getID());
  }

  @Test
  public void testGetName() {
    Assertions.assertEquals("Pam", employee01.getName());
    Assertions.assertEquals("Michael", employee02.getName());
    Assertions.assertEquals("Jim", employee03.getName());
  }

}