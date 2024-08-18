# Arkanoid Game:

## Overview:
This project is a Java-based implementation of the old but gold classic Arkanoid game.
The game includes 3 stages of increasing difficulty.
Your goal is to break all the bricks without letting the balls to fall down.

## Game features:
**Paddle movement**: Based on keyboard arrows. <br />
**Ball Mechanics**: Implement realistic ball physics for dynamic bouncing off the paddle and bricks. <br />
**Brick Variations**: Introduce multiple levels of bricks, each requiring one or more hits to break. <br />
**Score System**: Track and update the player's score as they break bricks and progress through levels. <br />
**Game States**: Include Start, Pause, and End screens to enhance game control and flow. <br />
## Compile and Run:
The project already contains a build file, so only need to follow these steps: <br />
1. Compile the code via this Ant command:
```
ant compile
```
2. Run the compiled code by:
```
ant run
```
**Note**:
You can specify your desired sequence of levels by passing the sequence as an argument like this:
```
ant -Dargs="1 3 2 1 2 3 1" run
```

## Game Controls:
**Left Arrow**: Move paddle to the left. <br />
**Right Arrow**: Move paddle to the right. <br />
**Space**: Exit the game after loss or win. <br />
**P**: Pause the game.






