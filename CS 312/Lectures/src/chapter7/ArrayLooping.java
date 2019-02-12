package chapter7;

public class ArrayLooping {

	/* Definitions:
	 * 1. For-Each Loop: Traverse an Array without needing its index.
	 * 2. Previous Looping: Looping by setting the iterated value equal to the previous indexes in a loop.
	 *		This helps prevent a fence-post solution.
	 * 3. Previous and Next Looping: Looping by checking the bounds of the Array,
	 * 		then determining that it's safe to get the previous and next elements.
	 */

	public static void main(String[] args) {
		int[] data = {-32, -1343, 234, 4326, 65756};

		// For-Each Loop example <- Read Definitions #1 for more info
		for(int value : data) {
			int currentValue = value; // equal to a value in the Array, in order
		}

		// Previous Looping <- Read Definitions #2 for more info
		for(int i = 1; i < data.length; i++) {
			int currentElement = data[i];
			int prevElement = data[i - 1];
		}

		// Previous and Next Looping <- Read Definitions #3 for more info
		for(int i = 0; i < data.length; i++) {
			int prev = -1;
			int current = data[i];
			int next = -1;
			if(i != 0) {
				prev = data[i - 1];
			}
			if(i < data.length - 1) {
				next = data[i + 1];
			}
			System.out.println(prev + " " + current + " " + next);
		}

		// "Insert Into" via Ascending Order Algorithm <- Uses Previous and Next Looping
		int insert = 6;
		int index = 0;
		boolean inserted = false;
		for(int i = 0; i < data.length; i++) {
			boolean prevExists = false;
			boolean nextExists = false;
			int prev = -1;
			int next = -1;
			if(i != 0) {
				prev = data[i - 1];
				prevExists = true;
			}
			if(i < data.length - 1) {
				next = data[i + 1];
				nextExists = true;
			}

			// find the best index
			if(!inserted) {
				if(!prevExists && next >= insert) {
					// at first element
					index = i;
					inserted = true;
				} else if(!nextExists) {
					// at last element
					index = i;
					inserted = true;
				} else if(prev <= insert && next > insert) {
					// use regular algorithm
					index = i;
					inserted = true;
				}
			}
		}
		int removed = data[index]; // remove the old index
		data[index] = insert; // insert the new index
		System.out.println("Old value removed: " + removed); // output: -1343
	}
}
