package simbot_core;

/**
 *
 * @author Chattriya
 */
public class SB_Food {
    public int x, y, width, height;
    /**
     * 
     * @param x the x position of the food at top left.
     * @param y the y position of the food at top left
     * @param env
     */
    public SB_Food(int x, int y, AbstractEnvironment env) {
        this.x = x;
        this.y = y;
        this.width = env.getConstFoodSize();
        this.height = env.getConstFoodSize();
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
