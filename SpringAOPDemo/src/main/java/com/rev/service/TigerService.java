package com.rev.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="tigerService")
@Scope(value="prototype")
public class TigerService extends AnimalService {
	
	private static int tigerSpeed = 20;
	private Boolean tigerFull = false;

	@Override
	public int getSpeed() {
		return TigerService.tigerSpeed;
	}

	@Override
	public Boolean isFull() {
		return this.tigerFull;
	}

	@Override
	public void setFull(Boolean full) {
		this.tigerFull = full;
	}

	@Override
	public void animalChasesYou() {
		System.out.println("Tiger is chasing you.");
	}

}