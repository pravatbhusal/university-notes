package chapter14;

import java.util.Arrays;

public class Queue<E> {

	// Array container, best implementation for "cyclic" wrap-around
	private E[] container;

	// first item in the queue, ready to be dequeued
	private int first;

	// last item added to the queue
	private int last;

	// current queue of the queue
	private int size;

	// constructor, initialize the queue container
	public Queue() {
		last = -1;
		final int INITIAL_CAPACITY = 1;
		container = getArrayOfE(INITIAL_CAPACITY);
	}

	// return an Array of E using the parameter of a capacity
	@SuppressWarnings("unchecked")
	private E[] getArrayOfE(int capacity) {
		return (E[]) new Object[capacity];
	}

	// return the first item of the queue
	public E front() {
		return container[first];
	}

	// return if the queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// add an item to the end of the queue
	public void enqueue(E item) {
		if(size == container.length) {
			// filled all indexes, re-size the queue
			final int DOUBLE = 2;
			resize((size * DOUBLE) + 1);
		}
		// add the item and open-up the next last index
		last++;
		container[last] = item;
		size++;

		/* cyclic-wrap around the last index if
 			equal to the container's length */
		if(last == container.length) {
			last = -1;
		}
	}

	// remove and return the first item of the queue
	public E dequeue() {
		E oldFirstItem = front();
		// null-out the first item and set the new first item index
		container[first] = null;
		first++;
		size--;

		/* cyclic-wrap around the first index if
	 		equal to the container's length */
		if(first == container.length) {
			first = 0;
		}
		return oldFirstItem;
	}

	// resize the queue to the new size
	private void resize(int newSize) {
		E[] newContainer = getArrayOfE(newSize);

		// iterate through each item within the queue
		int currentItem = first;
		int newContainerIndex = 0;
		while(currentItem != last) {
			newContainer[newContainerIndex] = container[currentItem];
			currentItem++;
			newContainerIndex++;

			// cyclic wrap-around the queue
			if(currentItem == container.length) {
				currentItem = 0;
			}
		}
		// fence-post solution, add the last element as well
		newContainer[newContainerIndex] = container[last];

		// reset the first and last indexes
		first = 0;
		last = container.length - 1;

		// set the queue's container to the new container
		container = newContainer;
	}
}
