package com.pack.op.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.op.model.UserModel;

@Repository
public interface AuthRepository extends JpaRepository<UserModel,Integer>{



	
}
