package com.pack.op.modeldto;

import com.pack.op.model.PlanModel.Month;

public class PlanModelDTO {

	private int planId;
	private String planName;
	private Month month;
	
	
	
	public PlanModelDTO()
	{
		super();
		
	}
	
	private int discountInPercent;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getDiscountInPercent() {
		return discountInPercent;
	}
	public void setDiscountInPercent(int discountInPercent) {
		this.discountInPercent = discountInPercent;
	}
	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
	}
	
}
