package com.pack.op.service;

import java.util.List;

import com.pack.op.model.UserModel;

public interface UserService {

	public List<UserModel> getAllUsers();

	public UserModel getUserById(int id);

	public void saveUser(UserModel user1);

	public void deleteUser(int id);


}
