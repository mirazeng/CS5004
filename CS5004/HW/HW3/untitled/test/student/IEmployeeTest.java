package student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IEmployeeTest {
  // This is a placeholder for student code.
  HourlyEmployee snoopyHours = new HourlyEmployee("Snoopy", "111-CHLY-BRWN", 17.50, 20);
  SalariedEmployee lucy = new SalariedEmployee("Lucy", "222-22-2222", 70000.00);
  IEmployee woodStock = new SalariedEmployee("Woodstock", "33-CHIRP", 180000.50);


  // sample test provided to students
  @Test
  public void testGetErrorWhenCreatingEmployee() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", null, 15.51, 30);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee(null, "PT-TIME", 15.51, -1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", "PT-TIME", -1, 30);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", "PT-TIME", 51, 30);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", "PT-TIME", 15.51, 81);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", "", 15.51, 81);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("", "PT-TIME", 15.51, 81);
    });

    // --------------------------------

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("Full-timer", null, 100000.00);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee(null, "FT-TIME", -1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("Full-timer", "FT-TIME", 1000001.00);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("Full-timer", "FT-TIME", -1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("", "FT-TIME", -1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("Full-timer", "", -1);
    });

  }

  @Test
  public void testGetHappyDayEmployee() {
    Assertions.assertEquals("Snoopy", snoopyHours.getName());
    Assertions.assertEquals("111-CHLY-BRWN", snoopyHours.getID());
    Assertions.assertEquals(17.50, snoopyHours.getBaseSalary());
    Assertions.assertEquals(17.50 * 20, snoopyHours.getPayForThisPeriod());

    Assertions.assertEquals("Lucy", lucy.getName());
    Assertions.assertEquals("222-22-2222", lucy.getID());
    Assertions.assertEquals(70000.00, lucy.getBaseSalary());
    Assertions.assertEquals(5833.33, lucy.getPayForThisPeriod());

    Assertions.assertEquals("Woodstock", woodStock.getName());
    Assertions.assertEquals("33-CHIRP", woodStock.getID());
    Assertions.assertEquals(180000.50, woodStock.getBaseSalary());
    Assertions.assertEquals(15000.04, woodStock.getPayForThisPeriod());
  }

  @Test
  public void testGetPayForThisPeriod() {
    Assertions.assertEquals(17.50 * 20, snoopyHours.getPayForThisPeriod());
    Assertions.assertEquals(5833.33, lucy.getPayForThisPeriod());
    Assertions.assertEquals(15000.04, woodStock.getPayForThisPeriod());
  }

  @Test
  public void testGetBaseSalary() {
    Assertions.assertEquals(17.50, snoopyHours.getBaseSalary());
    Assertions.assertEquals(70000.00, lucy.getBaseSalary());
    Assertions.assertEquals(180000.50, woodStock.getBaseSalary());
  }

  @Test
  public void testGetID() {
    Assertions.assertEquals("111-CHLY-BRWN", snoopyHours.getID());
    Assertions.assertEquals("222-22-2222", lucy.getID());
    Assertions.assertEquals("33-CHIRP", woodStock.getID());
  }

  @Test
  public void testGetName() {
    Assertions.assertEquals("Snoopy", snoopyHours.getName());
    Assertions.assertEquals("Lucy", lucy.getName());
    Assertions.assertEquals("Woodstock", woodStock.getName());
  }

  @Test
  public void testBadRaise() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", "PT-TIME", 15.51, 30);
      e.giveRaiseByPercent(-0.1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new HourlyEmployee("Part-timer", "PT-TIME", 15.51, 30);
      e.giveRaiseByPercent(10.1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("Full-timer", "FT-TIME", 100000.00);
      e.giveRaiseByPercent(-0.1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      IEmployee e = new SalariedEmployee("Full-timer", "FT-TIME", 100000.00);
      e.giveRaiseByPercent(10.1);
    });
  }

  @Test
  public void testGoodRaise() {
    snoopyHours.giveRaiseByPercent(5.0);
    Assertions.assertEquals((17.50 + (17.50 * (5.0 / 100))), snoopyHours.getBaseSalary());
    lucy.giveRaiseByPercent(10.0);
    Assertions.assertEquals(70000.00 + (70000.00 * (10.0 / 100)), lucy.getBaseSalary());
    woodStock.giveRaiseByPercent(10.0);
    Assertions.assertEquals(180000.50 + (180000.50 * (10.0 / 100)), woodStock.getBaseSalary());
  }

  @Test
  public void testNoRaise() {
    IEmployee e1 = new HourlyEmployee("Part-timer", "PT-TIME", 48.5, 30);
    e1.giveRaiseByPercent(9.0);
    Assertions.assertEquals(48.5, e1.getBaseSalary());

    IEmployee e2 = new SalariedEmployee("Full-timer", "FT-TIME", 950000.00);
    e2.giveRaiseByPercent(10.0);
    Assertions.assertEquals(950000.00, e2.getBaseSalary());
  }

  @Test
  public void testHourlyEmployeeGetPay() {

    //==========================================
    // Below is testing HourlyEmployee
    HourlyEmployee e1 = new HourlyEmployee("Test Hourly", "test001", 48.5, 30);
    Assertions.assertEquals(48.5 * 30, e1.getPayForThisPeriod());

    e1.setSpecialHours(80);
    Assertions.assertEquals(((40 * 48.5) + (40 * 48.5 * 1.5)), e1.getPayForThisPeriod());

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      e1.setSpecialHours(-1);
    });
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      e1.setSpecialHours(100);
    });

    // Testing scenario where special hours is set to exactly 40
    e1.setSpecialHours(40);
    Assertions.assertEquals((40 * 48.5), e1.getPayForThisPeriod());

    e1.setSpecialHours(38);
    Assertions.assertEquals((38 * 48.5), e1.getPayForThisPeriod());

    //==========================================s
    // Below is testing SalariedEmployee
    SalariedEmployee e2 = new SalariedEmployee("Test Yearly", "test002", 950000.00);
    Assertions.assertEquals(79166.67, e2.getPayForThisPeriod());
  }

  @Test
  public void testCopyConstructor(){
    // Test hourly and salaried employee copy constructor
    HourlyEmployee e1 = new HourlyEmployee("Test Hourly", "test001", 48.5, 30);
    HourlyEmployee e2 = new HourlyEmployee(e1);
    Assertions.assertEquals(e1.getName(), e2.getName());
    Assertions.assertEquals(e1.getID(), e2.getID());
    Assertions.assertEquals(e1.getBaseSalary(), e2.getBaseSalary());
    Assertions.assertEquals(e1.getPayForThisPeriod(), e2.getPayForThisPeriod());

    SalariedEmployee e3 = new SalariedEmployee("Test Yearly", "test002", 950000.00);
    SalariedEmployee e4 = new SalariedEmployee(e3);
    Assertions.assertEquals(e3.getName(), e4.getName());
    Assertions.assertEquals(e3.getID(), e4.getID());
    Assertions.assertEquals(e3.getBaseSalary(), e4.getBaseSalary());
    Assertions.assertEquals(e3.getPayForThisPeriod(), e4.getPayForThisPeriod());

  }

  @Test
  public void testToString(){
    // Test hourly and salaried employee toString
    HourlyEmployee e1 = new HourlyEmployee("Bradley Cooper", "bc01", 48.5, 30);
    Assertions.assertEquals("""
            Name: Bradley Cooper
            ID: bc01
            Base Salary: $48.50""", e1.toString());

    SalariedEmployee e2 = new SalariedEmployee("Orlando Bloom", "ob01", 950000.00);
    Assertions.assertEquals("""
            Name: Orlando Bloom
            ID: ob01
            Base Salary: $950000.00""", e2.toString());
  }

  @Test
  public void testGoodEquals(){
    // Test hourly and salaried employee equals
    HourlyEmployee e2 = new HourlyEmployee("Wilson Fisk", "wf01", 48.5, 30);
    HourlyEmployee e1 = new HourlyEmployee("Wilson Fisk", "wf01", 48.5, 30);
    Assertions.assertTrue(e1.equals(e2));

    SalariedEmployee e3 = new SalariedEmployee("Paul Atreides", "ob01", 950000.00);
    SalariedEmployee e4 = new SalariedEmployee("Paul Atreides", "ob01", 950000.00);
    Assertions.assertTrue(e3.equals(e4));
  }

   @Test
  public void testBadEquals(){
    // Test mismatched ID
    HourlyEmployee e1 = new HourlyEmployee("Wilson Fisk", "wf01", 48.5, 30);
    HourlyEmployee e2 = new HourlyEmployee("Wilson Fisk", "wf02", 48.5, 30);
    Assertions.assertFalse(e1.equals(e2));
    Assertions.assertFalse(!(e1.equals(e1)));

    SalariedEmployee e3 = new SalariedEmployee("Paul Atreides", "pa01", 950000.00);
    SalariedEmployee e4 = new SalariedEmployee("Paul Atreides", "pa02", 950000.00);
    Assertions.assertFalse(e3.equals(e4));
    Assertions.assertFalse(!(e3.equals(e3)));

    // Test mismatched name
    HourlyEmployee e5 = new HourlyEmployee("Wilson Fisk", "wf01", 48.5, 30);
    HourlyEmployee e6 = new HourlyEmployee("Wilson Atreides", "wf01", 48.5, 30);
    Assertions.assertFalse(e5.equals(e6));

    SalariedEmployee e7 = new SalariedEmployee("Paul Atreides", "pa01", 950000.00);
    SalariedEmployee e8 = new SalariedEmployee("Paul Fisk", "pa01", 950000.00);
    Assertions.assertFalse(e7.equals(e8));

    IEmployee e9 = new HourlyEmployee("Ryan Gosling", "rg01", 32.0, 28);
    IEmployee e10 = new SalariedEmployee("Ryan Reynolds", "rr01", 120000.00);
    Assertions.assertFalse(e9.equals(e10));
    Assertions.assertFalse(e10.equals(e9));

    Assertions.assertFalse(e9.equals(null));
    Assertions.assertFalse(e10.equals(null));
  }

  @Test
  public void testGoodHashCode(){
    // Test hourly and salaried employee hashCode
    HourlyEmployee e1 = new HourlyEmployee("Paul Atreides", "pa01", 28.5, 35);
    HourlyEmployee e2 = new HourlyEmployee("Paul Atreides", "pa01", 28.5, 35);
    Assertions.assertEquals(e1.hashCode(), e2.hashCode());

    // Test hourly and salaried employee hashCode
    SalariedEmployee e3 = new SalariedEmployee("Frank Ocean", "fo001", 660000.00);
    SalariedEmployee e4 = new SalariedEmployee("Frank Ocean", "fo001", 660000.00);
    Assertions.assertEquals(e3.hashCode(), e4.hashCode());
  }


}

