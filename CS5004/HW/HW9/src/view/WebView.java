package view;

import model.photoAlbum.IAlbum;
import model.shape.IShape;
import model.snapshot.ISnapshot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The type Web view.
 */
public class WebView implements IWebView {
  private final String outputFile;

  /**
   * Instantiates a new Web view.
   *
   * @param outputFile the output file
   */
  public WebView(String outputFile) {
    this.outputFile = outputFile;
  }

  /**
   * Generate web view.
   *
   * @param model the model
   */
  public void generateWebView(IAlbum model) {
    StringBuilder html = new StringBuilder();
    html.append("<!DOCTYPE html>\n");
    html.append("<html>\n");
    html.append("<head>\n");
    html.append("<title>Photo Album Web View</title>\n");
    html.append("</head>\n");
    html.append("<body>\n");

    List<ISnapshot> snapshotsCollection = model.getSnapshots();

    for (ISnapshot snapshot : snapshotsCollection) {
      html.append("<h1>Snapshot ID: " + snapshot.getSnapshotID() + "</h1>\n");
      html.append("<h2> " + snapshot.getDescription() + " </h2>\n");
      html.append("<svg width=\"1000\" height=\"1000\">\n");

      for (IShape shape : snapshot.getShapes()) {
        html.append(generateSVGElement(shape));
      }

      html.append("</svg>\n");
    }

    try (FileWriter writer = new FileWriter(outputFile)) {
      writer.write(html.toString());
      System.out.println("Web view generated successfully! Artifact location: " + outputFile);
    } catch (IOException e) {
      System.out.println("Error writing to output file: " + e.getMessage());
    }
  }

  private String generateSVGElement(IShape shape) {
    StringBuilder svg = new StringBuilder();
    String shapeType = shape.getType().toLowerCase();
    String colorString = String.format("rgb(%d,%d,%d)"
            , shape.getColor().getRed()
            , shape.getColor().getGreen()
            , shape.getColor().getBlue());

    switch (shapeType) {
      case "rectangle":
        svg.append(String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"%s\" />\n",
                shape.getPosition().getX(), shape.getPosition().getY(),
                shape.getDimensionX(), shape.getDimensionY(),
                colorString));
        break;
      case "oval":
        svg.append(String.format("<ellipse cx=\"%d\" cy=\"%d\" rx=\"%d\" ry=\"%d\" fill=\"%s\" />\n",
                // start from the center of the shape
                // formula: x + width / 2, y + height / 2
                shape.getPosition().getX() + shape.getDimensionX() / 2,
                shape.getPosition().getY() + shape.getDimensionY() / 2,
                shape.getDimensionX() / 2, shape.getDimensionY() / 2,
                colorString));
        break;
      default:
        System.out.println("Unknown shape type: " + shapeType);
    }
    return svg.toString();
  }
}