# Dynamic Programming (DP)
A method to solve complex problems by breaking them into smaller, easier, sub-problems.  
- Ex: Recursion, breaks the problem into sub-problems using different method parameters

The solution to the original problem can be calculated from results of smaller problems.
- Sub-problems have a natural ordering from smallest to largest OR simplest to hardest
  - Therefore, larger problems depend on previous solutions
  
### DP Algorithm
1. Define the sub-problems using Mathematics/English.  
2. Determine where the solution will be found.  
3. Determine how to to create the first sub-problem.  
4. Determine the order in which the sub-problems will be solved.  
5. Determine how to compute the final answer using the previously computed sub-problems.

# Memoization
Store (cache) results from functions such as method calls for later look-up.

We can use a data structure like an ArrayList to store each method(N) result, then if the user asks to see the results of the
same method(N) it would just return the index corresponding to N, which would be O(1) fast look-up instead of re-doing
the redundant program.

However, a drawback is the space and time trade-off since the data structure would sacrifice more space for time.

# Fibonacci Problem using Dynamic Programming
For Fibonacci, we implemented it using recursion with the naive method: ```f(n) = fib(n - 1) + fib(n - 2)```
- However, the time complexity of this method is O(2^N) and calls many redundant method calls
- Therefore, instead of using recursion, we can use iteration to prevent redundant method calls

### Memoization of The Fibonnacci Problem
1. Check if N is present in the ArrayList, if it is then return the value  
2. Check if N - 1 and N - 2 are present, if they are then return the sum of the two values  
3. If neither are available, do the regular implementation of fibonacci (use iteration for efficiency)

