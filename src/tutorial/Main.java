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

package tutorial;

import simbot_core.AbstractRobot;
import simbot_core.AbstractSimulation;
import simbot_core.Setting;
import simbot_core.UI_Simulation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chattriya
 */
public class Main {
    
    public static void main(String args[]) {
        Setting.setEnv(new SampleEnv());

        List<AbstractRobot> robots = new ArrayList<>();
        for (int i=0; i<10; i++) {
            robots.add(new StupidRobot());
        }

        /* run simulation without GUI */
        AbstractSimulation sim = new Simulation(robots);
        sim.startSimulation();

        /* run simulation with GUI */
        UI_Simulation ui = new UI_Simulation();
        AbstractSimulation sim2 = new Simulation(robots, ui);
        sim2.startSimulation();
    }
}
