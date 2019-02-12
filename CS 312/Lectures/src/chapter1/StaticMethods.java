package chapter1;

public class StaticMethods {

	/* Definitions:
	 * 1. Comment: A note written in source code by the parameter to clarify code.
	 * 2. Program Hygiene: A structure and style to how a code is written.
	 * 3. Static Methods: A named group of statements
	 * 4. Procedural Decomposition: Dividing a problem into methods.
	 * 5. Algorithm: A systematic way of solving a problem.
	 * 6. Structured Algorithm: A solution of breaking down coherent tasks.
	 * 7. Lack of structure: Many small steps, tough to remember...
	 * 8. Redundancy: Repetition of code, prevent this by using classes or methods.
	 * 9. Method Calling: Executing the code inside of a method.
	 * 10. ASCII Art: Computer art using Strings.
	 */

	/* Extra Notes
	 * 1. We use methods to follow programming decomposition and organize our code.
	 */

	/* Program Hygiene Tips
	 * 1. Comment hygiene follows a space after a double slash, and use of a multi-line comment
	 * 		after 120 characters including spaces.
	 * 2. Multi-line comments should have one indent after the top of multi-line comment.
	 * 3. General methods should be on the top of a class.
	 * 4. More specific methods should be at the bottom of a class.
	 * 5. Do NOT have just one line of code for methods.
	 * 6. Methods use camel-casing structure (first word lower-case and sequential words are upper-case).
	 * 7. Always comment on what a method does and what its parameters do.
	 * 8. main() method should be a concise summary of your program.
	 * 		- It is generally poor style if each method calls the next without ever returning (chaining)
	 * 9. Make the main() method make most (not all) of the calls.
	 * 		- Methods must return values to main() to be passed on later
	 */

	// a method that initiates the program
	public static void main(String[] args) {
		newMethodExample(); // calling the method newMethodExample
		drawSimpleRectangle(); // calling the method drawSimpleRectangle
	}

	// here's an example of declaring a new method with the identifier of newMethodExample
	// a method that prints println() statements that notify the user of the method
	public static void newMethodExample() {
		System.out.println("This println() statement was executed in the newMethodExample method!");
		System.out.println("Here's another line of println() statement for good code hygiene.");
	}

	// a method that draws a simple rectangle structure (ASCII art)
	public static void drawSimpleRectangle() {
		System.out.println("###");
		System.out.println("###");
		System.out.println("###");
	}
}
