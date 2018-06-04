package com.revature.hw;

import java.util.List;

public class BinarySearch<T> {
	private List<T> sortedList;

	public int indexOf(T t) {
		// TODO Write an implementation for this method declaration
		int size = this.sortedList.size();
		int midpoint = (size+1)/2;
		int left = 0;
		int right = this.sortedList.size()-1;
		if(t.equals(this.sortedList.get(midpoint))) {
			return midpoint;
		}
		
//		while(left <= right) {
//		if(Integer.parseInt(t) > 0) {
//			
//		}
		return 0;
	}

	public BinarySearch(List<T> sortedList) {
		super();
		this.sortedList = sortedList;
	}

	public List<T> getSortedList() {
		return sortedList;
	}

	public void setSortedList(List<T> sortedList) {
		this.sortedList = sortedList;
	}

}