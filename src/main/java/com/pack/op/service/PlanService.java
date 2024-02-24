package com.pack.op.service;

import java.util.List;

import com.pack.op.model.PlanModel;

public interface PlanService {

	public void createPlan(PlanModel plan);

	public List<PlanModel> getAllPlans();

	public PlanModel getPlanById(int id);

	public void deletePlan(int id);

}
