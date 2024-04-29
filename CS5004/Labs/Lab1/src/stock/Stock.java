package stock;

/**
 * Wenqing Zeng - Lab_1
 * This class represents a Stock class with following attributes:
 * symbol, name, costBasis, currentPrice.
 */
public class Stock {
  private final String symbol;
  private final String name;
  private double costBasis;
  private double currentPrice;

  /**
   * Constructor of Stock: instantiates a new Stock.
   *
   * @param symbol    the symbol of a stock
   * @param name      the name of a stock
   * @param costBasis the cost basis of stock
   */
  public Stock(String symbol, String name, double costBasis) {
    this.symbol = symbol;
    this.name = name;
    this.costBasis = costBasis;
  }

  /**
   * a method to get symbol of the stock.
   *
   * @return the symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * a method to get name of the stock.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * a method to get cost basis of the stock.
   *
   * @return the cost basis
   */
  public double getCostBasis() {
    return costBasis;
  }

  /**
   * a method to sets new cost basis of the stock.
   *
   * @param newCostBasis the new cost basis
   */
  public void setCostBasis(double newCostBasis) {
    this.costBasis = newCostBasis;
  }

  /**
   * a method to get current price of the stock.
   *
   * @return the current price
   */
  public double getCurrentPrice() {
    return currentPrice;
  }

  /**
   * a method to set new current price of the stock.
   *
   * @param NewCurrentPrice the new current price
   */
  public void setCurrentPrice(double NewCurrentPrice) {
    this.currentPrice = NewCurrentPrice;
  }

  /**
   * a method to get/calculate change percent,
   * after updated the current price of the stock.
   * @return the change percent
   */
  public double getChangePercent() {
    return (this.currentPrice - this.costBasis) / this.costBasis;
  }

  /**
  * a method to represent Stock objects in String format.
  *
  * @return the formatted string of Stock object information
  */
  public String toString() {
    String strCurrentPrice = String.valueOf(this.currentPrice);
    String strChangePercent = String.format("%.2f", this.getChangePercent() * 100);
    return name
        + " Current Price: "
        + "$ "
        + strCurrentPrice
        + "\n"
        + " Gain/Loss: "
        + strChangePercent
        + "%";
  }
}
