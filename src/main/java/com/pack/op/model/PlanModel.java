package com.pack.op.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "plan")
public class PlanModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int planId;
	
	
	
	public PlanModel() {
		super();
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	

	private String planName;
	@Enumerated(EnumType.STRING)
	private Month month;
	private int discountInPercent;
	
	

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public int getDiscountInPercent() {
		return discountInPercent;
	}

	public void setDiscountInPercent(int discountInPercent) {
		this.discountInPercent = discountInPercent;
	}

	public Set<UserSubscription> getUserSub() {
		return userSub;
	}

	public void setUserSub(Set<UserSubscription> userSub) {
		this.userSub = userSub;
	}

	public static enum Month {
		ONE,
		THREE,
		SIX,
	}
	
	@JsonIgnore
	@JsonManagedReference(value = "userSubscrip")
	@OneToMany(mappedBy = "plan")
	private Set<UserSubscription> userSub;
}
