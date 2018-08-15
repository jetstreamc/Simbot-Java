package simbot_core;

/**
 *
 * @author Chattriya
 */


public class Position {
    int x, y;
    /**
     * 
     * @param x the x position of the robot
     * @param y the y position of the robot
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param pos an instance of {@link Position}
     */
    Position(Position pos) {
        this.x = pos.x;
        this.y = pos.y;
    }
}
