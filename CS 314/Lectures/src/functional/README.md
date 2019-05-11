# Functional Programming
Style of programming emphasizing the use of functions (methods) to decompose tasks.
- New Programming Paradigm in Java 8
- Commonly used in JavaScript (ES6)

Although Java is an Object-Oriented Programming language, Java 8 added features to make the language partially functional.
Therefore, Java is a multi-paradigm language like C++.

### Common Programming Paradigms:
- Procedural
- Object-Oriented
- Functional

# Side Effect-Free Code
- Side Effect: Change of a state in an Object or program after calling a function.

Pseudo-Ex:
```java
int result1 = f(x) + f(x);
int result2 = 2 * f(x);
```
result1 and result2 may equal the same value. If the function f(x) had side-effects, such as updating instance variables, then
the two variables may not be equivalent.

Here's another example of code side-effects:
```java
public static int n;

public static void main(String[] args) {
	n = 5;
	int result1 = f(n) + f(n); // 45
	int result2 = 2 * f(n); // 120
	System.out.println(result1 + " " + result2);
}

public static int f(int x) {
	n = x * 2; // updates the instance variable "n", causes side-effect
	return n + x;
}
```

The goal of functional programming is to minimize side-effects.
- If we minimize side-effects, we can run f(x) on different CPUs using a concept  called concurrency
- Concurrency: Multi-tasking processes using CPU cores (also referred to as Multi-threading)
  - If a computer has 4 CPU cores, then the task can be divided into 4 processes,
      which would theoretically finish the program 4x faster

# First Class Functions
Of a programming language, integrated within the language to support many operations available to other entities.
	
In functional programming, methods are first-class. You can:
- Store functions in a variable
- Pass functions as parameters to another function
- Return values from a function
- Create a collection of functions

Lambda Expressions: Expressions that describes a function with specified parameters and a return value.
- The syntax of a lambda expression: ```(parameters) -> expression```
- Typically are static, but can be dynamic
- The return-type is based on the passed parameters
	- Ex: If integers are used, then the program returns an integer
	- Ex: If Objects are used, then the program returns an Object

For example,
```java
(x) -> (x) * (x)
```
Is equivalent to:
```java
public static int squared(int x) {
	return x * x;
}
```

# BinaryOperator
An interface implemented in Java 8 to implement functional programming.
- Represents binary operator which takes two operands and operates on them to produce a result

### MathMatrix and IntBinaryOperator
Remember the Gacky MathMatrix programming assignment? It required us to use ```mat + mat``` or ```mat - mat``` in two separate methods, which caused gacky and redundant code.

We could've used functional programming, instead:
```java
getMat(rhs, (x, y) -> x + y);
getMat(rhs, (x, y) -> x - y);
```

Now within the getMat method:
```java
getMat(MathMatrix rhs, IntBinaryOperator intOp) {
	int temp1 = 2;
	int temp2 = 4;
	int result = intOp.applyAsInt(temp1, temp2);
}
```
As seen above, the ```IntBinaryOperator``` handled the operations from the lambda expression that was passed into getMat.

In fact, there are different operations per data-type that can be implemened using the ```BinaryOperator``` interface.
- There are also other BinaryOperators like ```DoubleBinaryOperator``` or ```LongBinaryOperator```

# VarArgs
If your method needs to use multiple parameters (arguments) but doesn't have a specified amount, then using VarArgs it allows you to do so. Any parameters inside the VarArgs will be stored inside an Array.
- The VarArg MUST be the last parameter in a method
	- Therefore, a method can only have a single VarArg

Ex:
```java
sumNumber(5, 10, 15, 25, 30, 35, 40, 45, 50); // 255

public static int sumNumber(int arbitrary, int ... varArgs) {
	// must clone before continuing
	int[] parameters = varArgs.clone();

	// return the sum of the arbitrary integer and var args
	int sum = arbitrary;
	for(int i = 0; i < parameters.length; i++) {
		sum += parameters[i];
	}
	return sum;
}
```

# Streams
Sequence of elements from a data source that supports aggregate functions.

### Non-functional Example (without Streams):
```java
int sum = 0;
for(int i = 0; i <= 5; i++) {
	sum += i * i;
}
```
The answer is 55.

### Functional Example (with Streams)
Using the ```map``` modifier applies lambda to each element in the stream.
- Abstracts-out loops
- Map is an example of a "Higher-order Function": A function that takes in a function as an argument

The example using an IntStream's map function:
```java
int sum = IntStream.range(1, 6).map(n -> n * n).sum();
```
The answer is 55.

###### The Underlying Idea:
- range(1, 6) -> [1, 2, 3, 4, 5]
- [1, 2, 3, 4, 5] map -> [1, 4, 9, 16, 25]
- [1, 4, 9, 16, 25] sum -> 55

### Filter Modifier
Removes/keeps elements of a stream using a boolean lambda.

Example of Summing Odd Squared Numbers:
```java
int sum = IntStream.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3).filter(n -> n % 2 != 0).map(n -> n * n).sum();
```
The answer is 151.

###### The Underlying Idea:
- IntStream.of -> [3, 1, 4, 1, 5, 9, 2, 6, 5, 3]
- filter -> [3, 1, 1, 5, 9, 5, 3]
- map -> [9, 1, 1, 25, 81, 25, 9]
- sum -> 151

### Reduce Modifier


