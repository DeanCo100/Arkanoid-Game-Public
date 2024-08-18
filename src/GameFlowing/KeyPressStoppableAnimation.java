/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package GameFlowing;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * KeyPressStoppableAnimation is an animation wrapper that stops when a specific key is pressed.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isKeyPressed;
    private boolean shouldStop;
    private boolean isAlreadyPressed;
    /**
     * Creates a new KeyPressStoppableAnimation.
     *
     * @param sensor    the KeyboardSensor to check for key presses.
     * @param key       the key that should stop the animation when pressed.
     * @param animation the animation to be wrapped and controlled by key presses.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isKeyPressed = false;
        this.shouldStop = false;
        this.isAlreadyPressed = true;

    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key) && !this.isKeyPressed) {
            if (this.isAlreadyPressed) {
                return;
            } else {
                this.shouldStop = true;
            }
        }
        this.isAlreadyPressed = false;
        this.isKeyPressed = this.sensor.isPressed(this.key);
    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}