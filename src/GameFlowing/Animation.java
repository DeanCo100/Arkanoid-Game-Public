/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package GameFlowing;
import biuoop.DrawSurface;

/**
 * The Animation interface represents a single animation in the game.
 * It defines methods for performing one frame of the animation
 * and determining whether the animation should stop.
 */
public interface Animation {
    /**
     * Performs one frame of the animation.
     *
     * @param d the draw surface on which to draw the frame
     */
    void doOneFrame(DrawSurface d);

    /**
     * Determines whether the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    boolean shouldStop();
}