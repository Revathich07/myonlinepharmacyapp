package com.pack.op.modeldto;

import java.util.Date;

import com.pack.op.model.PlanModel;
import com.pack.op.model.UserModel;
import com.pack.op.model.UserSubscription.Status;

public class UserSubscriptionDTO {

	 private int subid;
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
	public UserSubscriptionDTO(int subid, Date startDate, Date endDate, Status status) {
		super();
		this.subid = subid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	public UserSubscriptionDTO(int subid, UserModel userModel, PlanModel plan, Date startDate, Date endDate,
			Status status) {
		super();
		this.subid = subid;
		this.userModel = userModel;
		this.plan = plan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public UserSubscriptionDTO()
	{
		super();
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	private UserModel userModel;
	 private PlanModel plan;
	 private Date startDate;
	 private Date endDate;
	 private Status status;
}
