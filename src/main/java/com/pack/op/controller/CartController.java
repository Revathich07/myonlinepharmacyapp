package com.pack.op.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.op.model.CartModel;
import com.pack.op.modeldto.CartModelDTO;
import com.pack.op.service.CartService;

@RestController
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    private CartService cartService;
	
	@PostMapping("/addCart")
    public ResponseEntity<String> saveCart(@RequestBody CartModelDTO cartDto) {
    	CartModel cartDetails=modelMapper.map(cartDto,CartModel.class);
    	cartService.saveCart(cartDetails); 
    	return new ResponseEntity<String>("Cart got added successfully", HttpStatus.CREATED);
    }
	
	 @GetMapping("/cart/list")
		public List<CartModel> getAllCart()
		{
			return cartService.getAllCart();
		}
		
		@GetMapping("/cart/list/{id}")
		public CartModel getCartById(@PathVariable int id){
			return cartService.getCartById(id);
		}
	
		@PutMapping("/user/updateCart/{id}")
	    public ResponseEntity<String> updateCart(@PathVariable int id,@RequestBody CartModelDTO cart) {
			CartModel cartDet=modelMapper.map(cart, CartModel.class);
			CartModel cartDet1 = cartService.getCartById(id); 
			cartDet1.setStatus(cartDet.getStatus());
			cartDet1.setTotal(cartDet.getTotal());
			cartDet1.setItemNo(cartDet.getItemNo());
	        cartService.saveCart(cartDet1);
	        return new ResponseEntity<String>("Cart got updated successfully", HttpStatus.CREATED);
	    }
	    

		@DeleteMapping("/user/deleteCart/{id}")
		public void deleteMedicine(@PathVariable int id)
		{
			cartService.deleteCart(id);
		}
}
