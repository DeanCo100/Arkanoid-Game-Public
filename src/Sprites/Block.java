//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package Sprites;

import GameFlowing.GameLevel;
import Listeners.HitListener;
import Listeners.HitNotifier;
import GameFlowing.Velocity;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a block that can be collided with and drawn on the screen.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;

    //Fields and constants
    private static final double EPSILON = 0.0000001;
    private Color color;

    private Rectangle rectangle;
    private int hittingPoints;

//    /**
//     * Constructor.
//     *
//     * @param rect          the rectangle shape of the block.
//     * @param hittingPoints the hitting points of the block.
//     * @param color         the color of the block.
//     */
//    //New constructor based on changes in the ass6:
//    public Block(Rectangle rect, int hittingPoints, Color color) {
//        this.rectangle = rect;
//        this.color = color;
//        this.hittingPoints = hittingPoints;
//        this.hitListeners = new ArrayList<HitListener>();
//    }

    /**
     * Constructor.
     *
     * @param rectangle the rectangle shape of the block.
     * @param color     the color of the block.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Return the "collision shape" of the block.
     *
     * @return the rectangle shape of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * Notifies the object that it was hit at the specified collision point with a given velocity.
     *
     * @param collisionPoint  The point of collision.
     * @param currentVelocity The current velocity of the object.
     * @return The new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double x = collisionPoint.getX();
        double y = collisionPoint.getY();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        //Checks for collision in the right or left edges of the Block.
        if (Math.abs(x - this.rectangle.getUpperLeft().getX()) <= EPSILON) {
            dx = -dx;
        } else if (Math.abs(x - this.rectangle.getUpperLeft().getX() - this.rectangle.getWidth()) <= EPSILON) {
            dx = -dx;
        }
        //Checks for collision in the top or bottom edges of the Block.
        if (Math.abs(y - this.rectangle.getUpperLeft().getY()) <= EPSILON) {
            dy = -dy;
        }
        if (Math.abs(y - rectangle.getUpperLeft().getY() - rectangle.getHeight()) <= EPSILON) {
            dy = -dy;
        }
//        // Notify all HitListener objects
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * Draws the block on the given surface.
     *
     * @param surface The surface to draw on.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());

    }

    /**
     * Do nothing for now.
     */
    @Override
    public void timePassed() {
        return;
    }

    /**
     * Adds the block to the given game as a collidable and a sprite.
     *
     * @param gameLevel The game to add the block to.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addCollidable(this);
        gameLevel.addSprite(this);
    }

    /**
     * The removeFromGame method is responsible for removing the sprite from the game.
     * It removes the sprite as a collidable and as a sprite from the specified game.
     *
     * @param gameLevel the game from which the sprite should be removed
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
