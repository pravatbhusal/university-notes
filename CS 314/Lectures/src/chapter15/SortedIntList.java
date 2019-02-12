package chapter15;

public class SortedIntList extends IntList {

	// construct a SortedIntList with a capacity
	public SortedIntList(int capacity) {
		super(capacity);
	}

	// add an element and sort it within the list
	@Override
	public void add(int value) {
		// use binary search to find the position to add the value
		int start = 0;
		int stop = getSize() - 1;

		// binary search algorithm
		int position = -1;
		while(position != -1 && start <= stop) {
			int mid = (start + stop) / 2;
			if(get(mid) == value) {
				position = mid;
			} else if(mid < get(mid)) {
				stop = mid - 1; // divide in half by left
			} else if(mid > get(mid)) {
				start = mid + 1; // divide in half by right
			}
		}
		if(position == -1) {
			/* cannot find the same value in the list, insert into start,
				which is beginning of the sorted location for the value */
			insert(start, value);
		} else {
			// we found the same value at a position position, so place this value there too
			insert(position, value);
		}
		
		/* NOTE: This would be a logic error if the client tried to use the
			insert() method since we haven't modified the insert() method to sort. */
	}
}
