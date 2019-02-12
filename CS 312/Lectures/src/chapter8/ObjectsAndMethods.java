package chapter8;

public class ObjectsAndMethods {

	/* Definitions:
	 * 1. Constructor: Methods used to initialize the object's state.
	 * 		- Constructors can be overloaded
	 * 		- The default constructor, when not defined, has zero parameters
	 * 2. this: Refers to the implicit parameter inside a class.
	 * 		- A final (constant) Object that stores the methods and variables of the class
	 * 		- It can be accessed anywhere in the class
	 * 		- It can also pass parameters to call the constructor; however, it must be
	 * 			called only inside a constructor as the first line of code.
	 * 			- EX: this(35, 75) for City.java
	 * 3. Encapsulation: Hiding implementation details from the client.
	 * 		Also referred to as "scope."
	 * 		- public keyword: can be accessed anywhere
	 * 		- private keyboard: can be accessed only inside the class
	 * 		- protected keyboard: can be accessed only in the package and subclasses
	 * 4. Shadowing: 2 variables with the same name in the same scope
	 * 5. Accessor Methods: Instance methods that return data.
	 * 		- For example, getX method in City.java
	 * 6. Mutator Methods: Instance methods that change data.
	 * 		- For example: addCords in City.java
	 * 		- Constructors are NOT instance methods, so they're not mutators
	 */

	/* Extra Notes:
	 * 1. Using an Object as a String calls the toString method within the Object's class
	 * 		- All Objects in Java have a default toString and equals method that is called
	 */

	/* Programming Hygiene Tips:
	 * 1. It is OK to have methods to return private variables.
	 * 		- These methods can be one-liners that only return the values
	 * 		- Look at the City.java's getXDelta method as an example
	 */

	public static void main(String[] args) {
		// creating new dallas, austin, and houston City Objects
		City dallas = new City(35, 58);
		City austin = new City(93,100);

		// set to default constructor <- Read Definitions #1 for more info
		City houston = new City(); 

		System.out.println(austin.getXDelta(dallas)); // outputs: 58
		System.out.println(austin.getYDelta(dallas)); // outputs: 42

		System.out.println(houston.getX()); // outputs: 0 <- Read Definitions #5 for more info
		System.out.println(houston.getY()); // outputs: 0 <- Read Definitions #5 for more info

		City.CITY_EXISTS = false; // setting a static variable to false, so all instances get updated
		System.out.println(City.CITY_EXISTS); // false
		System.out.println(City.cityExists()); // false <- Read Definitions #5 for more info

		// reference semantics with Objects
		City newYork = new City(38, 25);
		changePoints(newYork, 35, 78);
		System.out.println(newYork); // outputs: (73, 103) <- Read Extra Notes #1 for more info
	}

	public static void changePoints(City city, int x, int y) {
		city.addCoords(x, y);
	}
}
