package com.hackbulgaria.java;

import java.util.LinkedList;

public class LinkedBucket<K, V> implements BucketInterface<K, V>{

	private class Entry {
		private K key;
		private V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V newValue) {
			this.value = newValue;
		}
	}
	
	private LinkedList<Entry> list;
	
	public LinkedBucket() {
		list = new LinkedList<>();
	}
	
	@Override
	public void add(K key, V value) {
		if(get(key) == null) {
			list.add(new Entry(key, value));
		} else {
			Entry entry = getEntry(key);
			entry.setValue(value);
		}
	}

	private Entry getEntry(K key) {
		for(Entry entry : list) {
			if(entry.getKey().equals(key)) {
				return entry;
			}
		}
		return null;
	}

	@Override
	public void remove(K key) {
		list.remove(getEntry(key));
	}

	@Override
	public V get(K key) {
		Entry entry = getEntry(key);
		V value = null;
		
		if(entry != null) {
			value = entry.getValue();
		}
		
		return value;
	}
}
