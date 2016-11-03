# Linked List

## Let's implement our own linked list

First we will implement it only for ints.
Then we will make it work with generics.

### The Interface

First we will create an interface called MyLinkedListInterface that will describe the functions that our Linked list will have.

For now we want to have the following functions in our LinkedList:

- addFirst(int newElement)
- addLast(int newElement)
- add(int newElement, int index)
- getFirst()
- getLast()
- get(int index)
- size()
- remove(int index)
- addList(MylinkedListInterface list) - appends another linked list 

### After we have created the interface it is time for implementation

Create a Class named MyLinkedList that should implement our Interface.

When writing the implementation document the big O() complexity of each function as a java doc.

## Some intresting tasks

Solve the following problems and document their complexities both in terms of time and memory.

### Finding kth to last element

Implement an algorithm to find the kth to last element in our singly linked list without using size() function or iterating twice.

Try to do it in O(n).

### Deleting an element

Implement an algorithm to delete a node in the middle of a singly linked list, given
only access to that node.

### Partitioning a LinkedList

Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

### Connected lists

Detect if two lists have at least one common node and find the first common node.

Example:

 list_1: A->B->C->D

 list_2: F->C->D 

### (L)oops

Detect if a given linked list has a loop.

Example: A->B->C->D->B

### First element in a loop

Given a circular linked list (with a loop), implement an algorithm which returns the node at the beginning of the loop.

### Palindroms again

Check if a given linked list is a palindrom.

Compare the big O() complexity of each different solutions.
You can do it with additional data structure, iterative, recursive, in place.