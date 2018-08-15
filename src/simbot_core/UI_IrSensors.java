package simbot_core;

import java.awt.Graphics;

/**
 *
 * @author Chattriya
 */
public class UI_IrSensors extends javax.swing.JPanel {

    private int[] irValues;

    UI_IrSensors() {
        this.irValues = new int[]{100, 100, 100, 100, 100, 100, 100, 100};
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();
        g.drawArc(w/4, h/4, w/2, h/2, 0, 360);
        g.drawLine(w/2, h/2, 3*w/4-10, h/2);
        g.drawArc(3*w/4-8, h/2-4, 8, 8, 0, 360);
        g.drawString(""+irValues[0], 3*w/4 + 5, h/2 + 5);
        g.drawString(""+irValues[1], 5*w/8 + 10, 5*h/8 + 15);
        g.drawString(""+irValues[2], w/2 - 12, 3*h/4 + 15);
        g.drawString(""+irValues[3], 3*w/8 - 30, 3*h/4 + 5);
        g.drawString(""+irValues[4], w/4 - 25, h/2 + 5);
        g.drawString(""+irValues[5], 3*w/8 - 30, 3*h/8 - 5);
        g.drawString(""+irValues[6], w/2 - 12, h/4 - 5);
        g.drawString(""+irValues[7], 5*w/8 + 10, 3*h/8 - 5);
    }
    
    void drawIRValue(int[] irValues)
    {
        this.irValues = irValues;
        this.repaint();
    }

    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(130, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );
    }
}
