package com.pack.op.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "user_subscription")
public class UserSubscription {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int subid;

	@JsonBackReference(value = "userBean")
	@OneToOne
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private UserModel userModel;
	

	public int getSubid() {
		return subid;
	}


	public void setSubid(int subid) {
		this.subid = subid;
	}


	public UserModel getUserModel() {
		return userModel;
	}


	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}


	public PlanModel getPlan() {
		return plan;
	}


	public void setPlan(PlanModel plan) {
		this.plan = plan;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	@JsonBackReference(value = "userSubscrip")
	@ManyToOne
	@JoinColumn(name="planId", referencedColumnName = "planId")
	private PlanModel plan;
	


	public UserSubscription()
	{
		super();
	}

	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	

	public static enum Status {
		ACTIVE,
		INACTIVE
	}
	
}
