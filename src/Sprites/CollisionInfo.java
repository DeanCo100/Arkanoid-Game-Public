//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package Sprites;

import GeometryShapes.Point;

/**
 * Represents information about a collision between two objects.
 */
public class CollisionInfo {
    //Fields and constants
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Creates a new CollisionInfo object.
     *
     * @param collisionPoint  the point at which the collision occurred.
     * @param collisionObject the collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * Returns the point at which the collision occurred.
     *
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Returns the collidable object involved in the collision.
     *
     * @return the collision object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}