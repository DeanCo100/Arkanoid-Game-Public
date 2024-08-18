/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */
package GameFlowing;

import Levels.EndScreen;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The GameFlow class is responsible for managing the flow of the game.
 * It handles the progression through different levels and displays the appropriate screens based on the game's state.
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter gameScore;
    private static final int MAX_SCORE = 665;
    private static final int MINUS_ONE = 1;
    /**
     * Constructs a new GameFlow with the specified AnimationRunner and KeyboardSensor.
     *
     * @param ar the AnimationRunner to run the animations
     * @param ks the KeyboardSensor to handle keyboard input
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.ar = ar;
        this.ks = ks;
        this.gameScore = new Counter(0);
    }
    /**
     * Runs the game levels.
     * Iterates over the list of LevelInformation objects and handles the progression through each level.
     *
     * @param levels the list of LevelInformation objects representing the game levels
     */
    public void runLevels(List<LevelInformation> levels) {
        //The number of the levels:
        int numLevels = levels.size();
        //Iterating over all the levels in the list
        for (int i = 0; i < numLevels; i++) {
            LevelInformation levelInfo = levels.get(i);
            GameLevel level = new GameLevel(this.ar, this.ks, levelInfo, this.gameScore);
            level.initialize();
            level.run();

            if (!level.getWinOrLose()) {
                EndScreen endScreen = new EndScreen("Game Over. Your score is ", this.ks, this.gameScore);
                Animation gameOverAnimation = new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                        endScreen);
                this.ar.run(gameOverAnimation);
                return; // Exit the loop if the player loses
            }

            boolean isLastLevel = i == numLevels - MINUS_ONE;
            if (isLastLevel) {
                EndScreen endScreen = new EndScreen("You Win! Your score is ", this.ks, this.gameScore);
                Animation youWinAnimation = new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY,
                        endScreen);
                this.ar.run(youWinAnimation);
                return; // Exit the loop if all blocks are destroyed and it's the last level
            }
        }
    }
}