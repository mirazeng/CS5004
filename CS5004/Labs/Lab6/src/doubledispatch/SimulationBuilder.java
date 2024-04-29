package doubledispatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The type Simulation builder.
 */
public class SimulationBuilder {
  private static final List<String> simulationLog = new ArrayList<>();

  /**
   * Add to log.
   *
   * @param message the message
   */
  public static void addToLog(String message) {
    simulationLog.add(message);
  }

  /**
   * Gets simulation log.
   *
   * @return the simulation log
   */
  public static List<String> getSimulationLog() {
    return simulationLog;
  }

  /**
   * Create planet.
   *
   * @param name the name
   * @return the planet
   */
  public static IPlanet createPlanet(String name) {
    if (name.equalsIgnoreCase("Mars")) {
      return new Mars();
    } else if (name.equalsIgnoreCase("Mercury")) {
      return new Mercury();
    } else if (name.equalsIgnoreCase("Venus")) {
      return new Venus();
    } else {
      return null;
    }
  }

  /**
   * Create explorer space explorer.
   *
   * @param name the name
   * @return the space explorer
   */
  public static ISpaceExplorer createExplorer(String name) {
    if (name.equalsIgnoreCase("TerrainExplorer")) {
      return new TerrainExplorer();
    } else if (name.equalsIgnoreCase("LifeExplorer")) {
      return new LifeExplorer();
    } else {
      return null;
    }
  }
}

//  /**
//   * The entry point of application.
//   *
//   * @param args the input arguments
//   */
//  public static void main(String[] args) {
//    String[] planets = {"Mars", "Mercury", "Venus", "Jupiter"};
//    List<IPlanet> planetsList = new ArrayList<>();
//
//    for (String planet : planets) {
//      IPlanet aPlanet = SimulationBuilder.createPlanet(planet);
//      if (aPlanet != null) {
//        planetsList.add(aPlanet);
//      }
//    }
//
//    planetsList.add(new Jupiter());
//    ISpaceExplorer terrainEx = SimulationBuilder.createExplorer("TerrainExplorer");
//    ISpaceExplorer lifeEx = SimulationBuilder.createExplorer("LifeExplorer");
//
//    for (IPlanet aPlanet : planetsList) {
//      aPlanet.accept(terrainEx);
//      aPlanet.accept(lifeEx);
//    }
//    System.out.println(SimulationBuilder.getSimulationLog());
//  }
//
//}