package com.rev.beans;

public class BearWithSetter extends Bear{
	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithSetter. this bear is: "+this.toString());
		System.out.println("cave: "+cave.toString());
	}

}

