package chapter3;

public class Parameters {

	/* Definitions:
	 * 1. Parameter: Value passed to a method by its caller
	 * 2. Method Overloading: Same method identifier, but different parameters
	 */

	/* Program Hygiene Tips
	 * 1. Typically it's best to have only 2 to 3 parameters for a method.
	 * 2. Use parameters and rarely use global variables to reduce redundancy.
	 * 3. You may use method chaining to call methods that have 2 or more parameters.
	 */

	public static void main(String[] args) {
		sayNumber(5.0); // calls the sayNumber method with the double parameter and passes value 5.0 to the number parameter
		sayNumber(5); // calls the sayNumber method with the int parameter and passes value 5 to the number parameter
		sayTexts("First Text", "Second Text"); // calls the sayTexts method and passes String values to the text1 and text2 parameters
	}

	// a method named sayNumber with a double parameter called number
	public static void sayNumber(double number) {
		System.out.println("Called the sayNumber method with the double parameter.");
		System.out.println("The number passed was " + number);
	}

	// the same method, sayNumber, but with an int parameter called number (Method Overloading)
	public static void sayNumber(int number) {
		System.out.println("Called the sayNumber method with the int parameter.");
		System.out.println("The number passed was " + number);
	}

	// a method with multiple parameters
	public static void sayTexts(String text1, String text2) {
		System.out.println(text1);
		System.out.println(text2);
	}
}
