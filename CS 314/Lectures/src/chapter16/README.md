# LinkedList
A list that links Nodes together to hold data without using an Array storage container.

# Efficiency Differences to an Array-based List:
### Adding to the lists
- In the worst-case, adding to the last of an Array-based List like ArrayList would take O(N) due to needing to resize.
However, a LinkedList is O(1) because it doesn't need to re-size.
- In the worst-case, adding to the start of an Array-based List would take O(N) or F(N) = 2N due to
needing to iterate through the entire Array to push elements in proper position and resizing.
However, a LinkedList is O(1) because it uses reference pointers as Nodes.
- Inserting in the middle of both lists are O(N).

### Removing from the lists
- Removing at the front or back of an Array-based list is O(N). However, for  a LinkedList it's O(1).
- Removing in the middle of both lists is O(N).
