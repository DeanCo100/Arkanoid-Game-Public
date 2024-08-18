//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 26-05-23
 */
package Listeners;
import Sprites.Ball;
import Sprites.Block;
/**
 * A listener interface for objects that need to be notified when a collision occurs.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the block that is being hit
     * @param hitter   the ball that is doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}