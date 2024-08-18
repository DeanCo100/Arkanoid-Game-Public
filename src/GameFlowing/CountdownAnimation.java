/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */

package GameFlowing;

import Sprites.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;
/**
 * The CountdownAnimation class is responsible for displaying a countdown animation.
 * It implements the Animation interface.
 */
public class CountdownAnimation implements Animation {
    private double seconds;
    private int countFrom;
    private int countDown;
    private boolean enoughCounting;
    private String levelName;
    private SpriteCollection screenOfGame;
    private Color background;
    private Sleeper sleeper;
    private int millisecondsPerFrame;
    private int startFrom;
    private static final int FINISH = 0;
    private static final int THOUSAND = 1000;
    private static final int TWO = 2;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 20;
    private static final int SPLIT = 2;
    private static final int FONT_SIZE = 14;
    private static final int ZERO = 0;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private static final int EIGHTY = 80;
    /**
     * Constructs a new CountdownAnimation with the specified parameters.
     *
     * @param seconds       the total duration of the countdown in seconds
     * @param countFrom     the number to count down from
     * @param screenOfGame  the sprite collection representing the game screen
     * @param levelName     the name of the current level
     */

    public CountdownAnimation(double seconds, int countFrom,
                              SpriteCollection screenOfGame, String levelName) {
        this.seconds = seconds;
        this.countFrom = countFrom;
        this.countDown = countFrom;
        this.screenOfGame = screenOfGame;
        this.levelName = levelName;
    }

    /**
     * Performs one frame of the countdown animation.
     * Draws the level name and the countdown number on the specified DrawSurface.
     * Sleeps for a certain amount of time based on the duration of the countdown.
     *
     * @param d the DrawSurface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        if (this.countDown <= FINISH) {
            this.enoughCounting = true;
        }
        //Random numbers rgb for color.
        Color color = new Color(164, 117, 53);
        //Draw the level name

        this.screenOfGame.drawAllOn(d);
        d.drawText(WIDTH - TWO * HUNDRED, FONT_SIZE + TWO, "Level Name: " + this.levelName, FONT_SIZE);
        //Draw the countDown
        d.setColor(color);
        d.drawText(520, d.getHeight() / SPLIT, (Integer.valueOf(this.countDown)).toString(), EIGHTY);


        if (this.countFrom != this.countDown) {

            // sleep for numOfSeconds seconds.
            new Sleeper().sleepFor((long) (THOUSAND * (this.seconds / this.countFrom)));
        }
        this.countDown--;
    }
    /**
     * Checks if the countdown animation should stop.
     *
     * @return true if the countdown has finished, false otherwise
     */
    public boolean shouldStop() {
        return (this.enoughCounting);
    }
}
