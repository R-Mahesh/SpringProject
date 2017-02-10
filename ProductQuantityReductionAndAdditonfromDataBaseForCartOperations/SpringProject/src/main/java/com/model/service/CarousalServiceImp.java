package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.CarousalDao;
import com.model.entity.Carousal;

@Service
public class CarousalServiceImp implements CarousalService{

	@Autowired
	private CarousalDao carousalDao;
	
	
	@Transactional
	public Carousal getCarousal(int sp) {
		// TODO Auto-generated method stub
		return carousalDao.getCarousal(sp);
	}

	@Transactional
	public int addCarousal(Carousal carousal) {
		return carousalDao.addCarousal(carousal);
	}

	
}
