package com.pack.op.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.UserModel;
import com.pack.op.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private AuthRepository authRepo;
	
	@Override
	public void saveUser(UserModel theUser){
		
		authRepo.save(theUser);
	}



}
