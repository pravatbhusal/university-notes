package chapter15;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* Change the original IntList.java to a GackyGenericList
	using the E class instead of integers. */
public class GenericList<E> implements Iterable<E> {

	// container Array for the data-set
	private E[] genericList;

	// the current size of the GenericList
	private int size;

	/*
	 * pre: capacity >= 0
	 * post: initialize the genericList
	 */
	public GenericList(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be less than 0.");
		}
		genericList = getArray(capacity);
	}

	// return an Array of E[] using a hack since in Java you cannot initialize an Array of E[]
	private E[] getArray(int length) {
		return (E[]) new Object[length]; // ignore the SuppressWarnings in the Eclipse IDE
	}

	/*
	 * pre: None
	 * post: copy the rawGenericList into intoList
	 */
	public GenericList(GenericList<E> rawGenericList) {
		size = rawGenericList.size;
		genericList = getArray(size);

		// deep copy the rawGenericList to genericList
		for(int element = 0; element < size; element++) {
			genericList[element] = rawGenericList.get(element);
		}
	}

	// return the size of the list
	public int getSize() {
		return size;
	}

	// return the capacity of the list
	public int getCapacity() {
		return genericList.length;
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: the value at position
	 */
	public E get(int position) {
		if(position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is either less than 0"
					+ "or greater than or equal to size.");
		}
		return genericList[position];
	}

	// resize the genericList Array up to the length parameter
	private void resize(int length) {
		E[] newGenericList = getArray(length);

		// deep copy the new integer list from the old integer list
		for(int element = 0; element < size; element++) {
			newGenericList[element] = genericList[element];
		}
		// set the old integer list to the new list
		genericList = newGenericList;
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: push all values from the right of the position to the right
	 * 		by one index and insert the value into the position
	 */
	public void insert(int position, E value) {
		if(position >= getCapacity()) {
			// resize the list to the position
			int resizeLength = position + 1;
			resize(resizeLength);
		}
		// traverse backwards and push each element to the right by one index
		for(int element = size; element > position; element--) {
			genericList[element] = genericList[element - 1];
		}
		// insert the value into its proper position
		genericList[position] = value;
		size++;
	}

	// merge another integer list to this integer list
	public void insertAll(GenericList<E> mergeGenericList, int position) {
		// for each position of the merge list, insert into this list
		final int MERGE_LIST_SIZE = mergeGenericList.size;
		for(int mergePosition = 0; mergePosition < MERGE_LIST_SIZE; mergePosition++) {
			int insertPosition = position + mergePosition;
			insert(insertPosition, mergeGenericList.get(mergePosition));
		}
	}

	// add to the end of the list
	public void add(E value) {
		insert(size, value);
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: store a value at the position and push all values from
	 * 		the right of the position to the left by one index then
	 * 		return the stored value at the position
	 */
	public E remove(int position) {
		if(position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is either less than 0"
					+ "or greater than or equal to size.");
		}
		// traverse backwards and push each element to the left by one index
		E deletedValue = genericList[position];
		for(int element = position; element < size - 1; element++) {
			genericList[element] = genericList[element + 1];
		}
		size--;
		return deletedValue;
	}

	/*
	 * pre: 0 <= start <= stop <= size()
	 * post: Removes from this list all of the elements whose index is between
	 * start, inclusive, and stop, exclusive. Shifts any succeeding elements to the
	 * left (reduces their index). Size of list updated correctly.
	 */
	public void removeRange(int start, int stop) {
		if(start < 0 || start > stop || stop > size) {
			throw new IllegalArgumentException("The start is either less than zero, "
					+ "greater than stop, or stop is greater than the size.");
		}
		// short-circuit the algorithm if it's the same start and stop
		if(start != stop) {
			int range = stop - start;
			for(int removeIndex = stop; removeIndex < size; removeIndex++) {
				/* replace all elements after the stop index
					into the delete range of elements */
				genericList[removeIndex - range] = genericList[removeIndex];
			}
			size -= range;
		}
	}

	// return the list as a String
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		// create a string builder that builds the list as a String
		StringBuilder genericListBuilder = new StringBuilder();
		genericListBuilder.append("[" + genericList[0]); //fence-post solution
		for (int element = 1; element < size; element++) {
			// append each value into the list
			genericListBuilder.append (", ");
			genericListBuilder.append(genericList[element]);
		}
		genericListBuilder.append("]");
		return genericListBuilder.toString();
	}

	// test the GenericList class
	public static void main(String[] args) {
		GenericList<Integer> list = new GenericList<Integer>(5);
		GenericList<Integer> mergeList = new GenericList<Integer>(10);
		mergeList.add(5);
		mergeList.add(10);
		list.insertAll(mergeList, 0);
		list.add(20);
		list.insert(2, 25);
		list.removeRange(1, 3);
		System.out.println(list); // [5, 20]
	}

	// iterator method from the Iterable interface
	// use this method to iterate through the list and use for each loop
	@Override
	public Iterator<E> iterator() {
		// use an inner-GenericList Iterator class
		return new GLIterator();
	}

	// create an inner-class that implements the Iterator interface
	private class GLIterator implements Iterator<E> {

		// gets the next step count for hasNext
		private int indexOfNext;
		
		/* checks if its safe to remove [is true once program calls next()].
		 * remove() deletes the next() method's previous returned value, so
		 * next() must be called before remove; therefore, create this variable
		 * to check if the program called next() before remove(). */
		private boolean isRemoveSafe;

		// return if there is a next element in the iteration available
		@Override
		public boolean hasNext() {
			return indexOfNext < getSize();
		}

		// return the next element in the iteration
		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No more elements left.");
			}
			// return the next element in the iteration, then move cursor to the right
			E result = genericList[indexOfNext];
			isRemoveSafe = true;
			indexOfNext++; 
			return result;
		}

		// remove the last returned index by next()
		@Override
		public void remove() {
			if(!isRemoveSafe) {
				throw new IllegalStateException("Not okay to remove. Call next.");
			}
			// move cursor to the left to remove the last returned index by next()
			isRemoveSafe = false;
			indexOfNext--;
			
			// remove the element, using the "this" keyword from GenericList due to being inside an inner-class
			GenericList.this.remove(indexOfNext);
		}

	}
}
