//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 25-04-23
 */
package Sprites;

import GameFlowing.GameLevel;
import GameFlowing.Velocity;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The Paddle class represents a paddle object in a game of Breakout.
 * The paddle can be moved left or right using the arrow keys on the keyboard.
 * It implements the Sprite and Collidable interfaces.
 */
public class Paddle implements Sprite, Collidable {
    //Fields and constants
    private static final double EPSILON = 0.0000001;
    private static final int PADDLE_SPEED = 4;
    private static final int LEFT_EDGE = 20;
    private static final int RIGHT_EDGE = 780;
    private static final int FIVE = 5;
    private static final int ZERO = 0;
    private static final int ANGLE_REGION1 = 300;
    private static final int ANGLE_REGION2 = 330;
    private static final int ANGLE_REGION5 = 60;
    private static final int ANGLE_REGION4 = 30;
    private static final int ONE = 1;
    private KeyboardSensor keyboard;
    private Color color;
    private Rectangle rectangle;
    private int speed;

    /**
     * Creates a new Paddle object.
     *
     * @param rectangle the rectangle representing the paddle's dimensions and position.
     * @param keyboard  the keyboard sensor used to receive input from the user.
     * @param color     the color of the paddle.
     * @param speed     the speed of the paddle/
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard, Color color, int speed) {
        this.rectangle = rectangle;
        this.keyboard = keyboard;
        this.color = color;
        this.speed = speed;
    }

    /**
     * Moves the paddle to the left by PADDLE_SPEED pixels.
     * If the paddle has reached the left edge of the screen, it will not move any further.
     */
    public void moveLeft() {
        double newX = this.rectangle.getUpperLeft().getX() - this.speed;
        if (newX < LEFT_EDGE) {
            newX = LEFT_EDGE;
        }
        Point newUpperLeft = new Point(newX, this.rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(newUpperLeft, this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /**
     * Moves the paddle to the right by PADDLE_SPEED pixels.
     * If the paddle has reached the right edge of the screen, it will not move any further.
     */
    public void moveRight() {
        double newX = this.rectangle.getUpperLeft().getX() + this.speed;
        if (newX + this.rectangle.getWidth() > RIGHT_EDGE) {
            newX = RIGHT_EDGE - this.rectangle.getWidth();
        }
        Point newUpperLeft = new Point(newX, this.rectangle.getUpperLeft().getY());
        this.rectangle = new Rectangle(newUpperLeft, this.rectangle.getWidth(), this.rectangle.getHeight());
    }

    /**
     * Returns the rectangle representing the paddle's collision area.
     *
     * @return the rectangle representing the paddle's collision area.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Calculates the new velocity of a ball that has collided with the paddle.
     *
     * @param collisionPoint  the point at which the ball collided with the paddle.
     * @param currentVelocity the current velocity of the ball.
     * @return the new velocity of the ball.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Initiallizing variables values.
        double paddleWidth = this.rectangle.getWidth();
        double regionWidth = paddleWidth / FIVE;
        double ballAngle = ZERO;
        double speed = currentVelocity.getSpeed();
        double x = collisionPoint.getX();
        double y = collisionPoint.getY();
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        Line leftLine = new Line(this.rectangle.getUpperLeft(), this.rectangle.getLowerLeft());
        Line rightLine = new Line(this.rectangle.getUpperRight(), this.rectangle.getLowerRight());

        if (rightLine.isPointOnLine(collisionPoint)) {
            ballAngle = ANGLE_REGION5;
        }
        if (leftLine.isPointOnLine(collisionPoint)) {
            ballAngle = ANGLE_REGION1;
        }
        // calculate which region the collision point is in
        int region = (int) ((collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) / regionWidth) + ONE;

        // calculate the new angle based on which region was hit
        if (region == 1) {
            ballAngle = ANGLE_REGION1;
        } else if (region == 2) {
            ballAngle = ANGLE_REGION2;
        } else if (region == 4) {
            ballAngle = ANGLE_REGION4;
        } else if (region == 5) {
            ballAngle = ANGLE_REGION5;
        } else if (region == 3) {
            // if the collision point is in the middle region, just flip the y velocity
            return new Velocity(dx, -dy);
        }
        // calculate the new velocity based on the angle and speed
        double radians = Math.toRadians(ballAngle);
        dx = speed * Math.sin(radians);
        dy = -speed * Math.cos(radians);
        return new Velocity(dx, dy);
    }

    /**
     * Draws the paddle on the given DrawSurface object.
     *
     * @param d the DrawSurface object on which to draw the paddle
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * Moves the paddle left or right based on keyboard input.
     * Called once per frame.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(keyboard.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Adds the paddle as a collidable and sprite to the given Game object.
     *
     * @param g the Game object to which to add the paddle
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
