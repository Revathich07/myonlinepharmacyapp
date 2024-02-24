package com.pack.op.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.op.model.UserModel;
import com.pack.op.modeldto.UserModelDTO;
import com.pack.op.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	ModelMapper modelMapper;
	

    @Autowired
    private UserService userService;
    
    @GetMapping("/admin/list")
	public List<UserModel> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("/admin/list/{userId}")
	public UserModel getUserById(@PathVariable int userId){
		return userService.getUserById(userId);
	}
	
	@PostMapping("/admin/createEmployee")
	public void createEmployee(@RequestBody UserModelDTO user)
	{
		UserModel user1=modelMapper.map(user, UserModel.class);
		userService.saveUser(user1);
	}
	
	@PutMapping("/admin/updateUser/{id}")
    public void updateUser(@PathVariable int id,@RequestBody UserModelDTO user) {
		UserModel userDet=modelMapper.map(user, UserModel.class);
		UserModel userDet1 = userService.getUserById(id); 
        userDet1.setUserName(userDet.getUserName());
        userDet1.setPhoneNum(userDet.getPhoneNum());
        userDet1.setUserEmail(userDet.getUserEmail());
        userService.saveUser(userDet1);
		}
    
	
	@DeleteMapping("/admin/delete/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
	}

}
