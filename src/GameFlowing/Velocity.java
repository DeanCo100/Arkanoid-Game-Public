//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 01-04-23
 */
package GameFlowing;

import GeometryShapes.Point;

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    //Fields:
    private double dx;
    private double dy;
    private double angle;
    private double speed;

    /**
     * Constructs a Velocity object with the specified change in position on the x and y axes.
     *
     * @param dx the change in position on the x axis
     * @param dy the change in position on the y axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.speed = Math.sqrt(dx * dx + dy * dy);
        this.angle = Math.toDegrees(Math.atan2(dy, dx));
    }

    /**
     * Gets the change in position on the x axis.
     *
     * @return the change in position on the x axis
     */
    public double getDx() {
        return dx;
    }

    /**
     * Gets the change in position on the y axis.
     *
     * @return the change in position on the y axis
     */
    public double getDy() {
        return dy;
    }

    /**
     * Creates a new Velocity object based on the given angle and speed.
     *
     * @param angle the angle in degrees
     * @param speed the speed in pixels per second
     * @return a new Velocity object based on the given angle and speed
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle);
        double dx = speed * Math.sin(radians);
        double dy = speed * Math.cos(radians);
        return new Velocity(dx, dy);
    }

    /**
     * Returns the angle of this object's movement, in degrees.
     *
     * @return the angle of this object's movement, in degrees.
     */
    public double getAngle() {
        return this.angle;
    }

    /**
     * Returns the speed of this object's movement, in pixels per second.
     *
     * @return the speed of this object's movement, in pixels per second.
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Applies the velocity to a point and returns the new point.
     *
     * @param p the point to which the velocity is applied
     * @return the new point after the velocity has been applied
     */
    public Point applyToPoint(Point p) {
        double x = p.getX() + this.dx;
        double y = p.getY() + this.dy;
        return new Point(x, y);

    }
}
