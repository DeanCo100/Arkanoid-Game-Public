//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 26-05-23
 */
package GameFlowing;

import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * A sprite that displays the current score on the screen.
 */
public class ScoreIndicator implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 20;
    private static final int TWO = 2;
    private static final int FONT_SIZE = 14;
    private static final int ZERO = 0;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;
    private Counter score;
    private Rectangle rectangle;
    private String levelName;

    /**
     * Constructs a new ScoreIndicator.
     *
     * @param score     the counter for the score
     * @param levelName the name of the level to print.
     */
    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        this.levelName = levelName;
        // Adjust the size and position as needed
        this.rectangle = new Rectangle(new Point(ZERO, ZERO), WIDTH, HEIGHT);

    }

    /**
     * Draws the score indicator on the given draw surface.
     *
     * @param surface the draw surface to draw on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.PINK);
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        surface.setColor(Color.WHITE);
        surface.drawText((int) ((rectangle.getUpperLeft().getX() + rectangle.getWidth() - HUNDRED) / TWO),
                (int) ((rectangle.getUpperLeft().getY() + rectangle.getHeight() + TEN) / TWO),
                "Score: " + score.getValue(), FONT_SIZE);
        surface.drawText(WIDTH - TWO * HUNDRED, FONT_SIZE + TWO, "Level Name: " + levelName, FONT_SIZE);
    }

    /**
     * Performs the relevant actions when time passed.
     * (In this case, nothing needs to be done for the score indicator.)
     */
    public void timePassed() {
        // Nothing to do for the score indicator.
    }

    /**
     * Adds the score indicator to the given game.
     *
     * @param gameLevel the game to add the score indicator to
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
