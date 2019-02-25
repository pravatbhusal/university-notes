package chapter15;

public class IntList {

	// container Array for the data-set
	private int[] intList;

	// the current size of the IntList
	private int size;

	/*
	 * pre: capacity >= 0
	 * post: initialize the intList
	 */
	// Worst-case Time Complexity: O(N) due to creating an Array takes N operations
	public IntList(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be less than 0.");
		}
		intList = new int[capacity];
	}

	/*
	 * pre: None
	 * post: copy the rawIntList into intoList
	 */
	// Worst-case Time Complexity: O(N)
	public IntList(IntList rawIntList) {
		size = rawIntList.size;
		intList = new int[size];

		// deep copy the rawIntList to intList
		for(int element = 0; element < size; element++) {
			intList[element] = rawIntList.get(element);
		}
	}

	// return the size of the list
	// Worst-case Time Complexity: O(1)
	public int getSize() {
		return size;
	}

	// return the capacity of the list
	// Time Complexity: O(1)
	public int getCapacity() {
		return intList.length;
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: the value at position
	 */
	// Worst-case Time Complexity: O(1)
	public int get(int position) {
		if(position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is either less than 0"
					+ "or greater than or equal to size.");
		}
		return intList[position];
	}

	// resize the intList Array up to the length parameter
	// Worst-case Time Complexity: O(N)
	private void resize(int length) {
		int[] newIntList = new int[length];

		// deep copy the new integer list from the old integer list
		for(int element = 0; element < size; element++) {
			newIntList[element] = intList[element];
		}
		// set the old integer list to the new list
		intList = newIntList;
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: push all values from the right of the position to the right
	 * 		by one index and insert the value into the position
	 */
	// Worst-case Time Complexity: O(N)
	public void insert(int position, int value) {
		if(position >= getCapacity()) {
			// resize list based on a standard resize algorithm: capacity * 2 + 1
			int resizeLength = getCapacity() * 2 + 1;
			resize(resizeLength);
		}
		// traverse backwards and push each element to the right by one index
		for(int element = size; element > position; element--) {
			intList[element] = intList[element - 1];
		}
		// insert the value into its proper position
		intList[position] = value;
		size++;
	}

	// merge another integer list to this integer list
	// Worst-case Time Complexity: O(N^2) due to insert()
	public void insertAll(IntList mergeIntList, int position) {
		// for each position of the merge list, insert into this list
		final int MERGE_LIST_SIZE = mergeIntList.size;
		for(int mergePosition = 0; mergePosition < MERGE_LIST_SIZE; mergePosition++) {
			int insertPosition = position + mergePosition;
			insert(insertPosition, mergeIntList.get(mergePosition));
		}
	}

	// add to the end of the list
	// Worst-case Time Complexity: O(N) due to resize()
	public void add(int value) {
		insert(size, value);
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: store a value at the position and push all values from
	 * 		the right of the position to the left by one index then
	 * 		return the stored value at the position
	 */
	// Worst-case Time Complexity: O(N)
	public int remove(int position) {
		if(position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is either less than 0"
					+ "or greater than or equal to size.");
		}
		// traverse backwards and push each element to the left by one index
		int deletedValue = intList[position];
		for(int element = position; element < size - 1; element++) {
			intList[element] = intList[element + 1];
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
	// Worst-case Time Complexity: O(N)
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
				intList[removeIndex - range] = intList[removeIndex];
			}
			size -= range;
		}
	}

	// return the list as a String
	// Worst-case Time Complexity: O(N)
	public String toString() {
		if (size == 0) {
			return "[]";
		}
		// create a string builder that builds the list as a String
		StringBuilder intListBuilder = new StringBuilder();
		intListBuilder.append("[" + intList[0]); //fence-post solution
		for (int element = 1; element < size; element++) {
			// append each value into the list
			intListBuilder.append (", ");
			intListBuilder.append(intList[element]);
		}
		intListBuilder.append("]");
		return intListBuilder.toString();
	}

	// test the IntList class
	public static void main(String[] args) {
		IntList list = new IntList(5);
		IntList mergeList = new IntList(10);
		mergeList.add(5);
		mergeList.add(10);
		mergeList.add(15);
		list.insertAll(mergeList, 0);
		list.add(20);
		list.insert(2, 25);
		list.removeRange(1, 3);
		System.out.println(list); // [5, 15, 20]
	}
}
