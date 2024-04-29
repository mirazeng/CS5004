package canvasDisplay;

import shape.IShape;
import snapshot.Snapshot;

import java.util.List;

/** The interface Canvas. */
public interface ICanvas {
  /** Reset canvas. */
  void resetCanvas();

  /**
   * Add shape.
   *
   * @param name the name
   * @param type the type
   * @param positionX the position x
   * @param positionY the position y
   * @param dimensionX the dimension x
   * @param dimensionY the dimension y
   * @param colorR the color r
   * @param colorG the color g
   * @param colorB the color b
   */
  void addShape(
      String name,
      String type,
      double positionX,
      double positionY,
      double dimensionX,
      double dimensionY,
      double colorR,
      double colorG,
      double colorB);

  /**
   * Remove shape.
   *
   * @param shapeName the shape name
   */
  void removeShape(String shapeName);

  /**
   * Move shape.
   *
   * @param shapeName the shape name
   * @param positionX the position x
   * @param positionY the position y
   */
  void moveShape(String shapeName, double positionX, double positionY);

  /**
   * Scale shape.
   *
   * @param shapeName the shape name
   * @param deltaX the delta x
   * @param deltaY the delta y
   */
  void scaleShape(String shapeName, double deltaX, double deltaY);

  /**
   * Change shape color.
   *
   * @param shapeName the shape name
   * @param colorR the color r
   * @param colorG the color g
   * @param colorB the color b
   */
  void changeShapeColor(String shapeName, double colorR, double colorG, double colorB);

  /**
   * Display shapes from snapshot.
   *
   * @param snapshot the snapshot
   */
  void displayShapesFromSnapshot(Snapshot snapshot);

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  List<IShape> getShapes();
}