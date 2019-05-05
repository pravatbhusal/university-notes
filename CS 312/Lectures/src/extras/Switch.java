package extras;

public class Switch {

	/* Definitions
	 * 1. Switch: Checks the value inside its parameter, then executes
	 * 		the case, and cases after, for which it equals the value.
	 * 2. Case: An equal case from the switch statement.
	 * 3. Default: If no case was executed, executes this case.
	 * 4. Break: Breaks out of the case block, will stop executing
	 * 		the rest of the cases inside the switch statement.
	 * 5. "Fall Through": If there's no break statement in a case, then the
	 * 		program will execute all other cases until INCLUDING the default
	 * 		case until the program encounters a break.
	 */

	// a method to test switch statements
	public static void main(String[] args) {
		/*
		 * an example of a switch statement WITHOUT break;
		 * 
		 * it will execute ALL cases, including default <- Read Extra Notes #1 for more information
		 */
		String season = "Spring";
		switch(season) {
		case "Spring":
			System.out.println("We start at Spring!");
		case "Summer":
			System.out.println("Then we go to Summer!");
		case "Fall":
			System.out.println("Then we're at Fall!");
		case "Winter":
			System.out.println("Now we're finally at Winter!");
		default:
			System.out.println("The original season we started at was: " + season);
		}
		System.out.println();

		// an example of a switch statement WITH break
		final int MAX_AGE = 25;
		int myAge = (int) ((Math.random() * MAX_AGE) + 1);
		switch(myAge) {
		case 13:
			System.out.println("I'm 13 years old.");
			System.out.println("Yay! I'm at least a teenager!");
			break;
		case 18:
			System.out.println("I'm 18 years old.");
			System.out.println("Yay! I'm at least an adult!");
			break;
		default: 
			System.out.println("No case for age: " + myAge);
		}
		System.out.println();

		/*
		 * an example of a "fall through" program <- Read Definitions #5 for more information;
		 * 
		 * this program will execute cases 0, 1, and 2 because animation = 0
		 */
		int animation = 0;
		switch(animation) {
		// cases 0, 1, and 2 are for a jump animation
		case 0:
			System.out.println("Bend Legs...");
		case 1:
			System.out.println("Jump!");
		case 2:
			System.out.println("Fall down...");
			break;
			// cases 3, 4, and 5 are for a walk animation
		case 3:
			System.out.println("Ready legs...");
		case 4:
			System.out.println("Walk!");
		case 5:
			System.out.println("Slow down and stop...");
			break;
			// cases 6, 7, and 8 are for a punch animation
		case 6:
			System.out.println("Ready fists...");
		case 7:
			System.out.println("Punch!");
		case 8:
			System.out.println("Pull fist back...");
			break;
		default:
			System.out.println("This animation is not supported...");
		}
	}
}
