package com.revature.cc;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread{
	private List <String> basket= new ArrayList<>();
	private int maxSize = 5;
	
	public List<String> getBasket() {
		return basket;
	}
	public void setBasket(List<String> basket) {
		this.basket = basket;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void fillBasket() {
		//this will fill the basket
		if(basket.size() == maxSize) {
			System.out.println("Producer is waiting...");
		//.wait() until notified
		}
	}
	@Override
	public void run() {
		System.out.println("Hello from producer "+this.getName());
	}

}
