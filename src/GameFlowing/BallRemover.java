//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 26-05-23
 */
package GameFlowing;

import Listeners.HitListener;
import Sprites.Ball;
import Sprites.Block;

/**
 * The BallRemover class is responsible for removing balls from the game when they hit the death region block.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    private static final int DECREASER = 1;

    /**
     * Constructs a BallRemover object.
     *
     * @param gameLevel           the game to remove the ball from
     * @param remainingBalls the counter keeping track of the remaining balls
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * This method is called when a ball hits the death region block.
     * It decreases the remaining balls count by one and removes the ball from the game.
     *
     * @param beingHit the block that was hit (the death region block)
     * @param hitter   the ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Decrease the remaining blocks count by one.
        this.remainingBalls.decrease(DECREASER);
        //Remove the block from the game.
        hitter.removeFromGame(this.gameLevel);

    }
}
