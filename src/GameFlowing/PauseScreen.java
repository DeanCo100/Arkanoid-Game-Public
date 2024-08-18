/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package GameFlowing;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * Represents a pause screen animation that displays a message and waits for the user to press a key.
 * Implements the Animation interface.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private static final int FONT_SIZE = 32;
    private static final int SPLIT = 2;
    private static final int TEN = 10;

    /**
     * Constructs a PauseScreen object with the given KeyboardSensor.
     *
     * @param k the KeyboardSensor used to detect key presses
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * Performs one frame of the pause screen animation.
     * Draws the "paused -- press space to continue" message on the DrawSurface.
     * If the space key is pressed, sets the stop flag to true.
     *
     * @param d the DrawSurface on which to draw the animation
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(TEN, d.getHeight() / SPLIT, "paused -- press space to continue", FONT_SIZE);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    /**
     * Checks if the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    public boolean shouldStop() {
        return this.stop;
    }
}