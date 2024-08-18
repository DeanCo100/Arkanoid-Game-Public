/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package Levels;

import GameFlowing.Animation;
import GameFlowing.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * Represents the end screen animation displayed at the end of the game.
 * Implements the Animation interface.
 */
public class EndScreen implements Animation {
    private static final int FONT_SIZE = 32;
    private static final int TEXT_X = 260;
    private static final int TEXT_Y = 280;

    private String message;
    private KeyboardSensor keyboardSensor;
    private boolean shouldTerminate;
    private Counter gameScore;
    /**
     * Constructs a new EndScreen animation with the given parameters.
     *
     * @param message         the message to be displayed on the end screen
     * @param keyboardSensor  the keyboard sensor for detecting key presses
     * @param gameScore       the counter representing the game score
     */
    public EndScreen(String message, KeyboardSensor keyboardSensor, Counter gameScore) {
        this.message = message;
        this.keyboardSensor = keyboardSensor;
        this.shouldTerminate = false;
        this.gameScore = gameScore;
    }

    /**
     * Performs one frame of the end screen animation.
     * Draws the end screen message and game score on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(TEXT_X, TEXT_Y, message + gameScore.getValue(), FONT_SIZE);
    }
    /**
     * Determines if the animation should stop.
     *
     * @return always returns false, indicating that the animation should not stop
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
