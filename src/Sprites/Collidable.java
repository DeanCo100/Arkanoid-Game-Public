//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package Sprites;

import GameFlowing.Velocity;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;

/**
 * Interface for collidable objects.
 */
public interface Collidable {
    /**
     * Returns the collision shape of the object.
     *
     * @return Rectangle The collision shape of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notifies the object that we collided with it at `collisionPoint` with
     * a given velocity. The return is the new velocity expected after the hit
     *
     * @param collisionPoint  The point where the collision occurred.
     * @param currentVelocity The current velocity of the colliding object.
     * @param hitter          The ball that hits the Collidables.
     * @return Velocity The new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}