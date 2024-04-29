package distance;

import java.util.Objects;

/**
 * Wenqing Zeng - Lab_2
 * This class represents a Point3D class
 * with following attributes:
 * x, y, z coordination.
 */
public class Point3D {
  private final int x;
  private final int y;
  private final int z;

  /**
   * Instantiates a default Point 3D.
   */
  public Point3D() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  /**
   * Instantiates a new Point 3D.
   *
   * @param x the x
   * @param y the y
   * @param z the z
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Instantiates another new Point 3D.
   *
   * @param other the other
   */
  public Point3D(Point3D other) {
    this.x = other.x;
    this.y = other.y;
    this.z = other.z;
  }

  /**
   * a method to get x.
   *
   * @return the x
   */
  public int getX() {
    return this.x;
  }

  /**
   * a method to get y.
   *
   * @return the y
   */
  public int getY() {
    return this.y;
  }

  /**
   * a method to get z.
   *
   * @return the z
   */
  public int getZ() {
    return this.z;
  }

  /**
   * a method to calculate distance
   * between two Point3D objects.
   *
   * @param other the other
   * @return the double
   */
  public double distanceTo(Point3D other) {
    int xDifference = this.x - other.x;
    int yDifference = this.y - other.y;
    int zDifference = this.z - other.z;

    double xSquare = Math.pow(xDifference, 2);
    double ySquare = Math.pow(yDifference, 2);
    double zSquare = Math.pow(zDifference, 2);

    return Math.sqrt(xSquare + ySquare + zSquare);
  }


  /**
   * a boolean equal method to ensure
   * two different Point3D object.
   *
   * @param otherO the other o
   * @return the boolean
   */
  @Override
  public boolean equals(Object otherO) {
    if (this == otherO) {
      return true;
    }
    if (otherO == null) {
      return false;
    }
    if (!(otherO instanceof Point3D)) {
      return false;
    }
    Point3D otherPoint = (Point3D) otherO;

    return (this.x == otherPoint.getX()
            && this.y == otherPoint.getY()
            && this.z == otherPoint.getZ());
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }

}