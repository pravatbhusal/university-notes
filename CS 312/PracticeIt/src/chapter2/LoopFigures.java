package chapter2;

public class LoopFigures {

	public static void main(String[] args) {
		numbersOutput60();
		waveNumbers40();
		printDesign();
		SlashFigure2();
	}
	
	/* It's common to print a rotating, increasing list of single-digit numbers at 
	 * the start of a program's output as a visual guide to number the columns of 
	 * the output to follow. With this in mind, write nested for loops to produce 
	 * the following output, with each line 60 characters wide:
	 *
	 *          |         |         |         |         |         |
	 * 123456789012345678901234567890123456789012345678901234567890
	 */
	public static void numbersOutput60() {
		// first row
		for(int i = 0; i < 6; i++) {
		    for(int j = 0; j < 9; j++) {
		        System.out.print(" ");
		    }
		    System.out.print("|");
		}

		System.out.println();

		// second row
		for(int i = 1; i <= 60; i++) {
		    System.out.print(i%10);
		}
	}
	
	/* Write for loops to produce the following output, with each line 40 
	 * characters wide:
	 *
	 * ----------------------------------------
	 * _-^-_-^-_-^-_-^-_-^-_-^-_-^-_-^-_-^-_-^-
	 * 1122334455667788990011223344556677889900
	 * ----------------------------------------
	 */
	public static void waveNumbers40() {
		// print 40 of -
		for(int i = 0; i < 40; i++) {
		    System.out.print("-");
		}

		System.out.println();

		// print 10 of _-^-
		for(int i = 0; i < 10; i++) {
		    System.out.print("_-^-");
		}

		System.out.println();

		// print sequence 11223344556677889900 twice
		for(int i = 1; i <= 20; i++) {
		    System.out.print(i % 10);
		    System.out.print(i % 10);
		}

		System.out.println();

		// print 40 of -
		for(int i = 0; i < 40; i++) {
		    System.out.print("-");
		}
	}
	
	/* Write a method called printDesign that produces the following output. Use 
	 * nested for loops to capture the structure of the figure.
	 *
	 * -----1-----
	 * ----333----
	 * ---55555---
	 * --7777777--
	 * -999999999-
	 */
	public static void printDesign() {
	    // 5 iterations for the 5 rows
	    for(int i = 0; i < 5; i++) {
	        // iterations to print - is based on value of y = i
	        for(int j = 5 - i; j > 0; j--) {
	            System.out.print("-");
	        }
	        
	        // how many numbers to print is based on value of y = 2x + 1
	        int num = 2*i + 1;
	        
	        // iterations to print num is based on the value of num
	        for(int k = 0; k < num; k++) {
	            System.out.print(num);
	        }
	        
	        // iterations to print - is based on value of y = i
	        for(int j = 5 - i; j > 0; j--) {
	            System.out.print("-");
	        }
	        
	        System.out.println();
	    }
	}
	
	/* Modify the SlashFigure program from the previous exercise to produce a new 
	 * program SlashFigure2 that uses a global constant for the figure's height.
	 */
	public static final int SIZE = 4;
	
	// utilize a loop table (and graph) to solve this problem
	public static void SlashFigure2() {
		// number of rows of figure is based on value of i
        for(int i = 0; i < SIZE; i++) {
            // number of backslashes is based on value of y = i * 2
            for(int j = 0; j < i * 2; j++) {
                System.out.print("\\");
            }
            
            // SIZE @ 0: when i = 0 = -2, 1 = -6, 2 = -10, 3 = -14 -> y = -4*i -2
            // SIZE @ 4: when i = 0 = 14, 1 = 10, 2 = 6, 3 = 2 -> y = -4*i + 14
            // SIZE @ 7: when i = 0 = 26, 2 = 22, 3 = 18, 4 = 14 -> y = -4*i + 26
            // Therefore, slope = -4*i and y-intercept = -2 + (4*SIZE)
            for(int j = 0; j < -4*i + -2 + (4*SIZE); j++) {
                System.out.print("!");
            }
            
            // number of forward slashes is based on value of y = i * 2
            for(int j = 0; j < i * 2; j++) {
                System.out.print("/");
            }
            
            System.out.println();
        }
	}
}
