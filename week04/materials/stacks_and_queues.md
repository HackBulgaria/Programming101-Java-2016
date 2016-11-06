## Queue

[Queue](http://en.wikipedia.org/wiki/Queue_%28abstract_data_type%29) is an
abstract data type. This means that it does not define a specific implementation.
It just provides an interface for the supported operations.

The interface of a Queue data type is:

```
Queue {

  // Adds value to the end of the Queue.
  enqueue(value)

  // Returns value from the front of the Queue and removes it.
  dequeue()

  // Returns value from the front of the Queue without removing it.
  peek()

  // Returns the number of elements in the Queue.
  size()
}
```

It could be implemented with both ArrayList and LinkedList.

## Stack

[Stack](http://en.wikipedia.org/wiki/Stack_%28abstract_data_type%29) is an
abstract data type. This means that it does not define a specific implementation.
It just provides an interface for the supported operations.

The interface of a Stack data type is:

```
Stack {

  // Adds value to the end of the Stack.
  push(value)

  // Returns value from the end of the Stack and removes it.
  pop()

  // Returns value from the end of the Stack without removing it.
  peek()

  // Returns the number of elements in the Stack.
  size()
}
```

It could be implemented with both ArrayList and LinkedList.
