package distance;

/**
 * This class calculate and represent the velocity
 * Should throw exception when elapsedTime
 * equals or is less than 0.
 */
public class Physics {
  /**
   * Velocity double.
   *
   * @param one         the start point
   * @param two         the end point
   * @param elapsedTime the elapsed time in seconds
   * @return the double
   * @throws IllegalArgumentException throws exception if elapsed time is 0 or negative.
   */
  public static double velocity(Point3D one, Point3D two, double elapsedTime)
          throws IllegalArgumentException {
    if (elapsedTime <= 0) {
      throw new IllegalArgumentException("the elapsedTime is <= 0");
    } else {
      double distance = one.distanceTo(two);
      return distance / elapsedTime;
    }
  }
  /**
   * The main driver of application.
   *
   * @param args the input arguments
   */

  public static void main(String[] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1,1,1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 0);
      System.out.println("Prof. Keith is on the move! His Velocity =" + velocity + "\n");
      velocity = Physics.velocity(one, two, 5);
      System.out.println("Velocity =" + velocity);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Encountered an error: " + e.getMessage());
    }
  }
}
