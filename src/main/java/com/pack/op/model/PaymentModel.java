package com.pack.op.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "payment")
public class PaymentModel {
	
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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int paymentId;
	
	@JsonBackReference(value = "userTab")
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private UserModel userModel;
	
	@JsonBackReference(value = "paymentMod")
	@OneToOne
	@JoinColumn(name="cartId", referencedColumnName = "cartId")
	private CartModel cart;
	
	@Enumerated(EnumType.STRING)
	private ModeOfPayment modeOfPayment;
	
	public static enum ModeOfPayment {
		ONLINE,
		CASH
	}
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public static enum Status {
		SUCCESS,
		FAILED,
		PENDING
	}
	
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
}
