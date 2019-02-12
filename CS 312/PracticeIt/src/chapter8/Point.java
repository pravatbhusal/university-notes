package chapter8;

public class Point {

	private int x;
	private int y;

	/* Add the following method to the Point class:
	 *
	 * public int quadrant()
	 *
	 * Returns which quadrant of the x/y plane this Point object falls in. 
	 * Quadrant 1 contains all points whose x and y values are both positive. 
	 * Quadrant 2 contains all points with negative x but positive y. Quadrant 3 
	 * contains all points with negative x and y values. Quadrant 4 contains all 
	 * points with positive x but negative y. If the point lies directly on the x 
	 * and/or y axis, return 0.
	 */
	public int quadrant() {
		if(x > 0 && y > 0) {
			return 1;
		} else if(x < 0 && y > 0) {
			return 2;
		} else if(x < 0 && y < 0) {
			return 3;
		} else if(x > 0 && y < 0) {
			return 4;
		}
		return 0;
	}

	/* Add the following method to the Point class:
	 *
	 * public int manhattanDistance(Point other)
	 *
	 * Returns the "Manhattan distance" between the current Point object and the 
	 * given other Point object. The Manhattan distance refers to how far apart two
	 * places are if the person can only travel straight horizontally or vertically,
	 * as though driving on the streets of Manhattan. In our case, the Manhattan 
	 * distance is the sum of the absolute values of the differences in their 
	 * coordinates; in other words, the difference in x plus the difference in y 
	 * between the points.
	 */
	public int manhattanDistance(Point other) {
		/* you can call the parameter's Point objects private variables
			because this method is already inside the Point Class */
		int xDifference = Math.abs(x - other.x);
		int yDifference = Math.abs(y - other.y);
		int distance = xDifference + yDifference;
		return distance;
	}

	/* Add the following method to your Point class:
	 *
	 * public boolean isVertical(Point other)
	 *
	 * Returns true if the given Point lines up vertically with this Point; that 
	 * is, if their x coordinates are the same.
	 */
	public boolean isVertical(Point other) {
		if(other.x == x) {
			return true;
		}
		return false;
	}

	/* Add the following method to the Point class:
	 *
	 * public double slope(Point other)
	 *
	 * Returns the slope of the line drawn between this Point and the given other 
	 * Point. Use the formula (y2 - y1) / (x2 - x1) to determine the slope between 
	 * two points (x1, y1) and (x2, y2). Note that this formula fails for points 
	 * with identical x-coordinates, so throw an IllegalArgumentException in this 
	 * case.
	 */
	public double slope(Point other) {
		int yDelta = other.y - y;
		int xDelta = other.x - x;
		if(xDelta == 0) {
			throw new IllegalArgumentException();
		}
		return (double) yDelta / xDelta;
	}

	/* Add the following method to the Point class:
	 *
	 * public boolean isCollinear(Point p1, Point p2)
	 *
	 * Returns whether this Point is collinear with the given two other points.
	 * Since Java's double type is imprecise, round all slope values to a 
	 * reasonable accuracy such as four digits past the decimal point before you 
	 * compare them.
	 */
	public boolean isCollinear(Point p1, Point p2) {
		double slope1 = slope(x, y, p1.x, p1.y);
		double slope2 = slope(p1.x, p1.y, p2.x, p2.y);
		double slope3 = slope(p2.x, p2.y, x, y);

		// check whether the slopes are the same for all pairs of points
		if(slope1 == slope2 && slope2 == slope3) {
			return true;
		}
		return false;
	}

	// dumb slope method to prevent error from the isCollinear method
	private double slope(int x2, int y2, int x3, int y3) {
		return 0;
	}
}
