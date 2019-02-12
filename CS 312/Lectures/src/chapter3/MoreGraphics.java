package chapter3;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class MoreGraphics {

	public static void main(String[] args) {
		// create the new DrawingPanel
		final int WIDTH = 100;
		final int HEIGHT = 100;
		DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);

		// create the Graphics object
		Graphics g = panel.getGraphics();
		createTriangle(g, 10, 90, 50, 10, 90, 90);
	}

	// parameterized method to create a triangle polygon
	public static void createTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
		// create a new Polygon object, and add points
		Polygon triangle = new Polygon();
		triangle.addPoint(x1, y1);
		triangle.addPoint(x2, y2);
		triangle.addPoint(x3, y3);

		// fill the Polygon as the triangle
		g.fillPolygon(triangle);

		// draw a red border around the triangle
		g.setColor(Color.RED);
		g.drawPolygon(triangle);
	}
}
