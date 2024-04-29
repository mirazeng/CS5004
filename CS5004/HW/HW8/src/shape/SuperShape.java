package shape;

/** The type Super shape. */
public abstract class SuperShape implements IShape {
  /** The Name. */
  protected String name;

  /** The Type. */
  protected String type;

  /** The Position. */
  protected ShapePosition position;

  /** The Color. */
  protected Color color;

  /**
   * Instantiates a new Super shape.
   *
   * @param name the name
   * @param type the type
   * @param position the position
   * @param color the color
   */
  // user can choose what type of shape they want to create
  // from canvas
  // so that made String type to ShapeType type
  public SuperShape(String name, String type, ShapePosition position, Color color) {
    this.name = name;
    this.type = type;
    this.position = position;
    this.color = color;
  }

  /**
   * Instantiates a new Super shape.
   *
   * @param shape the shape
   */
  // copy constructor
  public SuperShape(SuperShape shape) {
    this.name = shape.name;
    this.type = shape.type;
    this.position = shape.position;
    this.color = shape.color;
  }

  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  @Override
  public String getType() {
    return this.type;
  }

  /**
   * Gets position.
   *
   * @return the position
   */
  @Override
  public ShapePosition getPosition() {
    return this.position;
  }

  @Override
  public void setPosition(ShapePosition position) {
    this.position = position;
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public void changeColor(Color color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "Name: " + this.name + "\nType: " + this.type;
  }
}