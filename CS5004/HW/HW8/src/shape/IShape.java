package shape;

/** The interface Shape. */
public interface IShape {

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Resize.
   *
   * @param factorX the factor x
   * @param factorY the factor y
   */
  void resize(double factorX, double factorY);

  /**
   * Change color.
   *
   * @param color the color
   */
  void changeColor(Color color);

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();

  /**
   * Gets position.
   *
   * @return the position
   */
  ShapePosition getPosition();

  /**
   * Sets position.
   *
   * @param shapePosition the shape position
   */
  void setPosition(ShapePosition shapePosition);

  /**
   * Clone shape.
   *
   * @return the shape
   */
  IShape cloneShape();

  /**
   * Gets color.
   *
   * @return the color
   */
  Color getColor();
}