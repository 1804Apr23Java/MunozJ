package com.rev.beans;

public abstract class Bear {

	protected int id;
	protected String name;
	protected Cave cave;

	public abstract void methodInBear();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cave getCave() {
		return this.cave;
	}

}