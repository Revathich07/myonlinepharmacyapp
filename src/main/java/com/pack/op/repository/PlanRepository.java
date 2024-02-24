package com.pack.op.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pack.op.model.PlanModel;

@Repository
public interface PlanRepository extends JpaRepository<PlanModel,Integer> {

	public PlanModel findByPlanId(int id);
}
