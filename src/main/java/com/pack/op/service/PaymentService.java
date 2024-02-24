package com.pack.op.service;

import java.util.List;

import com.pack.op.model.PaymentModel;

public interface PaymentService {

	public void savePayment(PaymentModel payDetails);

	public List<PaymentModel> getAllPayments();

	public PaymentModel getPaymentById(int id);

	public void deletePayment(int id);

}
