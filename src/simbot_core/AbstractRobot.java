package simbot_core;

/**
 *
 * @author Chattriya
 */
public abstract class AbstractRobot {

    private Position pos = new Position(Setting.getEnv().getRobotInitPos());
    private int degree = Setting.getEnv().getRobotInitDegree();
    
    /**
     * Perform how the robot move
     */
    public abstract void execute();

    /**
     * @return the current position of robot
     */
    Position getPos() {
        return pos;
    }

    /**
     * The robot could turn around. The degree is the value that used to track the current robot turning.
     * @return the current degree of the robot.
     */
    int getDegree() {
        return degree;
    }

    /**
     * This method will retrieve the values of distance to wall around the robot in 8 directions. The front of robot is at 0 degree.
     * @return the integer array of 8 IR sensor values at degrees of 0, 45, 90, 135, 180, 225, 270, 315 respectively.
     */
    protected int[] getIRValues(){
        int[] values = new int[8];
        for(int i=0; i<8; i++) {
            int dis = 0;
            int direction = degree + i * 45;
            double tmp_x = pos.x + (Setting.getEnv().getRobotSize() * Math.cos(direction * Math.PI / 180));
            double tmp_y = pos.y + (Setting.getEnv().getRobotSize() * Math.sin(direction * Math.PI / 180));
            while(!CollisionLogic.isPointInWalls(tmp_x, tmp_y) && dis < Setting.getEnv().getRobotIrMaxDistance()) {
                dis += 1;
                tmp_x += 1 * Math.cos(direction * Math.PI / 180);
                tmp_y += 1 * Math.sin(direction * Math.PI / 180);
            }
            values[i] = dis;
        }
        return values;
    }
    
    /**
     * Move forward the robot for 3 pixels.
     */
    protected void moveForward() {
        double tmp_x = pos.x + (3*Math.cos(degree*Math.PI/180));
	    double tmp_y = pos.y + (3*Math.sin(degree*Math.PI/180));
        if(!CollisionLogic.isRobotInWall(tmp_x, tmp_y)) {
            pos.x = (int) tmp_x;
            pos.y = (int) tmp_y;
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
     * Get the array of angle between each food to the head of the robot.
     * @return the array of angle between the food and the front of the robot (-180 to 180 degrees).
     */
    protected int[] smellAllFoods() {
        Position[] foods = Setting.getEnv().getAllFoodPositions();
        int[] directions = new int[foods.length];
        for(int i=0; i<foods.length; i++) {
            int dx = foods[i].x - pos.x;
            int dy = foods[i].y - pos.y;
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
}