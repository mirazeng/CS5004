package shape;

/** The type Color. */
public class Color {
  private final double red;
  private final double green;
  private final double blue;

  /**
   * Instantiates a new Color.
   *
   * @param red the red
   * @param green the green
   * @param blue the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Color(double red, double green, double blue) throws IllegalArgumentException {
    if (isNotValidColor(red) || isNotValidColor(green) || isNotValidColor(blue)) {
      throw new IllegalArgumentException("Invalid color value");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Gets red.
   *
   * @return the red
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Gets green.
   *
   * @return the green
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   */
  public double getBlue() {
    return this.blue;
  }

  @Override
  public String toString() {
    return this.red + "," + this.green + "," + this.blue;
  }

  private boolean isNotValidColor(double color) {
    return color < 0.0 || color > 255.0;
  }
}