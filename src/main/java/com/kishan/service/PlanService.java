package com.kishan.service;

import java.util.*;

import com.kishan.entity.Plan;

public interface PlanService {

	public Map<Integer, String> getPlanCategories();

	public boolean savePlan(Plan plan);
	
	public boolean updatePlan(Plan plan);

	public List<Plan> getAllPlan();
	
	public Plan getPlanById(Integer planId);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId, String status);
	
	

}
