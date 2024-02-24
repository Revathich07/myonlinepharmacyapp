package com.pack.op.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.op.model.UserModel;
import com.pack.op.modeldto.UserModelDTO;
import com.pack.op.service.AuthService;



@RestController
@RequestMapping("/user")
public class AuthController 
{
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    private AuthService authService;
	
	@PostMapping("/signup")
    public ResponseEntity<String> saveUser(@RequestBody UserModelDTO userdto) {
    	UserModel user=modelMapper.map(userdto,UserModel.class);
    	
    	authService.saveUser(user);
    	return new ResponseEntity<String>("User got added successfully", HttpStatus.CREATED);
    	
    }
	

}
