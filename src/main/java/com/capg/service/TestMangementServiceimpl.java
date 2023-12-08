package com.capg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.TestManagement;
import com.capg.repo.TestManagementRepo;

@Service
public class TestMangementServiceimpl implements TestManagementService{

	
	@Autowired
	TestManagementRepo testManagementRepo ;
	
	@Override
	public TestManagement registerTest(TestManagement testManagement) {
		
		return testManagementRepo.save(testManagement);
	}


	
}
