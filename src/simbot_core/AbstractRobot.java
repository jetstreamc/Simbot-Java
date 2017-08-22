package simbot_core;

import simbot_program.MyEnvironment;
import java.awt.Color;

/**
 *
 * @author Chattriya
 */
public abstract class AbstractRobot {
    protected int x, y, degree;
    protected boolean fillColor;
    protected Color color;
    protected AbstractEnvironment env;
    protected boolean isShow;

    /**
     * Constructor
     */
    public AbstractRobot() {
        this.env = new MyEnvironment();
        x = env.getConstRobotInitPos().x;
        y = env.getConstRobotInitPos().y;
        this.degree = env.getConstRobotInitDegree();
        this.setShow(true);
    }

        /**
     * Constructor
     * @param env
     */
    public void setup(AbstractEnvironment env){
        this.env = env;
        x = env.getConstRobotInitPos().x;
        y = env.getConstRobotInitPos().y;
        this.degree = env.getConstRobotInitDegree();
    }
    
    /**
     * Constructor
     * @param degree the angle of the robot.
     */
    public void setup(int degree) {
        this.degree = degree;
    }
    
    /**
     * Constructor
     * @param robotX the x position of the robot.
     * @param robotY the y position of the robot.
     */
    public void setup(int robotX, int robotY) {
        x = robotX;
        y = robotY;
    }
    
    /**
     * Perform how the robot move
     */
    public abstract void execute();
    
    /**
     *
     * @return the integer array of 8 IR sensor values at degrees of 0, 45, 90, 135, 180, 225, 270, 315 respectively.
     */
    public int[] getIRValues(){
        int[] values = new int[8];
        for(int i=0; i<8; i++) {
            int dis = 0;
            int direction = degree + i * 45;
            double tmp_x = x + (env.getConstRobotRadius() * Math.cos(direction * Math.PI / 180));
            double tmp_y = y + (env.getConstRobotRadius() * Math.sin(direction * Math.PI / 180));
            while(!isPointInWall(tmp_x, tmp_y) && dis < env.getConstRobotIrMaxDistance()) {
                dis += 1;
                tmp_x += 1 * Math.cos(direction * Math.PI / 180);
                tmp_y += 1 * Math.sin(direction * Math.PI / 180);
            }
            values[i] = dis;
        }
        return values;
    }
    
    /**
     * Check if the robot is eating getConstFood.
     * @return check whether the robot is at food or not.
     */
    public boolean isEatingFood() {
        SB_Food[] foods = env.getConstFood();
        boolean isEating = false;
        for(SB_Food f: foods) {
            isEating |= (x + env.getConstRobotRadius() >= f.x) 
                && (x - env.getConstRobotRadius() <= f.x + f.width)
                && (y + env.getConstRobotRadius() >= f.y)
                && (y - env.getConstRobotRadius() <= f.y + f.height);
        }
        return isEating;
    }
    
    /**
     * Check whether the robot is at the valid or invalid position
     * @param x the x position of the robot to be checked
     * @param y the y position of the robot to be checked
     * @return boolean to indicate that the robot is at valid position.
     */
    protected boolean isRobotInWall(double x, double y) {
        if(x<env.getConstRobotRadius() || x>env.getConstMazeWidth()-env.getConstRobotRadius() 
                || y<env.getConstRobotRadius() || y>env.getConstMazeHeight()-env.getConstRobotRadius()) {
            return true;
        }
        for(SB_Wall w : env.getConstWalls()) {
            if( (x+env.getConstRobotRadius() >= w.x1 && x-env.getConstRobotRadius() <= w.x2) 
                    && (y+env.getConstRobotRadius() >= w.y1 && y-env.getConstRobotRadius() <= w.y2) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the (x,y) is in the valid or invalid position
     * @param x the x position of the robot to be checked
     * @param y the y position of the robot to be checked
     * @return boolean to indicate that the robot is at valid position.
     */
    public boolean isPointInWall(double x, double y) {
        if(x<0 || x>env.getConstMazeWidth() || y<0 || y>env.getConstMazeHeight()) {
            return true;
        }
        for(SB_Wall w : env.getConstWalls()) {
            if( (x >= w.x1 && x <= w.x2) && (y >= w.y1 && y <= w.y2) ) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Move forward the robot for 3 pixels.
     */
    protected void moveForward() {
        double tmp_x = x + (3*Math.cos(degree*Math.PI/180));
	double tmp_y = y + (3*Math.sin(degree*Math.PI/180));
        if(!isRobotInWall(tmp_x, tmp_y)) {
            x = (int) tmp_x;
            y = (int) tmp_y;
        }
    }
    
    /**
     * Turn the robot -5 degree.
     */
    protected void spinLeft() {
        degree = (degree - 5 + 360) % 360;
    }
    
    /**
     * Turn the robot +5 degree.
     */
    protected void spinRight() {
        degree = (degree + 5 + 360) % 360;
    }
    
    /**
     * Get the angle between the food and the head of the robot.
     * @return the angle between the food and the head of the robot.
     */
    protected int[] smellDirection() {
        SB_Food[] foods = env.getConstFood();
        int[] directions = new int[foods.length];
        for(int i=0; i<foods.length; i++) {
            int dx = foods[i].x - x;
            int dy = foods[i].y - y;
            int angle = (int) (Math.atan2(dy, dx) * 180.0 / Math.PI) - degree;
            while (angle < -180) {
                angle = angle + 360;
            }
            while (angle > 180) {
                angle = angle - 360;
            }
            directions[i] = angle;
        }
        return directions;
    }

    /**
     * 
     * @return the angle between the food and the head of the robot.
     */
    public int[] getDirectionToFood() {
        return smellDirection();
    }
    
    /**
     * set the color filling when drawing the robot in UI.
     * @param isFill
     */
    public void setFillColor(boolean isFill) {
        fillColor = isFill;
    }
    
    /**
     * set the showing when drawing the robot in UI.
     * @param isShow
     */
    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public boolean getShow() {
        return this.isShow;
    }
}