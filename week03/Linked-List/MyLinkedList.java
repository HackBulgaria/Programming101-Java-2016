package com.hackbulgaria.java;

public class MyLinkedList<T extends Comparable<T> > implements MyLinkedListInterface<T> {

	private Node head;
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
	}

	private Node getNode(int index) {
		Node node = head;

		for (int i = 0; i < index; i++) {
			if (node.nextNode == null) {
				throw new IndexOutOfBoundsException("The requested index is greated than the size");
			}

			node = node.nextNode;
		}

		return node;
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("The provided index is out of range: " + index);
		}
	}

	@Override
	public void addFirst(T newElement) {
		Node newNode = new Node(newElement, head);
		head = newNode;
		size++;
	}

	@Override
	public void addLast(T newElement) {
		if (size == 0) {
			addFirst(newElement);
		} else {
			Node lastNode = getNode(size - 1);
			Node newNode = new Node(newElement);
			lastNode.nextNode = newNode;
			size++;
		}
	}

	@Override
	public void add(T newElement, int index) {
		validateIndex(index);

		if (index == 0) {
			addFirst(newElement);
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

		return getNode(size - 1).element;
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

		if (index == 0) {
			head = head.nextNode;
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


}
