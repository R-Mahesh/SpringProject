package com.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.dao.CartDao;
import com.model.entity.CartItem;
import com.model.entity.MyCart;
import com.model.entity.Products;
import com.model.entity.User;


@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartDao cartDao;
	
	 @Transactional
	public int addCart(MyCart myCart) {
		return cartDao.addCart(myCart);
	}
	 @Transactional
		public List<MyCart> getAllCartItem() {
			return cartDao.getAllCartItem();
		}
	 @Transactional(propagation=Propagation.SUPPORTS)
		public int editMyCart(MyCart myCart) {
			return cartDao.editMyCart(myCart);	
		}
	 @Transactional
		public MyCart getCart(int id) {
			return cartDao.getCart(id);
		}
	@Override
	public List<User> getCartByUserClass(User id) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUserClass(id);
	}
	@Override
	public int deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}
	@Override
	public int addCarts(CartItem cartItems) {
		// TODO Auto-generated method stub
		return cartDao.addCarts(cartItems);
	}
	@Override
	public List<CartItem> getCartItem() {
		// TODO Auto-generated method stub
		return cartDao.getCartItem();
	}

	 
	 
}
