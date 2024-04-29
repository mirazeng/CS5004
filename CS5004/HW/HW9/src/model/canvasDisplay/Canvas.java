package model.canvasDisplay;

import model.shape.*;
import model.snapshot.Snapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Canvas.
 */
public class Canvas implements ICanvas {

  private final List<IShape> shapes;

  /**
   * Instantiates a new Canvas.
   */
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
          int positionX,
          int positionY,
          int dimensionX,
          int dimensionY,
          int colorR,
          int colorG,
          int colorB)
          throws IllegalArgumentException {

    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Shape name must not be empty or null");
    }

    if (!checkShapeName(name)) {
      ShapePosition position = new ShapePosition(positionX, positionY);
      ShapeColor color = new ShapeColor(colorR, colorG, colorB);
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
  public void moveShape(String shapeName, int positionX, int positionY)
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
  public void scaleShape(String shapeName, int deltaX, int deltaY) {
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
  public void changeShapeColor(String shapeName, int colorR, int colorG, int colorB)
          throws IllegalArgumentException {

    if (!checkShapeName(shapeName)) {
      throw new IllegalArgumentException("Shape name does not exist");
    } else {
      for (IShape shape : this.shapes) {
        if (shape.getName().equals(shapeName)) {
          shape.changeColor(new ShapeColor(colorR, colorG, colorB));
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