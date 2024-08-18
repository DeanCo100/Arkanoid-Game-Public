/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package Levels;

import GameFlowing.LevelInformation;
import GameFlowing.Velocity;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import Sprites.Block;
import Sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Represents the Level 3 configuration and properties.
 * Implements the LevelInformation interface.
 */
public class Level3 implements LevelInformation {
    public static final int SCREEN_WIDTH = 800;
    private static final double EPSILON = 0.0000001;
    public static final int SCREEN_HEIGHT = 600;
    private static final int BLOCK_WIDTH = 45;
    private static final int BLOCK_HEIGHT = 25;
    private static final double FIRST_ROW_Y = 180.00;
    private static final double FIRST_BLOCK_X = 240.00;
    private static final int NUM_BLOCKS_FIRST_ROW = 12;
    private static final int NUM_ROWS = 6;
    private static final int ZERO = 0;
    private static final int PLUS_ONE = 1;
    private static final int BLOCKS_NUM = 57;
    private static final int PADDLE_WIDTH = 85;
    private static final double BALL_SPEED = 6.44;
    private static final int PADDLE_SPEED = 8;
    private static final int NUM_BALLS = 2;

    private List<Block> blocks = new ArrayList<>();

    /**
     * Constructs a new Level3 instance.
     * Initializes the blocks configuration for Level 3.
     */
    public Level3() {
        Color[] blockColors = {Color.BLUE, Color.WHITE, Color.YELLOW, Color.BLUE, Color.WHITE, Color.BLUE};
        for (int i = 0; i < NUM_ROWS; i++) {
            int y = (int) (FIRST_ROW_Y + i * (BLOCK_HEIGHT));
            for (int j = i; j < NUM_BLOCKS_FIRST_ROW; j++) {
                if (j > ZERO) {
                    int x = (int) (FIRST_BLOCK_X + j * (BLOCK_WIDTH));
                    Block block = new Block(new Rectangle(new Point(x, y), BLOCK_WIDTH, BLOCK_HEIGHT),
                            blockColors[i]);
                    this.blocks.add(block);
                } else {
                    int x = (int) (FIRST_BLOCK_X + PLUS_ONE + j * BLOCK_WIDTH);
                    Block block = new Block(new Rectangle(new Point(x, y), BLOCK_WIDTH, BLOCK_HEIGHT),
                            blockColors[i]);
                    this.blocks.add(block);
                }
            }
        }

    }

    /**
     * Returns the number of balls in Level 3.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }
    /**
     * Returns the initial velocities of the balls in Level 3.
     *
     * @return a list of Velocity objects representing the initial velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double speed = BALL_SPEED;
        velocities.add(Velocity.fromAngleAndSpeed(40.27, speed));
        velocities.add(Velocity.fromAngleAndSpeed(-190.73, speed));
        return velocities;
    }
    /**
     * Returns the speed of the paddle in Level 3.
     *
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }
    /**
     * Returns the width of the paddle in Level 3.
     *
     * @return the paddle width
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }
    /**
     * Returns the name of Level 3.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Level3";
    }
    /**
     * Returns the background sprite of Level 3.
     *
     * @return the background sprite
     */
    @Override
    public Sprite getBackground() {
        return new Level3BackGround();
    }
    /**
     * Returns the list of blocks in Level 3.
     *
     * @return a list of Block objects
     */
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }
    /**
     * Returns the number of blocks that need to be removed in Level 3.
     *
     * @return the number of blocks to remove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return BLOCKS_NUM;
    }
}
