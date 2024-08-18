//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 01-04-23
 */
package GeometryShapes;
/**
 * The Point class represents a point in a 2D coordinate system.
 * The coordinates are represented by their x and y values.
 */
public class Point {
    /**
     * A constant used to compare floating point values for equality.
     */
    private static final double EPSILON = 0.0000001;
//Fields:
    private double x;
    private double y;

    /**
     * Constructs a new point with the specified x and y coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the distance between this point and another point.
     *
     * @param other the other point
     * @return the distance between the two points
     */
    public double distance(Point other) {
        double dx = (this.x - other.x) * (this.x - other.x);
        double dy = (this.y - other.y) * (this.y - other.y);
        return Math.sqrt(dx + dy);
    }

    /**
     * Compares this point to the specified point for equality, using a tolerance value of EPSILON.
     *
     * @param other the point to compare to
     * @return true if the x and y coordinates of this point are within EPSILON distance of the x and y coordinates
     * of the other point, false otherwise.
     */
    public boolean equals(Point other) {
        return (Math.abs(this.x - other.x) <= EPSILON && Math.abs(this.y - other.y) <= EPSILON);
    }
    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate of this point
     */
    public double getY() {
        return this.y;
    }

}
