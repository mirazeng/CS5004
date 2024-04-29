package shape;

/** The type Rectangle. */
public class Rectangle extends SuperShape {
  private double width;
  private double height;

  /**
   * Instantiates a new Rectangle.
   *
   * @param name the name
   * @param type the type
   * @param position the position
   * @param width the width
   * @param height the height
   * @param color the color
   */
  public Rectangle(
      String name, String type, ShapePosition position, double width, double height, Color color) {
    super(name, type, position, color);
    this.width = width;
    this.height = height;
  }

  /**
   * Instantiates a new Rectangle.
   *
   * @param rectangle the rectangle
   */
  public Rectangle(Rectangle rectangle) {
    super(rectangle);
    this.width = rectangle.width;
    this.height = rectangle.height;
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Sets width.
   *
   * @param width the width
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(double height) {
    this.height = height;
  }

  @Override
  public void resize(double factorX, double factorY) {
    this.width = this.width * factorX;
    this.height = this.height * factorY;
  }

  @Override
  public IShape cloneShape() {
    return new Rectangle(this);
  }

  @Override
  public String toString() {
    String rectangleString =
        super.toString()
            + "\n"
            + "Min corner: ("
            + this.position.getX()
            + ","
            + this.position.getY()
            + "), "
            + "Width: "
            + this.width
            + ", Height: "
            + this.height
            + ", "
            + "Color: ("
            + this.color.toString()
            + ")\n";
    return rectangleString;
  }
}