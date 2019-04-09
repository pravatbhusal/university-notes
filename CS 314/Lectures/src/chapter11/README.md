# Maps
An interface that maps keys to values.

# Iterators
An interface that allows for a data-structure to be iterated through when using a for-each loop.

### ConcurrentModificationException of Iterators
While iterating through an Object using an iterator, if a programmer modifies the original data-structure without using the
iterator's implemented methods it will cause a concurrent modification exception.
  - To prevent this, create a new Iterator Object such as ```Iterator<E> myIterator = thisObject.iterator();``` and iterate
  through the data structure using that with ```while(myIterator.hasNext())``` and ```myIterator.next()``` and any modifications
  such as removing an element in the data-structure must use the iterator's implemented methods like ```myIterator.remove()```

# Comparables
From the Java Standard Library:  
- An interface that imposes a ordering on the objects of each class that implements it
  - Must implement the compareTo method
- The ordering is referred to as the class's natural ordering
