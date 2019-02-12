package chapter2;

/* This program contains multiple programming challenges
 * from the PracticeIt's simple loop assignments.
 */
public class SimpleLoops {

	public static void main(String[] args) {
		loopSquares();
		starTriangle();
		numberTriangle();
		spacesAndNumbers();
	}
	
	/* Write a for loop that produces the following output:
	 * 1 4 9 16 25 36 49 64 81 100
	 * For added challenge, try to modify your code so that it does not need to 
	 * use the * multiplication operator.
	 */
	public static void loopSquares() {
		/* declare and initialize more than 2 variables, then check if i <= 100,
		then add the additive variable by 2 each loop */
		for(int i = 1, addNumber = 3; i <= 100; addNumber += 2) {
			System.out.print(i + " ");
			i += addNumber; // increase the loop controller by the additive variable
		}
		System.out.println(); // add a new line
	}
	
	/* Write for loops to produce the following output:
	 *
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 */
	public static void starTriangle() {
		// number of rows loop
		for(int i = 1; i <= 5; i ++) {
		    // number of columns per row loop (based on value of i)
			for(int j = 1; j <= i; i ++) {
				System.out.println("*");
		    }
		    System.out.println(); // add a new line
		}
		System.out.println(); // add a new line
	}
	
	/* Write for loops to produce the following output:
	 * 1
	 * 22
	 * 333
	 * 4444
	 * 55555
	 * 666666
	 * 7777777
	 */
	public static void numberTriangle() {
		// number of rows loop
		for(int i = 1; i <= 7; i ++) {
		    // number of columns per row loop (based on value of i)
		    for(int j = 1; j <= i; j++) {
		        System.out.print(i); // print value of i
		    }
		    System.out.println(); // add a new line
		}
		System.out.println(); // add a new line
	}
	
	/* Write nested for loops to produce the following output:
	 *
	 *     1
	 *    22
	 *   333
	 *  4444
	 * 55555
	 */
	public static void spacesAndNumbers() {
		// number of rows loop
		for(int i = 1; i <= 5; i++) {
		    // number of spaces loop (based on max number of rows minus i)
		    for(int j = 5 - i; j > 0; j--) {
		        System.out.print(" ");
		    }
		    
		    // number of times to print value of i (based on value of i)
		    for(int k = 1; k <= i; k ++) {
		        System.out.print(i);
		    }
		    
		    System.out.println(); // add a new line
		}
		System.out.println(); // add a new line
	}
}