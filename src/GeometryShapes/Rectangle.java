//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package GeometryShapes;
import Sprites.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rectangle in 2D space, defined by a point (its upper-left corner) and its width and height.
 */
public class Rectangle {
    //Fields:
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Creates a new rectangle with the given location and dimensions.
     *
     * @param upperLeft the upper-left corner of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns a (possibly empty) List of intersection points with the specified line.
     *
     * @param line the line to check for intersection with the rectangle
     * @return a list of intersection points (possibly empty)
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersections = new ArrayList<>();

        // Check for intersection with top line
        Line top = new Line(upperLeft, new Point(upperLeft.getX() + width, upperLeft.getY()));
        Point intersection = line.intersectionWith(top);
        //If there is an Intersection between the Rectangle and the Line add the Point to the List.
        if (intersection != null) {
            intersections.add(intersection);
        }
        // Check for intersection with bottom line
        Line bottom = new Line(new Point(upperLeft.getX(), upperLeft.getY() + height),
                new Point(upperLeft.getX() + width, upperLeft.getY() + height));
        intersection = line.intersectionWith(bottom);
        //If there is an Intersection between the Rectangle and the Line add the Point to the List.
        if (intersection != null) {
            intersections.add(intersection);
        }

        // Check for intersection with left line
        Line left = new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + height));
        intersection = line.intersectionWith(left);
        //If there is an Intersection between the Rectangle and the Line add the Point to the List.
        if (intersection != null) {
            intersections.add(intersection);
        }

        // Check for intersection with right line
        Line right = new Line(new Point(upperLeft.getX() + width, upperLeft.getY()), new Point(upperLeft.getX()
                + width, upperLeft.getY() + height));
        intersection = line.intersectionWith(right);
        //If there is an Intersection between the Rectangle and the Line add the Point to the List.
        if (intersection != null) {
            intersections.add(intersection);
        }
        return intersections;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left corner of the rectangle.
     *
     * @return the upper-left corner of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Returns the lower-left corner of the rectangle.
     *
     * @return the lower-left corner of the rectangle
     */
    public Point getLowerLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * Returns the upper-right corner of the rectangle.
     *
     * @return the upper-right corner of the rectangle
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }
    /**
     * Returns the lower-right corner of the rectangle.
     *
     * @return the lower-right corner of the rectangle
     */
    public Point getLowerRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * Returns true if the given point is inside this rectangle.
     *
     * @param point the point to check
     * @return true if the point is inside the rectangle, false otherwise
     */
    public boolean isPointInRectangle(Point point) {
        return (point.getX() > this.getUpperLeft().getX() && point.getX() < this.getUpperRight().getX()
                && point.getY() > this.getUpperRight().getY() && point.getY() < this.getLowerRight().getY());
    }
}