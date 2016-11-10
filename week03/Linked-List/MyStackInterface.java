package com.hackbulgaria.java;

/**
 * Stack interface
 * 
 * @author vladimir
 *
 * @param <T> should implement the Comparable interface.
 * 
 */
public interface MyStackInterface<T extends Comparable <T> > {

	/**
	 * Removes the element on top of the stack.
	 *
	 * @return the element on top of the stack.
	 */
	public T pop();

	/**
	 * Adds an element on top of the stack
	 *
	 * @param element the element to be added
	 */
	public void push(T element);
	
	/**
	 * @return the element on top of the stack.
	 */
	public T peek();
	
	/**
	 * @return the number of elements in the stack.
	 */
	public int getSize();
}
