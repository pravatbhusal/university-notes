package chapter16;

public class SinglyLinkedList<E> {

	// the size of the list
	private int size;

	// the first Node reference of the list
	private Node<E> first;

	// the last Node reference of the list
	private Node<E> last;

	// append to the end of the list
	public void add(E data) {
		Node<E> newNode = new Node<E>(data);
		if(first == null) {
			// list is empty, fence-post our first reference
			first = newNode;
		} else {
			// list is not empty, set the old last's next reference to the new Node
			last.setNext(newNode);
		}
		// update the last reference to the new Node
		last = newNode;
		size++;
	}

	// add to the front of the list
	public void addFront(E data) {
		Node<E> newNode = new Node<E>(data);
		if(first == null) {
			// list is empty, fence-post our first and last reference
			first = newNode;
			last = newNode;
		} else {
			// list is not empty, set the new first's next reference to the old first reference
			newNode.setNext(first);
			first = newNode;
		}
		size++;
	}

	// return the list as a String
	@Override
	public String toString() {
		Node<E> refNode = first;
		StringBuilder listBuilder = new StringBuilder();
		listBuilder.append("[");

		// loop till we hit the last Node
		while(refNode != last) {
			// append the data, then go to the next Node
			listBuilder.append(refNode.getData());
			listBuilder.append(", ");
			refNode = refNode.getNext();
		}
		// if not null, fence-post solution for the last Node
		if(refNode != null) {
			listBuilder.append(refNode.getData());
		}
		listBuilder.append("]");

		// return the list builder as a String
		return listBuilder.toString();
	}

	// test the SinglyLinkedList class
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(12);
		list.add(17);
		list.addFront(5);
		list.add(102);
		list.addFront(18);
		System.out.println(list); // [18, 5, 12, 17, 102]
	}
}
