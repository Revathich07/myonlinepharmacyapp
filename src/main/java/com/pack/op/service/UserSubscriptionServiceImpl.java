package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.UserSubscription;
import com.pack.op.repository.UserSubscriptionRepository;



@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

	@Autowired
	UserSubscriptionRepository userSubRepo;
	
	@Override
	public void createSubscription(UserSubscription subscription) {
		 userSubRepo.save(subscription);
		
	}

	@Override
	public List<UserSubscription> getAllSubscribedUsers() {
		return userSubRepo.findAll();
	}

	@Override
	public UserSubscription getSubscribedUserById(int id) {
		return userSubRepo.findBysubid(id);
	}

	@Override
	public void deleteUserSub(int id) {
		userSubRepo.deleteById(id);
	}

}
