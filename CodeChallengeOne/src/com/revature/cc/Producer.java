package com.revature.cc;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {
	List<Integer> basket = new ArrayList<>();
	private int maxSize = 5;

	public List<Integer> getBasket() {
		return basket;
	}

	public void setBasket(List<Integer> basket) {
		this.basket = basket;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void fillBasket(List<Integer> basket) {
		// this will fill the basket
		synchronized (basket) {
			if (basket.size() == maxSize) {
				try {
				System.out.println("Producer is waiting...");
				basket.wait();}
				catch(InterruptedException e) {
					
				}
			}
		}
	}

	@Override
	public void run() {
		System.out.println("Hello from producer " + this.getName());
	}

}
