
package com.capg.controller;

import java.util.List;

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

import com.capg.entity.Category;
import com.capg.entity.Tests;
import com.capg.exceptions.IdNotFoundException;
import com.capg.service.TestService;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	    @Autowired
	    private TestService testService;

	    //add test
	    @PostMapping("/test")
		public ResponseEntity<Tests> addTest(@RequestBody Tests test)
		{
			return new ResponseEntity <Tests>(testService.addTest(test), HttpStatus.OK);
		}
	    //update test
	    @PutMapping("/test/{test_id}")
	    public ResponseEntity<Tests> updateTestById(@PathVariable("test_id") int testId,@RequestBody Tests test) throws IdNotFoundException
		{
			return new ResponseEntity<Tests>(testService.updateTestById(testId,test), HttpStatus.OK);
		}
	    //get test
	    @GetMapping("/tests")
	    public ResponseEntity<List<Tests>> getAllTests()
		{
			return new ResponseEntity <List<Tests>>(testService.getAllTests(),HttpStatus.OK);
		}

	    //get single test	
	    @GetMapping("/test/{test_id}")
	    public ResponseEntity<Tests> getTest(@PathVariable("test_id") int testId)
		{
			return new ResponseEntity<Tests>(testService.getTest(testId), HttpStatus.OK);
		}
	    
	    //delete test
	    @DeleteMapping("/test/{test_id}")
	    public ResponseEntity<String> deleteTestById(@PathVariable("test_id") int testId) throws IdNotFoundException
		{
			return new ResponseEntity<String>(testService.deleteTestByTestId(testId), HttpStatus.OK);
		}
	   
	    //get test of particular category
	    @GetMapping("/test/category/{category_id}")
		public ResponseEntity<List<Tests>> getTestOfCategory(@PathVariable Category category)
		{
			return new ResponseEntity<List<Tests>>(testService.getTestOfCategory(category), HttpStatus.OK);
		}
}

