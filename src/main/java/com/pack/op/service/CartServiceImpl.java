package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.CartModel;
import com.pack.op.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	@Override
	public void saveCart(CartModel cartDetails) {
		cartRepo.save(cartDetails);
	}

	@Override
	public List<CartModel> getAllCart() {
		return cartRepo.findAll();
	}

	@Override
	public CartModel getCartById(int id) {
		return cartRepo.findCartById(id);
	}

	@Override
	public void deleteCart(int id) {
		cartRepo.deleteById(id);
		
	}
	

}
