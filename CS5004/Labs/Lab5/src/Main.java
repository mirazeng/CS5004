import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import sports.IPlayer;
import sports.Roster;
import sports.basketball.BasketballPlayer;
import sports.basketball.BasketballStats;

/**
 * The type Main.
 */
public class Main {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    // now we can test individuals by variable name, plus let's add them all to our team
    List<IPlayer> dreamTeam = new ArrayList<>();
    IPlayer kobe = new BasketballPlayer("Kobe Bryant", 34, 6.6,
            new BasketballStats(35.4, 9, 10));
    dreamTeam.add(kobe);
    IPlayer shaq = new BasketballPlayer("Shaquille O'Neal", 47, 7.4,
            new BasketballStats(29.5, 18, 8));
    dreamTeam.add(shaq);
    IPlayer larry = new BasketballPlayer("Larry Bird", 62, 6.9,
            new BasketballStats(36, 10, 12));
    dreamTeam.add(larry);
    IPlayer julius = new BasketballPlayer("Julius Erving", 69, 6.7,
            new BasketballStats(33, 12, 12));
    dreamTeam.add(julius);
    IPlayer mike = new BasketballPlayer("Michael Jordan", 61, 6.8,
            new BasketballStats(38, 11, 13));
    dreamTeam.add(mike);

    List<IPlayer> otherTeam = new ArrayList<>();
    otherTeam.add(kobe);
    otherTeam.add(shaq);
    otherTeam.add(larry);
    otherTeam.add(julius);
    otherTeam.add(mike);

    for (IPlayer each : dreamTeam) {
      System.out.println(each);
    }

    Roster<BasketballPlayer, Double> roster = new Roster(dreamTeam);
    roster.sortByStats(); // sort by points
    System.out.println(roster.getPlayers());

    System.out.println(roster.getPlayers().equals(otherTeam));
    roster.addPlayer(new BasketballPlayer("Keith", 59, 5.6, new BasketballStats(1, 2, 3)));
    System.out.println(roster.getPlayers());

    BiFunction<BasketballPlayer, Double, Double> assists =
            ((player, total) -> player.getStats().getAssistsPerGame() + total);

    BiFunction<BasketballPlayer, Double, Double> points =
            ((player, total) -> player.getStats().getPointsPerGame() + total);


    System.out.println("Total Team Assists for the season: " + roster.fold(assists, 0.0));
    System.out.println("Total Team Points for the season: " + roster.fold(points, 0.0));

  }
}