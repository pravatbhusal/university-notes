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
		if(size == 0) {
			// list is empty, fence-post our first reference
			first = newNode;
		} else {
			// set the old last's next reference to the new Node
			last.setNext(newNode);
		}
		// update the last reference to the new Node
		last = newNode;
		size++;
	}

	// add to the front of the list
	public void addFront(E data) {
		if(size == 0) {
			// list is empty, let add() handle it
			add(data);
		} else {
			// set the new Node's next reference to the old first reference
			Node<E> newNode = new Node<E>(data);
			newNode.setNext(first);
			first = newNode; // set the new first's reference to the new Node
		}
		size++;
	}

	// insert at a position of the list
	public void insert(int position, E data) {
		// fence-post solutions
		if(position == 0) {
			addFront(data); // front of list
		} else if(position == size) {
			add(data); // end of list
		}
		// get the previous Node of the target position
		Node<E> prevNode = getNode(position - 1);

		// set the new Node's next to the previous Node's next
		Node<E> newNode = new Node<E>(data);
		newNode.setNext(prevNode.getNext());

		// set the previous Node's next to the new Node
		prevNode.setNext(newNode);
		size++;
	}

	// remove a Node at the front of the list
	public E removeFront() {
		E removed = first.getData();

		// set the old first's Node to its next Node
		first = first.getNext();

		size--;
		if(size == 0) {
			// list is empty, so also update last
			last = null;
		}
		return removed;
	}

	// remove a Node at a position of the list
	public E remove(int position) {
		if(position == 0) {
			return removeFront(); // front of list
		}
		// get the previous Node of the target position
		Node<E> prevNode = getNode(position - 1);
		E removed = prevNode.getNext().getData();

		// set the previous Node's next to its next next Node
		prevNode.setNext(prevNode.getNext().getNext());

		size--;
		if(prevNode.getNext() == null) {
			// program removed the last Node, so update last
			last = prevNode;
		}
		return removed;
	}

	// return a Node's data at a position
	public E get(int position) {
		return getNode(position).getData();
	}

	// return a Node at a position
	private Node<E> getNode(int position) {
		// fence-post solution for efficiency
		if(position == size - 1) {
			return last;
		}

		// iterate till it reaches the position's Node
		Node<E> currentNode = first;
		for(int nodePos = 0; nodePos < position; nodePos++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
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
		list.insert(3, 100);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		System.out.println(list); // [12, 17, 102]
	}
}
