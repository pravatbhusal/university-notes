package chapter11;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Iterator data-types require the "Iterable" interface
public class Iterators<E> implements Iterable<E> {

	/* Definitions:
	 * 1. Iterable: An interface that contains an iterator() method that returns
	 * 		an Iterator Object.
	 * 		- Uses Java Generics fir data-typing
	 * 2. Iterator: An interface that contains hasNext(), next(), and remove()
	 * 		methods to handle the iteration of a data-type.
	 * 		- Uses Java Generics for data-typing
	 */

	/* Extra Notes:
	 * 1. Whenever using a for-each loop on an implemented Iterator Object,
	 * 		it calls the iterator() method inside and does the loop.
	 */

	// test the Iterators class
	public static void main(String[] args) {
		// add 15 elements to the Iterators<> Object
		Iterators<Integer> iterator = new Iterators<Integer>(15);

		// output each value using a for-each loop <- Read Extra Notes #1 for more info
		for(Integer value : iterator) {
			System.out.println(value);
		}
	}

	// the length of the Iterator Array container
	private int length;

	// constructor for the Iterators class
	public Iterators(int length) {
		this.length = length;
	}

	@Override
	public Iterator<E> iterator() {
		// return an inner-class that is an Iterator Object
		E[] testData = getEArray(length);
		return new IteratorObject<E>(testData);
	}

	// hack to return an Array of E Objects, suppress warnings (optional)
	@SuppressWarnings("unchecked")
	private E[] getEArray(int length) {
		return (E[]) new Object[length];
	}

	// an inner-class for the iterator() method to return, suppress warnings (optional)
	@SuppressWarnings("hiding")
	private class IteratorObject<E> implements Iterator<E> {

		// container for the E Objects
		private E[] container;

		// gets the next step count for hasNext
		private int nextIndex;

		/* checks if its safe to remove [is true once program calls next()].
		 * remove() deletes the next() method's previous returned value, so
		 * next() must be called before remove; therefore, create this variable
		 * to check if the program called next() before remove(). */
		boolean isRemoveSafe;

		// constructor, ignore any warnings
		public IteratorObject(E[] container) {
			this.container = container;
			nextIndex = 0;
			isRemoveSafe = false;
		}

		// checks if there exists a next Object
		@Override
		public boolean hasNext() {
			return nextIndex < container.length;
		}

		// return the next element in the iteration, and goes forward one
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No more elements are left!");
			}
			// move cursor to the right and return the next index
			E nextObject = container[nextIndex];
			nextIndex++;
			isRemoveSafe = true;
			return nextObject;
		}

		// removes (sets null) the last element returned, and goes back one
		@Override
		public void remove() {
			if(!isRemoveSafe) {
				throw new IllegalStateException("Call next() since the "
						+ "program doesn't know the next Object.");
			}
			// move cursor to the left and remove the next index
			isRemoveSafe = false;
			nextIndex--;
			container[nextIndex] = null;
		}

	}
}
