package com.pack.op.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.op.model.AccountModel;
import com.pack.op.modeldto.AccountModelDTO;
import com.pack.op.service.AccountService;

@RestController
@RequestMapping("/customer/account")
public class AccountController {


	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    private AccountService accService;
	
	@PostMapping("/addAccount")
    public ResponseEntity<String> saveAccount(@RequestBody AccountModelDTO accdto) {
    	AccountModel account=modelMapper.map(accdto,AccountModel.class);
    	accService.saveAccount(account); 
    	return new ResponseEntity<String>("Account got added successfully", HttpStatus.CREATED);
    }
	
	@GetMapping("/admin/list")
	public ResponseEntity<List<AccountModel>> getAllAccounts()
	{
		
		List<AccountModel> accounts= accService.getAllAccounts();
		return new ResponseEntity<List<AccountModel>>(accounts, HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/list/{id}")
	public AccountModel getAccountById(@PathVariable int id){
		return accService.getAccountById(id);
	}

	@PutMapping("/customer/updateAcc/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable int id,@RequestBody AccountModelDTO accModel) {
		AccountModel accDet=modelMapper.map(accModel, AccountModel.class);
		AccountModel accDet1 = accService.getAccountById(id); 
		accDet1.setBalance(accDet.getBalance());
		accDet1.setAccNo(accDet.getAccNo());
		accService.saveAccount(accDet1);
        return new ResponseEntity<String>("Account got updated successfully", HttpStatus.CREATED);
		}
    

	@DeleteMapping("/admin/delete/{id}")
	public void deleteAccount(@PathVariable int id)
	{
		accService.deleteAccount(id);
	}
}
