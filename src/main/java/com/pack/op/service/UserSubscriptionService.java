package com.pack.op.service;

import java.util.List;

import com.pack.op.model.UserSubscription;

public interface UserSubscriptionService {

	public void createSubscription(UserSubscription subscription);

	public List<UserSubscription> getAllSubscribedUsers();

	public UserSubscription getSubscribedUserById(int id);

	void deleteUserSub(int id);

}
