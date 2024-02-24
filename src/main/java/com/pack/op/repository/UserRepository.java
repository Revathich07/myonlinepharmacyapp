package com.pack.op.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.op.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

	public Optional<UserModel> findByUserEmail(String email);

	public UserModel findByUserId(int id);
}
