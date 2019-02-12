package chapter8;

public class Point {

	// instance variables, state, fields
	// by default, the scope is public
	int x;
	int y;

	// example of an instance method
	// outputs the x and y points
	public void outputPoints() {
		System.out.println(x);
		System.out.println(y);
	}

	// outputs the points inside the parameters
	public void outputOtherPoints(int x, int y) {
		System.out.println(x);
		System.out.println(y);
	}
}