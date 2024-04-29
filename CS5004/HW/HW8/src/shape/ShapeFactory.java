package shape;

/** The type Shape factory. */
public class ShapeFactory {
  /**
   * Create shape super shape.
   *
   * @param name the name
   * @param type the type
   * @param position the position
   * @param dimensionX the dimension x
   * @param dimensionY the dimension y
   * @param color the color
   * @return the super shape
   */
  public static SuperShape createShape(
      String name,
      String type,
      ShapePosition position,
      double dimensionX,
      double dimensionY,
      Color color) {

    type = type.toLowerCase();

    switch (type) {
      case "rectangle":
        return new Rectangle(name, type, position, dimensionX, dimensionY, color);
      case "oval":
        return new Oval(name, type, position, dimensionX, dimensionY, color);
      default:
        throw new IllegalArgumentException("Invalid shape type: " + type);
    }
  }
}