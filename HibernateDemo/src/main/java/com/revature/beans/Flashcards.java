package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Flashcards implements Serializable{
	
	/*
	 * 
	 * */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.sequence, generator="flashcardSequence")
	
	

}
