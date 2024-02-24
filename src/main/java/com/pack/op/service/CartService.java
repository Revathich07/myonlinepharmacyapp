package com.pack.op.service;

import java.util.List;

import com.pack.op.model.CartModel;

public interface CartService {

	public void saveCart(CartModel cartDetails);

	public List<CartModel> getAllCart();

	public CartModel getCartById(int id);

	public void deleteCart(int id);

}
