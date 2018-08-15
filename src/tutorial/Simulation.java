package tutorial;

import simbot_core.AbstractRobot;
import simbot_core.AbstractSimulation;
import simbot_core.UI_Simulation;

import java.util.List;

public class Simulation extends AbstractSimulation {

    Simulation(List<AbstractRobot> robots) {
        super(robots);
    }

    Simulation(List<AbstractRobot> robots, UI_Simulation ui) {
        super(robots, ui);
    }

    @Override
    public boolean meetStoppingCriteria() {
        return env.getSimulationMaxStep() <= this.currentStep;
    }

    @Override
    protected void beforeStep() {
        System.out.println("Start Step: " + this.currentStep);
    }

    @Override
    protected void afterStep() {
        System.out.println("Finish Step: " + this.currentStep);
        System.out.println();
    }

    @Override
    protected void beforeSimulation() {
        System.out.println("Start AbstractSimulation");
    }

    @Override
    protected void afterSimulation() {
        System.out.println("Finish simulation");
    }
}
