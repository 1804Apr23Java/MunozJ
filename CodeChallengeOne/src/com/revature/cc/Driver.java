package com.revature.cc;


public class Driver {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.out.println("Code doesnt do anything yet");
		
		final Producer p1 = new Producer();
		p1.start();
		
		Consumer c2 = new Consumer();
		c2.start();
		
		//lets try producing first
		
//			try 
//			{
//				p1.fillBasket();
//			}
//			catch(InterruptedException e){
//			
//			}
	
		
	}

}
