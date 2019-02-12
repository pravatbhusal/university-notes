package chapter3;

import java.awt.Graphics;

public class ShowDesign {
    public static void main(String[] args) {
        final int PANEL_WIDTH = 200;
        final int PANEL_HEIGHT = 200;
        
        // create and initialize the panel and graphics objects
        DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
        Graphics g = panel.getGraphics(); // default Graphics color is BLACK
        
        int numSquares = 4; // number of squares to create
        int x = 20; // initial x-value
        int y = 20; // initial y-value
        int width = 160; // initial width
        int height = 160; // initial height
        int widthFraction = width / numSquares; // 40px
        int heightFraction = height / numSquares; // 40px
        
        for(int i = 0; i < numSquares; i++) {
            g.drawRect(x, y, width, height);
            
            // decrease the width and height by 40px every iteration
            width -= widthFraction;
            height -= heightFraction;
            
            // increase the x and y by 20px every iteration
            x += widthFraction / 2;
            y += heightFraction / 2;
        }
    }
}
