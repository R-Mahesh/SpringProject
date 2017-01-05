package com.model.dao;

import com.model.entity.Carousal;

public interface CarousalDao {
	
	public int addCarousal(Carousal carousal);
	public Carousal getCarousal(int sp);
	
}
