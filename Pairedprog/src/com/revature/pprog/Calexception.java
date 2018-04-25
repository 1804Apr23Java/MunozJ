package com.revature.pprog;

public class Calexception extends Exception{
	public Calexception(String message) {
		super(message);
		System.out.println("My exception");
	}
}
