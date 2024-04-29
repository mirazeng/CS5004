package shape;

/** The type Oval. */
public class Oval extends SuperShape {
  private double radiusX;
  private double radiusY;

  /**
   * Instantiates a new Oval.
   *
   * @param name the name
   * @param type the type
   * @param position the position
   * @param radiusX the radius x
   * @param radiusY the radius y
   * @param color the color
   */
  public Oval(
      String name,
      String type,
      ShapePosition position,
      double radiusX,
      double radiusY,
      Color color) {
    super(name, type, position, color);
    this.radiusX = radiusX;
    this.radiusY = radiusY;
  }

  /**
   * Instantiates a new Oval.
   *
   * @param oval the oval
   */
  public Oval(Oval oval) {
    super(oval);
    this.radiusX = oval.radiusX;
    this.radiusY = oval.radiusY;
  }

  /**
   * Gets radius x.
   *
   * @return the radius x
   */
  // TODO: should this return this.radiusX or this.radiusY?
  public double getRadiusX() {
    return this.radiusX;
  }

  /**
   * Sets radius x.
   *
   * @param radiusX the radius x
   */
  public void setRadiusX(double radiusX) {
    this.radiusX = radiusX;
  }

  /**
   * Gets radius y.
   *
   * @return the radius y
   */
  public double getRadiusY() {
    return this.radiusY;
  }

  /**
   * Sets radius y.
   *
   * @param radiusY the radius y
   */
  public void setRadiusY(double radiusY) {
    this.radiusY = radiusY;
  }

  @Override
  public void resize(double factorX, double factorY) {
    this.radiusX = this.radiusX * factorX;
    this.radiusY = this.radiusY * factorY;
  }

  @Override
  public IShape cloneShape() {
    return new Oval(this);
  }

  // TODO: position is in super class
  @Override
  public String toString() {
    String ovalString =
        super.toString()
            + "\n"
            + "Center: ("
            + this.position.getX()
            + ","
            + this.position.getY()
            + "), "
            + "X radius: "
            + this.radiusX
            + ", Y radius: "
            + this.radiusY
            + ", "
            + "Color: ("
            + this.color.toString()
            + ")\n";
    return ovalString;
  }
}