package chapter11;

// Comparable data-types require the "Comparable" interface
public class Comparables<E> implements Comparable<E> {

	private E classObject;

	/*
	 * Definitions:
	 * 1. Comparable: An interface that contains a compareTo
	 * 		method that compares a passed Generic Object to
	 * 		another Object (typically the Object within the
	 * 		same class).
	 * 		- If the two Objects are equal, return 0
	 * 		- If the class Object is greater than the passed Object, return x > 0
	 * 		- If the class Object is less than the passed Object, return x < 0
	 */

	// constructor
	public Comparables(E obj) {
		classObject = obj;
	}

	// compare the classObject to the passedObject <- Read Definitions #1 for more info
	@Override
	public int compareTo(E passedObject) {
		if(classObject.hashCode() > passedObject.hashCode()) {
			// class object is greater than passed object
			return 1;
		} else if(classObject.hashCode() < passedObject.hashCode()) {
			// class object is less than passed object
			return -1;
		}
		return 0; // equal
	}

}
