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
 * The WideEasy class implements LevelInformation interface and represents the information for the "Wide Easy" level.
 */
public class WideEasy implements LevelInformation {
    private static final double ALL_HEIGHT = 250.00;
    private static final double BLOCK_WIDTH = 50;
    private static final int BLOCK_HEIGHT = 25;
    private static final int TWO = 2;
    private static final int PADDLE_WIDTH = 600;
    private static final int PADDLE_SPEED = 4;
    private static final int NUM_BALLS = 10;
    private static final double BALLS_SPEED = 6.23;
    private static final int NUM_BLOCKS = 15;

    /**
     * Constructs a new instance of the WideEasy class.
     */
    public WideEasy() {
    }

    /**
     * Returns the number of balls in the level.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    /**
     * Returns the initial velocities of the balls in the level.
     *
     * @return a list of the initial ball velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double speed = BALLS_SPEED;
        //all the angles are randomly chosed, therefore they are not in const (MAGIC NUMBER).
        velocities.add(Velocity.fromAngleAndSpeed(230.23, speed));
        velocities.add(Velocity.fromAngleAndSpeed(220.33, speed));
        velocities.add(Velocity.fromAngleAndSpeed(210.57, speed));
        velocities.add(Velocity.fromAngleAndSpeed(200.23, speed));
        velocities.add(Velocity.fromAngleAndSpeed(190.24, speed));
        velocities.add(Velocity.fromAngleAndSpeed(-190.22, speed));
        velocities.add(Velocity.fromAngleAndSpeed(-200.36, speed));
        velocities.add(Velocity.fromAngleAndSpeed(-210.34, speed));
        velocities.add(Velocity.fromAngleAndSpeed(-220.26, speed));
        velocities.add(Velocity.fromAngleAndSpeed(-230.24, speed));
        return velocities;
    }

    /**
     * Returns the speed of the paddle in the level.
     *
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * Returns the width of the paddle in the level.
     *
     * @return the paddle width
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * Returns the name of the level.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * Returns the background sprite for the level.
     *
     * @return the background sprite
     */
    @Override
    public Sprite getBackground() {
        return new WideEasyBackground();
    }

    /**
     * Returns a list of blocks that make up the level.
     *
     * @return a list of blocks
     */
    @Override
    public List<Block> blocks() {
        //Creates the row of the blocks
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(20, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.BLUE));
        blocks.add(new Block(new Rectangle(new Point(70, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.BLUE));
        blocks.add(new Block(new Rectangle(new Point(120, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.ORANGE));
        blocks.add(new Block(new Rectangle(new Point(170, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.ORANGE));
        blocks.add(new Block(new Rectangle(new Point(220, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.YELLOW));
        blocks.add(new Block(new Rectangle(new Point(270, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.YELLOW));
        blocks.add(new Block(new Rectangle(new Point(320, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.GREEN));
        blocks.add(new Block(new Rectangle(new Point(370, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.GREEN));
        blocks.add(new Block(new Rectangle(new Point(420, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.GREEN));
        blocks.add(new Block(new Rectangle(new Point(470, ALL_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT), Color.BLUE));
        blocks.add(new Block(new Rectangle(new Point(520, ALL_HEIGHT), BLOCK_WIDTH + TWO, BLOCK_HEIGHT),
                Color.BLUE));
        blocks.add(new Block(new Rectangle(new Point(572, ALL_HEIGHT), BLOCK_WIDTH + TWO, BLOCK_HEIGHT),
                Color.PINK));
        blocks.add(new Block(new Rectangle(new Point(624, ALL_HEIGHT), BLOCK_WIDTH + TWO, BLOCK_HEIGHT),
                Color.PINK));
        blocks.add(new Block(new Rectangle(new Point(676, ALL_HEIGHT), BLOCK_WIDTH + TWO, BLOCK_HEIGHT),
                Color.CYAN));
        blocks.add(new Block(new Rectangle(new Point(728, ALL_HEIGHT), BLOCK_WIDTH + TWO, BLOCK_HEIGHT),
                Color.CYAN));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_BLOCKS;
    }
}
