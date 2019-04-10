package chapter14;

import java.util.Queue;

public class Queues {

	/*
	 * Determine if the elements in an Integer Queue are strictly decreasing from front to back.
	 * pre: All elements in the queue > 0
	 * post: The queue is restored to its original state, may not use an auxiliary data structure.
	 */
	public static boolean isStrictlyDecreasing(Queue<Integer> queue) {
		queue.add(0); // flag, helps us determine stop point
		int prev = queue.remove();
		boolean decreasing = true;

		// loop until the previous dequeued is 0, which means the queue has been iterated through
		while(prev != 0) {
			int current = queue.remove();
			if(decreasing) {
				// if the previous is greater, then the queue is decreasing
				decreasing = prev > current;
			}
			// push the list
			queue.remove();
			prev = current;
		}
		return decreasing;
	}
}
