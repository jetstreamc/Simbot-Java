package tutorial;

import java.util.Random;
import simbot_core.AbstractRobot;


public class StupidRobot extends AbstractRobot {

    private Random random = new Random();

    @Override
    public void execute() {
        int[] directionsToFood = this.smellAllFoods();
        int[] distanceAround = this.getIRValues();

        int randomVal = random.nextInt(3);
        if(randomVal == 0) this.moveForward();
        if(randomVal == 1) this.spinLeft();
        if(randomVal == 2) this.spinRight();
    }
}
