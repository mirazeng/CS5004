package controller;

import model.photoAlbum.IAlbum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The type File parser.
 */
public class FileParser {

  private final File file;
  private final Scanner userInput;

  /**
   * Instantiates a new File parser.
   *
   * @param filename the filename
   * @throws FileNotFoundException the file not found exception
   */
  public FileParser(String filename) throws FileNotFoundException {
    if (filename == null || filename.isEmpty()) {
      throw new FileNotFoundException("Cannot access the file.");
    }
    this.file = new File(filename);
    this.userInput = new Scanner(file);
  }

  /**
   * a method to read the file and parse the add shape command.
   *
   * @param input command input
   * @param model the model
   */
  private static void parseAddShapeCommand(Scanner input, IAlbum model) {
    String shapeName = input.next();
    String type = input.next();

    int dimensionX = Integer.parseInt(input.next());
    int dimensionY = Integer.parseInt(input.next());
    int width = Integer.parseInt(input.next());

    int height = Integer.parseInt(input.next());

    int red = Integer.parseInt(input.next());
    int green = Integer.parseInt(input.next());
    int blue = Integer.parseInt(input.next());

    model.getCanvas().addShape(shapeName, type
            , dimensionX, dimensionY
            , width, height
            , red, green, blue);
  }

  /**
   * a method to read the file and parse the move shape command.
   *
   * @param input command input
   * @param model the model
   */
  private static void parseMoveShapeCommand(Scanner input, IAlbum model) {
    String shapeName = input.next();
    int x = input.nextInt();
    int y = input.nextInt();
    model.getCanvas().moveShape(shapeName, x, y);
  }

  /**
   * a method to read the file and parse the change shape color command.
   *
   * @param input command input
   * @param model the model
   */
  private static void parseChangeColorCommand(Scanner input, IAlbum model) {
    String shapeName = input.next();
    int red = input.nextInt();
    int green = input.nextInt();
    int blue = input.nextInt();
    model.getCanvas().changeShapeColor(shapeName, red, green, blue);
  }

  /**
   * a method to read the file and parse the resize shape command.
   *
   * @param input command input
   * @param model the model
   */
  private static void parseResizeShapeCommand(Scanner input, IAlbum model) {
    String shapeName = input.next();
    int width = input.nextInt();
    int height = input.nextInt();
    model.getCanvas().scaleShape(shapeName, width, height);
  }

  /**
   * a method to read the file and parse the remove shape command.
   *
   * @param input command input
   * @param model the model
   */
  private static void parseRemoveShapeCommand(Scanner input, IAlbum model) {
    String shapeName = input.next();
    model.getCanvas().removeShape(shapeName);
  }

  /**
   * a method to read the file and parse the take snapshot command.
   *
   * @param input command input
   * @param model the model
   */
  private static void parseTakeSnapshotCommand(Scanner input, IAlbum model) {
    String description = input.nextLine().trim();
    model.takeSnapshot(description);
  }

  /**
   * Parse file.
   *
   * @param model the model
   */
  public void parseFile(IAlbum model) {
    while (userInput.hasNext()) {
      String command = userInput.next();
      command = command.toLowerCase();
      switch (command) {
        // ignore the description line
        case "#":
          userInput.nextLine();
          break;
        case "shape":
          parseAddShapeCommand(userInput, model);
          break;
        case "move":
          parseMoveShapeCommand(userInput, model);
          break;
        case "color":
          parseChangeColorCommand(userInput, model);
          break;
        case "resize":
          parseResizeShapeCommand(userInput, model);
          break;
        case "remove":
          parseRemoveShapeCommand(userInput, model);
          break;
        case "snapshot":
          parseTakeSnapshotCommand(userInput, model);
          break;
        default:
      }
    }
  }
}