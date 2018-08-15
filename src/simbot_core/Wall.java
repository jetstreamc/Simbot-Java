package simbot_core;

/**
 *
 * @author Chattriya
 */
public class Wall {
    int x1, x2, y1, y2;
    String label;
    
    /**
     * 
     * @param x the x position of wall at the top left.
     * @param y the y position of wall at the top left.
     * @param width the width of wall.
     * @param height the height of wall.
     */
    public Wall(int x, int y, int width, int height) {
        this(x, y, width, height, "");
    }
    
    /**
     * 
     * @param x the x position of wall at the top left.
     * @param y the y position of wall at the top left.
     * @param width the width of wall.
     * @param height the height of wall.
     * @param label the text to be displayed on wall.
     */
    public Wall(int x, int y, int width, int height, String label)
    {
        this.x1 = x;
        this.x2 = x+width;
        this.y1 = y;
        this.y2 = y+height;
        this.label = label;
    }
}
