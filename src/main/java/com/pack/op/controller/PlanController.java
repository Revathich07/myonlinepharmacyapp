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

import com.pack.op.model.PlanModel;
import com.pack.op.modeldto.PlanModelDTO;
import com.pack.op.service.PlanService;

@RestController
@RequestMapping("/admin/plan")
public class PlanController {
	@Autowired
	PlanService planSer;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping("/addPlan")
    public ResponseEntity<String> addPlan(@RequestBody PlanModelDTO plandto) {
    	PlanModel plan=modelMapper.map(plandto,PlanModel.class);
        planSer.createPlan(plan);
        return new ResponseEntity<String>("Plan got added successfully", HttpStatus.CREATED);
    }
	
	@GetMapping("/admin/list")
	public List<PlanModel> getAllPlans()
	{
		return planSer.getAllPlans();
	}
	
	@GetMapping("/admin/list/{id}")
	public PlanModel getPlanById(@PathVariable int id){
		return planSer.getPlanById(id);
	}

	@PutMapping("/admin/updatePlan/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable int id,@RequestBody PlanModelDTO plan) {
		PlanModel planDet=modelMapper.map(plan, PlanModel.class);
		PlanModel planDet1 = planSer.getPlanById(id); 
		planDet1.setDiscountInPercent(planDet.getDiscountInPercent());
		planDet1.setPlanName(planDet.getPlanName());
		planDet1.setMonth(planDet.getMonth());
        planSer.createPlan(planDet1);
        return new ResponseEntity<String>("Plan got updated successfully", HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public void deletePlan(@PathVariable int id)
	{
		planSer.deletePlan(id);
	}
}
