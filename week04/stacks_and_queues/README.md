# Stacks and Queues

## Creating our own stack and queue

### The Interfaces

Lets make interfaces for stack and queue

stack:
-pop()
-push(T element)
-peek()

queue:
-enqueue(T element)
-dequeue()
-peek()

Feel free to add more functions to the interfaces if necessary.

### Enhance our own linked list

We already have implemented a linked list. Lets enhance it so that it implements our newly created interfaces.

We should have proper exception handling.
Document the the complexity of each function.

## Tasks

### Stacked Queue

Implement a MyQueue class which implements a queue using two stacks.

### Stack with a minimum bonus

How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should
all operate in O(1) time.

### Sorting with stacks

Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty.

### Not too high

Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack
exceeds some threshold. Implement a data structure SetOfStacks that mimics
this. SetOfStacks should be composed of several stacks and should create a
new stack once the previous one exceeds capacity. SetOfStacks.push() and
SetOfStacks.pop() should behave identically to a single stack (that is, pop()
should return the same values as it would if there were just a single stack)

Bonus: Implement a function popAt(int index) which performs a pop operation on a specific index.
