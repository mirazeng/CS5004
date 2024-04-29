import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import sports.Roster;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;

/**
 * The type Test roster.
 */
public class TestRoster {


  /**
   * Test roster empty constructor.
   */
  @Test
  public void testRosterEmptyConstructor() {
    Roster<BasketballPlayer, Double> testRoster = new Roster<BasketballPlayer, Double>();
    assertEquals(new ArrayList<BasketballPlayer>(), testRoster.getPlayers());
  }

  /**
   * Test roster from list constructor.
   */
  @Test
  public void testRosterFromListConstructor() {
    List<BasketballPlayer> testList = new ArrayList<>();
    testList.add(new BasketballPlayer("Kobe Bryant", 24, 200.0, null));
    testList.add(new BasketballPlayer("Lebron James", 36, 206.0, null));
    testList.add(new BasketballPlayer("Michael Jordan", 40, 198.0, null));
    Roster<BasketballPlayer, Double> testRoster = new Roster<BasketballPlayer, Double>(testList);
    assertEquals(testList, testRoster.getPlayers());
  }

  /**
   * Test roster get players.
   */
  @Test
  public void testRosterGetPlayers() {
    List<BasketballPlayer> testList = new ArrayList<>();
    BasketballPlayer kobe = new BasketballPlayer("Kobe Bryant", 24, 200.0, null);
    testList.add(kobe);
    Roster<BasketballPlayer, Double> testRoster = new Roster<BasketballPlayer, Double>(testList);
    assertEquals(kobe, testRoster.getPlayers().getFirst());
  }

  /**
   * Test roster add players.
   */
  @Test
  public void testRosterAddPlayers() {
    Roster<BasketballPlayer, Double> testRoster =
            new Roster<BasketballPlayer, Double>(new ArrayList<BasketballPlayer>());

    testRoster.addPlayer(new BasketballPlayer("Kobe Bryant", 24, 200.0, null));

    assertEquals(1, testRoster.getPlayers().size());
    assertEquals(new BasketballPlayer("Kobe Bryant", 24, 200.0, null),
            testRoster.getPlayers().getFirst());


  }

  /**
   * Test roster sorting.
   */
  @Test
  public void testRosterSorting() {

    BasketballPlayer kobe = new BasketballPlayer("Kobe Bryant", 34, 6.6,
            new BasketballStats(35.4, 9, 10));
    BasketballPlayer shaq = new BasketballPlayer("Shaquille O'Neal", 47, 7.4,
            new BasketballStats(29.5, 18, 8));
    BasketballPlayer larry = new BasketballPlayer("Larry Bird", 62, 6.9,
            new BasketballStats(36, 10, 12));
    BasketballPlayer julius = new BasketballPlayer("Julius Erving", 69, 6.7,
            new BasketballStats(33, 12, 12));
    BasketballPlayer mike = new BasketballPlayer("Michael Jordan", 61, 6.8,
            new BasketballStats(38, 11, 13));

    List<BasketballPlayer> dreamTeam = new ArrayList<>();
    dreamTeam.add(kobe);
    dreamTeam.add(shaq);
    dreamTeam.add(larry);
    dreamTeam.add(julius);
    dreamTeam.add(mike);

    Roster<BasketballPlayer, Double> roster = new Roster(dreamTeam);

    roster.sortByStats();

    List<String> sortedNames = new ArrayList<>();
    sortedNames.add("Shaquille O'Neal");
    sortedNames.add("Julius Erving");
    sortedNames.add("Kobe Bryant");
    sortedNames.add("Larry Bird");
    sortedNames.add("Michael Jordan");

    // After using the BasketballComparator, the roster should be sorted by points per game
    // Testing if the players are in correct order by examining their names
    for (int i = 0; i < dreamTeam.size(); i++) {
      assertEquals(sortedNames.get(i), roster.getPlayers().get(i).getName());
    }

  }

  /**
   * Test roster fold.
   */
  @Test
  public void testRosterFold() {
    List<BasketballPlayer> dreamTeam = new ArrayList<>();

    BasketballPlayer kobe = new BasketballPlayer("Kobe Bryant", 34, 6.6,
            new BasketballStats(35.4, 9, 10));
    dreamTeam.add(kobe);
    BasketballPlayer shaq = new BasketballPlayer("Shaquille O'Neal", 47, 7.4,
            new BasketballStats(29.5, 18, 8));
    dreamTeam.add(shaq);
    BasketballPlayer larry = new BasketballPlayer("Larry Bird", 62, 6.9,
            new BasketballStats(36, 10, 12));
    dreamTeam.add(larry);
    BasketballPlayer julius = new BasketballPlayer("Julius Erving", 69, 6.7,
            new BasketballStats(33, 12, 12));
    dreamTeam.add(julius);
    BasketballPlayer mike = new BasketballPlayer("Michael Jordan", 61, 6.8,
            new BasketballStats(38, 11, 13));
    dreamTeam.add(mike);

    Roster<BasketballPlayer, Double> roster = new Roster(dreamTeam);

    // Total of points per game for all the players in the roster equals to 171.9
    assertEquals(171.9, roster.fold(this::statsCombiner, 0.0));
  }


  /**
   * Stats combiner double.
   *
   * @param player the player
   * @param result the result
   * @return the double
   */
  // One implementation of the bifunction for testing purposes,
  // just sums up all players' points per game stat
  public double statsCombiner(BasketballPlayer player, double result) {
    result += player.getStats().getPointsPerGame();
    return result;
  }


}