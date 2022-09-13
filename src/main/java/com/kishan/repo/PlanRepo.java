package com.kishan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kishan.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
