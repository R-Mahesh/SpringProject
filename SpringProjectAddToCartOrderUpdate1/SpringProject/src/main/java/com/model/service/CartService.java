package com.model.service;

import java.util.List;

import com.model.entity.CartItem;
import com.model.entity.MyCart;
import com.model.entity.User;

public interface CartService {

	public int addCart(MyCart myCart);
	public List<MyCart> getAllCartItem();
	public int editMyCart(MyCart myCart);
	public MyCart getCart(int id);
	public List<User> getCartByUserClass(User id);
	public int deleteCart(int id);
	public int addCarts(CartItem cartItems);
	public List<CartItem> getCartItem();
}
