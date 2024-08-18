//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 01-04-23
 */
package Sprites;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;

import java.util.List;

/**
 * A class representing a line in a 2D coordinate system.
 */
public class Line {
    private static final double EPSILON = 0.0000001;
    private static final int SPLIT = 2;

    private Point start;
    private Point end;

    /**
     * Constructs a new Line object with the specified start and end points.
     *
     * @param start the starting point of the line
     * @param end   the ending point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructs a new Line object with the specified coordinates.
     *
     * @param x1 the x-coordinate of the starting point
     * @param y1 the y-coordinate of the starting point
     * @param x2 the x-coordinate of the ending point
     * @param y2 the y-coordinate of the ending point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Returns the length of the line.
     *
     * @return the length of the line
     */
    public double length() {
        if (Math.abs(this.start.getX() - this.end.getX()) <= EPSILON && Math.abs(this.start.getY() - this.end.getY())
                <= EPSILON) {
            return 0;
        }
        double dx = (this.start.getX() - this.end.getX()) * (this.start.getX() - this.end.getX());
        double dy = (this.start.getY() - this.end.getY()) * (this.start.getY() - this.end.getY());
        return Math.sqrt(dx + dy);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        Point mid = new Point((this.start.getX() + this.end.getX()) / SPLIT,
                (this.start.getY() + this.end.getY()) / SPLIT);
        return mid;
    }

    /**
     * Returns the starting point of the line.
     *
     * @return the starting point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the ending point of the line.
     *
     * @return the ending point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Determines whether two lines intersect.
     *
     * @param other the other line to check for intersection
     * @return true if the lines intersect, false otherwise
     */
    @SuppressWarnings("checkstyle:SimplifyBooleanReturn")
    public boolean isIntersecting(Line other) {
        // Initialize isVertical flags
        boolean isVertical1 = false;
        boolean isVertical2 = false;
        //Checking for max values of the lines.
        double minX1 = Math.min(this.start.getX(), this.end.getX());
        double maxX1 = Math.max(this.start.getX(), this.end.getX());
        double minY1 = Math.min(this.start.getY(), this.end.getY());
        double maxY1 = Math.max(this.start.getY(), this.end.getY());
        double minX2 = Math.min(other.start.getX(), other.end.getX());
        double maxX2 = Math.max(other.start.getX(), other.end.getX());
        double minY2 = Math.min(other.start.getY(), other.end.getY());
        double maxY2 = Math.max(other.start.getY(), other.end.getY());
        //If one (or both) of the lines is actually a point.
        if ((Math.abs(this.start.getX() - this.end.getX()) <= EPSILON && Math.abs(this.start.getY()
                - this.end.getY()) <= EPSILON) || (Math.abs(other.start.getX() - other.end.getX()) <= EPSILON
                && Math.abs(other.start.getY() - other.end.getY()) <= EPSILON)) {
            return !(maxX1 < minX2) && !(maxX2 < minX1) && !(maxY1 < minY2) && !(maxY2 < minY1);
        }
        //If they have a same point start or end
        if (this.start.equals(other.start) || this.end.equals(other.end) || this.start.equals(other.end)
                || this.end.equals(other.start)) {
            return true;
        }
        // Check if the "bounding boxes" intersect
        if (maxX1 < minX2 || maxX2 < minX1 || maxY1 < minY2 || maxY2 < minY1) {
            return false;
        }

        //Calculating the slopes and the "b"'s of each line.
        double mLine1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double mLine2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        double bLine1 = this.start.getY() - mLine1 * this.start.getX();
        double bLine2 = other.start.getY() - mLine2 * other.start.getX();
        // Check if either line is vertical
        if (Math.abs(this.start.getX() - this.end.getX()) <= EPSILON) {
            isVertical1 = true;
        }
        if (Math.abs(other.start.getX() - other.end.getX()) <= EPSILON) {
            isVertical2 = true;
        }
        // In case both of the lines are vertical
        if (isVertical1 && isVertical2) {
            // Check if their x-coordinates are the same and their y-ranges overlap
            return Math.abs(this.start.getX() - other.start.getX()) <= EPSILON
                    && !(maxY1 < minY2 || maxY2 < minY1);
        }
        //In case one of the lines are parallel to the Y axis.
        if (Math.abs(this.start.getX() - this.end.getX()) <= EPSILON) {
            double xIntersect = this.start.getX();
            double yIntersect = mLine2 * xIntersect + bLine2;
            return yIntersect >= Math.min(minY1, maxY1) && yIntersect <= Math.max(minY1, maxY1) && xIntersect
                    >= Math.min(minX2, maxX2) && xIntersect <= Math.max(minX2, maxX2);
        } else if (Math.abs(other.start.getX() - other.end.getX()) <= EPSILON) {
            double xIntersect = other.start.getX();
            double yIntersect = mLine1 * xIntersect + bLine1;
            return yIntersect >= Math.min(minY2, maxY2) && yIntersect <= Math.max(minY2, maxY2) && xIntersect
                    >= Math.min(minX1, maxX1) && xIntersect <= Math.max(minX1, maxX1);
        }
        //In case there are infinity intersections points.
        if ((Math.abs(mLine1 - mLine2) <= EPSILON) && (Math.abs(bLine1 - bLine2) > EPSILON)) {
            return false;
        }
        if ((Math.abs(mLine1 - mLine2) <= EPSILON) && (Math.abs(bLine1 - bLine2) <= EPSILON)) {
            return true;
        }
        // Calculate the slope and intercept of the two lines
// Calculate the x and y values of the intersection point
        double xIntersect = (bLine2 - bLine1) / (mLine1 - mLine2);
        double yIntersect = mLine1 * xIntersect + bLine1;

// Determine the range of x and y values for each bounding line
        double minX = Math.min(Math.min(this.start.getX(), this.end.getX()),
                Math.min(other.start.getX(), other.end.getX()));
        double maxX = Math.max(Math.max(this.start.getX(), this.end.getX()),
                Math.max(other.start.getX(), other.end.getX()));
        double minY = Math.min(Math.min(this.start.getY(), this.end.getY()),
                Math.min(other.start.getY(), other.end.getY()));
        double maxY = Math.max(Math.max(this.start.getY(), this.end.getY()),
                Math.max(other.start.getY(), other.end.getY()));

// Calculate the y values of the two bounding lines at the x value of the intersection point
        double yBound1 = mLine1 * xIntersect + bLine1;
        double yBound2 = mLine2 * xIntersect + bLine2;

// Check if the intersection point lies within the range of x and y values for both bounding lines
        if (xIntersect >= minX && xIntersect <= maxX && yIntersect >= minY && yIntersect <= maxY
                && yIntersect >= Math.min(yBound1, yBound2) && yIntersect <= Math.max(yBound1, yBound2)) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the intersection point of two lines.
     *
     * @param other the line to find the intersection point with.
     * @return the intersection point of the two lines, or null if they don't intersect.
     */
    public Point intersectionWith(Line other) {
        //In case they are not intersecting.
        if (!isIntersecting(other)) {
            return null;
        }
        //Gets the min and max values from the lines
        double minX1 = Math.min(this.start.getX(), this.end.getX());
        double maxX1 = Math.max(this.start.getX(), this.end.getX());
        double minY1 = Math.min(this.start.getY(), this.end.getY());
        double maxY1 = Math.max(this.start.getY(), this.end.getY());
        double minX2 = Math.min(other.start.getX(), other.end.getX());
        double maxX2 = Math.max(other.start.getX(), other.end.getX());
        double minY2 = Math.min(other.start.getY(), other.end.getY());
        double maxY2 = Math.max(other.start.getY(), other.end.getY());
        //Calculating the slopes and the "b"'s of each line.
        double mLine1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double mLine2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        double bLine1 = this.start.getY() - mLine1 * this.start.getX();
        double bLine2 = other.start.getY() - mLine2 * other.start.getX();
        // check for vertical lines that overlap only in one point
        boolean isVertical1 = Math.abs(minX1 - maxX1) <= EPSILON;
        boolean isVertical2 = Math.abs(minX2 - maxX2) <= EPSILON;
        boolean isHorizontal1 = Math.abs(minY1 - maxY1) <= EPSILON;
        boolean isHorizontal2 = Math.abs(minY2 - maxY2) <= EPSILON;
        if (isHorizontal1 && isVertical2) {
            return new Point(maxX2, maxY1);
        }
        if (isVertical1 && isHorizontal2) {
            return new Point(maxX1, maxY2);
        }
        //Checks if both are verticals
        if (isVertical1 && isVertical2) {
            if (Math.abs(this.start.getX() - other.start.getX()) <= EPSILON) {
                // check for overlap
                if (minY2 <= maxY1 && minY1 <= maxY2) {
                    double yOverlapStart = Math.max(minY1, minY2);
                    double yOverlapEnd = Math.min(maxY1, maxY2);
                    // single intersection point
                    if (Math.abs(yOverlapStart - yOverlapEnd) <= EPSILON) {
                        return new Point(this.start.getX(), yOverlapStart);
                    } else {
                        // lines overlap but not at a single point
                        return null;
                    }
                }
            }
            // parallel vertical lines do not intersect
            return null;
        }
        //Checks if one of the lines is vertical
        if (isVertical1) {
            double intersectionX = this.start.getX();
            double intersectionY = mLine2 * intersectionX + bLine2;

            if (intersectionX >= minX1 && intersectionX <= maxX1 && intersectionY >= minY1 && intersectionY <= maxY1) {
                return new Point(intersectionX, intersectionY);
            } else {
                return null;
            }
        } else if (isVertical2) {
            double intersectionX = other.start.getX();
            double intersectionY = mLine1 * intersectionX + bLine1;

            if (intersectionX >= minX2 && intersectionX <= maxX2 && intersectionY >= minY2 && intersectionY <= maxY2) {
                return new Point(intersectionX, intersectionY);
            } else {
                return null;
            }
        }
        //Checks if both horizontal.
        if (isHorizontal1 && isHorizontal2) {
            if (Math.abs(this.start.getY() - other.start.getY()) <= EPSILON) {
                // check for overlap
                if (minX2 <= maxX1 && minX1 <= maxX2) {
                    double xOverlapStart = Math.max(minX1, minX2);
                    double xOverlapEnd = Math.min(maxX1, maxX2);
                    // single intersection point
                    if (Math.abs(xOverlapStart - xOverlapEnd) <= EPSILON) {
                        return new Point(xOverlapStart, this.start.getY());
                    } else {
                        // lines overlap but not at a single point
                        return null;
                    }
                }
            }
            // parallel horizontal lines do not intersect
            return null;
        }
        //In case one is vertical and the other line is horizontal.

        if (isHorizontal1) {
            // line 1 is horizontal, line 2 is not
            double intersectionX = (this.start.getY() - bLine2) / mLine2;
//            double intersectionX = (other.start.getY() - this.start.getY()) / slope1 + this.start.getX();
            if (intersectionX >= minX1 && intersectionX <= maxX1 && intersectionX >= minX2 && intersectionX <= maxX2) {
                return new Point(intersectionX, this.start.getY());
            }
            // lines do not intersect
            return null;
        } else if (isHorizontal2) {
            // line 2 is horizontal, line 1 is not
            double intersectionX = (other.start.getY() - bLine1) / mLine1;
//            double intersectionX = (this.start.getY() - other.start.getY()) / slope2 + other.start.getX();
            if (intersectionX >= minX1 && intersectionX <= maxX1 && intersectionX >= minX2 && intersectionX <= maxX2) {
                return new Point(intersectionX, other.start.getY());
            }
            // lines do not intersect
            return null;
        }
        //In case both have the same slope
        if (Math.abs(mLine1 - mLine2) <= EPSILON && Math.abs(bLine1 - bLine2) <= EPSILON) {
            // check for overlap
            if (minY2 <= maxY1 && minY1 <= maxY2) {
                double yOverlapStart = Math.max(minY1, minY2);
                double yOverlapEnd = Math.min(maxY1, maxY2);
                double xOverlapStart = Math.max(minX1, minX2);
                double xOverlapEnd = Math.min(maxX1, maxX2);
                // check for single intersection point
                if (Math.abs(yOverlapStart - yOverlapEnd) <= EPSILON
                        && Math.abs(xOverlapStart - xOverlapEnd) <= EPSILON) {
                    return new Point(xOverlapStart, yOverlapStart);
                } else {
                    // lines overlap but not at a single point
                    return null;
                }
            }
        }
        //Finding the intersection X and Y values.
        double xIntersect = (bLine2 - bLine1) / (mLine1 - mLine2);
        double yIntersect = (mLine1 * xIntersect + bLine1);
        // intersection point is not within the range of the two line segments
        if (xIntersect < Math.max(minX1, minX2) - EPSILON || xIntersect > Math.min(maxX1, maxX2) + EPSILON) {
            return null;
        } else {
            return new Point(xIntersect, yIntersect);
        }
    }

    /**
     * Determines whether the current line is equal to the given line.
     * Two lines are considered equal if they have the same start and end points,
     * or if their start and end points are reversed.
     * If the lines don't have an intersection point, they are not considered equal.
     *
     * @param other The line to compare to.
     * @return True if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        //If they dont have intersection point they are for sure doesnt equals.
        if (!isIntersecting(other)) {
            return false;
        }
        //Checking if the lines are equals.
        if ((Math.abs(this.end.getX() - other.end.getX()) <= EPSILON && Math.abs(this.end.getY() - other.end.getY())
                <= EPSILON) && (Math.abs(this.start.getX()
                - other.start.getX()) <= EPSILON && Math.abs(this.start.getY() - other.start.getY()) <= EPSILON)) {
            return true;
        } else if ((Math.abs(this.end.getX() - other.start.getX()) <= EPSILON && Math.abs(this.end.getY()
                - other.start.getY()) <= EPSILON) && (Math.abs(this.start.getX()
                - other.end.getX()) <= EPSILON && Math.abs(this.start.getY() - other.end.getY()) <= EPSILON)) {
            return true;
        }
        return false;
    }
    /**
     * Returns the closest intersection point between a given rectangle and the line that starts at
     * the point of origin of this line and continues in its direction.
     * @param rect the rectangle to check for intersection with the line.
     * @return the closest intersection Point between the given rectangle and the line, or null if there is
     *  no intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersections = rect.intersectionPoints(this);
        if (intersections.isEmpty()) {
            return null;
        }
        int length = intersections.size();
        //Sorting the List by distance and then return the relevant Point.
        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - i - 1; ++j) {
                //Swap between intersections[j] and intersections[j+1]
                if (intersections.get(j).distance(this.start) > intersections.get(j + 1).distance(this.start)) {
                    Point temp = intersections.get(j);
                    intersections.set(j, intersections.get(j + 1));
                    intersections.set(j + 1, temp);
                }
            }
        }
        return intersections.get(0);
    }
    /**
     * Checking if a Point is on a Line and Returns true if the given point is on this line, and false otherwise.
     * @param point the point to check if it's on this line.
     * @return true if the given point is on this line, and false otherwise.
     */
    public boolean isPointOnLine(Point point) {
        return (Math.abs(this.start.distance(this.end) - (point.distance(this.start) + point.distance(this.end)))
                <= EPSILON);
    }
}

