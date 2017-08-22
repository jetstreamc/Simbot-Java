/*
 * Copyright 2016 Chattriya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package simbot_program;

import java.util.ArrayList;
import java.util.List;
import simbot_core.AbstractRobot;
import simbot_core.AbstractSimulation;
import simbot_core.JForm_Simulation;

/**
 *
 * @author Chattriya
 */
public class Main {
    
    public static void main(String args[]) throws InterruptedException {
        List<AbstractRobot> robots = new ArrayList<AbstractRobot> ();
        for (int i=0; i<10; i++) {
            robots.add(new MyRobot());
        }
        
        JForm_Simulation sim_ui = new JForm_Simulation();
        AbstractSimulation sim = new MySimulation(robots, sim_ui);
        sim.startSimulation();
    }
}
