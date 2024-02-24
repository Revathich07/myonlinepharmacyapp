package com.pack.op.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.op.model.PlanModel;
import com.pack.op.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanRepository planRepo;
	
	@Override
	public void createPlan(PlanModel plan) {
		planRepo.save(plan);
		
	}

	@Override
	public List<PlanModel> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public PlanModel getPlanById(int id) {
		return planRepo.findByPlanId(id);
	}

	@Override
	public void deletePlan(int id) {
		planRepo.deleteById(id);
		
	}

}
