# HashTable
Overcomes the problems of an ArrayList while maintaining the fast access, insertion, and deletion in terms of N.
- Uses an Array and Hash functions to determine the index for each element
- Cannot contain duplicate keys, by convention the newest key will override the old key

### Usages of HashTables in Java
1. HashTable class
2. HashSet class
- Implements the Set interface with the internal storage container as a HashTable
- Compare this to the TreeSet class, which uses an internal storage of a Red Black Tree
3. HashMap class
- Implements the Map interface with the internal storage container as a HashTable for the keys

### Hash Functions
- Hash: To mix or randomly shuffle
- Hash Function: Take a large piece of data, reduce it to smaller pieces of data
  - Typically reduces to a single integer used to index onto an Array

Example of a Hash Function:  
Assume we are using our names as the "key."
- Take 3rd letter of the name, take integer value of the letter, divide by 6, then take remainder
- Ex: ```"Pravat" -> 'a' = 1 -> 1 % 6 = 6``` so 6 is the hash key

The example above uses the "mapping" technique. The example above is NOT a perfect hash function.
- Perfect Hash Function: A hash function that yields one to one mapping from the keys to the hash values

# Hashing Techniques
Tranforming a Key to an Integer can use 4 techniques:
1. Mapping: Integer values or Object keys that that can be easily converted to integer values
2. Folding: Partitioning a key into several parts, and the integer values for the various parts are combined
  - The parts may be hashed first
  - The combination can use addition, multiplication, shifting, logical exclusive OR, etc.
3. Shifting: Use Bitwise operators to shift keys into integers, gives a better range of hash values than folding
4. Casting: Very simple, such as casting characters to integers in Java

### How to Implement The "Mapping" Technique
The mapping technique transforms hashed key value into a legal index on a HashTable's Array container.

Typically, get the location on a table by taking the result of a hash function, then divide by the size of the table, and take the remainder as the integer index.
- ```index = key % size```
- Empirical evidence shows prime number as best for the size
  - Ex: If there's 1000 elements in the hash table, make the size equal to 997 or 1009 elements
  
###### Visual Example of The Mapping Technique
<img src="images/mapping.png" height="35%" width="35%"></img>

# Hashing Collisions
What to do when inserting an element onto the Array container, but there's already something present?

### Open Addressing
Search forward of backwards for an open space in the Array container.
- Linear Probing: Move forward spots until finding an open index.
  - Null if never occupied an index
  - When removing, replace the index as a blank
- Quadratic Probing: Moving 1 spot, 2 spots, 4 spots, 8 spots, 16 spots, etc.

For both probings, resize the Array when load factor reaches a limit (such as the end of the Array container).

### Closed Addressing
Each element of the HashTable is another data structure
- Such as a LinkedList, balanced BST, etc.
- This takes more space, but it's easier to implement

### Implementing a HashTable in Java
Use the hashCode method from the Object class to receive an integer index of the Object key
- Notes to remember about hashCode and equals:
  - If two Objects are equal according to the equals method, then calling hashCode would produce the same integer result
  - If you override equals, you MUST override hashCode or else it may cause logic errors
