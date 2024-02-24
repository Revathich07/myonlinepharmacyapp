package com.pack.op.service;

import java.util.List;

import com.pack.op.model.CartItems;

public interface CartItemService {


	public void saveCartItems(CartItems itemDetails);

	public List<CartItems> getAllCartItems();

	public CartItems getCartItemById(int id);

	public void deleteCartItem(int id);

}
