# Stack
A simple data structure that represents a stack of items.
- Uses a LinkedList container, so no need to resize
- Every method within the Stack is O(1)

# Queue
A simple data structure that represents a "line" or queue of items.
- Uses a native Array container to better represent a "cyclic-wrap-around" of items within the Queue
- Every method within the Queue is O(1) except enqueue() worst-case is O(N) due to needing to resize the Queue's container

## Application of Queues
### Radix Sort (Non-Inplace, Non-Comparision)
Uses an Array of Queues based on the number's base.
- For example, base 10 integers would mean there's an Array container of 10 Queues

1. For each digit at the end of a number in the original list, place the number into the proper Queue index of the Array container based on the last digit of the number.  
2. Empty the Queue in order from 0 to 9 back into the list.  
3. Keep repeating steps 1 and 2 until the list is sorted.  

The Big O time efficiency of Radix Sort is O(N * log(max))
- max = # of digits of the greatest (maximum) number
- It's logarithmic because logarithms can help us obtain the # of digits
	- Ex: log10(12345) = 4.09149, so get the first digit of any logarithm answer then add it by one and you get the number of digits in a number. For this example, 4 is the first digit, add it by one and it becomes 5. Therefore, the number 12345 has 5 digits.

# Infix vs Postfix Expressions
### Infix Expressions
We've been using infix expressions since elementary school mathematics.
- Mathematical operations go in-between numbers
- Ex: ```3 + 5 * 7 + 10```

### Postfix Expressions
Mathematical operations go after the numbers.
- Ex: ```32 * 1 +``` postfix equals to the infix ```(3 * 2) + 1```
- Ex: ```378 * +``` postfix equals to the infix ```(3 + 7) * 8```
	- The order of operations are preserved since the * appears immediately after the 7 and the 8, denoting that * has precedence, with + coming after
