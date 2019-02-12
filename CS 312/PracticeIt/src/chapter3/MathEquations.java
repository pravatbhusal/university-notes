package chapter3;

public class MathEquations {

	public static void main(String[] args) {
		printSquare(1,5);
		quadratic(2,3,4);
		distance(1,4,35,65);
	}
	
	public static void printSquare(int min, int max) {
	    // print number of rows based on max - min, inclusive
	    for(int i = min; i <= max; i++) {
	        // print number of columns based on max - min, inclusive
	        for(int k = min, j = i; k <= max; k++, j++) {
	            // if j is max, reset j
	            if(j == max) {
	                System.out.print(j);
	                j = min - 1; // j will be added by 1 once the loop iterates
	            } else {
	                System.out.print(j);
	            }
	        }
	        System.out.println();
	    }
	}
	
	public static void quadratic(double a, double b, double c) {
	    // return two roots using the quadratic formula
	    double firstRoot = (-b + (Math.sqrt(Math.pow(b,2) - 4*a*c))) / (2*a);
	    double secondRoot = (-b - (Math.sqrt(Math.pow(b,2) - 4*a*c))) / (2*a);
	    
	    System.out.println("First root = " + firstRoot);
	    System.out.println("Second root = " + secondRoot);
	}
	
	public static double distance(int x1, int y1, int x2, int y2) {
	    // return the distance between the points using the distance formula
	    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
