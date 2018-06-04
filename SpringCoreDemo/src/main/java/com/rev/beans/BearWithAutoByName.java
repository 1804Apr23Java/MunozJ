package com.rev.beans;

public class BearWithAutoByName extends Bear {
	
	//method identifier must match name of the dependency
	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutoByName. this bear is: "+this.toString());
		System.out.println("cave: "+cave.toString());
	}

}
