package chapter2;

public class ExpressionsVariables {

	/* Definitions:
	 * 1. Data Type: A category or set of data values.
	 * 2. Primitive Types: 8 simple data types -> int, double, char, boolean, byte, short, long float.
	 * 3. Expression: A combination of values or operations that results to a value.
	 * 4. Operator: Combines multiple values or expressions.
	 * 5. Concatenation: Using + operator between a String and another value to make a longer String.
	 * 6. Variable: A piece of computer memory with an identifier (name) and data type.
	 * 7. Declaring: Specifying the type and identifier of a variable, method, or class
	 * 8. Initializing: Setting a variable equal to a value.
	 */

	/* Extra Notes
	 * 1. Expressions follow PEMDAS!
	 * 2. The plus operator (+) adds expressions.
	 * 3. The minus operator (-) subtracts numbers.
	 * 4. The multiply operator (*) multiplies numbers.
	 * 5. The divide operator (/) divides numbers.
	 * 6. The modulus operator (%) gets the remainder of numbers, same order of precedence as multiply and divide
	 * 7. A double data-type is a real-number, an int data-type is an integer.
	 * 8. When using the modulus operator with an operand on the left-side being smaller than the right, the 
	 * 		answer returns the left-side operand. EX: 12 % 50 = 12
	 * 9. Any number after a + after a String becomes a String because of PEMDAS.
	 * 		EX: 4.5 + 3 + "CS" + 3 + 7 = 7.5CS37
	 * 		EX: 2.0 + 3 + "OK" + 3 - 7 = Syntax Error! Cannot use - with concatenation!
	 * 10. Integer division ALWAYS rounds down because it removes any remainders and decimals. EX: 3 / 2 = 1.5 -> 1
	 * 11. Using underscores with integers can act as commas. EX: 1_000_000 = 1000000
	 * 12. When integers and doubles mix, the value is ALWAYS a double.
	 * 13. However, integer and double conversion is per-operator and only affects the operands.
	 * 		EX: 3 * 2.0 + 3 / 2 = (6.0) + (1) = 7.0
	 */

	/* Program Hygiene Tips
	 * 1. Space out expressions. EX: 12*3 should be 12 * 3
	 * 2. Variable identifiers should follow camel-case.
	 */

	/* Exceptions (Errors) Types
	 * 1. Syntax/Compiler Error: Program doesn't run due to error with syntax.
	 * 2. Runtime Error: Program compiles, but errors at a point.
	 * 3. Logic Error: Program works and compiles, but it doesn't work as intended.
	 */

	public static void main(String[] args) {
		// expressions
		System.out.println(3 * 4); // the expression 3 * 4 is first evaluated, then it outputs 12
		System.out.println(1017 % 100 + (12 % 100)); // outputs: 29 <- remember to use PEMDAS!
		System.out.println(1.25 + 7/4 + "CS" + 3 + 4); // result: "2.25CS34" <- Read Extra Notes #8 for more info
		System.out.println(1.5 + "Hello" + -3); // result: "1.5Hello-3"

		// a few primitive variables (all of them are: int, double, long, float, short, byte, char, boolean)
		double exampleDouble = 3.5; // a double variable named exampleDouble that equals 3.5
		int exampleInt = 3; // an int variable named exampleInt that equals to 3
		exampleDouble = 3.0; // re-initializing the exampleDouble variable to 3.0
		double mixNumbers = exampleDouble * exampleInt + 3 / 2; // 3.0 * 3 + 1 = 10.0 <- Read Extra Notes #12 for more info
		
		// String variables (Object/References)
		System.out.println(mixNumbers); // prints 10.0 <- notice how we did not need quotes around the variable
		String exampleString = "This is a String variable.";
		System.out.println(exampleString); // outputs: This is a String variable.
	}
}
