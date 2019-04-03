package chapter14;

import java.util.Stack;

public class Stacks {

	/* 
	 * Write a client method that removes all elements from a
	 * stack that are less than a given value. The method
	 * removes all elements in a Stack "less than" a given
	 * cutoff value, but the relative order of the rest of
	 * the elements in the Stack is unchanged.
	 */
	public <E extends Comparable<E>> void remove(Stack<E> st, E cutoff) {
		Stack<E> tempStack = new Stack<E>();
		while(!st.isEmpty()) {
			E value = st.pop();
			if(value.compareTo(cutoff) >= 0) {
				// found a value greater or equal to cutoff, add to the temporary Stack
				tempStack.push(value);
			}
		}
		// reverse temporary stack to put into order
		while(!tempStack.isEmpty()) {
			E value = tempStack.pop();
			st.push(value);
		}
	}
	
		/*
	 * Check if a parenthesis syntax is valid (balanced).
	 * pre (Assume implemented): All characters are either '(' or ')'
	 * Ex: (())(()) is balanced
	 * Ex: ())() is not balanced
	 */
	public static boolean isSyntaxValid(String syntax) {
		Stack<Character> syntaxStack = new Stack<Character>();

		// iterate through the syntax String
		final int SYNTAX_LENGTH = syntax.length();
		for(int charIndex = 0; charIndex < SYNTAX_LENGTH; charIndex++) {
			char syntaxChar = syntax.charAt(charIndex);

			if(syntaxChar == '(') {
				// for an open parenthesis, add to the stack
				syntaxStack.push(syntaxChar);
			} else if(syntaxChar == ')' && !syntaxStack.isEmpty()) {
				// pop whenever encountering a closing parenthesis
				syntaxStack.pop();
			} else if(syntaxStack.isEmpty()) {
				/* the Stack is empty too early, deleted more opening
					parenthesis than needed or didn't start with one */
				return false;
			}
		}
		// if there are still parenthesis left-over, then it's invalid
		return syntaxStack.isEmpty();
	}
}
