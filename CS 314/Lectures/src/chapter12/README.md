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

### Space and Time Trade-off for Recursion
- Takes O(N) space AND time for a recursive-call that calls N times
	- Because it takes N stack-spaces to finish the recursion
	
# Recursive Backtracking
Recursively checks if a solution is correct, if not, then it backtracks to its previous steps and tries other possibilities until the entire algorithm has been solved.
- Ex: A Sudoku algorithm that brute-forces through every possibilities until the entire matrix has been solved.

### General Backtracking Algorithm
1. To backtrack, you must have a failed case (dead-end case) so the backtrack algorithm goes back to the previous-case (typically the child method returns false). Then the parent method call handles the false case and tries other possibilities until a child method returns true.  
2. If the child method returned true, then it calls its own child method for the next step and attempts that step until it returns true, then it keeps going until the base-case has been reached.
3. However, if the parent method call attempted all possibilities, then it returns false so that the grand-parent method that called the parent method call handles other possibilities as well.
4. The program keeps going until the program has been solved.
