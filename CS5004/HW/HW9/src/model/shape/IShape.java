package model.shape;

/**
 * The interface Shape.
 */
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
   * @param changeX the factor x
   * @param changeY the factor y
   */
  void resize(int changeX, int changeY);

  /**
   * Change color.
   *
   * @param color the color
   */
  void changeColor(ShapeColor color);

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
  ShapeColor getColor();

  /**
   * Gets dimension x.
   *
   * @return the dimension x
   */
  int getDimensionX();

  /**
   * Gets dimension y.
   *
   * @return the dimension y
   */
  int getDimensionY();
}