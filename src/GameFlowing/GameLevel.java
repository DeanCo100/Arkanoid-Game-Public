//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package GameFlowing;

import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import Listeners.ScoreTrackingListener;
import Sprites.Ball;
import Sprites.Block;
import Sprites.SpriteCollection;
import Sprites.Collidable;
import Sprites.Sprite;
import Sprites.Paddle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

import biuoop.Sleeper;

/**
 * The Game class represents a game of Arkanoid.
 * It initializes the game by creating the Blocks and Ball (and Paddle) and adding them to the game.
 * The game loop is run in the run() method, where all sprites are drawn on the surface and timePassed() is
 * called on all sprites.
 * The ball's velocity is updated based on collisions with the environment.
 */
public class GameLevel implements Animation {
    // Fields and constants
    public static final int SCREEN_WIDTH = 800;
    private static final double EPSILON = 0.0000001;
    public static final int SCREEN_HEIGHT = 600;
    private static final int BLOCK_WIDTH = 45;
    private static final int BLOCK_HEIGHT = 25;
    private static final double FIRST_ROW_Y = 180.00;
    private static final double FIRST_BLOCK_X = 240.00;
    private static final int PADDLE_WIDTH = 120;
    private static final int PADDLE_HEIGHT = 20;
    private static final int PADDLE_SPEED = 4;
    private static final double PADDLE_START_X = 400.00;
    private static final double PADDLE_Y = 580.00;
    private static final int BALL_R = 5;
    private static final int BLOCK_SPACING = 2;
    private static final double START_X1 = 248.71;
    private static final double START_Y1 = 152.23;
    private static final double START_X2 = 450.29;
    private static final double START_Y2 = 400.01;
    private static final int NUM_BLOCKS_FIRST_ROW = 12;
    private static final int NUM_ROWS = 6;
    private static final int SIDE_WIDTH = 20;
    private static final int UP_DOWN_HEIGHT = 20;
    private static final double START_ANGLE = 33.77;
    private static final double START_SPEED = 4.45;
    private static final int ZERO = 0;
    private static final int SIXTY = 60;
    private static final int THOUSAND = 1000;
    private static final int PLUS_ONE = 1;
    private static final int TOTAL_BLOCKS = 57;
    private static final int START_TOP = 20;
    private static final int COUNT_FROM = 3;
    private static final int COUNT = 2;
    private static final int HALF = 2;
    private static final double START_X_LEV2 = 400.00;
    private static final double START_Y_LEV2 = 420.00;
    private static final int TWENTY = 20;
    private static final int HUNDRED = 100;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //    private GUI gui;
    private Sleeper sleeper;
    private Counter remainedBlocks;
    private Counter ballsCounter;
    private Counter gameScore;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private boolean winOrLose;

    /**
     * Creates a new GameLevel object.
     * Initializes the SpriteCollection, GameEnvironment, GUI, and Sleeper objects.
     *
     * @param runner           the AnimationRunner of the game.
     * @param keyboard         the keyboard of the game.
     * @param levelInformation the levelInformation of this game.
     * @param gameScore        the counter for the game score.
     */
    public GameLevel(AnimationRunner runner, KeyboardSensor keyboard, LevelInformation levelInformation,
                     Counter gameScore) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.levelInformation = levelInformation;
        this.sleeper = new Sleeper();
        this.remainedBlocks = new Counter(0);
        this.ballsCounter = new Counter(0);
        this.gameScore = gameScore;
        this.runner = runner;
        this.running = false;
        this.keyboard = keyboard;
        this.winOrLose = false;
    }

    /**
     * Returns whether the player has won or lost the game.
     *
     * @return true if the player has won the game, false if the player has lost.
     */
    public boolean getWinOrLose() {
        return this.winOrLose;
    }

    /**
     * Adds the background sprite of the current level game.
     */
    public void addBackGround() {
        this.sprites.addSprite(this.levelInformation.getBackground());
    }

    /**
     * Adds a Collidable object to the game environment.
     *
     * @param c The Collidable object to add
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Removes the specified collidable object from the game environment.
     *
     * @param c the collidable object to be removed
     */
    public void removeCollidable(Collidable c) {
        //To remove the Collidable
        this.environment.removeCollidable(c);
    }

    /**
     * Removes the specified sprite object from the game.
     *
     * @param s the sprite object to be removed
     */
    public void removeSprite(Sprite s) {
        //To remove the sprite
        this.sprites.removeSprite(s);
    }

    /**
     * Adds a Sprite object to the game.
     *
     * @param s The Sprite object to add
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Calculates the total number of blocks in the game.
     *
     * @return the total number of blocks in the game.
     */
    private int calculateTotalBlocks() {
        int totalBlocks = 0;
        for (int i = 0; i < NUM_ROWS; i++) {
            int numBlocks = NUM_BLOCKS_FIRST_ROW - i;
            totalBlocks += numBlocks;
        }
        return totalBlocks;
    }

    /**
     * Runs the game by starting the countdown animation and then the game animation.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(COUNT, COUNT_FROM,
                this.sprites, this.levelInformation.levelName()));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * Determines whether the game animation should stop.
     *
     * @return true if the game animation should stop, false otherwise.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Performs one frame of the game animation.
     *
     * @param d the DrawSurface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        // Call timePassed() on all sprites
        this.sprites.notifyAllTimePassed();
        // Check for game over condition
        if (this.ballsCounter.getValue() == ZERO) {
            this.winOrLose = false;
            this.running = false;
        }
        if (this.remainedBlocks.getValue() == ZERO) {
            this.gameScore.increase(HUNDRED);
            this.winOrLose = true;
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            PauseScreen pause = new PauseScreen(this.keyboard);
//            this.runner.run(new PauseScreen(this.keyboard));
            Animation pauseAinmation = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, pause);
            this.runner.run(pauseAinmation);
//            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, pause));
        }
    }

    /**
     * Returns the width of the game.
     *
     * @return the width of the game.
     */

    public int getGameWidth() {
        return this.runner.getGui().getDrawSurface().getWidth();
    }

    /**
     * Returns the height of the game.
     *
     * @return the height of the game.
     */
    public int getGameHeight() {
        return this.runner.getGui().getDrawSurface().getHeight();
    }

    /**
     * Initializes the game by creating all the necessary objects to the game (blocks, balls, paddle, ETC) and adding
     * them to the game. also getting the background of the current level.
     */
    public void initialize() {
        this.addBackGround();
        this.levelInformation.getBackground();
        this.createFrameBlocks();
        this.createScoreBar();
        this.createPaddle();
        this.createBalls();
        this.createBlocks();
    }

    /**
     * Creates and adds the blocks to the game based on the level information.
     * Also adds the necessary hit listeners to the blocks.
     */
    public void createBlocks() {
        BlockRemover blockRemover = new BlockRemover(this, remainedBlocks);
        for (Block block : this.levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            this.remainedBlocks.increase(1);
            block.addHitListener(new ScoreTrackingListener(gameScore));

        }
    }

    /**
     * Creates and adds the balls to the game based on the level information.
     * The behavior depends on the level name.
     */
    public void createBalls() {

        if (this.levelInformation.levelName().equals("Direct Hit")) {
            for (Velocity velocity : this.levelInformation.initialBallVelocities()) {
                Point point = new Point((double) SCREEN_WIDTH / HALF, (double) SCREEN_HEIGHT - HUNDRED);
                Ball ball = new Ball(point, BALL_R, Color.MAGENTA, this.environment);
                ball.setVelocity(velocity);
                this.ballsCounter.increase(PLUS_ONE);
                ball.addToGame(this);
            }
        } else if (this.levelInformation.levelName().equals("Wide Easy")) {
            for (Velocity velocity : this.levelInformation.initialBallVelocities()) {
                int counter = 0;
                Point point = new Point(START_X_LEV2 + counter * TWENTY, START_Y_LEV2 - counter * TWENTY);
                Ball ball = new Ball(point, BALL_R, Color.MAGENTA, this.environment);
                ball.setVelocity(velocity);
                this.ballsCounter.increase(PLUS_ONE);
                ball.addToGame(this);
                counter++;
            }
        }
        if (this.levelInformation.levelName().equals("Level3")) {
            for (Velocity velocity : this.levelInformation.initialBallVelocities()) {
                int counter = 0;
                Point point = new Point((double) SCREEN_WIDTH / HALF - HUNDRED
                        + counter * (HUNDRED + TWENTY + TWENTY),
                        (double) SCREEN_HEIGHT / HALF + HUNDRED);
                Ball ball = new Ball(point, BALL_R, Color.MAGENTA, this.environment);
                ball.setVelocity(velocity);
                this.ballsCounter.increase(PLUS_ONE);
                ball.addToGame(this);
                counter++;
            }
        }
    }

    /**
     * Creates and adds the paddle to the game based on the level information.
     * The behavior depends on the level name.
     */
    public void createPaddle() {
        if (this.levelInformation.levelName().equals("Wide Easy")) {
            Paddle paddle = new Paddle(new Rectangle(new Point(PADDLE_START_X - 220.00, PADDLE_Y),
                    this.levelInformation.paddleWidth(), PADDLE_HEIGHT), this.keyboard,
                    Color.PINK, this.levelInformation.paddleSpeed());
            paddle.addToGame(this);
        } else {
            Paddle paddle = new Paddle(new Rectangle(new Point(PADDLE_START_X - 40.00, PADDLE_Y),
                    this.levelInformation.paddleWidth(), PADDLE_HEIGHT),
                    this.keyboard, Color.PINK, this.levelInformation.paddleSpeed());
            paddle.addToGame(this);
        }
    }
    /**
     * Creates and adds the frame blocks to the game.
     */
    public void createFrameBlocks() {
        Block block11 = new Block(new Rectangle(new Point(ZERO, START_TOP),
                this.getGameWidth(), UP_DOWN_HEIGHT), Color.GRAY);
        block11.addToGame(this);
        Block block21 = new Block(new Rectangle(new Point(ZERO, ZERO), SIDE_WIDTH,
                this.getGameWidth()), Color.GRAY);
        block21.addToGame(this);
        Block block31 = new Block(new Rectangle(new Point(this.getGameWidth()
                - UP_DOWN_HEIGHT, ZERO), SIDE_WIDTH, this.getGameHeight()), Color.GRAY);
        block31.addToGame(this);
        Block deathRegion = new Block(new Rectangle(new Point(ZERO, this.getGameHeight()),
                this.getGameWidth(), UP_DOWN_HEIGHT), Color.GRAY);
        deathRegion.addHitListener(new BallRemover(this, this.ballsCounter));
        deathRegion.addToGame(this);
    }
    /**
     * Creates and adds the score bar to the game.
     */
    public void createScoreBar() {
        // Create and add the score indicator
        ScoreIndicator scoreIndicator = new ScoreIndicator(gameScore, this.levelInformation.levelName());
        scoreIndicator.addToGame(this);
    }
}