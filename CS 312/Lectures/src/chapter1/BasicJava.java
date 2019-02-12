package chapter1;

/* BasicJava is a class identifier, conventionally we capitalize each word of a class.
 * Class names must have the same identifier as the file name.
 */
public class BasicJava {

	/* Definitions:
	 * 1. Program: A set of instructions to be carried out by a computer.
	 * 2. Program Execution: The act of carrying out a program.
	 * 3. Programming Language: A systematic set of rules to describe computations.
	 * 4. High-Level Languages: Fewer commands than machine/assembly language, and easier to understand.
	 * 5. Method: A function in a class.
	 * 6. Console: Text box to show a program's output.
	 * 7. String: A sequence of text characters.
	 * 8. Syntax: Set of legal structures and commands for a particular language.
	 * 9. Syntax Error (Compiler Error): An error with syntax. EX: system.out.println() causes
	 * 		an error because System should be capitalized.
	 * 10. Escape Sequence: A special sequence of characters to represent a special String.
	 */

	/* Extra Notes
	 * 1. Java is case-sensitive.
	 * 2. Java code is synchronous (reads from top to bottom), but later we learn how to create asynchronous code.
	 * 3. You may not use reserved keywords (such as static) as identifiers (names).
	 * 4. On the Eclipse IDE, use CTRL+I to auto-indent Java code.
	 */

	/* Every java program initiates with this method below.
	 * The String[] args is a parameter that contains data passed by the command line.
	 */
	public static void main(String[] args) {
		/* System refers to the console. 
		 * out refers to outputting. 
		 * println() refers to printing a String on a new line.
		 * Therefore, we use System.out.println(); to output a String in a new line onto the console.
		 */
		System.out.println("Hello World!"); // outputs onto console: Hello World
		System.out.println(); // blank line
		System.out.println("This program produces"); // outputs onto console: This program produces
		System.out.println("4 lines of output."); // outputs onto console: 4 lines of output

		/* The 4 different types of Escape Sequences are shown below
		 * \t = 1 tab (4 spaces)
		 * \n = new line
		 * \" = a double quote (")
		 * \\ = a backward slash (\)
		 */
		System.out.println("Hello\t"); // outputs onto console with a tab at the end: Hello    
		System.out.println("And Goodbye\n"); // outputs onto console with an extra new line at the end: And Goodbye
		System.out.println("Welcome Back\""); // outputs onto console: Welcome Back"
		System.out.println("Nevermind...\\"); // outputs onto console: Nevermind...\
	}
}
