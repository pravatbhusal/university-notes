package chapter14;

import java.util.LinkedList;

public class Stack<E> {

	// utilize a DoublyLinkedList container
	private LinkedList<E> container;

	// constructor, O(1)
	public Stack() {
		container = new LinkedList<E>();
	}

	// return if the Stack is empty, O(1)
	public boolean isEmpty() {
		return container.size() == 0;
	}

	// push an item to the top of the stack, O(1)
	public void push(E value) {
		container.addLast(value);
	}

	// return the item at the top of the Stack, O(1)
	public E top() {
		return container.get(0);
	}

	// remove and return the item at the top of the Stack, O(1)
	public E pop() {
		return container.removeLast();
	}

	/*
	 * pre: other != null
	 * post: return if the other's Stack elements equals this Stack's
	 */
	public boolean equals(Object other) {
		if(other instanceof Stack) {
			// a container for the Stacks
			Stack<E> thisContainer = new Stack<E>();
			Stack<E> otherContainer = new Stack<E>();

			// the other Stack's cast as a Stack
			// ignore warning for this case; to fix for other use cases use Stack<?> instead
			@SuppressWarnings("unchecked")
			Stack<E> otherStack = (Stack<E>) other;
			boolean isEquals = true;

			// iterate both Stacks until exhausting the items
			while(isEquals && !isEmpty() && !otherStack.isEmpty()) {
				// check if the peek are equal, then 
				isEquals = otherStack.top().equals(top());

				// push the popped values of the Stacks onto the containers
				thisContainer.push(pop());
				otherContainer.push(otherStack.pop());
			}
			if(isEquals) {
				// now check if both Stacks are empty
				isEquals = isEmpty() && otherStack.isEmpty();
			}
			// add-back the Stack items
			pushInto(thisContainer, this);
			pushInto(otherContainer, otherStack);
			return isEquals;
		}
		// the other Object is not an instance of Stack
		return false;
	}

	// push the items from doPushStack parameter to the getPushStack parameter
	private void pushInto(Stack<E> doPushStack, Stack<E> getPushStack) {
		// iterate through the entire push stack
		while(!doPushStack.isEmpty()) {
			// push the popped value from get push stack onto the do push stack
			getPushStack.push(doPushStack.pop());
		}
	}

	// print the stack in reverse order
	public void printReverseOrder() {
		while(!isEmpty()) {
			// before the recursive call, pop the Stack item and store it
			E value = pop();

			// call the recursive call
			printReverseOrder();

			// finished recursive call, print from bottom of Stack to top

			// print the value, then restore the state
			System.out.print(value + " ");
			push(value);
		}
		// base case where the Stack is empty, initiate finished recursive calls
	}
}
