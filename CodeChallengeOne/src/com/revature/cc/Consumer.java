package com.revature.cc;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends Thread{
	private List <String> basket= new ArrayList<>();
	private int maxSize = 5;
	
	@Override
	public void run() {
		System.out.println("Hello from consumer "+this.getName());
	}

	public void emptyBasket() {
		//this will empty the basket
		if(basket.size()==0) {
			System.out.println("Basket is empty now");
		//wake producer
		}
	}

	public List<String> getBasket() {
		return basket;
	}

	public void setBasket(List<String> basket) {
		this.basket = basket;
	}

	public int getMaxSize() {
		return maxSize;
	}


}
