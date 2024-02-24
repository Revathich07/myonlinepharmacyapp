package com.pack.op.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.CartItems;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Integer>{

	 
	 @Query("SELECT count(*) FROM CartItems i JOIN i.cart c WHERE  c.cartId = :cartId")
	 public long getNoOfItems(@Param("cartId") int cartId);
	 
	
	 @Query("SELECT sum(i.price) FROM CartItems i JOIN i.cart c WHERE c.cartId = :cartId")
	 public double getTotalPrice(@Param("cartId") int cartId);

	
	 @Query("SELECT p.discountInPercent FROM CartModel c JOIN UserSubscription s ON c.userModel.userId=s.userModel.userId JOIN PlanModel p ON s.plan.planId=p.planId WHERE c.cartId=:cartId")
	 public int getDiscount(@Param("cartId") int cartId);

	
	 public CartItems findByItemId(int id);
	 

}
