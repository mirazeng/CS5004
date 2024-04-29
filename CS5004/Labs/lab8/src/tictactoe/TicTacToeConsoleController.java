package tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * The type Tic tac toe console controller.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Readable in;

  /**
   * Instantiates a new Tic tac toe console controller.
   *
   * @param in  the in
   * @param out the out
   * @throws IllegalArgumentException the illegal argument exception
   */
  public TicTacToeConsoleController(Readable in, Appendable out) throws IllegalArgumentException {
    if ((in == null) || (out == null)) {
      throw new IllegalArgumentException("In or Out can not be empty");
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void playGame(TicTacToe m) throws IllegalStateException, IllegalArgumentException {
    if (m == null) {
      throw new IllegalArgumentException("Model can not be null");
    }
    Scanner scan = new Scanner(this.in);
    String rowInput = "";
    String columnInout = "";

    try {
      out.append(m.toString()).append("\n");
      out.append("Enter a move for " + m.getTurn().toString() + ":").append("\n");

      while (scan.hasNext()) {
        rowInput = scan.next();
        if (rowInput.equalsIgnoreCase("q")) {
          out.append("Game quit! Ending game state:\n" + m + "\n");
          break;
        }
        columnInout = scan.next();
        if (columnInout.equalsIgnoreCase("q")) {
          out.append("\"Game quit! Ending game state:\n" + m + "\n");
          break;
        }
        try {
          m.move((Integer.valueOf(rowInput) - 1), (Integer.valueOf(columnInout) - 1));
        } catch (IllegalArgumentException e) {
          out.append("Please input a valid move.\n");
          continue;
        }
        if (m.isGameOver()) {
          out.append(m + "\n");
          out.append("Game is over! ");
          if (m.getWinner() == null) {
            out.append("Tie game.");
          } else {
            out.append(m.getWinner().toString() + "wins. ");
          }
          break;
        } else {
          out.append(m + "\n");
          out.append("Enter a move for " + m.getTurn().toString() + ":\n");
        }
      }
      if (!m.isGameOver() && (!rowInput.equalsIgnoreCase("q"))
              && (!columnInout.equalsIgnoreCase("q"))) {
        out.append("No more inout. \n");
      }
    } catch (IOException e) {
      throw new IllegalStateException("Illegal State!");
    }
  }
}