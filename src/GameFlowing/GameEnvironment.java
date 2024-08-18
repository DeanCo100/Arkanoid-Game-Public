/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package GameFlowing;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import Sprites.Collidable;
import Sprites.CollisionInfo;
import Sprites.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a game environment with collidable objects.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Creates a new game environment by creating a new ArrayList.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }


    /**
     * Adds the collidable object to the environment.
     *
     * @param c The collidable object to add.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }
    /**
     * Removes the specified collidable object from the game environment's collidables list.
     *
     * @param c the collidable object to be removed
     */
    public void removeCollidable(Collidable c) {
        //To remove the Collidable
        this.collidables.remove(c);
    }
    /**
     * Returns a list of all collidable objects in the environment.
     *
     * @return A list of all collidable objects.
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * Returns information about the closest collision that is going to occur,
     * if an object moves from the start of the given line to its end and collides
     * with a collidable object in this environment. Returns null if there is no collision.
     *
     * @param trajectory The trajectory of the moving object, represented as a line.
     * @return The information about the closest collision, or null if there is no collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<CollisionInfo> collisionInfos = new ArrayList<CollisionInfo>();
        List<Collidable> collidablesCopy = new ArrayList<>(this.collidables);  // Create a copy of the Collidables
        for (Collidable c : collidablesCopy) { //Iterates over the copy
            Rectangle rect = c.getCollisionRectangle();
            Point intersection = trajectory.closestIntersectionToStartOfLine(rect);
            //If there is an intersection
            if (intersection != null) {
                collisionInfos.add(new CollisionInfo(intersection, c));
            }
        }
        if (collisionInfos.isEmpty()) {
            return null;
        }
        //Checking for the closest collision from the starting point.
        CollisionInfo closestCollision = collisionInfos.get(0);
        double closestDistance = closestCollision.collisionPoint().distance(trajectory.start());
        for (CollisionInfo collision : collisionInfos) {
            double distance = collision.collisionPoint().distance(trajectory.start());
            if (distance < closestDistance) {
                closestCollision = collision;
                closestDistance = distance;
            }
        }
        return closestCollision;
    }
}