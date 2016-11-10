package com.hackbulgaria.java;

public class MyLinkedList<T extends Comparable<T>>
		implements MyLinkedListInterface<T>, MyQueueInterface<T>, MyStackInterface<T> {

	private Node head;
	// the rightmost element of the list
	private Node tail;
	private int size;

	private class Node {
		private T element;
		private Node nextNode;

		public Node(T element) {
			this.element = element;
		}

		public Node(T element, Node nextNode) {
			this.element = element;
			this.nextNode = nextNode;
		}
	}

	public MyLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	private Node getNode(int index) {
		Node node = head;

		if (index == size - 1) {
			node = tail;
		} else {

			for (int i = 0; i < index; i++) {
				if (node.nextNode == null) {
					throw new IndexOutOfBoundsException("The requested index is greated than the size");
				}

				node = node.nextNode;
			}
		}

		return node;
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("The provided index is out of range: " + index);
		}
	}

	private T removeHead() {
		T firstElement = null;

		if (size != 0) {
			firstElement = head.element;
			remove(0);
		}

		return firstElement;
	}

	@Override
	public void addFirst(T newElement) {
		Node newNode = new Node(newElement, head);
		head = newNode;

		if (size == 0) {
			tail = newNode;
		}

		size++;
	}

	@Override
	public void addLast(T newElement) {
		if (size == 0) {
			addFirst(newElement);
		} else {
			tail.nextNode = new Node(newElement);
			tail = tail.nextNode;
			size++;
		}
	}

	@Override
	public void add(T newElement, int index) {
		validateIndex(index);

		if (index == 0) {
			addFirst(newElement);
		} else if(index == size -1) {
			addLast(newElement);
		} else {
			Node previousNode = getNode(index - 1);
			Node newNode = new Node(newElement, previousNode.nextNode);
			previousNode.nextNode = newNode;
			size++;
		}
	}

	@Override
	public T getFirst() {
		if (head == null) {
			return null;
		}

		return head.element;
	}

	@Override
	public T getLast() {
		if (head == null) {
			return null;
		}

		return tail.element;
	}

	@Override
	public T get(int index) {
		validateIndex(index);

		return getNode(index).element;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void remove(int index) {
		validateIndex(index);

		if (index == 0 && size == 1) {
			head = null;
			tail = null;
		} else if (index == 0) {
			head = head.nextNode;
		} else if (index == size - 1) {
			tail = getNode(size - 2);
			tail.nextNode = null;
		} else {
			Node previousNode = getNode(index - 1);
			previousNode.nextNode = previousNode.nextNode.nextNode;
		}

		size--;
	}

	@Override
	public void addList(MyLinkedListInterface<T> list) {
		if (list == null) {
			throw new IllegalArgumentException("The provided list cannot be null.");
		}

		for (int i = 0; i < list.getSize(); i++) {
			addLast(list.get(i));
		}
	}

	@Override
	public T pop() {
		return removeHead();
	}

	@Override
	public void push(T element) {
		addFirst(element);
	}

	@Override
	public void enqueue(T element) {
		addLast(element);
	}

	@Override
	public T dequeue() {
		return removeHead();
	}

	@Override
	public T peek() {
		T firstElement = null;

		if (size != 0) {
			firstElement = head.element;
		}

		return firstElement;
	}

}
