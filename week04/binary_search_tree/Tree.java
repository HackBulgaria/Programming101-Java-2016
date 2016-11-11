package com.hackbulgaria.java;

public class Tree {

	private Node root;
	
	private class Node {
		private int element;
		private Node left;
		private Node right;
		
		public Node(int element) {
			this.element = element;
		}
	}
	
	public void add(int newElement) {
		if(root == null) {
			root = new Node(newElement);
		} else {
			addRecursive(newElement, root);
		}
	}
	
	private void addRecursive(int newElement, Node currentNode) {
		if (newElement < currentNode.element) {
			if(currentNode.left == null) {
				currentNode.left = new Node(newElement);
			} else {
				addRecursive(newElement, currentNode.left);
			}
		} else if (newElement > currentNode.element){
			if(currentNode.right == null) {
				currentNode.right = new Node(newElement);
			}  else {
				addRecursive(newElement, currentNode.right);
			} 
		}
	}
}
