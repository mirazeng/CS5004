import java.io.InputStreamReader;

import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeModel;


/**
 * Run a Tic Tac Toe game interactively on the console.
 */
public class Main {
  /**
   * Run a Tic Tac Toe game interactively on the console.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    new TicTacToeConsoleController(new InputStreamReader(System.in),
        System.out).playGame(new TicTacToeModel());
  }
}