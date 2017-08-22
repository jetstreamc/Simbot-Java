package simbot_core;

/**
 *
 * @author Chattriya
 */


public interface AbstractEnvironment {
    
    public int getConstMazeWidth();
    
    public int getConstMazeHeight();
    
    public SB_Wall[] getConstWalls();
    
    public SB_Food[] getConstFood();
    
    public SB_RobotPosition getConstRobotInitPos();
    
    public int getConstRobotInitDegree();
    
    public int getConstRobotRadius();
    
    public int getConstRobotIrMaxDistance();
    
    public int getConstSimulationRefreshMillis();
    
    public int getConstSimulationMaxStep();
    
    public int getConstFoodSize();
}
