package chapter14;

import java.util.Queue;

public class Queues {
	
	/*
	 * Determine if the elements in an Integer Queue are strictly decreasing from front to back.
	 * pre: All elements in the queue > 0
	 * post: The queue is restored to its original state, may not use an auxiliary data structure.
	 * 
	 * How to iterate through the Queue without modifying it:
	 * Let's say the Queue starts as [12, 10, 8, 8, 7]
	 * - We add a 0 flag, so it's now [12, 10, 8, 8, 7, 0]
	 * - Then dequeue (remove) and enqueue the front to the back [10, 8, 8, 7, 0, 12]
	 * - Then do the same step again, so dequeue, [8, 8, 7, 0, 12, 10]
	 * - Keep going... [8, 7, 0, 12, 10, 8] -> [7, 0, 12, 10, 8, 8] -> [0, 12, 10, 8, 8, 7]
	 * - Now this is the element at the flag, so remove it [12, 10, 8, 8, 7] however the loop
	 * 		will not run again so it won't be enqueued at the back of the Queue
	 * - Therefore, we have iterated through the entire Queue without modifying it.
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
			// push the previous element to the back of the queue
			queue.add(prev);
			prev = current;
		}
		return decreasing;
	}
}
