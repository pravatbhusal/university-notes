package chapter9;

import java.util.ArrayList;

public class TypeChecking {

	/* Definitions:
	 * 1. instanceof: Type comparision operator that returns true if
	 * 		the Object on the left is a child or parent, the class, or an
	 * 		interface of the Object on the right.
	 * 		EX: longhorn instanceof Critter <- returns true
	 * 		EX: object instanceOf String <- true
	 * 2. getClass: This method returns an Object as a Class data-type.
	 * 		You can get various things, such as the class name, isArray,
	 * 		the super class name, and much more.
	 * 3. equals: A method from the Object class that just uses the == boolean operator
	 *		between two Objects. Therefore, it's necessary to override the method
	 *		to create your own logic to compare between Objects.
	 */

	/* Extra Notes:
	 * 1. When an instanceof has no relationship (Child or Parent),
	 * 		compiler returns a Syntax Error.
	 */

	/* Programming Hygiene Tips:
	 * 1. Do NOT downcast, it will only throw a ClassCastException at runtime.
	 * 2. When overriding the equals method, it must have a single parameter of an
	 * 		Object or else it will be considered as "overloading," instead.
	 */

	public static void main(String[] args) {
		// up-casting (Parent equals new Child)
		Object upCastingObj = new String();

		// ERROR! down-casting (Child equals new Parent) <- Read Programming Hygiene Tips #1 for more info
		String exceptionStr = (String) new Object();

		// instance of <- Read Definitions #1 and Extra Notes #1 for more info
		String testStr = "This is a test String...";
		Object testObj = new Object();
		ArrayList<String> testList = new ArrayList<String>();
		System.out.println(testStr instanceof Object); // output: true <- child is an instance of parent
		System.out.println(testObj instanceof String); // output: false <- parent is not an instance of child
		System.out.println(testList instanceof ArrayList); // output: true <- is the same class

		// equals method <- Read Programming Hygiene #2 for more info
		TypeChecking check1 = new TypeChecking();
		TypeChecking check2 = new TypeChecking();
		Object obj1 = new Object();
		System.out.println(check1.equals(check2)); // output: true
		System.out.println(check1.equals(obj1)); // output: false

		// getClass method <- Read Definitions #2 for more info
		String stringClassTemplate = "We will get this String as a class Object!";
		Class stringClass = stringClassTemplate.getClass();
		System.out.println(stringClass.getName()); // output: java.lang.String
		System.out.println(stringClass.getSimpleName()); // output: String
		System.out.println(stringClass.getSuperclass()); // output: class java.lang.Object
	}

	// overriding the equals method from the Object class <- Read Definitions #3 for more info
	@Override
	public boolean equals(Object obj) {
		return obj instanceof TypeChecking;
	}
}
