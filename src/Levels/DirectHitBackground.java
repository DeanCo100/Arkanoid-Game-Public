/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package Levels;

import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
/**
 * Represents the background sprite for the "Direct Hit" level.
 * Implements the Sprite interface.
 */
public class DirectHitBackground implements Sprite {
    private static final int CENTER_X = 400;
    private static final int CENTER_Y = 150;
    private static final int OUTER_RADIUS = 80;
    private static final int MIDDLE_RADIUS = 70;
    private static final int INNER_RADIUS = 60;
    private static final int TEN = 10;
    private static final int TWO_PI = 360;
    /**
     * Draws the background on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Set the background color by arbitrary RGB.
        Color color = new Color(159, 15, 196);
        d.setColor(color);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        // Draw the circles with arbitrary RGB yellow colors.
        color = new Color(239, 239, 159);
        d.setColor(color);
        d.fillCircle(CENTER_X, CENTER_Y, OUTER_RADIUS);
        color = new Color(241, 241, 102);
        d.setColor(color);
        d.fillCircle(CENTER_X, CENTER_Y, MIDDLE_RADIUS);
        d.setColor(Color.YELLOW);
        d.fillCircle(CENTER_X, CENTER_Y, INNER_RADIUS);

        // Draw the rays
        d.setColor(Color.BLACK);
        for (int i = 0; i < TWO_PI; i += TEN) {
            int x = CENTER_X + (int) (OUTER_RADIUS * Math.cos(Math.toRadians(i)));
            int y = CENTER_Y + (int) (OUTER_RADIUS * Math.sin(Math.toRadians(i)));
            d.drawLine(CENTER_X, CENTER_Y, x, y);
        }
    }
    /**
     * Updates the background sprite for each frame.
     * No action is needed in this case.
     */
    public void timePassed() {
        // No need for any action
    }
}