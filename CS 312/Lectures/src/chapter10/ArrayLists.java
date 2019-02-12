package chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayLists {

	/* Definitions:
	 * 1. Collection: An object that stores data; a.k.a "data structure"
	 * 		- Some collections maintain an ordering; some allow duplicates
	 * 		- Typical operations: add, remove, clear, contains, size
	 * 		- EX: ArrayList, LinkedList, HashMap, TreeSet, PriorityQueue
	 * 		- All of the above examples are found in the java.util package
	 * 2. Elements: Objects stored in a collection
	 * 3. List: a collection storing an ordered sequence of elements.
	 * 		- Each element starts at a 0-based index
	 * 		- A list has a size (number of elements)
	 * 		- Elements can be added anywhere into the list
	 * 4. ArrayList: a standard list in Java that has no set size
	 * 		- Syntax: ArrayList<Type> name = new ArrayList<Type>();
	 * 5. Wrapper class: An object whose sole purpose is to
	 * 		hold a primitive value.
	 */

	/* Extra Notes:
	 * 1. ArrayLists do NOT accept primitive-types, so you must
	 * 		use the wrapper classes instead.
	 * 2. Legal indexes for ArrayLists are between 0 and its size - 1
	 * 		- Anything out-of-bounds will return an Exception
	 * 3. Because of the compareTo method, we can actually sort and search
	 * 		Object types using sorting and searching algorithms.
	 * 4. When adding an element with a specified index, you cannot skip indexes.
	 * 5. ArrayLists with a parameter for initialCapacity is only used for memory
	 * 		purposes and does not alter the size() method or any logic.
	 *		EX: ArrayList<Integer> list = new ArrayList<Integer>(5);
	 * 6. When traversing an ArrayList, traverse inversely so that when removing
	 * 		removing an index the ArrayList will stay in order.
	 */

	/* References:
	 * 1. Read the Java Documentation about ArrayLists
	 * 		- https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
	 */

	public static void main(String[] args) {
		// creating a new ArrayList
		ArrayList<String> namesList = new ArrayList<String>();

		// add an element to an ArrayList
		namesList.add("Jessica");

		// adding an element to a specific index in an ArrayList
		namesList.add(1, "Bobby");
		namesList.add(1, "Tom"); // pushes the "Bobby" String to index 2

		// setting an element at a specific index in an ArrayList
		namesList.set(1, "Carl"); // sets the "Tom" String at index 1 to "Carl"
		
		// outputting the entire ArrayList (inner toString method)
		System.out.println(namesList); // outputs: [Jessica, Carl, Bobby]

		// getting individual values from the ArrayList
		System.out.println(namesList.get(2)); // outputs: Bobby
		System.out.println(namesList.get(1)); // outputs: Carl

		// get the size of an ArrayList
		int namesListSize = namesList.size(); // 3

		// remove from an ArrayList using index
		namesList.remove(2); // removes index 2 and returns Bobby
		namesListSize = namesList.size(); // 2

		// remove from an ArrayList using Object
		namesList.remove("Carl"); // removes index of Carl and returns true
		namesListSize = namesList.size(); // 1
		
		// return an index of an Object in an ArrayList
		namesList.indexOf("Jessica"); // returns 0, the index of Jessica
		
		// clear an ArrayList
		namesList.clear(); // removes all elements in the list

		// ArrayList using the Integer wrapper class
		ArrayList<Integer> peopleAges = new ArrayList<Integer>();
		peopleAges.add(12);
		System.out.println(peopleAges.get(0)); // outputs: 12

		// ArrayList with initialCapacity <- Read Extra Notes #5 for more info
		ArrayList<Integer> capacityList = new ArrayList<Integer>(2);
		capacityList.add(1); // size() == 1
		capacityList.add(2); // size() == 2, list is "filled"
		capacityList.add(3); // size() == 3, list is expanded to make room for the third element
	}

	// traversing an ArrayList <- Read Extra Notes #6 for more info
	public static void traverseArrayList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3453);
		list.add(324354);
		list.add(3259834);

		// Read Extra Notes #6 for more info
		for(int i = list.size() - 1; i >= 0; i--) {
			// remove even indexes
			if(i % 2 == 0) {
				list.remove(i);
			}
		}
	}
	
	// comparing among Objects in a Collection
	public static void comparing() {
		// compareTo method <- Read Definitions #6 for more info
		String firstPerson = "Alice";
		String secondPerson = "Jack";
		int personCompare = firstPerson.compareTo(secondPerson);
		System.out.println(personCompare); // output: -9

		// binary search algorithm using compareTo
		String[] namesArray = {"Alice", "Bobby", "Stenson", "Joe"};
		int stensonIndex = Arrays.binarySearch(namesArray, "Stenson"); // 2

		// TreeSet/Map uses compareTo interally for ordering
		Set<String> set = new TreeSet<String>(); // Set Object can be used since TreeSet extends Set
		for(String str : namesArray) {
			set.add(str);
		}
		System.out.println(set); // output: [Alice, Bobby, Joe, Stenson]

		// using the compareTo method on a custom Person Object
		Person robert = new Person("Robert", 25);
		Person joe = new Person("Joe", 28);
		robert.compareTo(joe); // -1
	}
	
	// shuffle a Collection in random order
	public static void shuffle(List<?> list) {
		if(list instanceof Collection) {
			Collections.shuffle(list); // shuffles the list Object in random order
		}
	}
}
