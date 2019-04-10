# Chapter 15 - Array-based Lists
This chapter highlights the variety of Array-based list data-structures you can program. These Array-based structures
utilize an internal Array container that holds the data of the values the client passes in. An example of an Array-based
list is the ArrayList class from the Java standard library.
- These lists use an Array as an internal storage container
- These lists are resizable as the list gets larger

# IntList
A list containing integers

# SortedIntList
Extends the IntList and utilizes a sorting mechanism for the data-sets using binary search.

# GackyGenericList
A list that can contain Object data-types, but is very gacky due to not using standard Java Generics.

# GenericList
A list that contains Generic data-types
- Implements Iterable<E> to allow the client to iterate through the list

# Time Efficiency
Most of the methods in the Lists have similar methods, instance variables, and functionality. Therefore, their
complexity is the same for many of the implementations. Below is a representation of the complexities of the
GenericList's public methods in best, average, and worst-case Big-O. Note that in Big-O, we cannot assume the
list is empty and make a fallacy that an algorithm is O(1); we can only assume the values within the Array.
- capacity constructor
  - O(N) all cases due to creating a new Array
- deep-copy constructor
  - O(N) all cases due to deep-copying
- getSize
  - O(1) all cases
- getCapacity
  - O(1) all cases
- get
  - O(1) all cases
- resize
  - O(N) all cases, due to deep-copying
  - Tip: resize(int newCapacity) where newCapacity = oldCapacity + constant would take O(N) average-case for the add algorithm due to needing to resize in constant time. Therefore, it's advised to do ```newCapacity = oldCapacity*2 + 1``` so that add() becomes O(1) average-case since it spreads out (amortizes) the cost of resizing enough.
- insert
  - O(N) worst-case, and F(N) = 2N due to resizing
  - O(N) average-case
  - O(1) best-case, when appending to the end of the list no need to fix positions
- insertAll
  - O(N^2) worst-case and average-case, due to needing to iterate the merge list and inserting
  - O(N) best-case, if the position parameter was at the very end of the list insert would be O(1)
- add
  - O(N) worst-case, and F(N) = 2N due to resizing
  - O(1) average and best-case, when appending at the end of the list
- remove
  - O(N) worst-case and average-case
  - O(1) best-case, when removing from the end of the list no need to fix positions
- removeRange
  - O(N) worst-case and average-case
  - O(1) best-case, when range only needs to remove once no need to fix positions
- toString
  - O(N) all cases

