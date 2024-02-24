package com.pack.op.modeldto;

import com.pack.op.model.CartModel;
import com.pack.op.model.MedicineModel;

public class CartItemsDTO {

	private int itemId;
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public MedicineModel getMed() {
		return med;
	}

	public void setMed(MedicineModel med) {
		this.med = med;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private CartModel cart;
	private MedicineModel med;
    private float price;
	
	private int quantity;
}
