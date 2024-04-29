package model.shape;

/**
 * The type ShapeColor.
 */
public class ShapeColor {
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Instantiates a new ShapeColor.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public ShapeColor(int red, int green, int blue) throws IllegalArgumentException {
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
  public int getRed() {
    return this.red;
  }

  /**
   * Gets green.
   *
   * @return the green
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   */
  public int getBlue() {
    return this.blue;
  }

  @Override
  public String toString() {
    return this.red + "," + this.green + "," + this.blue;
  }

  private boolean isNotValidColor(int color) {
    return color < 0 || color > 255;
  }
}