package com.pack.op.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.AccountModel;



@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer>{

	public AccountModel findByAccNo(int id);

	
	@Query("SELECT a.balance FROM AccountModel a WHERE a.userModel.userId=:userId")
	public double getBalance(@Param("userId") int userId);

	
	@Query("SELECT a FROM AccountModel a")
	public List<AccountModel> findAllAccounts();


	@Query("FROM AccountModel a WHERE a.userModel.userId=:userId")
	public AccountModel getAccountDetails(@Param("userId") int userId);

	
}
