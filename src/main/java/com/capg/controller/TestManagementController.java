package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.TestManagement;
import com.capg.service.TestManagementService;

@RestController
@RequestMapping("/api/v1")
public class TestManagementController {

	@Autowired
	TestManagementService testManagementService ;
	
	@PostMapping("/testmanagement")
	public ResponseEntity<TestManagement> registerTest(@RequestBody TestManagement testManagement)
	{
		return new ResponseEntity <TestManagement>(testManagementService.registerTest(testManagement), HttpStatus.OK);
	}
}
