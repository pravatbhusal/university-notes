package chapter3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle {
    public static void main(String[] args) {
        final int WIDTH = 600;
        final int HEIGHT = 200;
        
        // create the drawing panel
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        panel.setBackground(Color.YELLOW);
        Graphics g = panel.getGraphics();
        
        // create two diagonal lines that connect at the bottom in the middle
        g.setColor(Color.BLUE);
        g.drawLine(0,0,300,200);
        g.drawLine(600,0,300,200);
        
        // create 19 blue triangles (not 20 because the two diagonal lines is the 20th)
        for(int i = 0; i < 19; i++) {
            // decrease the triangle by a vertical spacing of 10px between lines
            final int LEFT_POINT_X = 15 + (i * 15);
            final int LEFT_POINT_Y = 10 + (i * 10);
            final int RIGHT_POINT_X = 585 - (i * 15);
            final int RIGHT_POINT_Y = 10 + (i * 10);
            
            // create the triangle
            Polygon triangle = new Polygon();
            triangle.addPoint(LEFT_POINT_X,LEFT_POINT_Y); // left point
            triangle.addPoint(RIGHT_POINT_X,RIGHT_POINT_Y); // right point
            triangle.addPoint(300,200); // bottom point (same for all triangles)
            g.drawPolygon(triangle);
        }
    }
}