# Memory Management
### Stack Memory
- Local primitives
- References to Objects, including parameters
- Stack frame and their reset counters (used for method calls)

Stacks do not garbage collect since it opens up a space whenever an old data is no longer in-use. The memory space is re-claimed once the old data is popped out of the stack.

### Program Counter
It acts as a register in a CPU (computer processing unit) to contain the address location of an instruction being executed. Once an instruction has been fetched, it returns to the previous counter value and then executes the next instruction.
- Works in parallel with stack memory

Ex: Recursive calls

### Heap Memory (Dynamically Allocated Variables)
- All Object data (these use the "new" keyword)
- Instance or static variables, including primitives

Heaps can garbage collect once its reference in the Stack has been popped out (removed).


# Recursion
A method that calls itself with different parameters.
- If parameters are the same, then it would never stop and cause a StackOverflow Error
- Every method call creates a stack frame
- Every stack frame updates the program counter

### Why use recursion?
- Helps algorithms to be simpler than iteratively (loops)
- Makes algorithms look cleaner

### How to do recursion?
1. Know when to stop (base or simple case)
2. Decide how to take one step  
	- Know where you're going (what is your goal?)
3. Break the journey down to smaller steps (the recursive part)  
	- This is where you actually call the recursive method
	
# Recursion Time and Space Complexity
### Space and Time Trade-off for Recursion
- Takes O(N) space AND time for a recursive-call that calls N times
	- Because it takes N stack-spaces to finish the recursion

### Multiple Recursion Time Complexity Example and Explanation
We know for 1 recursive call the time and space complexity becomes O(N). However, for 2 recursive calls, the time and space complexity becomes 2^N. If there were 3 calls, it's O(3^N), for 4 calls it's O(4^N), and etc.   

Why is this true? Because when there's multiple recursive calls each function calls itself N times.   

Let's get an example question:   
```java
public int mystery(int x) {
	if(x < 0) {
		return 1;
	}
	return 2 + mystery(x - 1) + mystery(x - 1);
}
```
If x = 20 and it takes 1 second to complete, then what's the time to complete when x = 30?   
- This particular question uses 2 recursive calls, so the time and space complexity is O(2^N).   

Therefore, ```2^20 / 2^30 = 1 / x``` = ```2^10 = 1 / x``` = ```x = ~1000 seconds``` the exact answer is 1024 seconds.
	
# Recursive Backtracking
Recursively checks if a solution is correct, if not, then it backtracks to its previous steps and tries other possibilities until the entire algorithm has been solved.
- Ex: A Sudoku algorithm that brute-forces through every possibilities until the entire matrix has been solved.  
<img src="images/sudoku_recursive_backtracking.gif" alt="Sudoku Recursive Backtracking" width="25%" height="25%">

Typically, recursive backtracking algorithms are "exhaustive": brute-force approach.  

### Short-Circuit Backtracking Algorithm
An algorithm may need to be short-circuited once an answer is found. These algorithms do not need to continue iterating through
every possible choice, and it can just return the success case once it finds a solution to the step.  
Ex: The 8-Queens Problem
```java
public static boolean recursiveMethod(List<Integer> list, step) {
	if(found a solution at this step) {
		// the program is finished! pop all stacks and return true!
		return true;
	} else {
		for(every possible choice or direction in the current step) {
			// make the next step
			step++;
			int result = recursiveMethod(list, step);
			
			// recursive call done, check the result
			if(result is a success) {
				// tell the other calls we're finished! pop all stacks and return true!
				return true;
			}
			// restore the state to the beginning of the loop (backtrack the step)
			step--;
		}
	}
	// at this point if the program never returned a value, then this step was a failure
	return false;
}
```
### Things To Understand About Short-Circuit Backtracking Algorithms
- Recursive calls will only pop a stack frame once it either succeeds or fails
- If it succeeds, then we consider the step a success and go to the next step
- If it fails, we go back a step and try another possible choice

Typically, you can identify a short-circuit backtracking algorithm if the step does not need to be checked among the other possible choices once the program finds a solution.

### Non-Short Circuit Backtracking Algorithm
Sometimes an algorithm cannot be short-circuited because the possible choices may need to be compared or used among each other even
after a recursive call to the next step. In these scenarios, the program typically doesn't return a value until the very end of the method.  
Ex: The Minimum Difference among a Team Array (from Programming Assignment 6)
```java
public static int recursiveMethod(List<Integer> list, step) {
	if(found a solution at this step) {
		return bestResult;
	} else {
		int bestResult = initial/base value;
		for(every possible choice or direction in the current step) {
			// make the next step
			step++;
			int result = recursiveMethod(list, step);
			
			// recursive call done, check the result
			if(result is a success) {
				// update the best result
				bestResult = result;
			}
			// restore the state to the beginning of the loop (backtrack the step)
			step--;
		}
	}
	// at this point if the program is done getting the best result, so return the best result (end case)
	return bestResult;
}
```
### Things To Understand About Non-Short Circuit Backtracking Algorithms
- Recursive calls will only pop a stack frame once it reaches base case or end case
- For either case, we compare it among the previous step's recursive call anyway

Typically, you can identify a non-short circuit backtracking algorithm if the step needs to be checked among the other possible choices even if the program found a potential solution.
