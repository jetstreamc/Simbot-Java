package simbot_core;

import simbot_program.MyEnvironment;
import java.util.List;

/**
 *
 * @author Chattriya
 */
public abstract class AbstractSimulation {    
    protected JForm_Simulation sim_ui;
    protected boolean uiEnabled;
    protected boolean isPause;
    protected List<AbstractRobot> robots;
    protected int countStep;
    AbstractEnvironment env;
            
    /**
     * 
     * @param robots the robots to be move in the maze.
     * @param sim_ui the UI for simulation program. Set null to disable the user interface.
     */
    public AbstractSimulation(List<AbstractRobot> robots, JForm_Simulation sim_ui) {
        this.env = new MyEnvironment();
        this.robots = robots;
        this.countStep = 0;
        this.sim_ui = sim_ui;
        this.uiEnabled = (sim_ui != null);
        if(uiEnabled) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    sim_ui.setVisible(true);
                }
            });
        }
    }
    
    public void setENV(AbstractEnvironment env) {
        this.env = env;
    }

    /**
     *  Start to perform the simulation
     */
    public void startSimulation() throws InterruptedException {
        countStep = 0;
        isPause = false;
        if(uiEnabled) {
            int delay = env.getConstSimulationRefreshMillis();
            while(!stopCondition()) {
                stepSimulation();
                Thread.sleep(delay);
            }
        }
        else {
            while(!stopCondition()) {
                stepSimulation();
            }
        }
    }
    
    public void closeUI() {
        if(uiEnabled) {
            sim_ui.dispose();
        }
    }
    
    /**
     * perform a single step of the simulation
     */
    protected void stepSimulation () {
        if(uiEnabled && sim_ui.isPause()) 
        {
            return;
        }
        if(uiEnabled) 
        { 
            stepWithUI(); 
        }
        else 
        { 
            stepWithoutUI(); 
        }
        countStep++;
        finishSingleStep();
        if(stopCondition() == true)
        {
            finishSimulation();
        }
    }
    
    /**
     *
     * @return true - if the simulation reach the terminate condition.
     * false - if not
     */
    protected boolean stopCondition() {
        return env.getConstSimulationMaxStep() < countStep;
    }
    
    /**
     * Specify what to do for each non-UI simulation at each step
     */
    protected abstract void stepWithoutUI();
    
    /**
     *  Specify what to do for each UI-supported simulation at each step
     */
    protected abstract void stepWithUI() ;
    
    /**
     *  Specify what to do after ending the step
     */
    protected abstract void finishSingleStep();
    
    /**
     *  Specify what to do after end the simulation
     */
    protected abstract void finishSimulation();
}
