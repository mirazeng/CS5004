package view;

import model.shape.IShape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The type Canvas panel.
 */
public class CanvasPanel extends JPanel {
  private final List<IShape> shapes;

  /**
   * Instantiates a new Canvas panel.
   *
   * @param shapes the shapes
   */
  public CanvasPanel(List<IShape> shapes) {
    this.shapes = shapes;
    setBackground(Color.WHITE);
  }

  @Override
  public void paintComponent(Graphics newShape) {
    super.paintComponent(newShape);
    for (IShape shape : shapes) {
      Color color = new Color(shape.getColor().getRed()
              , shape.getColor().getGreen()
              , shape.getColor().getBlue());
      newShape.setColor(color);
      int x = shape.getPosition().getX();
      int y = shape.getPosition().getY();
      int width = shape.getDimensionX();
      int height = shape.getDimensionY();

      switch (shape.getType().toLowerCase()) {
        case "rectangle":
          newShape.fillRect(x, y, width, height);
          break;
        case "oval":
          newShape.fillOval(x, y, width, height);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Sets shapes.
   *
   * @param shapes the shapes
   */
  public void setShapes(List<IShape> shapes) {
    this.shapes.clear();
    this.shapes.addAll(shapes);
  }
}