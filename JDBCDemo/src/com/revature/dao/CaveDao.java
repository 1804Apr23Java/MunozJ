package com.revature.dao;

import java.util.List;

import com.revature.domain.Cave;

public interface CaveDao {
	
	public List<Cave> getCaves();
	public Cave getCaveById(int id);
	public void insertCave(String caveName, int maxBears);

}