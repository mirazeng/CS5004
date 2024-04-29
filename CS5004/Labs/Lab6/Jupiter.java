package doubledispatch;

/**
 * The type Jupiter.
 */
public class Jupiter implements IPlanet {
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}