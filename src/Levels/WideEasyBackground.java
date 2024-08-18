/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package Levels;

import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The WideEasyBackground class implements the Sprite interface and represents the background for the "Wide Easy" level.
 */
public class WideEasyBackground implements Sprite {
    private static final int NUM_OF_RAYS = 100;
    private static final int START_X = 25;
    private static final int END_X = 775;

    /**
     * Draws the background on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        Color color = new Color(133, 151, 239);
        d.setColor(color);
        d.fillRectangle(0, 18, d.getWidth(), d.getHeight());
        d.setColor(Color.WHITE);
        d.fillCircle(150, 150, 60);

        for (int i = 1; i <= NUM_OF_RAYS; ++i) {
            d.drawLine(150, 150, (END_X - START_X) / NUM_OF_RAYS * i, 250);
        }

        d.setColor(Color.PINK);
        d.fillCircle(150, 150, 50);
        d.setColor(Color.YELLOW);
        d.fillCircle(150, 150, 40);

    }

    /**
     * Performs an action when time passes (no action needed for the background).
     */
    @Override
    public void timePassed() {
        // No need for any action
    }
}
