package tictactoe;

/**
 * The enum Player.
 */
public enum Player {
  /**
   * O player.
   */
  O(),

  /**
   * X player.
   */
  X();

  /**
   * To string string.
   *
   * @param type the type
   * @return the string
   */
  public String toString(Player type) {
    if (type == O) {
      return "O";
    } else {
      return "X";
    }
  }
}