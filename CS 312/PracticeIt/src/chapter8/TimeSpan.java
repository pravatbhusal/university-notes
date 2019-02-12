package chapter8;

public class TimeSpan {
	private int hours;
	private int minutes;

	// return hours
	public int getHours() {
		return hours;
	}

	// return minutes
	public int getMinutes() {
		return minutes;
	}

	// return time as a String
	public String toString() {
		return hours + ":" + minutes;
	}

	/* Add the following method to the TimeSpan class:
	 *
	 * public void add(TimeSpan span)
	 *
	 * Adds the given amount of time to this time span.
	 */
	public void add(TimeSpan span) {
		hours += span.getHours();
		minutes += span.getMinutes();

		// convert the minutes into hours
		if(minutes >= 60) {
			int extraHours = minutes / 60;
			hours += extraHours;
			minutes -= 60;
		}
	}
}
