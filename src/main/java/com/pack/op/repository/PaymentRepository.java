package com.pack.op.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.op.model.CartModel;
import com.pack.op.model.PaymentModel;


@Repository
public interface PaymentRepository extends JpaRepository<PaymentModel, Integer> {



	public PaymentModel findByPaymentId(int id);
	
	@Query("SELECT c FROM CartModel c JOIN PaymentModel p ON c.cartId=p.cart.cartId WHERE p.cart.cartId=:cartId")
	public CartModel getCartDetails(@Param("cartId") int cartId);

}
