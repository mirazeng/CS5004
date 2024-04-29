package model.shape;

/**
 * The type Oval.
 */
public class Oval extends SuperShape {
  private int radiusX;
  private int radiusY;

  /**
   * Instantiates a new Oval.
   *
   * @param name     the name
   * @param type     the type
   * @param position the position
   * @param radiusX  the radius x
   * @param radiusY  the radius y
   * @param color    the color
   */
  public Oval(
          String name,
          String type,
          ShapePosition position,
          int radiusX,
          int radiusY,
          ShapeColor color) {
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
  public int getRadiusX() {
    return this.radiusX;
  }

  /**
   * Sets radius x.
   *
   * @param radiusX the radius x
   */
  public void setRadiusX(int radiusX) {
    this.radiusX = radiusX;
  }

  /**
   * Gets radius y.
   *
   * @return the radius y
   */
  public int getRadiusY() {
    return this.radiusY;
  }

  /**
   * Sets radius y.
   *
   * @param radiusY the radius y
   */
  public void setRadiusY(int radiusY) {
    this.radiusY = radiusY;
  }


  @Override
  public void resize(int changeX, int changeY) {
    this.radiusX = changeX;
    this.radiusY = changeY;
  }

  @Override
  public IShape cloneShape() {
    return new Oval(this);
  }

  @Override
  public int getDimensionX() {
    return this.radiusX;
  }

  @Override
  public int getDimensionY() {
    return this.radiusY;
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
                    + "ShapeColor: ("
                    + this.color.toString()
                    + ")\n";
    return ovalString;
  }
}