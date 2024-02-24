package com.pack.op.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pack.op.model.CartModel;

import jakarta.transaction.Transactional;

@EnableTransactionManagement
@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer>
{
	@Query("SELECT c FROM CartModel c WHERE c.cartId = :cartId")
	public CartModel findCartById(@Param("cartId") int cartId);

	
	@Query("SELECT c.totalAfterDiscount FROM CartModel c WHERE c.cartId = :cartId")
	public double getTotal(@Param("cartId") int cartId);

	
}