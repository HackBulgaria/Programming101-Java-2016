package com.hackbulgaria.java;

/**
 * Queue Interface
 * 
 * @author vladimir
 *
 * @param <T> should implement the Comparable interface
 */
public interface MyQueueInterface<T extends Comparable<T> > {

	/**
	 * Adds an element to the end of the queue.
	 *
	 * @param the element to add.
	 */
	public void enqueue(T element);
	
	/**
	 * Removes and returns the first element in the queue
	 *
	 * @return the first element in the queue.
	 */
	public T dequeue();
	
	/**
	 * @return the element on top of the queue.
	 */
	public T peek();
	
	/**
	 * @return the number of elements in the queue.
	 */
	public int getSize();
}
