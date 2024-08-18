//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package Sprites;
import biuoop.DrawSurface;

/**
 * The Sprite interface represents any object that can be drawn on a DrawSurface and can change over time.
 */
public interface Sprite {
    /**
     * Draws the sprite on a given DrawSurface.
     *
     * @param d The DrawSurface to draw the sprite on.
     */
    void drawOn(DrawSurface d);

    /**
     * Notifies the sprite that a unit of time has passed.
     * This method is used to update the sprite's state or position.
     */
    void timePassed();
}