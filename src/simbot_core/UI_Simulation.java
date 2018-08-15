package simbot_core;

import java.util.Arrays;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import static javax.swing.GroupLayout.*;

/**
 *
 * @author Chattriya
 */
public final class UI_Simulation extends javax.swing.JFrame {

    public UI_Simulation() {
        initComponents();
    }

    private void initComponents() {
        JPanel panelLog = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        lbRunningStep = new JLabel();
        lbSmellDirection = new JLabel();
        irPanel = new UI_IrSensors();
        mazePanel = new UI_Maze();
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu menuExit = new javax.swing.JMenu();
        javax.swing.JMenu menuCredit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Running Steps: ");
        jLabel2.setText("Smell Direction: ");

        lbRunningStep.setText("0");
        lbSmellDirection.setText("0");

        GroupLayout panelLogLayout = new GroupLayout(panelLog);
        panelLog.setLayout(panelLogLayout);
        panelLogLayout.setHorizontalGroup(
            panelLogLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, panelLogLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelLogLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel2, Alignment.TRAILING, DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel1, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(panelLogLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(lbRunningStep, DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lbSmellDirection, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelLogLayout.setVerticalGroup(
            panelLogLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addGroup(panelLogLayout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(jLabel1, DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(lbRunningStep, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLogLayout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel2, PREFERRED_SIZE, 32, PREFERRED_SIZE)
                    .addComponent(lbSmellDirection, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        GroupLayout irPanelLayout = new GroupLayout(irPanel);
        irPanel.setLayout(irPanelLayout);
        irPanelLayout.setHorizontalGroup(
            irPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        irPanelLayout.setVerticalGroup(
            irPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        GroupLayout mazePanelLayout = new GroupLayout(mazePanel);
        mazePanel.setLayout(mazePanelLayout);
        mazePanelLayout.setHorizontalGroup(
            mazePanelLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        mazePanelLayout.setVerticalGroup(
            mazePanelLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        menuExit.setText("Exit");
        menuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExitMouseClicked();
            }
        });
        menuBar.add(menuExit);

        menuCredit.setText("Credit");
        menuCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCreditMouseClicked();
            }
        });
        menuBar.add(menuCredit);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mazePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(panelLog, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addComponent(irPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(mazePanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelLog, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(irPanel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                .addContainerGap(DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Mouse clicked event to stop the program.
     */
    private void menuExitMouseClicked() {
        System.exit(0);
    }

    /**
     * Mouse clicked event to show the credit.
     */
    private void menuCreditMouseClicked() {
        JOptionPane.showMessageDialog(this, "This program was originally developed by Chattriya Jariyavajee.", "Creator", JOptionPane.INFORMATION_MESSAGE);
    }

    private UI_IrSensors irPanel;
    private JLabel lbRunningStep;
    private JLabel lbSmellDirection;
    private UI_Maze mazePanel;

    /**
     * Draw the UI of 8 IR sensors.
     * @param evt 
     */
    void drawIR(int[] irValues) {
        irPanel.drawIRValue(irValues);
    }

    /**
     * Draw robots in maze. 
     * @param robots the list of {@link AbstractRobot}
     */
    void drawRobots(List<AbstractRobot> robots) {
        mazePanel.drawRobots(robots);
    }

    /**
     * Draw the number of currentStep into the label
     * @param countStep the current step number
     */
    void drawCountStep(int countStep) {
        SwingUtilities.invokeLater(() -> lbRunningStep.setText("" + countStep));
    }

    /**
     * Draw the number of smell direction into the label
     * @param direction the array of direction to foods position
     */
    void drawDirection(int[] direction) {
        SwingUtilities.invokeLater(() -> lbSmellDirection.setText("" + Arrays.toString(direction)));
    }
}
