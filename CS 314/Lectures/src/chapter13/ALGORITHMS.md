# Types of Algorithms
### In-place Algorithms
An in-place algorithm is an algorithm that changes the list without using an auxiliary data-structure. For example, if a sorting algorithm (like Merge Sort) needs multiple Arrays to sort the parent list, then it's NOT considered an in-place algorithm.

### Comparison Algorithms
A sorting algorithm that reads the list elements using a comparison operator like "greater than."

### Stable Algorithms
An algorithm that guarantees the relative order of equal items stays the same.  

Ex: [7(1), 6, 7(2), 5, 1, 2, 7(3), -5] ->  
	[-5, 1, 2, 5, 6, 7(1), 7(2), 7(3)]  
	The 7(x) are in order.  

Stable algorithms may matter for certain Object-types.

# Searching Algorithms
### Why Sort?
- Makes searching easier, especially for Binary Search

### Linear Search (or Sequential Search)
1. A single for loop that returns the target index once found.  
- O(N) time, best-case is O(1) when first element is the target

### Binary Search
1. If items are sorted, divide and conquer the list until found target.  
- O(log(N)) time, best-case is O(1) when the target is the middle element

Utilizes high (last index), low (first index), and middle (index of half)
- low = 0 at base, then low = mid + 1 if searching the right-side
- high = list.length - 1 at base, then high = mid - 1 if searching the left-side
- middle = low + ((high - low) /2) <- Don't use (low + high) / 2 because it may overflow integer

# Simple Sorting Algorithms
### Selection Sort (Not stable)
1. Find smallest element, then put it at the 0th index.  
2. Then the 2nd smallest index goes to the 1st index.  
3. Then the 3rd smallest index goes to the 2nd index.  
4. So on and so forth until the list is sorted.  
- O(N^2) time, best-case is O(N^2) even if the list is sorted because the dependent loop has no case that stops it from iterating

### Insertion Sort (Stable)
1. Swap each element to a sorted portion on the left-side of the list  
2. When an element found is less than the previous element, it places the found element to the proper position in the sorted portion on the left-side of the list.  
- O(N^2) time, best-case is O(N) when the list is already sorted so the dependent loop does not need to place any found elements to the sorted portion on the left-side of the list

# Faster Sorting Algorithms
### Quick Sort (Not Stable)
1. Decide a pivot (conventionally, the middle-index).  
2. Partition the list, all elements to the left of the pivot is less than the pivot, and all the elements to the right of the pivot is greater than the pivot.  
3. Recursively do steps 1 and 2 on smaller and smaller portions of the left and right-sides of the list until the program reaches the base-case: when the list length is 0 or 1.
- The division portion takes log2(N) times, and the partitioning takes N times; therefore, it takes O(Nlog(N)) time for best and worst-case
- However, worst-case is O(N^2) if the starting pivot becomes the greatest or smallest element because the dividing is no longer log(N) and becomes N

### Merge Sort (Stable)
1. Split the list into sub-lists until each sub-list contains 0 or 1 elements.  
2. Sort the smaller lists, then merge them together.  
- The division and merge portion takes log2(N) times, and the sorting takes N times; therefore, it takes O(Nlog(N)) time for all cases
