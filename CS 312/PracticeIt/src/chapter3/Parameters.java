package chapter3;

public class Parameters {

	public static void main(String[] args) {
		printNumbers(3);
		printPowersOf2(5);
		printPowersOfN(4, 3);
		cylinderSurfaceArea(3, 2.5);
	}
	
	/* Write a method called printNumbers that accepts a maximum number as a 
	 * parameter and prints each number from 1 up to that maximum, inclusive, 
	 * boxed by square brackets. You may assume that the value passed to 
	 * printNumbers is 1 or greater.
	 */
	public static void printNumbers(int maxNumber) {
	    // iterate until we reach maxNumber
	    for(int i = 1; i <= maxNumber; i++) {
	        System.out.print("[" + i + "]" + " ");
	    }
	}
	
	/* Write a method called printPowersOf2 that accepts a maximum number as an 
	 * argument and prints each power of 2 from 20 (1) up to that maximum power, 
	 * inclusive.You may assume that the value passed to printPowersOf2 is 0 or 
	 * greater.
	 */
	public static void printPowersOf2(int exponent) {
	    int twoPower = 1;
	    System.out.print(twoPower + " "); // print out the initial value of twoPower (1)
	    
	    // print out the value of twoPower in each iteration
	    for(int i = 0; i < exponent; i++) {
	        twoPower *= 2;
	        System.out.print(twoPower + " ");
	    }
	}
	
	/* Write a method called printPowersOfN that accepts a base and an exponent as 
	 * arguments and prints each power of the base from 0 up to that maximum power,
	 * inclusive. You may assume that the exponent passed to printPowersOfN has a 
	 * value of 0 or greater.
	 */
	public static void printPowersOfN(int base, int exponent) {
	    int valuePower = 1;
	    System.out.print(valuePower + " "); // print out the initial value of valuePower (1)
	    
	    // print out the value of valuePower in each iteration
	    for(int i = 0; i < exponent; i++) {
	        valuePower *= base;
	        System.out.print(valuePower + " ");
	    }
	}
	
	/* Write a method called cylinderSurfaceArea that accepts a radius and height 
	 * (both real numbers) as parameters and returns the surface area of a 
	 * cylinder with those dimensions.
	 */
	public static double cylinderSurfaceArea(double radius, double height) {
	    double surfaceArea = 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
	    return surfaceArea; // return (set) the method value
	}
}
