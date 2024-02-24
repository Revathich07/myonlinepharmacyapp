package com.pack.op.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@JsonBackReference(value = "cartEntity")
	@ManyToOne
	@JoinColumn(name="cartId", referencedColumnName = "cartId")
	private CartModel cart;
	
	@JsonBackReference(value = "medEntity")
	@ManyToOne
	@JoinColumn(name="medId", referencedColumnName = "medId")
	private MedicineModel med;
	
	private float price;
	
	private int quantity;

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
}
