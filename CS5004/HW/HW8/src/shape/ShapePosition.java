package shape;

/** The type Shape position. */
public class ShapePosition {

  private double xCoordinate;
  private double yCoordinate;

  /**
   * Instantiates a new Shape position.
   *
   * @param x the x
   * @param y the y
   */
  public ShapePosition(double x, double y) {
    this.xCoordinate = x;
    this.yCoordinate = y;
  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public double getX() {
    return this.xCoordinate;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(int x) {
    this.xCoordinate = x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public double getY() {
    return this.yCoordinate;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(int y) {
    this.yCoordinate = y;
  }

  public String toString() {
    return "(" + this.xCoordinate + ", " + this.yCoordinate + ")";
  }
}