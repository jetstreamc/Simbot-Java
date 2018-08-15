package tutorial;

import simbot_core.AbstractEnv;
import simbot_core.Position;
import simbot_core.Wall;

/**
 * The singleton environment object for simulation
 * @author Chattriya
 */
public class SampleEnv extends AbstractEnv {

    @Override
    public int getMazeWidth() {
        return 700;
    }

    @Override
    public int getMazeHeight() {
        return 600;
    }

    @Override
    public Wall[] getAllWalls() {
        return new Wall[] {
//                new Wall(160, 20, 60, 30, "1"),
//                new Wall(60, 60, 40, 40, "2"),
//                new Wall(255, 80, 20, 60, "3"),
//                new Wall(150, 100, 50, 60, "4"),
//                new Wall(20, 150, 50, 30, "5"),
//                new Wall(290, 10, 70, 30, "6"),
//                new Wall(350, 80, 30, 70, "7"),
//                new Wall(150, 220, 240, 60, "8"),
//                new Wall(60, 220, 30, 20, "9"),
//                new Wall(460, 20, 60, 30, "10"),
//                new Wall(450, 90, 50, 60, "11"),
//                new Wall(450, 220, 100, 20, "12"),
//                new Wall(570, 70, 80, 175, "13"),
//                new Wall(20, 290, 60, 170, "14"),
//                new Wall(150, 370, 30, 20, "15"),
//                new Wall(250, 340, 70, 50, "16"),
//                new Wall(390, 370, 30, 20, "17"),
//                new Wall(510, 370, 30, 20, "18"),
//                new Wall(150, 460, 30, 20, "19"),
//                new Wall(270, 460, 30, 20, "20"),
//                new Wall(390, 460, 30, 60, "21"),
//                new Wall(510, 460, 60, 20, "22"),
//                new Wall(510, 280, 30, 20, "23"),
//                new Wall(120, 510, 140, 60, "24"),
//                new Wall(420, 390, 90, 70, "25"),
//                new Wall(610, 335, 90, 70, "26"),
        };
    }

    @Override
    public Position[] getAllFoodPositions() {
        return new Position[]{new Position(30, 30), new Position(500, 530)};
    }

    @Override
    public Position getRobotInitPos() {
        return new Position(20, 20);
    }

    @Override
    public int getRobotInitDegree() {
        return 0;
    }

    @Override
    public int getRobotSize() {
        return 8;
    }

    @Override
    public int getRobotIrMaxDistance() {
        return 100;
    }

    @Override
    public int getSimulationRefreshMillis() {
        return 6;
    }

    @Override
    public int getSimulationMaxStep() {
        return 2500;
    }

    @Override
    public void handleRobotEatFood(int foodToEat) {
        System.out.println("Food number "+foodToEat+ " is ate");
    }

    @Override
    public int getFoodSize() {
        return 20;
    }
    
}
