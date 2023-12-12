package com.capg.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
	public Result findByUserIdAndTestId(int userId,int testId);
}
