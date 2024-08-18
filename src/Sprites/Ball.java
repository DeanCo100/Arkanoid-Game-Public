//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 01-04-23
 */
package Sprites;

import GameFlowing.GameLevel;
import GameFlowing.GameEnvironment;
import GameFlowing.Velocity;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import GeometryShapes.RectangleBoundaries;
import biuoop.DrawSurface;

import java.util.List;

import java.awt.Color;

/**
 * The Ball class represents a ball object.
 * A ball has a center point, a radius, a color, and a velocity.
 * It can be drawn on a DrawSurface object and moved according to its velocity.
 */
public class Ball implements Sprite {
    //Fields and constants.
    private static final double EPSILON = 0.0000001;
    private static final int UPPER_EDGE = 0;
    private static final int NO_SPEED = 0;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Point center;
    private int r;
    private Color color;
    private Velocity velocity;
    private RectangleBoundaries boundaries;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor for a Ball object.
     *
     * @param center          The center point of the ball
     * @param r               The radius of the ball
     * @param color           The color of the ball
     * @param gameEnvironment The GameEnvironment of the ball.
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        this.velocity = new Velocity(NO_SPEED, NO_SPEED); // Sets velocity to default of 0,0 like told us in the forum.
        this.boundaries = new RectangleBoundaries(UPPER_EDGE, UPPER_EDGE, WIDTH, HEIGHT);
    }

    /**
     * Constructor for a Ball object.
     *
     * @param x               The x-coordinate of the center point of the ball
     * @param y               The y-coordinate of the center point of the ball
     * @param r               The radius of the ball
     * @param color           The color of the ball
     * @param gameEnvironment The GameEnvironment of the ball.
     */
    public Ball(double x, double y, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        this.velocity = new Velocity(NO_SPEED, NO_SPEED); // Sets velocity to default of 0,0 like told us in the forum.
        this.boundaries = new RectangleBoundaries(UPPER_EDGE, UPPER_EDGE, WIDTH, HEIGHT);
    }

    /**
     * Returns the x-coordinate of the center point of the ball.
     *
     * @return The x-coordinate of the center point of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Returns the y-coordinate of the center point of the ball.
     *
     * @return The y-coordinate of the center point of the ball
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Returns the radius of the ball.
     *
     * @return The radius of the ball
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Returns the center point of the ball.
     *
     * @return The center point of the ball
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * Sets the center point of the ball.
     *
     * @param center The new center point of the ball
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Returns the color of the ball.
     *
     * @return The color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draws the ball on the given DrawSurface object.
     *
     * @param surface The DrawSurface object to draw the ball on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Adds the ball to the given game.
     *
     * @param gameLevel the game to add this sprite to.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * The removeFromGame method is responsible for removing the sprite from the game.
     *
     * @param g the game to be removed from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * Returns the boundaries of the ball's movement area.
     *
     * @return the RectangleBoundaries object that defines the boundaries of the ball's movement area.
     */
    public RectangleBoundaries getBoundaries() {
        return this.boundaries;
    }

    /**
     * Sets the boundaries of the ball's movement.
     *
     * @param boundaries the new boundaries to set.
     */
    public void setBoundaries(RectangleBoundaries boundaries) {
        this.boundaries = boundaries;
    }

    /**
     * Sets the ball's velocity to a given Velocity object.
     *
     * @param v the new velocity to set.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets the ball's velocity to a given dx and dy values.
     *
     * @param dx the new velocity's x value.
     * @param dy the new velocity's y value.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets the ball's velocity.
     *
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Returns the game environment associated with this ball.
     *
     * @return the game environment associated with this ball
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Sets the game environment of this object to the given game environment.
     *
     * @param gameEnvironment the game environment to set for this object.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Moves the ball one step according to its velocity.
     * If the ball collides with a collidable object, its velocity is updated accordingly.
     * If the ball collides with a boundary, its velocity is changed to bounce off the boundary.
     */
    public void moveOneStep() {
        //If the ball's velocity is null return without moving the ball.
        if (this.velocity == null) {
            return;
        }
        //The origin way to calculate the Trajectory
        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
        // Calculate the end point of the original trajectory line
        Point endPoint = this.velocity.applyToPoint(this.center);
        // Calculate the new end point by extending the original vector by 1.5
        Point newEndPoint = new Point(endPoint.getX() + (this.velocity.getDx() * 2.5),
                endPoint.getY() + (this.velocity.getDy() * 2.5));
        // Create a new line with the original start point and the new end point
        Line newTrajectory = new Line(this.center, newEndPoint);
        CollisionInfo collisionInfo = null;
        Point closestIntersection = null;
        for (Collidable collidable : gameEnvironment.getCollidables()) {
            Rectangle block = collidable.getCollisionRectangle();
            List<Point> intersections = block.intersectionPoints(newTrajectory);
            if (!intersections.isEmpty()) {
                // find closest intersection point to the ball's center
                Point intersection = gameEnvironment.getClosestCollision(newTrajectory).collisionPoint();
                if (closestIntersection == null
                        || newTrajectory.start().distance(closestIntersection)
                        > newTrajectory.start().distance(intersection)) {
                    closestIntersection = intersection;
                    collisionInfo = new CollisionInfo(closestIntersection, collidable);
                }
            }
        }
        if (collisionInfo != null) {
            Point collisionPoint = collisionInfo.collisionPoint();
            Collidable collidable = collisionInfo.collisionObject();
            // Handle the collision.
            Velocity newVelocity = collidable.hit(this, collisionPoint, this.velocity);
            // Move the ball to almost the collision point. Therefore I am using my threshold.
            this.center = new Point(collisionPoint.getX() - EPSILON, collisionPoint.getY() - EPSILON);
            this.velocity = newVelocity; // Update the velocity.
            this.center = trajectory.end();
        } else {
            double dx = this.getVelocity().getDx();
            double dy = this.getVelocity().getDy();
            //    nextCenter is holding the place that the ball will be in the next move.
            Point nextCenter = this.getVelocity().applyToPoint(this.center);
            //Checks for hitting the right or left boundaries
            if ((nextCenter.getX() + this.getSize()) >= (this.boundaries.getStartX() + this.boundaries.getStretchX())
                    || (nextCenter.getX() - this.getSize()) <= this.boundaries.getStartX()) {
                dx = -dx;
            }
            //Checks for hitting the upper or lower boundaries.
            if ((nextCenter.getY() + this.getSize()) >= (this.boundaries.getStartY() + this.boundaries.getStretchY())
                    || (nextCenter.getY() - this.getSize()) <= this.boundaries.getStartY()) {
                dy = -dy;
            }
            setVelocity(dx, dy);
            this.center = trajectory.end();
        }
    }
}