/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package Levels;

import GameFlowing.LevelInformation;
import GameFlowing.Velocity;
import Sprites.Block;
import Sprites.Sprite;
//import biuoop.DrawSurface;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;

//import java.awt.*;
import java.awt.Color;
import java.util.List;
import java.util.Arrays;

/**
 * Represents the level information for the "Direct Hit" level.
 * Implements the LevelInformation interface.
 */
public class DirectHit implements LevelInformation {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int PADDLE_SPEED = 8;
    private static final int PADDLE_WIDTH = 85;
    private static final double SPEED = 6.0;
    private static final double ANGLE = 180.00;
    private static final int HEIGHT = 30;
    private static final int WIDTH = 50;
    private static final double START_X = 375.00;
    private static final double START_Y = 135.00;

    /**
     * Constructs a DirectHit object.
     */
    public DirectHit() {
    }

    /**
     * Returns the number of balls in this level.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return ONE;
    }

    /**
     * Returns the initial velocities of the balls in this level.
     *
     * @return a list of velocities for the balls
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return Arrays.asList(Velocity.fromAngleAndSpeed(ANGLE, SPEED));
    }

    /**
     * Returns the speed of the paddle in this level.
     *
     * @return the speed of the paddle
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * Returns the width of the paddle in this level.
     *
     * @return the width of the paddle
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * Returns the name of this level.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * Returns the background sprite for this level.
     *
     * @return the background sprite
     */
    @Override
    public Sprite getBackground() {
        return new DirectHitBackground();
    }

    /**
     * Returns the list of blocks in this level.
     *
     * @return a list of blocks
     */
    @Override
    public List<Block> blocks() {
        Rectangle rect = new Rectangle(new Point(START_X, START_Y), WIDTH, HEIGHT);
        Block block = new Block(rect, Color.CYAN);
        return Arrays.asList(block);


    }

    /**
     * Returns the number of blocks that should be removed to complete this level.
     *
     * @return the number of blocks to remove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return ONE;
    }
}
