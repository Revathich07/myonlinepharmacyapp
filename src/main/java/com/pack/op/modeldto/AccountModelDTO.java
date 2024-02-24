package com.pack.op.modeldto;

import com.pack.op.model.UserModel;

public class AccountModelDTO {

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	private int accNo;
	


	private UserModel userModel;
	
	private double balance;
	
	
	
}
