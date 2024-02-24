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

import com.pack.op.model.CartItems;
import com.pack.op.modeldto.CartItemsDTO;
import com.pack.op.service.CartItemService;

@RestController
@RequestMapping("/customer/cartItems")
public class CartItemsController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    private CartItemService cartItemService;
	
	@PostMapping("/addItem")
    public ResponseEntity<String> saveItem(@RequestBody CartItemsDTO itemDto) {
    	CartItems itemDetails=modelMapper.map(itemDto,CartItems.class);
    	cartItemService.saveCartItems(itemDetails); 
    	return new ResponseEntity<String>("Item got added successfully", HttpStatus.CREATED);
    }
	
	 @GetMapping("/cartItems/list")
		public List<CartItems> getAllCartItems()
		{
			return cartItemService.getAllCartItems();
		}
		
		@GetMapping("/cart/list/{id}")
		public CartItems getCartItemById(@PathVariable int id){
			return cartItemService.getCartItemById(id);
		}
	
		@PutMapping("/user/updateCart/{id}")
	    public ResponseEntity<String> updateCartItem(@PathVariable int id,@RequestBody CartItemsDTO cartItems) {
			CartItems cartItemDet=modelMapper.map(cartItems, CartItems.class);
			CartItems cartDet1 = cartItemService.getCartItemById(id); 
			cartDet1.setPrice(cartItemDet.getPrice());
			cartDet1.setQuantity(cartItemDet.getQuantity());
			cartDet1.setItemId(cartItemDet.getItemId());
	        cartItemService.saveCartItems(cartDet1);
	        return new ResponseEntity<String>("Item got updated successfully", HttpStatus.CREATED);
	    }
	    

		@DeleteMapping("/user/deleteCart/{id}")
		public void deleteCartItem(@PathVariable int id)
		{
			cartItemService.deleteCartItem(id);
		}
}
