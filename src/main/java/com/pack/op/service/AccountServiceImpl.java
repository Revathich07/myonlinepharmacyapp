package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.AccountModel;
import com.pack.op.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public void saveAccount(AccountModel account) {
		accRepo.save(account);
		
	}
	
	@Autowired
	private AccountRepository accRepo;

	@Override
	public List<AccountModel> getAllAccounts() {
		List<AccountModel> accounts = accRepo.findAllAccounts();
		
		return accounts;
	}

	@Override
	public AccountModel getAccountById(int id) {
		return accRepo.findByAccNo(id);
	}

	@Override
	public void deleteAccount(int id) {
		accRepo.deleteById(id);
		
	}
	
	
		

		


}
