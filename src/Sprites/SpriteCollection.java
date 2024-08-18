//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package Sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * The SpriteCollection class represents a collection of sprites in a game.
 * It allows adding new sprites and notifying all sprites of elapsed time.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Creates a new SpriteCollection object.
     */

    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * Adds a new sprite to the collection.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }
    /**
     * The removeSprite method is responsible for removing a sprite from the game's list of sprites.
     *
     * @param s the sprite to be removed
     */
    public void removeSprite(Sprite s) {
        //To remove the sprite
        this.sprites.remove(s);
    }
    /**
     * The getSprites method returns a list of all the sprites in the game.
     *
     * @return the list of sprites in the game
     */
    public List<Sprite> getSprites() {
        return sprites;
    }

    /**
     * Calls timePassed() on all Sprites in the collection.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);  // Create a copy of the sprites collection
        for (Sprite s : spritesCopy) {  // Iterate over the copy
            s.timePassed();
        }
    }

    /**
     * Draws all Sprites in the collection on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
            List<Sprite> spritesCopy = new ArrayList<>(this.sprites);  // Create a copy of the sprites collection
        for (Sprite s : spritesCopy) { //Iterates over its copy.
            s.drawOn(d);
        }
    }
}