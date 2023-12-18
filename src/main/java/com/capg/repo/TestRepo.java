package com.capg.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.Tests;

public interface TestRepo  extends JpaRepository<Tests,Integer>{
	
	@Query(value="select * from test where is_active=true",nativeQuery=true)
	List<Tests> findAllTestsActive();
	
	@Query(value="select * from test where test_name=:testName",nativeQuery=true)
	Tests findTestByName(@Param("testName") String testName);
  
}
