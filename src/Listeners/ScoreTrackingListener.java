//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 26-05-23
 */
package Listeners;

import GameFlowing.Counter;
import Sprites.Ball;
import Sprites.Block;

/**
 * The ScoreTrackingListener class is responsible for tracking the score when blocks are hit.
 */
public class ScoreTrackingListener implements HitListener {
    private static final int PLUS_FIVE = 5;
    private Counter currentScore;
    /**
     * Constructs a ScoreTrackingListener with the specified score counter.
     *
     * @param scoreCounter the counter to track the score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * Updates the score when a block is hit.
     *
     * @param beingHit the block that was hit
     * @param hitter   the ball that hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(PLUS_FIVE);
    }
}