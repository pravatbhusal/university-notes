package chapter17;

// BST that accepts an E data-type that extends Comparable
public class BinarySearchTree<E extends Comparable<? super E>> {

	// the root Node of the BST
	private BNode<E> root;

	// the size (number of Nodes) of the BST
	private int size;

	// return the size (number of Nodes)
	public int size() {
		return size;
	}

	// add a new value into the BST, return if successful
	public boolean add(E value) {
		int oldSize = size;

		// set the root Node equal to the helper (in-case it's null)
		root = addHelper(value, root);

		// if the old size has changed, then a Node was added
		return oldSize != size;
	}

	// a helper method to recursively add the value into the correct Node
	private BNode<E> addHelper(E value, BNode<E> node) {
		if(node == null) {
			/* base-case, add the Node to the tree by setting
				the left or right reference of its parent */
			size++;
			return new BNode<E>(value);
		}
		// determine the direction by comparing the value to this Node's data
		int direction = value.compareTo(node.data);
		if(direction < 0) {
			// value is less than the Node, so recurse left
			node.leftChild = addHelper(value, node.leftChild);
		} else if(direction > 0) {
			// value is greater than the Node, so recurse right
			node.rightChild = addHelper(value, node.rightChild);
		}
		// return back the same Node, so we don't change the Node reference
		return node;
	}

	// return the height of the BST from the root Node
	public int height() {
		return helperHeight(root);
	}

	// a helper method to recursively get the height of the tree
	private int helperHeight(BNode<E> node) {
		if(node == null) {
			// outside the tree, subtract one because out-of-bounds
			return -1;
		}
		/* traverse through the entire tree, and add-up the greatest
			height between the right and left sub-trees */
		return 1 + Math.max(helperHeight(node.rightChild), helperHeight(node.leftChild));
	}

	// remove a value from the BST, return if successful
	public boolean remove(E value) {
		int oldSize = size;

		// set the root Node equal to the helper (in-case it deletes the root)
		root = removeHelper(value, root);

		// if the old size has changed, then a Node was deleted
		return oldSize != size;
	}

	// a helper method to recursively remove a value from the tree
	private BNode<E> removeHelper(E value, BNode<E> node) {
		if(node != null) {
			// determine the direction by comparing the value to this Node's data
			int direction = value.compareTo(node.data);
			if(direction < 0) {
				// target value is less than the Node, so recurse left
				node.leftChild = removeHelper(value, node.leftChild);
			} else if(direction > 0) {
				// target value is greater than the Node, so recurse right
				node.rightChild = removeHelper(value, node.rightChild);
			} else {
				// found the target Node, let's delete it
				size--;
				if(node.leftChild == null && node.rightChild == null) {
					// delete the leaf Node
					node = null;
				} else if(node.rightChild == null) {
					// the Node to delete only has one child, the left child
					// delete the Node by linking the Node's parent to the Node's left child
					node = node.leftChild;
				} else if(node.leftChild == null) {
					// the Node to delete only has one child, the right child
					// delete the Node by linking the Node's parent to the Node's right child
					node = node.rightChild;
				} else {
					// the Node has two children, so copy it to the max of the left-subtree
					node.data = getMaxValue(node.leftChild);

					// now there are duplicates, remove the max of the left-subtree Node
					/* sooner or later it'll hit the original max of the left
						subtree and execute the leaf Node deletion case */
					node.leftChild = removeHelper(node.data, node.leftChild);

					// since it's recursive, we need to backtrack size correctly (GACKY!)
					/* it'll still decrement by one since there'll be a recursive
						case where this else statement does not execute */
					size++;
				}
			}
		}
		// return back the Node, which may or may not change based on if it was deleted
		return node;
	}

	// return the maximum data from a Node sub-tree
	private E getMaxValue(BNode<E> node) {
		BNode<E> currentNode = node;
		E data = null;

		// iterate the right-subtree from this Node to get the maximum value
		while(currentNode != null) {
			if(currentNode.rightChild == null) {
				// the base-case, the next right child Node is null so set the value
				data = currentNode.data;
			}
			// traverse right (greater value)
			currentNode = currentNode.rightChild;
		}
		return data;
	}

	// print the pre-order traversal of the tree
	public void printPreOrder() {
		printPreOrderHelper(root);
	}

	// a helper method to recursively print the pre-order traversal
	private void printPreOrderHelper(BNode<E> node) {
		if(node != null) {
			// print before the recursive calls
			System.out.println(node.data);

			// traverse through the entire tree, per level
			printPreOrderHelper(node.rightChild);
			printPreOrderHelper(node.leftChild);
		}
	}

	// print the in-order traversal of the tree
	public void printInOrder() {
		printInOrderHelper(root);
	}

	// a helper method to recursively print the in-order traversal
	private void printInOrderHelper(BNode<E> node) {
		if(node != null) {
			// traverse through the right sub-tree
			printInOrderHelper(node.rightChild);

			// print in-between the recursive calls
			System.out.println(node.data);

			// traverse through the left sub-tree
			printInOrderHelper(node.leftChild);
		}
	}

	// print the post-order traversal of the tree
	public void printPostOrder() {
		printPostOrderHelper(root);
	}

	// a helper method to recursively print the post-order traversal
	private void printPostOrderHelper(BNode<E> node) {
		if(node != null) {
			// traverse through the entire tree, per level
			printPostOrderHelper(node.rightChild);
			printPostOrderHelper(node.leftChild);

			// print after the recursive calls
			System.out.println(node.data);
		}
	}

	// a private inner-class to represent Nodes of the BST
	private static class BNode<E> {
		private E data;
		private BNode<E> leftChild;
		private BNode<E> rightChild;

		// a default constructor for BST Node
		private BNode() {}

		// construct a BST Node with an initial value
		private BNode(E value) {
			data = value;
		}
	}

	// a tester method for the BST
	public static void main(String[] args) {
		BinarySearchTree<Integer> bTree = new BinarySearchTree<>();

		// add
		bTree.add(12);
		bTree.add(49);
		bTree.add(42);
		bTree.add(13);
		bTree.add(5);

		// traversals
		System.out.println("Pre-Order Traversal");
		bTree.printPreOrder();
		System.out.println("In-Order Traversal");
		bTree.printInOrder();
		System.out.println("Post-Order Traversal");
		bTree.printPostOrder();
		System.out.println();

		// height
		System.out.println("The height is: " + bTree.height());
		System.out.println();

		// remove
		bTree.remove(5);
		bTree.remove(13);
		System.out.println("Pre-Order Traversal to Test Remove");
		bTree.printPreOrder();
	}
}
