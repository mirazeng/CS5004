package stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for class Stock.
 * Two Stock objects constructed: Apple, Google
 */
public class TestStock {
  private stock.Stock Apple;
  private stock.Stock Google;
  private stock.Stock noneStock;

  /**
   * Set up parameters for Stock objects.
   */
  @Before
  public void setUp() {
    this.Apple = new Stock("AAPL", "Apple", 185.92);
    this.Google = new Stock("GOOGL", "Google", 142.6562);
    this.noneStock = new Stock("","", 9999.9999);
  }

  /**
   * Test of getting the symbol of Stock objects.
   */
  @Test
  public void testSymbol() {
    assertEquals("AAPL", this.Apple.getSymbol());
    assertEquals("GOOGL", this.Google.getSymbol());
    assertEquals("", this.noneStock.getSymbol());
  }

  /**
   * Test of getting the name of Stock objects.
   */
  @Test
  public void testName() {
    assertEquals("Apple", this.Apple.getName());
    assertEquals("Google", this.Google.getName());
    assertEquals("", this.noneStock.getName());
  }

  /**
   * Test of getting the cost basis of Stock objects.
   */
  @Test
  public void testGetCostBasis() {
    assertEquals(185.92, this.Apple.getCostBasis(), 0.001);
    assertEquals(142.6562, this.Google.getCostBasis(), 0.00001);
    assertEquals(9999.9999, this.noneStock.getCostBasis(), 0.00001);
  }

  /**
   * Test of getting the current price of Stock objects.
   */
  @Test
  public void testGetCurrentPrice() {
    this.Apple.setCurrentPrice(186.01);
    this.Google.setCurrentPrice(142.9869);
    this.noneStock.setCurrentPrice(0.0000001);
    assertEquals(186.01, this.Apple.getCurrentPrice(), 0.001);
    assertEquals(142.9869, this.Google.getCurrentPrice(), 0.00001);
    assertEquals(0.0000001, this.noneStock.getCurrentPrice(), 0.00000001);
  }

  /**
   * Test of setting the cost basis of Stock objects.
   * Implementing a getter method to ensure the value is correct
   */
  @Test
  public void testSetCostBasis() {
    this.Apple.setCostBasis(200.65);
    this.Google.setCostBasis(156.6874);
    this.noneStock.setCostBasis(1000000.00);
    assertEquals(200.65, this.Apple.getCostBasis(), 0.001);
    assertEquals(156.6874, this.Google.getCostBasis(), 0.000001);
    assertEquals(1000000.00, this.noneStock.getCostBasis(), 0.001);
  }

  /**
   * Test of setting the current price of Stock objects.
   * Implementing a getter method to ensure the value is correct
   */
  @Test
  public void testSetCurrentPrice() {
    this.Apple.setCurrentPrice(136.59);
    this.Google.setCurrentPrice(158.2698);
    this.noneStock.setCurrentPrice(0.9999);

    assertEquals(136.59, this.Apple.getCurrentPrice(), 0.001);
    assertEquals(158.2698, this.Google.getCurrentPrice(), 0.00001);
    assertEquals(0.9999, this.noneStock.getCurrentPrice(), 0.00001);
  }

  /**
   * Test of getting the change percentage of Stock objects.
   * Implementing a getter method to calculate and ensure the outcome is correct
   */
  @Test
  public void testGetChangePercent() {
    this.Apple.setCurrentPrice(136.59);
    this.Google.setCurrentPrice(158.2698);
    this.noneStock.setCurrentPrice(0.9999);
    this.Apple.setCostBasis(200.65);
    this.Google.setCostBasis(156.6874);
    this.noneStock.setCostBasis(1000000.00);
    assertEquals(((136.59 - 200.65) / 200.65), this.Apple.getChangePercent(), 0.0001);
    assertEquals(((158.2698 - 156.6874) / 156.6874), this.Google.getChangePercent(), 0.00001);
    assertEquals(((0.9999 - 1000000.00) / 1000000.00), this.noneStock.getChangePercent(), 0.00001);
  }

  /** Test of Stock object string output.
   * Implementing a setter method to ensure an integer to a string
   */
  @Test
  public void testToString() {
    this.Apple.setCurrentPrice(136.59);
    this.Apple.setCostBasis(200.65);
    assertEquals(
        "Apple Current Price: $ 136.59"
                + "\n"
                + " Gain/Loss: -31.93%", this.Apple.toString());
  }
}
