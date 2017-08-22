package simbot_program;

import simbot_core.SB_Food;
import simbot_core.SB_RobotPosition;
import simbot_core.SB_Wall;
import simbot_core.AbstractEnvironment;

/**
 *
 * @author Chattriya
 */
public class MyEnvironment implements AbstractEnvironment {
    private SB_Wall[] walls;
    public MyEnvironment() {
        walls = new SB_Wall[] {
            new SB_Wall(160, 20, 60, 30, "1"), // X, Y, Width, Height, Label
            new SB_Wall(60, 60, 40, 40, "2"),
            new SB_Wall(255, 80, 20, 60, "3"),
            new SB_Wall(150, 100, 50, 60, "4"),
            new SB_Wall(20, 150, 50, 30, "5"),
            new SB_Wall(290, 10, 70, 30, "6"),
            new SB_Wall(350, 80, 30, 70, "7"),
            new SB_Wall(150, 220, 240, 60, "8"),
            new SB_Wall(60, 220, 30, 20, "9"),
            new SB_Wall(460, 20, 60, 30, "10"),
            new SB_Wall(450, 90, 50, 60, "11"),
            new SB_Wall(450, 220, 100, 20, "12"),
            new SB_Wall(570, 70, 80, 175, "13"),
            new SB_Wall(20, 290, 60, 170, "14"),
            new SB_Wall(150, 370, 30, 20, "15"),
            new SB_Wall(250, 340, 70, 50, "16"),
            new SB_Wall(390, 370, 30, 20, "17"),
            new SB_Wall(510, 370, 30, 20, "18"),
            new SB_Wall(150, 460, 30, 20, "19"),
            new SB_Wall(270, 460, 30, 20, "20"),
            new SB_Wall(390, 460, 30, 60, "21"),
            new SB_Wall(510, 460, 60, 20, "22"),
            new SB_Wall(510, 280, 30, 20, "23"),
            new SB_Wall(120, 510, 140, 60, "24"),
            new SB_Wall(420, 390, 90, 70, "25"),
            new SB_Wall(610, 335, 90, 70, "26"),
        };
    }
    
    @Override
    public int getConstMazeWidth() {
        return 700;
    }
    
    @Override
    public int getConstMazeHeight() {
        return 600;
    }
    
    @Override
    public SB_Wall[] getConstWalls() {
        return walls;
    }
    
    @Override
    public SB_Food[] getConstFood() {
        SB_Food[] foods = { new SB_Food(530, 530, this), new SB_Food(500, 530, this) };
        return foods;
    }
    
    @Override
    public SB_RobotPosition getConstRobotInitPos() {
        return new SB_RobotPosition(20, 20);
    }
    
    @Override
    public int getConstRobotInitDegree() {
        return 0;
    }
    
    @Override
    public int getConstRobotRadius() {
        return 8;
    }
    
    @Override
    public int getConstRobotIrMaxDistance() {
        return 100;
    }
    
    @Override
    public int getConstSimulationRefreshMillis() {
        return 6;
    }
    
    @Override
    public int getConstSimulationMaxStep() {
        return 1500;
    }
    
    @Override
    public int getConstFoodSize() {
        return 20;
    }
    
}
