package chapter5;

public class Booleans {

	/* Definitions:
	 * 1. Boolean: A logical type whose values are true or false.
	 * 		EX: boolean test1 = true;
	 * 		EX: boolean test2 = false;
	 * 2. De Morgan's Law: Rule used to negate boolean tests (distributive property).
	 * 		EX: !(a && b) = !a || !b
	 * 		EX: !(a || b) = !a && !b
	 * 		EX: !(a == b) && !(a < 3) = a != b || a >= 3
	 * 3. Short-Circuit: Logical expressions do not continue once a result has been determined.
	 * 		- EX: (3 > 2) || (5 < 3) <- returns true and does not evaluate the 2nd expression
	 *		- EX: (4 < 8) && (3 > 2) <- returns false and does not evaluate the 2nd expression
	 */

	/* Extra Notes
	 * 1. Here are the following boolean operators:
	 * 		&& = AND operator (if all statements true, return true)
	 * 		|| = OR operator (if one statement true, return true)
	 * 		! = NOT operator (if statement false, return true; if statement true, return false)
	 */
	
	/* Program Hygiene Tips
	 * 1. Do not use code with if statements when returning booleans.
	 * 2. Do not do a redundant (boolean) == true or (boolean) == false
	 * 		Use (boolean) if it's true, instead
	 * 		Use !(boolean) if it's false, instead
	 * 		EX: if(x == true) -> if(x)
	 * 		EX if(x == false) -> if(!x)
	 */
	
	public static void main(String[] args) {
		boolean equal = isEqual(1, 1); // return: true <- because 1 == 1
		
		// boolean expression examples
		boolean test1 = true;
		boolean test2 = false;
		
		boolean checkTest1 = !test1; // false <- Read Extra Notes #1 for more info
		boolean checkTest2 = test1 && test2; // false <- test2 is false
		boolean checkTest3 = test1 || test2; // true <- test1 is true
		
		// De Morgan's Law <- Read Definitions #2 for more info
		boolean checkTest4 = !(test1 && test2) && (test1 || test2); // true
		
		// Short-Circuiting <- Read Definitions #3 for more info
		boolean sc1 = (23 > 4) || (345 < 345) || (3457 > 234); // true, stops after 1st expression
		boolean sc2 = (15 > 3) && (74 < 323) && (78 > 2); // false, stops after 2nd expression
	}
	
	// method to verify if two integers are equal to each other
	public static boolean isEqual(int a, int b) {
		/* do NOT do the following <- Read Program Hygiene Tips #1 for more info
			if(a == b) {
				return true;
			} else {
				return false;
			}
		*/
		
		return a == b; // better programming hygiene
	}
}
