package doubledispatch;

/**
 * The interface Space explorer.
 */
public interface ISpaceExplorer {
  /**
   * Visit.
   *
   * @param mercury the mercury
   */
  void visit(Mercury mercury);

  /**
   * Visit.
   *
   * @param mars the Mars
   */
  void visit(Mars mars);

  /**
   * Visit.
   *
   * @param venus the venus
   */
  void visit(Venus venus);

  /**
   * Visit.
   *
   * @param aPlanet the planet
   */
  default void visit(IPlanet aPlanet) {
    SimulationBuilder.addToLog("Visiting an unknown planet");
  }
}