## LinkedList

List is a data structure that allows us to store unlimited number of
elements without copying them over when expanding. In order to achieve
this it does not store the elements in an Array. Instead, every element
is an object that holds both the value (int, string, float, etc...) and
a pointer to the next element in the list. This way every element of the
list could be accessed starting from the first element (we call this `head`
of the list) and following the links.

List sacrifices the performance of accessing elements at random position
(this operation runs in O(n) time) so that adding, removing and retrieving
elements from the end of the list is fast (runs in O(1) time).

[Linked list](http://en.wikipedia.org/wiki/Linked_list) - List with link in one direction.

[Doubly linked list](http://en.wikipedia.org/wiki/Doubly_linked_list) - List with
links in both directions.
