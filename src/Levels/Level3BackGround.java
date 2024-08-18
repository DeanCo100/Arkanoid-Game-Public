/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package Levels;

import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
/**
 * The background for Level 3.
 */
public class Level3BackGround implements Sprite {
    /**
     * Draws the Level 3 background on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        Color color = new Color(117, 167, 217);
        d.setColor(color);
        d.fillRectangle(0, 18, d.getWidth(), d.getHeight());
        d.setColor(Color.GRAY);
        d.fillRectangle(110, 200, 10, 200);
        color = new Color(192, 192, 31);
        d.setColor(Color.BLUE);
        d.fillCircle(115, 200, 12);
        d.setColor(Color.WHITE);
        d.fillCircle(115, 200, 8);
        //Drawing the Israeli flag
        d.fillRectangle(120, 190, 100, 60);
        d.setColor(Color.BLUE);
        d.fillRectangle(120, 190, 100, 10);
        d.fillRectangle(120, 240, 100, 10);
        d.drawLine(170, 205, 200, 230);
        d.drawLine(170, 205, 140, 230);
        d.drawLine(140, 230, 200, 230);
        d.drawLine(170, 235, 140, 210);
        d.drawLine(170, 235, 200, 210);
        d.drawLine(140, 210, 200, 210);
        color = new Color(2, 40, 79);
        d.setColor(color);
        d.fillCircle(115, 200, 3);
        d.setColor(Color.BLUE);
        d.fillRectangle(100, 400, 30, 200);
        d.setColor(color);
        d.fillRectangle(65, 450, 100, 200);
        int startPositionX = 75;
        int startPositionY = 460;
        d.setColor(Color.WHITE);

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                d.fillRectangle(startPositionX + j * 18, startPositionY + i * 32, 10, 25);
            }
        }
        //Trying Something New of "EL EL ISRAEL"
        //Creating the first "EL"
        d.setColor(Color.WHITE);
        //Creating the "E"
        d.fillRectangle(200, 350, 10, 60);
        d.fillRectangle(210, 350, 50, 10);
        d.fillRectangle(210, 375, 50, 10);
        d.fillRectangle(210, 400, 50, 10);
        d.setColor(Color.BLUE);
        //Creating the "L"
        d.fillRectangle(265, 350, 10, 60);
        d.fillRectangle(275, 400, 50, 10);
        //Now creating the "-"
        d.setColor(Color.WHITE);
        d.fillRectangle(325, 375, 12, 8);

        //Creating the second "EL"
        d.setColor(Color.BLUE);
        //Creating the "E"
        d.fillRectangle(345, 350, 10, 60);
        d.fillRectangle(355, 350, 50, 10);
        d.fillRectangle(355, 375, 50, 10);
        d.fillRectangle(355, 400, 50, 10);
        //Creating the "L"
        d.setColor(Color.WHITE);
        d.fillRectangle(410, 350, 10, 60);
        d.fillRectangle(420, 400, 50, 10);
        //Creating the "Israel"
        d.setColor(Color.BLUE);
        //Creating the "I"
        d.fillRectangle(200, 420, 10, 60);
        d.setColor(Color.WHITE);
        //Creating the "S"
        d.fillRectangle(215, 420, 60, 10);
        d.fillRectangle(215, 430, 10, 25);
        d.fillRectangle(225, 445, 50, 10);
        d.fillRectangle(265, 445, 10, 25);
        d.fillRectangle(215, 470, 60, 10);
        // Creates the vertical bar of the "R"
        d.setColor(Color.BLUE);
        d.fillRectangle(280, 420, 10, 60);
        //Creates the "connecting" vertical line between both horizontal
        d.fillRectangle(330, 420, 10, 25);

        // Creates the top horizontal line of the "R"
        d.fillRectangle(290, 420, 50, 10);

        // Creates the diagonal line of the "R"
        for (int i = 0; i <= 30; i++) {
            d.fillRectangle((int) (285 + i * 1.5), 445 + i, 8, 8);
        }
        // Creates the bottom horizontal line of the "R"
        d.fillRectangle(290, 445, 50, 10);
        //Creates the "A"
        d.setColor(Color.WHITE);
        d.fillRectangle(345, 420, 60, 10);
        d.fillRectangle(345, 430, 10, 50);
        d.fillRectangle(355, 450, 50, 10);
        d.fillRectangle(395, 430, 10, 50);
        //Creates the "E"
        d.setColor(Color.BLUE);
        d.fillRectangle(410, 420, 10, 60);
        d.fillRectangle(420, 420, 50, 10);
        d.fillRectangle(420, 445, 50, 10);
        d.fillRectangle(420, 470, 50, 10);
        //Creates the "L"
        d.setColor(Color.WHITE);
        d.fillRectangle(475, 420, 10, 60);
        d.fillRectangle(485, 470, 50, 10);
        //Trying to create "David-Shield by lines":
        d.drawLine(650, 350, 550, 500);
        d.drawLine(650, 350, 750, 500);
        d.drawLine(550, 500, 750, 500);
        d.setColor(Color.blue);
        d.drawLine(650, 550, 550, 400);
        d.drawLine(650, 550, 750, 400);
        d.drawLine(550, 400, 750, 400);
    }

    @Override
    public void timePassed() {
        //Nothing to do here for now
    }
}
