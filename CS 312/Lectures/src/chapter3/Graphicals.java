package chapter3;

import java.awt.Color; // importing only the Color class from the java.awt package
import java.awt.*; // imports all classes from the java.awt package

public class Graphicals {

	/* Definitions:
	 * 1. Object: An entity that contains data and behavior.
	 * 2. DrawingPanel: A drawing window GUI on the screen.
	 * 3. Graphics: A "pen" to draw shapes and lines on a window.
	 * 4. Color: Colors used to draw or fill shapes using RGB values.
	 * 		The default Color is BLACK.
	 * 5. Import: A keyword used to utilize classes inside other packages.
	 */

	/* Extra Notes
	 * 1. Constructing (creating) an object: Type objectName = new Type(parameters);
	 * 2. Calling an object's method: objectName.methodName(parameters);
	 * 3. Because of convention, object data-types are upper-case.
	 * 4. All shape (x,y) positions begin at the top-left corner.
	 * 5. The window x-position increases rightward, and the y-position increases downward!
	 * 6. Any Graphics created afterwards can overlap any Graphics created before it.
	 * 7. All Graphical shapes are inscribed inside a rectangle figure.
	 */

	public static void main(String[] args) {
		// creating a new DrawingPanel object with a WIDTH and HEIGHT of 500
		final int WIDTH = 500;
		final int HEIGHT = 500;
		DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);

		// setting the DrawingPanel's background color to BLACK
		panel.setBackground(Color.BLACK);

		// creating a new Graphics object that equals to the panel's Graphics object
		Graphics g = panel.getGraphics();

		// set the Color to WHITE, so any Graphics created afterwards is white
		g.setColor(Color.WHITE);

		// draw a line from (0,0) to (25,25)
		g.drawLine(0,0,25,25);

		// draw an oval with position (25,30) and width of 45 and height of 50
		g.drawOval(25, 30, 45, 50);

		// draw a rectangle with position (50,50) and width 45 and height 55
		g.drawRect(50, 50, 45, 55);

		// set the Color to RGB of BROWN, so any Graphics created afterwards is brown
		final Color BROWN = new Color(192,128,64);
		g.setColor(BROWN);

		// draw a String of "Hello World!" with position (100,100)
		g.drawString("Hello World!", 100, 100);

		// fill and oval with position (200,200) and width of 45 and height of 50
		g.fillOval(200, 200, 45, 50);

		// draw a rectangle with position (350,350) and width 45 and height 55
		g.fillRect(350, 350, 45, 55);

		/* rectangle with a red inner filling and white outline,
			also this overlaps on-top the rectangle at position (350,350).
			<- Read Extra Notes #6 for more info. */
		g.setColor(Color.RED);
		g.fillRect(350, 400, 100, 50); // filling must go first
		g.setColor(Color.WHITE);
		g.drawRect(350, 400, 100, 50); // draw (outline) must go last
	}
}
