package com.model.dao;

import java.util.List;

import com.model.entity.MyCart;

public interface CartDao {

public	int addCart(MyCart myCart);
public List<MyCart> getAllCartItem();
public int editMyCart(MyCart myCart);
public MyCart getCart(int id);
}
