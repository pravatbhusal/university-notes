package chapter9;

import java.util.ArrayList;

public class TypeChecking {

	/* Definitions:
	 * 1. instanceof: Type comparison operator that returns true if
	 * 		the Object on the left is a child or the same class (or interface)
	 *  		of the Object on the right.
	 * 2. getClass: This method returns an Object as a Class data-type.
	 * 		You can get various things, such as the class name, isArray,
	 * 		the super class name, and much more.
	 * 3. equals: A method from the Object class that just uses the == boolean operator
	 *		between two Objects. Therefore, it's necessary to override the method
	 *		to create your own logic to compare between Objects.
	 */

	/* Programming Hygiene Tips:
	 * 1. Do NOT downcast, it will only throw a ClassCastException at runtime.
	 * 2. When overriding the equals method, it must have a single parameter of an
	 * 		Object or else it will be considered as "overloading," instead.
	 * 3. When using instanceof on completely unrelated Objects (neither Child or Parent),
	 * 		the compiler is smart enough to return a Syntax error.
	 */

	public static void main(String[] args) {
		// up-casting (Parent equals new Child) <- Read Polymorphism.java Extra Notes #6 for more info
		Object upCastingObj = new String();

		// ERROR! down-casting (Child equals new Parent) <- Read Programming Hygiene #6 for more info
		// String exceptionStr = (String) new Object();

		// instance of <- Read Definitions #1 and Extra Notes #1 for more info
		String testStr = "This is a test String...";
		Object testObj = new Object();
		boolean instanceOf = testStr instanceof Object; // true, since String (Child) is an instanceOf Object (Parent)
		instanceOf = testObj instanceof String; // false, since Object (Parent) is NOT an instanceOf String (Child)

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