package sports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballPlayerComparator;

/**
 * The type Roster.
 *
 * @param <T> the type parameter
 * @param <R> the type parameter
 */
public class Roster<T, R> {
  private List<T> players;

  /**
   * Instantiates a new Roster.
   */
  public Roster() {
    this.players = new ArrayList<>();
  }

  /**
   * Instantiates a new Roster.
   *
   * @param players the players
   */
  public Roster(List<T> players) {
    this.players = players;
  }

  /**
   * Gets players.
   *
   * @return the players
   */
  public List<T> getPlayers() {
    // return the collection of players
    return Collections.unmodifiableList(this.players);
  }

  /**
   * Add player.
   *
   * @param player the player
   */
  public void addPlayer(T player) {
    // add the new player to our list of players
    this.players.add(player);
  }

  /**
   * Sort by stats.
   */
  public void sortByStats() {
    this.players.sort((Comparator<? super T>) new BasketballPlayerComparator());
  }

  /**
   * Fold r.
   *
   * @param <R>       the type parameter
   * @param combiner  the combiner
   * @param seedValue the seed value
   * @return the r
   */
  public <R> R fold(BiFunction<T, R, R> combiner, R seedValue) {
    R result = seedValue;
    for (T eachPlayer : this.players) {
      result = combiner.apply(eachPlayer, result);
    }
    return result;

  }

}