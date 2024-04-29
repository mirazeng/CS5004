package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The type Tic tac toe model.
 */
public class TicTacToeModel implements TicTacToe {

  /**
   * The Board.
   */
  public Player[][] board = new Player[3][3];
  /**
   * The Count.
   */
  public int count = 0;

  /**
   * Instantiates a new Tic tac toe model.
   */
  public TicTacToeModel() {
    for (int i = 0; i < 2; i++) {
      for (int n = 0; n < 2; n++) {
        board[i][n] = null;
      }
    }
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
                    row -> " " + Arrays.stream(row).map(
                            p -> p == null ? " " : p.toString())
                            .collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.
    /*
     List<String> rows = new ArrayList<>();
     for(Player[] row : getBoard()) {
     List<String> rowStrings = new ArrayList<>();
     for(Player p : row) {
     if(p == null) {
     rowStrings.add(" ");
     } else {
     rowStrings.add(p.toString());
     }
     }
     rows.add(" " + String.join(" | ", rowStrings));
     }
     return String.join("\n-----------\n", rows);
     */
  }

  @Override
  public void move(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Moves should be between 0 to 2");
    }
    if (isGameOver()) {
      throw new IllegalStateException("Game is over");
    }
    if (checkNull(r, c)) {
      board[r][c] = this.getTurn();
    } else {
      throw new IllegalArgumentException("Space is not available");
    }
    count++;
  }

  @Override
  public Player getTurn() {
    if (count % 2.0 == 0) {
      return Player.X;
    } else {
      return Player.O;
    }
  }

  @Override
  public boolean isGameOver() {
    if (getWinner() != null) {
      return true;
    }
    return count == 9;
  }

  @Override
  public Player getWinner() {
    int n = 0;
    int count = 0;

    while (count < 2) {
      if (board[count][n] == board[count][n + 1] && board[count][n] == board[count][n + 2]) {
        return board[count][n];
      }
      if (board[n][count] == board[n + 1][count] && board[n][count] == board[n + 2][count]) {
        return board[n][count];
      }
      count++;
    }
    if (board[n][n] == board[n + 1][n + 1] && board[n][n] == board[n + 2][n + 2]) {
      return board[n][n];

    }
    if (board[n][n + 2] == board[n + 1][n + 1] && board[n][n + 2] == board[n + 2][n]) {
      return board[n][n + 2];
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] copy = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int n = 0; n < 3; n++) {
        copy[i][n] = this.board[i][n];
      }
    }
    return copy;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Moves should be between 0 to 2");
    }
    return board[r][c];
  }

  private boolean checkNull(int r, int c) {
    return board[r][c] == null;
  }
}