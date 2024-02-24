package com.pack.op.service;

import java.util.List;

import com.pack.op.model.AccountModel;

public interface AccountService {

	public void saveAccount(AccountModel account);

	public List<AccountModel> getAllAccounts();

	public AccountModel getAccountById(int id);

	public void deleteAccount(int id);

}
