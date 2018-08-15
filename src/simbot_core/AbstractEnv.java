package simbot_core;

public abstract class AbstractEnv {

    /**
     * @return the maze width in pixels
     */
    public abstract int getMazeWidth();

    /**
     * @return the maze height in pixels
     */
    public abstract int getMazeHeight();

    /**
     * @return the array of the {@link Wall}
     */
    public abstract Wall[] getAllWalls();

    /**
     * @return the array of the {@link Position} of food.
     */
    public abstract Position[] getAllFoodPositions();

    /**
     * @return the array of the {@link Position} of robots.
     */
    public abstract Position getRobotInitPos();

    /**
     * @return the initial degree of the rebots.
     */
    public abstract int getRobotInitDegree();

    /**
     * @return the food size in pixels.
     */
    public abstract int getFoodSize();

    /**
     * @return the robot radius in pixels.
     */
    public abstract int getRobotSize();

    /**
     * @return the maximum distance of IR sensor in pixels
     */
    public abstract int getRobotIrMaxDistance();

    /**
     * @return the duration between each frame of simulation.
     */
    public abstract int getSimulationRefreshMillis();

    /**
     * @return the maximum number of the simulation steps.
     */
    public abstract int getSimulationMaxStep();

    public abstract void handleRobotEatFood(int foodToEat);
}
