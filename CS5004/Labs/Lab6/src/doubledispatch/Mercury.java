package doubledispatch;

/**
 * The type Mercury.
 */
public class Mercury implements IPlanet {
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}