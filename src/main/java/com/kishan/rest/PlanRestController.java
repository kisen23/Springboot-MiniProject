package com.kishan.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishan.entity.Plan;
import com.kishan.service.PlanService;

@RestController
public class PlanRestController   {

	@Autowired
	private PlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PostMapping("/savePlan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responseMessage = "";

		boolean isSaved = planService.savePlan(plan);
		if (isSaved) {
			responseMessage = "Plan Saved";
		} else {
			responseMessage = "Plan not Saved";
		}

		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans() {
		List<Plan> allPlan = planService.getAllPlan();
		return new ResponseEntity<>(allPlan, HttpStatus.OK);
	}
	
	@GetMapping("/plan{plandID}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planID){
		Plan planById = planService.getPlanById(planID);
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan{plandID}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planID){
		boolean isDeleted = planService.deletePlanById(planID);
		String msg="";
		if(isDeleted) {
			msg= "Plan Deleted";
		}else {
			msg= "Plan not Deleted";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean isUpdated = planService.updatePlan(plan);
		String msg="";
		if(isUpdated) {
			msg= "Plan is Updated";
		}else { 
			msg= "Plan not Updated";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
		boolean isStatusChanged = planService.planStatusChange(planId,status);
		String msg="";
		if(isStatusChanged) {
			msg= "Plan status changed";
		}else { 
			msg= "Plan status not chnaged";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}


}
