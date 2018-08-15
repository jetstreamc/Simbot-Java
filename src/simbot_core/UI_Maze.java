package simbot_core;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chattriya
 */
public class UI_Maze extends javax.swing.JPanel{

    private Wall[] walls;
    private Position[] foods;
    private List<AbstractRobot> robots;
    private AbstractEnv env;
    /**
     * Creates new form mazePanel
     */
    UI_Maze(){
        env = Setting.getEnv();
        initComponents();
        setPreferredSize(new java.awt.Dimension(env.getMazeWidth(), env.getMazeHeight()));
        this.walls = env.getAllWalls();
        this.foods = env.getAllFoodPositions();
        robots = new ArrayList<>();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Wall m : walls)
        {    
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(m.x1, m.y1, (m.x2-m.x1), (m.y2-m.y1));
            g.setColor(Color.GRAY);
            g.drawRect(m.x1, m.y1, (m.x2-m.x1), (m.y2-m.y1));
            g.setColor(Color.BLACK);
            g.drawString(m.label, (m.x1+m.x2)/2, (m.y1+m.y2)/2);
        }
        
        for(AbstractRobot r : robots)
        {

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.GRAY);
            g2.drawArc(r.getPos().x - env.getRobotSize(), r.getPos().y - env.getRobotSize(), 2*env.getRobotSize(), 2 * env.getRobotSize(), 0, 360);
            g2.setStroke(new BasicStroke(1));
            g2.setColor(Color.DARK_GRAY);
            g2.drawLine(r.getPos().x, r.getPos().y, (int) (r.getPos().x+env.getRobotSize()*Math.cos(r.getDegree()*Math.PI/180.0)), (int) (r.getPos().y+env.getRobotSize()*Math.sin(r.getDegree()*Math.PI/180.0)));
            g2.fillRect(r.getPos().x+(int)((env.getRobotSize()-2)*Math.cos(r.getDegree()*Math.PI/180))-2
                        ,r.getPos().y+(int)((env.getRobotSize()-2)*Math.sin(r.getDegree()*Math.PI/180))-2
                        ,4
                        ,4
            );
        }

        g.setColor(Color.GREEN);
        for (Position food : foods) {
            g.fillRoundRect(food.x, food.y, env.getFoodSize(), env.getFoodSize(), 5, 5);
        }
    }
    
    void drawRobots(List<AbstractRobot> robots) {
        this.robots = robots;
        this.repaint();
    }

    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(500, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
    }
}
