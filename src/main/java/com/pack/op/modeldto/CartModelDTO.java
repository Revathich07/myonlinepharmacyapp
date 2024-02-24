package com.pack.op.modeldto;

import java.util.Date;
import com.pack.op.model.PaymentModel;
import com.pack.op.model.UserModel;
import com.pack.op.model.CartModel.Status;

public class CartModelDTO {

	private int cartId;
	private UserModel userModel;
	private long itemNo;
	private double total;
	private double totalAfterDiscount;
	private Date cartDate;
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
	

	public Date getCartDate() {
		return cartDate;
	}
	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getTotalAfterDiscount() {
		return totalAfterDiscount;
	}
	public void setTotalAfterDiscount(double totalAfterDiscount) {
		this.totalAfterDiscount = totalAfterDiscount;
	}
	

	private Status status;
	
}
