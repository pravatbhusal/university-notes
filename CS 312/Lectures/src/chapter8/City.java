package chapter8;

public class City {

	// instance variables, some of the fields and state
	// the "private" keyboard means it's encapsulated to only this class
	private int x;
	private int y;

	// static variables, some of the fields and state
	// CITY_EXISTS is public, so it can be accessed anywhere
	public static boolean CITY_EXISTS = true;

	// default constructor
	public City() {
		this(35, 75); // set default coords as 35 and 75
	}

	// (overloaded) initialize x and y constructor
	public City(int x, int y) {
		// example of shadowing
		this.x = x; // the instance variable x now equals parameter x
		this.y = y; // the instance variable y now equals parameter y
	}

	// return the x-value
	public int getX() {
		return x;
	}

	// return the y-value
	public int getY() {
		return y;
	}

	/* return the change in x-values between the
		parameter's city and this city Object */
	public int getXDelta(City city) {
		return Math.abs(city.x - x);
	}

	/* return the change in y-values between the
		parameter's city and this city Object */
	public int getYDelta(City city) {
		return Math.abs(city.y - y);
	}

	// add to x and y
	public void addCoords(int addX, int addY) {
		x += addX;
		y += addY;
	}

	// a static method that checks if the city exists
	public static boolean cityExists() {
		// in static methods, we cannot use instance variables or methods
		// therefore, we can only use static variables and methods
		return CITY_EXISTS;
	}

	// the print, println, or printf methods will call this
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}