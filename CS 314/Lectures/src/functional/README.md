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
```(java)
int result1 = f(x) + f(x);
int result2 = 2 * f(x);
```
result1 and result2 may equal the same value. If the function f(x) had side-effects, such as updating instance variables, then
the two variables may not be equivalent.

Here's another example of code side-effects:
```(java)
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



