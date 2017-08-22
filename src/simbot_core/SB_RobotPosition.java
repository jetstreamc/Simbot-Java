package simbot_core;

/**
 *
 * @author Chattriya
 */


public class SB_RobotPosition {
    public int x, y;
    /**
     * 
     * @param x the x position of the robot
     * @param y the y position of the robot
     */
    public SB_RobotPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
