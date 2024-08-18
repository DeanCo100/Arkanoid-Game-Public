/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package GameFlowing;

import Sprites.Block;
import Sprites.Sprite;

import java.util.List;

/**
 * Represents the information about a specific level in a game.
 */
public interface LevelInformation {
    /**
     * Retrieves the number of balls in the level.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * Retrieves the initial velocities of each ball.
     *
     * @return a list of initial ball velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * Retrieves the speed of the paddle.
     *
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * Retrieves the width of the paddle.
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * Retrieves the name of the level.
     *
     * @return the level name
     */
    String levelName();

    /**
     * Retrieves the background sprite of the level.
     *
     * @return the background sprite
     */
    Sprite getBackground();

    /**
     * Retrieves the blocks that make up the level.
     *
     * @return a list of blocks
     */
    List<Block> blocks();

    /**
     * Retrieves the number of blocks that need to be removed to clear the level.
     *
     * @return the number of blocks to remove
     */
    int numberOfBlocksToRemove();
}