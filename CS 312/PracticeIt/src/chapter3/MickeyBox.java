package chapter3;

import java.awt.Color;
import java.awt.Graphics;

public class MickeyBox {
    public static void main(String[] args) {
        final int WIDTH = 220;
        final int HEIGHT = 150;
        
        // create and initialize the panel and graphics objects
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        panel.setBackground(Color.YELLOW);
        Graphics g = panel.getGraphics();
        
        // create the two blue ovals
        g.setColor(Color.BLUE);
        g.fillOval(50,25,40,40);
        g.fillOval(130,25,40,40);
        
        // create the red rectangle
        g.setColor(Color.RED);
        /* the coordinate is (75,45) because the left blue circle's radius is 20.
            the height and width are 80 because it's a square,
            and the blue circles are 80 px apart. */
        g.fillRect(70,45,80,80);
        
        // create the black line in-between the red rectangle
        g.setColor(Color.BLACK);
        /* the (x1,y1) coordinate is (70,85) because the red rectangle's x starts at 70,
            and the line is in the middle which is plus 40 pixels down the rectangle's y.
            the (x2,y2) is (150,85) because the rectangle's x ends at 150, and the line
            is also in the middle which is plus 40 pixels down the rectangle's y.
            */
        g.drawLine(70,85,150,85);
    }
}
