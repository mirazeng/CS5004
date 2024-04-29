package model.canvasDisplay;

import model.shape.IShape;
import model.snapshot.Snapshot;

import java.util.List;

/**
 * The interface Canvas.
 */
public interface ICanvas {
  /**
   * Reset canvas.
   */
  void resetCanvas();

  /**
   * Add shape.
   *
   * @param name       the name
   * @param type       the type
   * @param positionX  the position x
   * @param positionY  the position y
   * @param dimensionX the dimension x
   * @param dimensionY the dimension y
   * @param colorR     the color r
   * @param colorG     the color g
   * @param colorB     the color b
   */
  void addShape(
          String name,
          String type,
          int positionX,
          int positionY,
          int dimensionX,
          int dimensionY,
          int colorR,
          int colorG,
          int colorB);

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
  void moveShape(String shapeName, int positionX, int positionY);

  /**
   * Scale shape.
   *
   * @param shapeName the shape name
   * @param deltaX    the delta x
   * @param deltaY    the delta y
   */
  void scaleShape(String shapeName, int deltaX, int deltaY);

  /**
   * Change shape color.
   *
   * @param shapeName the shape name
   * @param colorR    the color r
   * @param colorG    the color g
   * @param colorB    the color b
   */
  void changeShapeColor(String shapeName, int colorR, int colorG, int colorB);

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