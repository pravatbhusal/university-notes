package chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Maps {

	/*
	 * Definitions:
	 * 1. Map: An interface that maps keys to values.
	 * 		- Cannot contain duplicate keys, or else it replaces it
	 * 		- Therefore, each key can map only one value
	 * 		- Declared as Map<K, V> where K = key, V = value
	 * 2. TreeMap: A class that implements the Map interface and sorts
	 * 		the keys in ascending order (least to greatest)
	 * 		- Uses the Comparable<E> interface and compareTo method to sort
	 * 3. HashMap: A class that implements the Map interface and randomly
	 * 		distributes the keys using an efficient hashing algorithm.
	 * 4. Sets: An interface that extends Collection,
	 * 		and has no duplicate elements
	 * 		- It is iterable
	 * 		- Use Map.keySet() to get a Set of the keys, which you
	 * 			can use to iterate through each key-value pair
	 */

	/*
	 * Extra Notes:
	 * 1. Use TreeMaps when you need to sort the keys in order.
	 * 2. Use HashMaps when you don't need to sort keys and need efficiency.
	 * 3. Use Map.keySet() to get a Set of keys to use as an iterable
	 * 		for any Map Object. You MUST use a for-each loop.
	 * 		- for(E key : Map.keySet()) to iterate through each key
	 */

	/*
	 * Programming Hygiene Tips:
	 * 1. When declaring, usually a good idea to use the "Map" interface
	 * 		as the declaration, then it equals to any Map-type (such as
	 * 		TreeMap or HashMap).
	 * 		- This allows the programmer to easily change the Map-type
	 * 			on the initialized data-typing without causing any issues
	 * 		- Ex: Map<Integer, String> treeMap = new TreeMap<Integer, String>();
	 */

	public static void main(String[] args) {
		// creating a simple TreeMap <- Read Definitions #1 and 2 for more info
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();

		// adding values to the tree map
		treeMap.put(42, "Pravat");
		treeMap.put(36, "Abhi");
		treeMap.put(32, "Dinesh");
		treeMap.put(86, "Taran");
		System.out.println(treeMap); // outputs: {32=Dinesh, 36=Abhi, 42=Pravat, 86=Taran}

		// getting a key value
		String nameOfKey32 = treeMap.get(32);
		System.out.println(nameOfKey32); // outputs: Dinesh

		// check if the Map contains a key
		boolean containsKey55 = treeMap.containsKey(55);
		System.out.println(containsKey55); // outputs: false

		/* iterate through a Map using keySet(), you MUST 
			use a for-each loop to get from a Set */
		Set<Integer> keySet = treeMap.keySet();
		for(Integer key : keySet) {
			System.out.print(key + " "); // outputs: 32 36 42 86
		}

		// creating a simple HashMap <- Read Definitions #1 and 3 for more info
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		// adding values to the tree map
		hashMap.put(42, "Pravat");
		hashMap.put(36, "Abhi");
		hashMap.put(32, "Dinesh");
		hashMap.put(86, "Taran");
		System.out.println(hashMap); // {32=Dinesh, 36=Abhi, 86=Taran, 42=Pravat}
	}
}
