package com.rev.beans;

public class BearWithConstructor extends Bear {

	public BearWithConstructor() {
		super();
	}
	
	public BearWithConstructor(Cave cave) {
		this();
		this.cave = cave;
	}
	
	@Override
	public void methodInBear() {
		System.out.println("method in BearWithConstructor. this bear is: "+this.toString());
		System.out.println("cave: "+cave.toString());
	}

}
