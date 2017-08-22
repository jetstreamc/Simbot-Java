package simbot_program;

import java.util.Random;
import simbot_core.AbstractRobot;


public class MyRobot extends AbstractRobot {

    Random r;
    public MyRobot() {
        super();
        r = new Random();
    }

    @Override
    public void execute() {
        int choice = r.nextInt(3);
        if(choice == 0) this.moveForward();
        if(choice == 1) this.spinLeft();
        if(choice == 2) this.spinRight();
    }
}
