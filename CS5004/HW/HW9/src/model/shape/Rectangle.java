package model.shape;

/**
 * The type Rectangle.
 */
public class Rectangle extends SuperShape {
  private int width;
  private int height;

  /**
   * Instantiates a new Rectangle.
   *
   * @param name     the name
   * @param type     the type
   * @param position the position
   * @param width    the width
   * @param height   the height
   * @param color    the color
   */
  public Rectangle(
          String name, String type, ShapePosition position, int width, int height, ShapeColor color) {
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
  public int getWidth() {
    return this.width;
  }

  /**
   * Sets width.
   *
   * @param width the width
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public void resize(int changeX, int changeY) {
    this.width = changeX;
    this.height = changeY;
  }

  @Override
  public IShape cloneShape() {
    return new Rectangle(this);
  }

  @Override
  public int getDimensionX() {
    return this.width;
  }

  @Override
  public int getDimensionY() {
    return this.height;
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
                    + "ShapeColor: ("
                    + this.color.toString()
                    + ")\n";
    return rectangleString;
  }
}