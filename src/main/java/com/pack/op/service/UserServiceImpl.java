package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.UserModel;
import com.pack.op.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<UserModel> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserModel getUserById(int id) {
		return userRepo.findByUserId(id);
	}

	@Override
	public void saveUser(UserModel user1) {
		userRepo.save(user1);
	}

	@Override
	public void deleteUser(int id) {
	       userRepo.deleteById(id);
		
	}

}
