package com.hackbulgaria.java;

public class Map<K, V> implements MapInterface<K, V>{

	BucketInterface<K, V>[] buckets;
	private double loadFactor;
	private int size;
	
	
	public Map() {
		size = 8;
		loadFactor = 5;
		buckets = new LinkedBucket[size];
		for(int i=0; i<size; i++) {
			buckets[i] = new LinkedBucket<>();
		}
	}
	
	@Override
	public void put(K key, V value) {
		int bucketIndex = calculateBucketIndex(key);
		buckets[bucketIndex].add(key, value);
	}

	@Override
	public V get(K key) {
		int bucketIndex = calculateBucketIndex(key);
		
		return buckets[bucketIndex].get(key);
	}

	@Override
	public void remove(K key) {
		int bucketIndex = calculateBucketIndex(key);
		buckets[bucketIndex].remove(key);
	}

	@Override
	public boolean containsKey(K key) {
		return (get(key) != null);
	}

	private int calculateBucketIndex(K key) {
		return key.hashCode() % size;
	}
	
	/*
	 * hint for resizing
	 * 
	 * 1. create newList new LinkedBucked[size*2]
	 * 
	 * 2. oldList = this.list
	 * 3. list = newList
	 * 
	 * 4. for each element in oldList -> call put()
	 * 
	 */
}
