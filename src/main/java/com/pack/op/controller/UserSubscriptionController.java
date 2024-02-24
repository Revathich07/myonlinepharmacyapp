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

import com.pack.op.model.UserSubscription;
import com.pack.op.modeldto.UserSubscriptionDTO;
import com.pack.op.service.UserSubscriptionService;

@RestController
@RequestMapping("/admin/subscription")
public class UserSubscriptionController {

	@Autowired
	UserSubscriptionService userSubSer;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/addUserSubs")
    public ResponseEntity<String> addSubscription(@RequestBody UserSubscriptionDTO userSubdto) {
    	UserSubscription subscription=modelMapper.map(userSubdto,UserSubscription.class);
        userSubSer.createSubscription(subscription);
        return new ResponseEntity<String>("User Subscription got added successfully", HttpStatus.CREATED);
    }
	
//	com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields()

	@GetMapping("/admin/list")
	public List<UserSubscription> getAllUsersSub()
	{
		return userSubSer.getAllSubscribedUsers();
	}
	
	@GetMapping("/admin/list/{id}")
	public UserSubscription getUserSubById(@PathVariable int id){
		return userSubSer.getSubscribedUserById(id);
	}

	@PutMapping("/admin/updateSub/{id}")
    public ResponseEntity<String> updateUserSub(@PathVariable int id,@RequestBody UserSubscriptionDTO userSub) {
		UserSubscription userSubDet=modelMapper.map(userSub, UserSubscription.class);
		UserSubscription userSubDet1 = userSubSer.getSubscribedUserById(id); 
        userSubDet1.setStatus(userSubDet.getStatus());
        userSubDet1.setStartDate(userSubDet.getStartDate());
        userSubDet1.setEndDate(userSubDet.getEndDate());
        userSubSer.createSubscription(userSubDet1);
        return new ResponseEntity<String>("User Subscription got updated successfully", HttpStatus.CREATED);
		}


	@DeleteMapping("/admin/delete/{id}")
	public void deleteUserSub(@PathVariable int id)
	{
		userSubSer.deleteUserSub(id);
	}
}
