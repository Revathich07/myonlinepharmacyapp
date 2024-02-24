package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.AccountModel;
import com.pack.op.model.CartModel;
import com.pack.op.model.CartModel.Status;
import com.pack.op.model.PaymentModel;
import com.pack.op.model.PaymentModel.ModeOfPayment;
import com.pack.op.repository.AccountRepository;
import com.pack.op.repository.CartRepository;
import com.pack.op.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository payRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	
	
    @Autowired
    private AccountRepository accRepo;
	
	@Override
	public void savePayment(PaymentModel payDetails) {
		


		changeCartStatus(payDetails.getCart().getCartId());
		if(payDetails.getModeOfPayment()== ModeOfPayment.ONLINE)
			{ 
			   double balance=getBalance(payDetails.getUserModel().getUserId());
			   double totalAterDiscount= getTotal(payDetails.getCart().getCartId());
			   setBalanceAfterPayment(balance,totalAterDiscount,payDetails.getUserModel().getUserId());
			}
		
		payRepo.save(payDetails);
}
	
	private void changeCartStatus(int cartId) {
		CartModel cart = cartRepo.findCartById(cartId);
		System.out.println("--------------------------------------------------------");
		System.out.println(cart);
		cart.setStatus(Status.INACTIVE);
		cartRepo.save(cart);
		
	}
	
	private void setBalanceAfterPayment(double balance, double totalAterDiscount, int userId) {
		   AccountModel acc = accRepo.getAccountDetails(userId);
		   acc.setBalance(balance-totalAterDiscount);
		   accRepo.save(acc);
		
	}



	private double getTotal(int cartId) {
		return cartRepo.getTotal(cartId);
	}



	private double getBalance(int userId) {
		return accRepo.getBalance(userId);
		
	}



	@Override
	public List<PaymentModel> getAllPayments() {
		return payRepo.findAll();
	}



	@Override
	public PaymentModel getPaymentById(int id) {
		return payRepo.findByPaymentId(id);
	}



	@Override
	public void deletePayment(int id) {
		payRepo.deleteById(id);
		
	}
	
	
	

}
