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

# Binary Tree
Each Node has no more than two children.
- The "possible" children are referred to as the left and right child

### Full Binary Tree
Each Node has exactly 2 or 0 children.

### Complete Binary Tree
Every level, except the deepest depth, is completely filled. At the deepest depth, all Nodes are to the far left.
- Filled in from left to right, top to bottom
- The height of a complete binary tree with N Nodes is O(log2(N))
  - Ex: Let's say there 8 Nodes for a complete binary tree, then log2(8) = height of 3
  
### Perfect Binary Tree
All interior Nodes have two children, and all leaf Nodes have the same depth.

# Binary Tree Traversal
### Level-order
Traverse the tree through left-to-right, top-to-bottom Nodes

### Pre-Order
While traversing through the tree, get the left-intersected Node

### In-Order
While traversing through the tree, get the bottom-intersected Node

### Post-Order
While traversing through the tree, get the right-intersected Node

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
