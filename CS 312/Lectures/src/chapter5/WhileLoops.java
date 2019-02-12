package chapter5;

public class WhileLoops {

	/* Definitions:
	 * 1. Definite Loop: Executes a known number of times.
	 * 2. Indefinite Loop: Executes an unknown number of times.
	 * 3. While Loop: Repeatedly executes body as long as condition is true.
	 * 4. Fence Post: When there is trailing code or "half" solution.
	 */
	
	/* Program Hygiene Tips
	 * 1. Fence post redundancy is fine as long as its not greater than ~5 lines.
	 */

	public static void main(String[] args) {
		/* Fence post loop or "loop-and-a-half" solution. If we didn't use
			this solution, there would be a trailing comma. */
		int max = 5;
		for(int i = 1; i <= max - 1; i++) {
			System.out.print(i + ", ");
		}
		System.out.println(max);
		
		// while loop that loops 5 times from i = 1 to i = 5
		int i = 1;
		while(i <= 5) {
			System.out.println("The value of i is " + i);
			i++;
		}
	}
}
