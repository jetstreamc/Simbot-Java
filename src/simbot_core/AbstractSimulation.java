package simbot_core;

import java.util.List;

/**
 *
 * @author Chattriya
 */
public abstract class AbstractSimulation {

    private UI_Simulation sim_ui;
    private boolean uiEnabled;

    protected List<AbstractRobot> robots;
    protected int currentStep = 0;
    protected AbstractEnv env = Setting.getEnv();

    /**
     *
     * @param robots the robots to be move in the maze.
     */
    public AbstractSimulation(List<AbstractRobot> robots) {
        this.robots = robots;
    }

    /**
     * 
     * @param robots the robots to be move in the maze.
     * @param ui the UI for simulation program.
     */
    public AbstractSimulation(List<AbstractRobot> robots, UI_Simulation ui) {
        this.robots = robots;
        this.sim_ui = ui;
        this.uiEnabled = (ui != null);
        if(uiEnabled) {
            java.awt.EventQueue.invokeLater(() -> ui.setVisible(true));
        }
    }

    /**
     * Start the simulation
     */
    public void startSimulation() {
        currentStep = 0;
        beforeSimulation();
        while(!meetStoppingCriteria()) {
            beforeStep();
            currentStep++;
            for(AbstractRobot r:robots) {
                r.execute();
                if (uiEnabled) {
                    sim_ui.drawIR(r.getIRValues());
                    sim_ui.drawDirection(r.smellAllFoods());
                }
                int foodToEat = CollisionLogic.checkRobotInFood(r.getPos().x, r.getPos().y);
                if (foodToEat >= 0) {
                    env.handleRobotEatFood(foodToEat);
                }
            }
            afterStep();
            if (uiEnabled) {
                sim_ui.drawRobots(robots);
                sim_ui.drawCountStep(currentStep);
                try {
                    Thread.sleep(env.getSimulationRefreshMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        afterSimulation();
    }

    /**
     * Check whether the simulation should be stop or not
     * @return true if the simulation should be stopped
     */
    public abstract boolean meetStoppingCriteria();

    /**
     *  Specify what to do before starting a step
     */
    protected abstract void beforeStep();

    /**
     *  Specify what to do after ending a step
     */
    protected abstract void afterStep();

    /**
     *  Specify what to do before starting the simulation
     */
    protected abstract void beforeSimulation();

    /**
     *  Specify what to do after ending the simulation
     */
    protected abstract void afterSimulation();
}
