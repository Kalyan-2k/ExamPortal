package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.TestManagement;

public interface TestManagementRepo extends JpaRepository<TestManagement,Integer> {
	
	
}
