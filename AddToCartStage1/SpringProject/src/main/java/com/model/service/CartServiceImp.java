package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.CartDao;
import com.model.entity.MyCart;


@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartDao cartDao;
	
	 @Transactional
	public int addCart(MyCart myCart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(myCart);
	}

	
}
