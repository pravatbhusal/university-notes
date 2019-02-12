package chapter15;

/* Change the original IntList.java to a GackyGenericList
	using the Object class instead of integers. */
public class GackyGenericList {

	// container Array for the data-set
	private Object[] genericList;

	// the current size of the GenericList
	private int size;

	/*
	 * pre: capacity >= 0
	 * post: initialize the genericList
	 */
	public GackyGenericList(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be less than 0.");
		}
		genericList = new Object[capacity];
	}

	/*
	 * pre: None
	 * post: copy the rawGenericList into intoList
	 */
	public GackyGenericList(GackyGenericList rawGenericList) {
		size = rawGenericList.size;
		genericList = new Object[size];

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
	public Object get(int position) {
		if(position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is either less than 0"
					+ "or greater than or equal to size.");
		}
		return genericList[position];
	}

	// resize the genericList Array up to the length parameter
	private void resize(int length) {
		Object[] newGenericList = new Object[length];

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
	public void insert(int position, Object value) {
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
	public void insertAll(GackyGenericList mergeGenericList, int position) {
		// for each position of the merge list, insert into this list
		final int MERGE_LIST_SIZE = mergeGenericList.size;
		for(int mergePosition = 0; mergePosition < MERGE_LIST_SIZE; mergePosition++) {
			int insertPosition = position + mergePosition;
			insert(insertPosition, mergeGenericList.get(mergePosition));
		}
	}

	// add to the end of the list
	public void add(Object value) {
		insert(size, value);
	}

	/*
	 * pre: position >= 0 and position < size
	 * post: store a value at the position and push all values from
	 * 		the right of the position to the left by one index then
	 * 		return the stored value at the position
	 */
	public Object remove(int position) {
		if(position < 0 || position >= size) {
			throw new IllegalArgumentException("Position is either less than 0"
					+ "or greater than or equal to size.");
		}
		// traverse backwards and push each element to the left by one index
		Object deletedValue = genericList[position];
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

	/*
	 * pre: None
	 * post: Remove all redundant values within this list
	 */
	public void removeRedundants() {
		int uniques = 0; // the number of unique values in the list
		for(int index = 0; index < size; index++) {
			/* search if this value is redundant by iterating backwards, so the first unique
				element is not redundant but any elements afterwards is considered redundant */
			boolean isRedundant = false;
			int searchIndex = uniques - 1; // start iterating within the uniques section of the list
			while(!isRedundant && searchIndex >= 0) {
				if(genericList[index].equals(genericList[searchIndex])) {
					// found the same value, so it's redundant
					isRedundant = true;
				}
				searchIndex--;
			}
			if(!isRedundant) {
				// shift the unique value to the left
				genericList[uniques] = genericList[index];
				uniques++;
			}
		}
		// nullify all the non-unique elements for the garbage collector
		for(int nonUnique = uniques + 1; nonUnique < size; nonUnique++) {
			genericList[nonUnique] = null;
		}
		// update size to equal uniques since we only want the unique values
		size = uniques;
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
		GackyGenericList list = new GackyGenericList(5);
		GackyGenericList mergeList = new GackyGenericList(10);
		mergeList.add(5);
		mergeList.add(10);
		mergeList.add("Hello");
		list.insertAll(mergeList, 0);
		list.insert(2, 25);
		list.removeRange(1, 3);
		list.add(20);
		list.add(20);
		list.add(20);
		list.removeRedundants();
		System.out.println(list); // [5, Hello, 20]
	}
}