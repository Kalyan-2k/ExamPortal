package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.TestManagement;

public interface TestManagementRepo extends JpaRepository<TestManagement,Integer> {
	
	@Query(value="select * from test_management where user_id=:userId and test_id=:testId",nativeQuery = true)
	TestManagement fetchByUserIdAndTestId(@Param("userId") int userId,@Param("testId") int testId);
}
