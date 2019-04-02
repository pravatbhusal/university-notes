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
}
