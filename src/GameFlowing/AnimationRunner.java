/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package GameFlowing;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * The AnimationRunner class is responsible for running animations.
 * It manages the game loop, updates frames, and controls the frame rate.
 */

public class AnimationRunner {
    public static final int THOUSAND = 1000;
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    private static final int SIXTY = 60;
    private static final int ZERO = 0;

    /**
     * Constructs a new AnimationRunner with the specified GUI, frames per second, and sleeper.
     *
     * @param gui             the GUI to display the animations on
     * @param framesPerSecond the desired frames per second
     * @param sleeper         the sleeper object used for controlling frame rate
     */
    public AnimationRunner(GUI gui, int framesPerSecond, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = sleeper;
    }

    /**
     * Returns the GUI associated with this AnimationRunner.
     *
     * @return the GUI instance
     */
    public GUI getGui() {
        return this.gui;
    }

    /**
     * Runs the specified animation.
     * The animation loop continuously draws all sprites on the surface, calls timePassed() on all sprites,
     * updates the ball's velocity based on collisions with the environment, and waits for the next frame.
     *
     * @param animation the animation to run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = THOUSAND / this.framesPerSecond;
        while (!animation.shouldStop()) {
            // the start time we start from every frame.
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            // Sleeps the program in the remaining time.
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > ZERO) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}