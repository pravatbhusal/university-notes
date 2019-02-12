package chapter1;

/* Without using loops/recursion, write a program in a class named Shining 
 * that prints the following line of output 1000 times:
 * All work and no play makes Jack a dull boy.
 */

public class Shining {
	/* For this program to work, we can use parent methods that
	 output the child methods with a certain number of lines. */
    public static void main(String[] args) {
        printThousand();
    }
    
    // print 10 of printHundred() methods
    public static void printThousand() {
        printHundred();
        printHundred();
        printHundred();
        printHundred();
        printHundred();
        printHundred();
        printHundred();
        printHundred();
        printHundred();
        printHundred();
    }
    
    // print 4 of printTwentyFive() methods
    public static void printHundred() {
        printTwentyFive();
        printTwentyFive();
        printTwentyFive();
        printTwentyFive();
    }
    
    // print 5 of printFive() methods
    public static void printTwentyFive() {
        printFive();
        printFive();
        printFive();
        printFive();
        printFive();
    }
    
    public static void printFive() {
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
    }
}