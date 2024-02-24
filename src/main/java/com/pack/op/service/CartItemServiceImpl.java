package com.pack.op.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pack.op.model.CartItems;
import com.pack.op.model.CartModel;
import com.pack.op.repository.CartItemRepository;
import com.pack.op.repository.CartRepository;
import com.pack.op.repository.MedicineRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private MedicineRepository medRepo;
	
	@Override
	public void saveCartItems(CartItems itemDetails) {
		itemDetails.setPrice(itemDetails.getQuantity()*calculatePrice(itemDetails.getMed().getMedId()));
		cartItemRepo.save(itemDetails);
		long count=getNoOfItems(itemDetails.getCart().getCartId());
		setNoOfItems(itemDetails.getCart().getCartId(),count);
		double total=getTotalPrice(itemDetails.getCart().getCartId());
		setTotalPrice(itemDetails.getCart().getCartId(),total);
		int discount= getDiscount(itemDetails.getCart().getCartId());
		setTotalAfterDiscount(discount,itemDetails.getCart().getCartId());
	}
	
	   private void setTotalAfterDiscount(int discount, int cartId) {
		   CartModel cart = cartRepo.findCartById(cartId);
		   cart.setTotalAfterDiscount(cart.getTotal()-(cart.getTotal()*discount)/100);
		   cartRepo.save(cart);
		
	}

	private int getDiscount(int cartId) {
		return cartItemRepo.getDiscount(cartId);
		
	}

	private void setTotalPrice(int cartId, double total) {
		   CartModel cart = cartRepo.findCartById(cartId);
		   cart.setTotal(total);
		   cartRepo.save(cart);
		
	}

	private double getTotalPrice(int cartId) {
	    	return cartItemRepo.getTotalPrice(cartId);
		
	}
	
	
	private void setNoOfItems(int cartId, long count) {
		   
		   CartModel cart = cartRepo.findCartById(cartId);
		   cart.setItemNo(count);
		   cartRepo.save(cart);
		}

	public float calculatePrice(int medId)
    {
		return medRepo.getPriceById(medId).get(0);
    }
    
    public long getNoOfItems(int cartId)
    {
    	return cartItemRepo.getNoOfItems(cartId);
	
    }

	@Override
	public List<CartItems> getAllCartItems() {
		return cartItemRepo.findAll();
	}

	@Override
	public CartItems getCartItemById(int id) {
		return cartItemRepo.findByItemId(id);
	}

	@Override
	public void deleteCartItem(int id) {
		cartRepo.deleteById(id);
		
	}
    
    
}

