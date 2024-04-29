package canvasDisplay;

import java.util.ArrayList;
import java.util.List;
import shape.*;
import snapshot.Snapshot;

/** The type Canvas. */
public class Canvas implements ICanvas {

  private final List<IShape> shapes;

  /** Instantiates a new Canvas. */
  public Canvas() {
    this.shapes = new ArrayList<>();
  }

  @Override
  public void resetCanvas() {
    this.shapes.clear();
  }

  @Override
  public void addShape(
      String name,
      String type,
      double positionX,
      double positionY,
      double dimensionX,
      double dimensionY,
      double colorR,
      double colorG,
      double colorB)
      throws IllegalArgumentException {

      if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("Shape name must not be empty or null");
      }

    if (!checkShapeName(name)) {
      ShapePosition position = new ShapePosition(positionX, positionY);
      Color color = new Color(colorR, colorG, colorB);
      SuperShape shape =
          ShapeFactory.createShape(name, type, position, dimensionX, dimensionY, color);
      this.shapes.add(shape);
    } else {
      throw new IllegalArgumentException("Shape name must be unique");
    }
  }

  @Override
  public void removeShape(String shapeName) throws IllegalArgumentException {

    if (!checkShapeName(shapeName)) {
      throw new IllegalArgumentException("Shape name does not exist");
    } else {
      for (IShape shape : this.shapes) {
        if (shape.getName().equals(shapeName)) {
          this.shapes.remove(shape);
          break;
        } else {
          continue;
        }
      }
    }
  }

  @Override
  public void moveShape(String shapeName, double positionX, double positionY)
      throws IllegalArgumentException {

    if (!checkShapeName(shapeName)) {
      throw new IllegalArgumentException("Shape name does not exist");
    } else {
      for (IShape shape : this.shapes) {
        if (shape.getName().equals(shapeName)) {
          shape.setPosition(new ShapePosition(positionX, positionY));
        }
      }
    }
  }

  @Override
  public void scaleShape(String shapeName, double deltaX, double deltaY) {
    if (!checkShapeName(shapeName)) {
      throw new IllegalArgumentException("Shape name does not exist");
    } else {
      for (IShape shape : this.shapes) {
        if (shape.getName().equals(shapeName)) {
          shape.resize(deltaX, deltaY);
        }
      }
    }
  }

  @Override
  public void changeShapeColor(String shapeName, double colorR, double colorG, double colorB)
      throws IllegalArgumentException {

    if (!checkShapeName(shapeName)) {
      throw new IllegalArgumentException("Shape name does not exist");
    } else {
      for (IShape shape : this.shapes) {
        if (shape.getName().equals(shapeName)) {
          shape.changeColor(new Color(colorR, colorG, colorB));
        }
      }
    }
  }

  @Override
  public void displayShapesFromSnapshot(Snapshot snapshot) {
    this.shapes.clear();
    List<IShape> shapesToDisplay = snapshot.getShapes();
    this.shapes.addAll(shapesToDisplay);
  }

  @Override
  public List<IShape> getShapes() {
    List<IShape> copyOfShapes = new ArrayList<>();
    for (IShape shape : this.shapes) {
      copyOfShapes.add(shape.cloneShape());
    }
    return copyOfShapes;
  }

  private boolean checkShapeName(String shapeName) {
    for (IShape shape : this.shapes) {
      if (shape.getName().equals(shapeName)) {
        return true;
      }
    }
    return false;
  }
}