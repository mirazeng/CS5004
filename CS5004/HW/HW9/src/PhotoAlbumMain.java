import controller.AlbumController;
import controller.FileParser;
import controller.IAlbumController;
import model.photoAlbum.IAlbum;
import model.photoAlbum.ShapeAlbum;
import view.IPhotoAlbumView;
import view.PhotoAlbumView;
import view.WebView;

import java.io.IOException;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {

    String commandFileInput = null;
    String currentView = null;
    String outputFile = null;

    IAlbum shapeAlbumModel = new ShapeAlbum();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        commandFileInput = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-view")
              || args[i].equalsIgnoreCase("-v")) {
        currentView = args[i + 1];
      }
      if (args[i].equalsIgnoreCase("-out")
              || args[i].equalsIgnoreCase("-w")) {
        outputFile = args[i + 1];
      }
    }

    if (currentView.equalsIgnoreCase("graphical")) {
      IPhotoAlbumView photoAlbumView = new PhotoAlbumView();
      FileParser graphicalFileParser = new FileParser(commandFileInput);
      // initialize the controller
      IAlbumController albumController = new AlbumController(photoAlbumView, shapeAlbumModel);
      graphicalFileParser.parseFile(shapeAlbumModel);
      photoAlbumView.setVisible(true);
    } else {
      FileParser webFileParser = new FileParser(commandFileInput);
      webFileParser.parseFile(shapeAlbumModel);

      WebView newWebView = new WebView(outputFile);
      newWebView.generateWebView(shapeAlbumModel);
    }
  }
}