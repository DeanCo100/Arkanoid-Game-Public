//322537952 Dean Cohen
/**
 * @author Dean Cohen dean.cohen1@live.biu.ac.il.
 * @version 1.0 02-06-23
 */

import GameFlowing.AnimationRunner;
import GameFlowing.Counter;
import GameFlowing.LevelInformation;
import GameFlowing.GameFlow;
import Levels.DirectHit;
import Levels.Level3;
import Levels.WideEasy;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the main game class, which initializes and runs the game.
 */
public class Ass6Game {
    //Constants
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    private static final int BLOCK_WIDTH = 45;
    private static final int BLOCK_HEIGHT = 25;
    private static final double FIRST_ROW_Y = 180.00;
    private static final double FIRST_BLOCK_X = 240.00;
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_HEIGHT = 20;
    private static final int PADDLE_SPEED = 4;
    private static final double PADDLE_START_X = 400.00;
    private static final double PADDLE_Y = 560.00;
    private static final int BALL_R = 5;
    private static final int FPS = 60;
    private static final int DIRECT_HIT = 1;
    private static final int WIDE_EASY = 2;
    private static final int LEVEL3 = 3;
    private static final int NUM_LEVELS = 3;

    /**
     * The main method that creates a new game, initializes it, and runs it.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid Game", SCREEN_WIDTH, SCREEN_HEIGHT);
        Sleeper sleeper = new Sleeper();
        AnimationRunner runner = new AnimationRunner(gui, FPS, sleeper);
        // create a keyboard sensor
        KeyboardSensor keyboard = runner.getGui().getKeyboardSensor();
        Counter score = new Counter(0);
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0 || args[0].equals("${args}")) {
            // Default levels
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Level3());
        } else {
            //Boolean flag to situation which all the input is invalid then run by default level 1, 2, 3.
            boolean hasValidInput = false;
            for (String arg : args) {
                try {
                    int levelNum = Integer.parseInt(arg);
                    switch (levelNum) {
                        case DIRECT_HIT:
                            levels.add(new DirectHit());
                            hasValidInput = true;
                            break;
                        case WIDE_EASY:
                            levels.add(new WideEasy());
                            hasValidInput = true;
                            break;
                        case LEVEL3:
                            levels.add(new Level3());
                            hasValidInput = true;
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException ignored) {
                    // Ignore non-number arguments
                }
            }

            if (!hasValidInput) {
                // Run default levels
                levels.clear();
                levels.add(new DirectHit());
                levels.add(new WideEasy());
                levels.add(new Level3());
            }
        }

        GameFlow gameFlow = new GameFlow(runner, keyboard);
        gameFlow.runLevels(levels);
        gui.close();
    }
}