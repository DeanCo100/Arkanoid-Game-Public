//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 01-04-23
 */
package GeometryShapes;
/**
 * Represents the boundaries of a rectangle, including the starting point and how much it should stretch in
 * each direction.
 */
public class RectangleBoundaries {
    //Fields:
    private int startX;
    private int startY;
    private int stretchX;
    private int stretchY;

    /**
     * Constructor for RectangleBoundaries.
     *
     * @param startX   the x-coordinate of the starting point of the rectangle
     * @param startY   the y-coordinate of the starting point of the rectangle
     * @param stretchX the amount to stretch the rectangle in the x-direction
     * @param stretchY the amount to stretch the rectangle in the y-direction
     */
    public RectangleBoundaries(int startX, int startY, int stretchX, int stretchY) {
        this.startX = startX;
        this.startY = startY;
        this.stretchX = stretchX;
        this.stretchY = stretchY;
    }

    /**
     * Gets the x-coordinate of the starting point of the rectangle.
     *
     * @return the x-coordinate of the starting point
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Gets the y-coordinate of the starting point of the rectangle.
     *
     * @return the y-coordinate of the starting point
     */

    public int getStartY() {
        return startY;
    }

    /**
     * Gets the amount to stretch the rectangle in the x-direction.
     *
     * @return the amount to stretch in the x-direction
     */
    public int getStretchX() {
        return stretchX;
    }

    /**
     * Gets the amount to stretch the rectangle in the y-direction.
     *
     * @return the amount to stretch in the y-direction
     */

    public int getStretchY() {
        return stretchY;
    }
}

