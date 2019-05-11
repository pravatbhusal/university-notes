package chapter9;

public class Interfaces implements ImplementedParent {

	/* Definitions:
	 * 1. Interface: a reference type, similar to a class, that can only contain
	 * 		constants, methods, and nested types. Interfaces are seen as an
	 * 		organized mechanism to use when there are very similar classes.
	 * 		- Can act as APIs (Application Programming Interfaces)
	 */

	/* Extra Notes:
	 * 1. If a class implements an interface, then all of the methods
	 * 		within the interface must be added into the class.
	 * 		- The class that implements the interface must override the methods
	 * 2. Interfaces cannot have instance variables
	 * 		- However, interfaces can have public, static, final variables
	 * 3. Interfaces must have public methods.
	 * 4. Interfaces can have implemented static methods.
	 * 5. Interfaces can be implemented by a class an INFINITE number of times (separated by commas)
	 * 6. Methods inside the interface Object do NOT have a body.
	 */

	public Interfaces() {
		// utilizing variables from the interface
		System.out.println(EYE_COLOR); // output: BLACK
		System.out.println(HAIR_COLOR); // output: BLACK
		System.out.println(SKIN_COLOR); // output: BROWN
		System.out.println(getName()); // output: Bob
		
		// using an implemented static method from the interface
		ImplementedParent.sayHello();
	}

	// implemented from the ImplementedParent interface
	@Override
	public String getEyeColor() {
		return EYE_COLOR;
	}

	// implemented from the ImplementedParent interface
	@Override
	public String getHairColor() {
		return HAIR_COLOR;
	}

	// implemented from the ImplementedParent interface
	@Override
	public String getSkinColor() {
		return SKIN_COLOR;
	}

	// implemented from the ImplementedParent interface
	@Override
	public String getName() {
		return NAME;
	}
}
