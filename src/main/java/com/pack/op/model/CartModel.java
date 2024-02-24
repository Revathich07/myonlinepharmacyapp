package com.pack.op.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "cart")
public class CartModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cartId;
	
//	@OneToOne(fetch= FetchType.EAGER, optional = false)
//	@JoinColumn(name="userId", referencedColumnName = "userId")
//	private UserModel userModel;
	
	@JsonBackReference(value = "userMod")
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private UserModel userModel;
	
	
	private long itemNo;
	
	private double total;
	
	private double totalAfterDiscount;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public static enum Status {
		ACTIVE,
		INACTIVE
	}
	
	@Temporal(TemporalType.DATE)
	private Date cartDate;
	
	@JsonIgnore
	@JsonManagedReference(value = "cartEntity")
	@OneToMany(mappedBy = "cart")
	private Set<CartItems> items;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}

	public Set<CartItems> getItems() {
		return items;
	}

	public void setItems(Set<CartItems> items) {
		this.items = items;
	}

	public long getItemNo() {
		return itemNo;
	}

	public void setItemNo(long itemNo) {
		this.itemNo = itemNo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalAfterDiscount() {
		return totalAfterDiscount;
	}

	public void setTotalAfterDiscount(double totalAfterDiscount) {
		this.totalAfterDiscount = totalAfterDiscount;
	}
	
	@JsonIgnore
	@JsonManagedReference(value = "paymentMod")
	@OneToOne(mappedBy= "cart")
	private PaymentModel payment;
}
