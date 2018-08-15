package simbot_core;

public class CollisionLogic {
    /**
     * Check whether the robot is at the valid or invalid position
     * @param robot_x the x position of the robot to be checked
     * @param robot_y the robot_y position of the robot to be checked
     * @return boolean to indicate that the robot is at valid position.
     */
    public static boolean isRobotInWall(double robot_x, double robot_y) {
        if(robot_x< Setting.getEnv().getRobotSize() || robot_x> Setting.getEnv().getMazeWidth()- Setting.getEnv().getRobotSize()
                || robot_y< Setting.getEnv().getRobotSize() || robot_y> Setting.getEnv().getMazeHeight()- Setting.getEnv().getRobotSize()) {
            return true;
        }
        for(Wall w : Setting.getEnv().getAllWalls()) {
            if( (robot_x+ Setting.getEnv().getRobotSize() >= w.x1 && robot_x- Setting.getEnv().getRobotSize() <= w.x2)
                    && (robot_y+ Setting.getEnv().getRobotSize() >= w.y1 && robot_y- Setting.getEnv().getRobotSize() <= w.y2) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the food is at the valid or invalid position
     * @param food_x the x position of the robot to be checked
     * @param food_y the robot_y position of the robot to be checked
     * @return boolean to indicate that the robot is at valid position.
     */
    public static boolean isFoodInWall(double food_x, double food_y) {
        if(food_x< Setting.getEnv().getFoodSize() || food_x> Setting.getEnv().getMazeWidth()- Setting.getEnv().getFoodSize()
                || food_y< Setting.getEnv().getFoodSize() || food_y> Setting.getEnv().getMazeHeight()- Setting.getEnv().getFoodSize()) {
            return true;
        }
        for(Wall w : Setting.getEnv().getAllWalls()) {
            if( (food_x+ Setting.getEnv().getFoodSize() >= w.x1 && food_x- Setting.getEnv().getFoodSize() <= w.x2)
                    && (food_y+ Setting.getEnv().getFoodSize() >= w.y1 && food_y- Setting.getEnv().getFoodSize() <= w.y2) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the robot is eating food.
     * @return index of food to be eat (-1 if none).
     */
    public static int checkRobotInFood(double robot_x, double robot_y) {
        Position[] foods = Setting.getEnv().getAllFoodPositions();
        for (int i=0; i<foods.length; i++) {
            Position f_pos = foods[i];
            if ((robot_x + Setting.getEnv().getRobotSize() >= f_pos.x)
                    && (robot_x - Setting.getEnv().getRobotSize() <= f_pos.x + Setting.getEnv().getFoodSize())
                    && (robot_y + Setting.getEnv().getRobotSize() >= f_pos.y)
                    && (robot_y - Setting.getEnv().getRobotSize() <= f_pos.y + Setting.getEnv().getFoodSize())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Check whether the (x,y) is in the valid or invalid position
     * @param x the x position of the robot to be checked
     * @param y the y position of the robot to be checked
     * @return boolean to indicate that the robot is at valid position.
     */
    public static boolean isPointInWalls(double x, double y) {
        if(x<0 || x> Setting.getEnv().getMazeWidth() || y<0 || y> Setting.getEnv().getMazeHeight()) {
            return true;
        }
        for(Wall w : Setting.getEnv().getAllWalls()) {
            if( (x >= w.x1 && x <= w.x2) && (y >= w.y1 && y <= w.y2) ) {
                return true;
            }
        }
        return false;
    }
}
