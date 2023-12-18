package com.capg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
	public Result findByUserIdAndTestId(int userId,int testId);
	
	@Query(value="select * from result where user_id=:userId",nativeQuery=true)
	public List<Result> fetchAllTestsByUserId(@Param("userId")int userId);
}
