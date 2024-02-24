package com.pack.op.modeldto;

import java.util.Date;

import com.pack.op.model.CartModel;
import com.pack.op.model.UserModel;
import com.pack.op.model.PaymentModel.ModeOfPayment;
import com.pack.op.model.PaymentModel.Status;


public class PaymentModelDTO {

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	
    private int paymentId;
	
	
	private UserModel userModel;
	
	
	private CartModel cart;
	
	
	private ModeOfPayment modeOfPayment;
	
	
	
	
	private Status status;
	
	
	
	
	private Date paymentDate;
}
