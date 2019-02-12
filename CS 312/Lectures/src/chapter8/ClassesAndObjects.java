package chapter8;

public class ClassesAndObjects {

	/* Definitions:
	 * 1. Object-Oriented Programming: a programming paradigm that is
	 * 		based on the hierarchy of classes and objects.
	 * 		- Breaks the problem up based on data-types
	 * 		- EX: A Car class, which retrieves classes (objects) of
	 * 			the wheels, engine, windows, etc.
	 * 2. Procedural Programming: a programming paradigm that involves
	 * 		programming step-by-step using only one class and multiple methods.
	 * 3. Client Program: a program that uses objects.
	 * 4. Class: a program entity that represents a program module/template.
	 * 5. Object: an entity that combines state and behavior of a class.
	 * 6. Abstraction: distancing between ideas (programming decomposition).
	 * 7. Field: a variable inside an object, part of its state.
	 * 8. Instance Method (or object method): Exists inside each object of
	 * 		a class and gives behavior to each object.
	 * 		- Does NOT use the static keyword
	 * 9. Instance Variable: Exists inside each object of a
	 * 		class and gives data to each object.
	 * 		- Does NOT use the static keyboard
	 * 10. Implicit Parameter: A parameter where the instance method is called.
	 * 		- Basically, Parameters passed onto a method call.
	 * 		- EX: add(1, 2) <- 1 and 2 are implicit
	 * 11. Explicit Parameter: A parameter where the instance method is created
	 * 		- Basically, Parameters that define a method's call.
	 * 		- EX: public int add(int num1, int num2); <- num1 and num2 are explicit
	 * 12. Static: A universal keyword when assigned to data updates all class instances with the data.
	 */

	/* Extra Notes:
	 * 1. When creating a new Object, the variable is set to a new
	 * 		reference in memory to the Object. If you do not create a
	 * 		new Object and set it to another instead, then both Objects
	 * 		refer to the same reference in memory.
	 * 2. If no scope is defined for a field, it is defaulted to public.
	 * 3. Static methods can use ONLY static variables and methods.
	 * 4. Instance methods can use both static and instance variables and methods.
	 * 5. All state variables follow a default-zero value
	 * 		- All number primitives zero-default is 0
	 * 		- boolean's zero-default is false
	 * 		- All Objects zero-default is null
	 * 6. Static methods can be called without declaring a new class Object.
	 * 7. You can access private instance variables inside its own class.
	 * 		- Look at the City.java's getXDelta method as an example
	 */

	/* Programming Hygiene Tips:
	 * 1. When doing OOP (Object Oriented Programming), it is good
	 * 		to break down (abstraction) a program using classes and methods.
	 * 2. Good OOP has methods that accept complex Objects as parameters and
	 * 		do algorithms inside the method.
	 * 3. If a variable or method needs to be shared among Objects, make it static.
	 */

	public static void main(String[] args) {
		// creating a new Point Object called p1 <- Read Extra Notes #1 for more info
		Point p1 = new Point();
		p1.x = 7; // state x
		p1.y = 2; // state y
		p1.outputPoints(); // outputs: 7 2

		// creating a new Point Object called p2
		Point p2 = new Point();
		p2.x = 4; // state x
		p2.y = 3; // state y
		p2.outputPoints(); // outputs: 4 3
		p2.outputOtherPoints(234, 4324); // outputs: 234 4324
		
		// reference semantics with Objects <- Read Extra Notes #1 for more info
		Point p3 = p2;
		p3.x = 5;
		p3.outputPoints(); // outputs: 5 3
		p2.outputPoints(); // outputs: 5 3
	}
}
