package simbot_program;

import java.util.List;
import simbot_core.AbstractRobot;
import simbot_core.AbstractSimulation;
import simbot_core.JForm_Simulation;

/**
 *
 * @author Chattriya
 */
public class MySimulation extends AbstractSimulation{
    
    /**
     * 
     * @param robots The set of robot to be run on simulation.
     * @param sim_ui UI of simulation, set @null to disable the User Interface.
     */
    MySimulation(List<AbstractRobot> robots, JForm_Simulation sim_ui) {
        super(robots, sim_ui);
    }

    @Override
    public void finishSingleStep() {
        System.out.println("Finish Step: " + countStep);
    }

    @Override
    public void finishSimulation() {
        System.out.println("Finish simulation");
    }

    @Override
    protected void stepWithoutUI() {
        for(AbstractRobot r:robots) {
            r.execute();
        }
    }

    @Override
    protected void stepWithUI() {
        for(AbstractRobot r:robots) {
            r.execute();
            sim_ui.drawIR(r.getIRValues());
            sim_ui.drawDirection(r.getDirectionToFood());
        }
        sim_ui.drawRobots(robots);
        sim_ui.drawCountStep(countStep);
    }
}
