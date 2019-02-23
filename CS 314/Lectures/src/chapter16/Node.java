package chapter16;

public class Node<E> {

	// data of the Node
	private E data;

	// link to the next Node
	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	// return the data of the Node
	public E getData() {
		return data;
	}

	// return the next Node linked to this Node
	public Node<E> getNext() {
		return next;
	}

	// set the data of the Node
	public void setData(E data) {
		this.data = data;
	}

	// set the next Node linked to this Node
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
