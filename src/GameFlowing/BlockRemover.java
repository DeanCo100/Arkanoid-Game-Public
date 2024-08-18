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
 * The BlockRemover class is responsible for removing blocks from the game and keeping track of the
 * remaining blocks count.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    private static final int DECREASER = 1;

    /**
     * Constructs a BlockRemover object.
     *
     * @param gameLevel            the game to remove the blocks from
     * @param remainingBlocks the counter keeping track of the remaining blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * This method is called when a block is hit by a ball.
     * It decreases the remaining blocks count by one, removes the block from the game,
     * and removes this listener from the block's listeners list.
     *
     * @param beingHit the block that was hit
     * @param hitter   the ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Decrease the remaining blocks count by one.
        this.remainingBlocks.decrease(DECREASER);
        //Remove the block from the game.
        beingHit.removeFromGame(this.gameLevel);
        //Remove this listener from the block Listeners list.
        beingHit.removeHitListener(this);

    }
}
