package chapter3;

import java.awt.Color;
import java.awt.Graphics;

public class Squares {
    public static void main(String[] args) {
        final int WIDTH = 300;
        final int HEIGHT = 200;
        
        // create drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();
        
        // create red boxes
        g.setColor(Color.RED);
        for(int i = 0; i < 5; i++) {
            // decrease the height/width of each box by 20 for every increment of i
            final int BOX_WIDTH = 100 - (i * 20);
            final int BOX_HEIGHT = 100 - (i * 20);
            g.drawRect(50,50,BOX_WIDTH,BOX_HEIGHT);
        }
        
        // create diagonal line
        g.setColor(Color.BLACK);
        g.drawLine(50,50,150,150);
    }
}
