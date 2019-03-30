# Tree
### Nodes
- Root Node: Entry point
- Each Node is a leaf Node or internal Node
  - Leaf Node: A Node without any children Nodes
  - Internal Node: A Node with children Nodes
- Siblings Nodes are Nodes with the same parent Node

### Tree Structure
- Edge/Path: A branch within the tree
- Path Length: The number of edges that must be traversed to get from one Node to another
- Depth: The path length from the root Node to a target Node
  - Level = Depth + 1
- Height: The path length from an internal Node to its furthest leaf Node

<img src="images/regular_tree.png" height="35%" width="35%"></img>

# Binary Tree
Each Node has no more than two children.
- The "possible" children are referred to as the left and right child

### Full Binary Tree
Each Node has exactly 2 or 0 children.

<img src="images/full_binary_tree.png" height="35%" width="35%"></img>

### Complete Binary Tree
Every level, except the deepest depth, is completely filled. At the deepest depth, all Nodes are to the far left.
- Filled in from left to right, top to bottom
- The height of a complete binary tree with N Nodes is O(log2(N))
  - Ex: Let's say there 8 Nodes for a complete binary tree, then log2(8) = height of 3
  
<img src="images/complete_binary_tree.png" height="35%" width="35%"></img>
  
### Perfect Binary Tree
All interior Nodes have two children, and all leaf Nodes have the same depth.
- Has 2^(n+1) - 1 Nodes where n is the height of the tree

# Binary Tree Traversal
<img src="images/binary_tree_traversal.png" height="35%" width="35%"></img>

### Level-order
Starting from the root of a tree, process all nodes at the same depth from left to right, then proceed to the nodes at the next depth

### Pre-Order
Process the root, then process all subtrees (left to right)

### In-Order
Process the left sub tree, process the oot, process the right sub tree

### Post-Order
Process the left sub tree, process the right sub tree, then process the root

### Program for Printing Pre-Order, In-Order, and Post-Order Traversal
```java
public static void traversal(BNode node) {
   if(node != null) {
       // print the Node here for pre-order
       traversal(node.getLeft());
       // print the Node here for in-order
       traversal(node.getRight());
       // print the Node here for post-order
   }
}
```
